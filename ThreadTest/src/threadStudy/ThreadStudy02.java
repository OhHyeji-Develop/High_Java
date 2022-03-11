package threadStudy;

public class ThreadStudy02 {

	public static void main(String[] args) {
		System.out.println("MainThread Start");
		for(int i = 1; i <= 3; i++) {
			Thread th = new Thread(new MyThread1("THread" + i));
			th.start();
		}
		System.out.println("MainThread End");
	}

}


// Runnable 인터페이스 구현
// Runnable 인터페이스를 구현한 클래스를 Thread의 생성자로 주입하여 실행
class MyThread1 implements Runnable{
	private String threadName;

	public MyThread1(String threadName) {
		super();
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(threadName + " : " + i);
		}
	}
}