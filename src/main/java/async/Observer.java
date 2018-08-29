package async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.servlet.AsyncContext;
import javax.transaction.Transactional;

@Stateless	//Only works when @Stateless / @SessionScoped / @RequestScoped on Payara
@SuppressWarnings("unused")
public class Observer {


	public void getAsyncCtx2(@AsyncQualifier(2) @Observes final AsyncContext ac) throws IOException {
		System.out.println("getAsyncCtx(@Observes AC) fired");
		PrintWriter pw = ac.getResponse().getWriter();
		
		ac.start(()->{
			try {
				
				pw.println("<br/>From @Observes, progress 0%<br/>Thread: "+Thread.currentThread().getName()+"<br/><br/>");
				pw.flush();
				
				Thread.sleep(1000);
				pw.println("<br/>From @Observes, progress 25<br/>Thread: "+Thread.currentThread().getName()+"<br/><br/>");
				pw.flush();
				
				Thread.sleep(1000);
				pw.println("<br/>From @Observes, progress 50%<br/>Thread: "+Thread.currentThread().getName()+"<br/><br/>");
				pw.flush();
				
				Thread.sleep(1000);
				pw.println("<br/>From @Observes, progress 75%<br/>Thread: "+Thread.currentThread().getName()+"<br/><br/>");
				pw.flush();
				
				Thread.sleep(1000);
				pw.println("<br/>From @Observes, progress 100%<br/>Thread: "+Thread.currentThread().getName()+"<br/><br/>");
				pw.println("Done");
				
				ac.complete();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		});
		
	}
	
	
	
	//Doesnt work on Payara?
	public void getAsyncCtx(@AsyncQualifier(1) @Observes final AsyncContext ac) throws IOException {
		System.out.println("getAsyncCtx(@Observes AC) fired");
		//ac.complete();
		
		String message = (String) ac.getRequest().getAttribute("message");
		System.out.println(message);
		
		ac.start(()->{
			try {
				PrintWriter pw = ac.getResponse().getWriter();
				pw.println("From Async servlet: "+ac.getRequest().getAttribute("message")+",<br/>Thread: "+Thread.currentThread().getName()+"<br/><br/>");
				pw.flush();
				if(message.equals("Final Message")) {
					pw.println("Done");
					ac.complete();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
	}
	

	//Code that fires the event must be in transaction
	public void getString(@Observes(during=TransactionPhase.AFTER_SUCCESS) String s) throws IOException {
		System.out.println("@Observes(during=TransactionPhase.AFTER_SUCCESS) -> Got String (Sucess): "+s);
		
	}
	public void getStringFail(@Observes(during=TransactionPhase.AFTER_FAILURE) String s) throws IOException {
		System.out.println("@Observes(during=TransactionPhase.AFTER_FAILURE) -> Got String (Failure): "+s);
	}
	
}
