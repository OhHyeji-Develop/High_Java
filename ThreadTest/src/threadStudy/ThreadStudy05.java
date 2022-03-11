package threadStudy;

public class ThreadStudy05 {

	public static void main(String[] args) {
		// join()으로 Thread실행순서제어
		
		// join()으로 쓰레드의 순서를 제어하기 위해서는 
		// 특정 thread의 start()가 호출되기전에, 선행 thread.join()을 먼저 실행해야한다.
		// ex) thread2.start()가 호출되기 전에, thread1.join()을 먼저 실행해야
		//	   Thread1 -> Thread2 순서로 진행됨
		
		/*
		Thread thread1 = new Thread(new CustomThread());
		Thread thread2 = new Thread(new CustomThread());
		Thread thread3 = new Thread(new CustomThread());
		Thread thread4 = new Thread(new CustomThread());
		Thread thread5 = new Thread(new CustomThread());
		
		try {
			thread1.start();
			thread1.join();

			thread2.start();
			thread2.join();

			thread3.start();
			thread3.join();

			thread4.start();
			thread4.join();

			thread5.start();
			thread5.join();

			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("End of Main");
		*/
		
		for(int i = 0; i < 5; i++) {
			Thread thread = new Thread(new CustomThread());
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("End of Main");
	}

}

class CustomThread implements Runnable{
	@Override
	public void run() {
		System.out.print(Thread.currentThread().getName() + " ");
	}
}
