package io.interfiber.Pizza.coreFunctions;

public class ThreadProcess{
	
	public void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
