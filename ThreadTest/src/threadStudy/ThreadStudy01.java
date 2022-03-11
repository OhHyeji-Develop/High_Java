package threadStudy;

public class ThreadStudy01 {

	public static void main(String[] args) {
		
		// Thread(쓰레드)
		/*
		 	- 프로세스 : 메모리를 할당받아 실행중인 프로그램
		 	- 프로세스내의 명령어 블록으로 시작점과 종료점을 가진다.
		 	- 실행중에 멈출 수 있으며, 동시에 수행 가능
		 	- 동시에 여러 작업 가능 -> 작업의 효율성을 높힐 수 있음
		 	- 쓰레드끼리 메모리공유 -> 메모리 절약 효과
		 	
		 	- 쓰레드의 실행 순서는 예측할 수 없음.
		 	- 쓰레드의 실제 override하는 메서드는 run(), 쓰레드 호출 시 실행하는 메서드는 start()
		 	
		 */
		
		System.out.println("MainThread Start");
		for(int i = 1; i <= 3; i++) {
			new MyThread("Thread" + i).start();
		}
		System.out.println("MainThread End");

	}

}

// Thread 클래스를 상속받는 방법
class MyThread extends Thread{
	String threadName;

	public MyThread(String threadName) {
		super();
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(this.threadName + " : " + i);
		}
		System.out.println();
	}
}
