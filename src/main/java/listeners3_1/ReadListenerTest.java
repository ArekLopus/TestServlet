package listeners3_1;

import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

//@WebListener("Read Listener")
@SuppressWarnings("unused")
public class ReadListenerTest implements ReadListener {

	@Override
	public void onDataAvailable() throws IOException {
		System.out.println("ReadListener.onDataAvailable()");
		
	}

	@Override
	public void onAllDataRead() throws IOException {
		System.out.println("ReadListener.onAllDataRead()");
		
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("ReadListener.onError()");
		
	}

}
