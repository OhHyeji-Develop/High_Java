//2022-03-07-02
package kr.or.ddit.basic;

public class ThreadTest15 {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		TestThread th1 = new TestThread("test1", sObj);
		TestThread th2 = new TestThread("test2", sObj);
		
		th1.start();
		th2.start();
	}

}

class TestThread extends Thread{
	private ShareObject sObj;
	
	public TestThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			sObj.add();		// 반복문 1번 할때마다 add라는 메서드 실행
		}
	}
}


// 공통으로 사용할 클래스
class ShareObject{
	private int sum = 0;
	/*
	 - 동기화 하기  => synchronized를 이용해서 처리한다.
	 - 방법1 => 메서드 자체에 동기화 설정을 하는 방법
	 	public synchronized void add(){   -> 메서드 선언부에 synchronized를 붙힌다.
	 		처리할 내용들....
	 	}
	 - 방법2 => 동기화 블럭으로 설정하는 방법
	 	public void add(){
	 		synchronized(동기화할 객체){
	 			처리할 내용들....
	 		}
	 	}
	*/
//	public synchronized void add() {	// 방법1
	public void add() {
		synchronized(this) {			// 방법2
			int n = sum;
			
			n += 10;
			
			sum = n;
			
			System.out.println(Thread.currentThread().getName() + " 합계 : " + sum);  // 현재 실행중인 쓰레드가 어떤건지 알려주는 명령
		}
	}
}