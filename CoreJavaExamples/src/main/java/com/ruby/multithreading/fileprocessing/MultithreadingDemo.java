package com.ruby.multithreading.fileprocessing;

public class MultithreadingDemo {
  public static void main(String[] args) {
	 long starttime = System.currentTimeMillis();
	  for(int i=1; i<11; i++){
		  Thread thread = new Thread(new RunnableProcessor(), "MyName" + i);
	
		  thread.start();
	  }
	  long endTime = System.currentTimeMillis();
	System.out.println("Total time taken : " + ( endTime-starttime) + " milllisecond");
	System.out.println("ending main method");
/*	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
}
}
