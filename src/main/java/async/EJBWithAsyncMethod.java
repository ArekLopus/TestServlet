package async;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.transaction.TransactionSynchronizationRegistry;

@Stateless
public class EJBWithAsyncMethod {
	
	
	@Asynchronous
	public void async(Runnable r) {
		r.run();
	}

	
	
	@Inject
	private Event<String> event;
	
	@Resource
	TransactionSynchronizationRegistry tsr;
	
	@Resource
    SessionContext sc;
	
	//Code that fires the event must be in transaction
	@Asynchronous
	public void testEventSuccess() {
		System.out.println("testEventSuccess(), thread: "+Thread.currentThread().getName());
		event.fire("Just to test");
		//tsr.setRollbackOnly();
		//sc.setRollbackOnly();
	}
	
	
	public void testEventFail() {
		System.out.println("testEventFail(), thread: "+Thread.currentThread().getName());
		event.fire("Just to test");
		//tsr.setRollbackOnly();
		sc.setRollbackOnly();
	}

	
}
