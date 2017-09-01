package com.ruby.multithreading.fileprocessing;

public class RunnableProcessor implements Runnable {

	@Override
	public void run() {
		long starttime = System.currentTimeMillis();
			Thread thread = Thread.currentThread();
			//Thread.sleep(1000);
			System.out.println("RunnableJob is being run by " + thread.getName() + " (" + thread.getId() + ")  .. Start work");
			FileProcessor fileProcessor = new FileProcessor();
			fileProcessor.processFileAtomicApproach(thread.getName());
			System.out.println("RunnableJob is being run by " + thread.getName() + " (" + thread.getId() + ")  .. End work");
			  long endTime = System.currentTimeMillis();
				System.out.println("Total time taken : by  " + thread.getName() + "  " + ( endTime-starttime) + " milllisecond");
	}

}
