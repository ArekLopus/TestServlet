package listeners3_1;

import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

//@WebListener("Write Listener")
@SuppressWarnings("unused")
public class WriteListenerTest implements WriteListener {

	@Override
	public void onError(Throwable t) {
		System.out.println("WriteListener.onError()");
		
	}

	@Override
	public void onWritePossible() throws IOException {
		System.out.println("WriteListener.onWritePossible()");
		
	}
	
	
}
