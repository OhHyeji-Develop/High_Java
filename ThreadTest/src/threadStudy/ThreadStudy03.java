package threadStudy;

public class ThreadStudy03 {

	public static void main(String[] args) {
		
		// 방법1)
		MyThread3_1 th3_1 = new MyThread3_1();	// 인스턴스(객체) 생성
		th3_1.start();
		
		// 방법2)
		MyThread3_2 th3_2 = new MyThread3_2();
		Thread th = new Thread(th3_2);
		th.start();
		
		// 방법3) 
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 200; i++) {
					System.out.print("/");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
			}
		};
		
		Thread th1 = new Thread(r); // Thread클래스생성 후 생성자에 Runnable클래스의 인스턴스를 넣어서 생성
		th1.start();
	}

}

// 방법1) Thread 클래스를 상속
class MyThread3_1 extends Thread{
	
	@Override
	public void run() {
		for(int i = 1; i <= 200; i++) {
			System.out.print("*");
		
			try {
				Thread.sleep(100);
				// Thread.sleep(시간) -> 주어진 '시간'동안 작업을 잠시 멈춘다.
				// Thread.sleep()을 호출한 쓰레드는 주어진 시간동안 일시 정지 상태가 되고 다시 실행 대기 상태로 돌아간다.
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}


// 방법2) Runnable 인터페이스를 구현해서 사용
class MyThread3_2 implements Runnable{
	
	@Override
	public void run() {
		for(int i = 1; i <= 200; i++) {
			System.out.print("#");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}