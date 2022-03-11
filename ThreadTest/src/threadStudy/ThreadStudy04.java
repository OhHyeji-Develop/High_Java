package threadStudy;

public class ThreadStudy04 {

	public static void main(String[] args) {
		// join : 해당 쓰레드가 종료되기까지 기다렸다가 다음으로 넘어감
		MyThread4_1 th4_1 = new MyThread4_1();
		th4_1.start();
		
		try {
			th4_1.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("1~100까지의 합 : " + th4_1.getSum());

	}

}


class MyThread4_1 extends Thread{
	private long sum;

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			sum+=i;
		}
	}
	
}