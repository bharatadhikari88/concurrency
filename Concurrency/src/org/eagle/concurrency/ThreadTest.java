package org.eagle.concurrency;

public class ThreadTest implements Runnable{
	@Override
	public void run() {
		if("A".equals(Thread.currentThread().getName())){
			//abc();
		}else{
			xyz();
		}
		
	}
	private synchronized void xyz() {
		for(int i =0;i<100;i++){
			System.out.println("start" + Thread.currentThread().getName()+ i);
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			/*try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("end" + Thread.currentThread().getName());*/
	}
	private void abc() {
		for(int i =0;i<100;i++){
			System.out.println("start" + Thread.currentThread().getName()+i);
		}
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
		System.out.println("END");*/
		
	}
	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
	Thread a = new Thread(threadTest,"B");
	Thread b = new Thread(threadTest,"A");
	Thread c = new Thread(threadTest,"C");
	a.start();
	b.start();
	c.start();
		try {
			b.join();
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadTest.notify();

	}

}
