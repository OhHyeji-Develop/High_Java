//2022-03-03-07
package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 *   컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오.
 *   
 *   컴퓨터의 가위바위보는 난수를 이용해서 구하고,
 *   사용자의 가위바위보느 showInputDialog()를 이용해서 입력 받는다.
 *   
 *   입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 *   5초 안에 입력이 없으면 게이에 진것으로 처리한다.
 *   
 *   5초 안에 입력이 있으면 승패를 구해서 출력한다.
 *   
 *   결과 예시)
 *   1) 5초안에 입력이 없을 때
 *   	- 결 과 -
 *   	시간 초과로 당신이 졌습니다.
 *   2) 5초안에 입력이 있을 때
 *   	- 결 과 -
 *   	컴퓨터 : 가위
 *   	사용자 : 바위
 *   	결 과 : 당신이 이겼습니다.
 */

public class ThreadTest07_01 {

	public static void main(String[] args) {
		
		Thread th1 = new Input();
		Thread th3 = new Count();
		
		th1.start();
		th3.start();
		

	}

}


class Input extends Thread{
	
	public static boolean inputck = false;
	Integer rsp = (int)(Math.random() * 3) + 1;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("가위바위보~");
		inputck = true;
		System.out.println("사용자 : " + str);
		
		if(str.equals("가위")) {
			if(rsp == 1) {
				System.out.println("컴퓨터 : 가위");
				System.out.println("- - -비겼습니다- - -");
			}else if(rsp == 2) {
				System.out.println("컴퓨터 : 바위");
				System.out.println("- - 당신이 졌습니다 - -");
			}else if(rsp == 3){
				System.out.println("컴퓨터 : 보");
				System.out.println("- - 당신이 이겼습니다 - -");
			}
		}else if(str.equals("바위")) {
			if(rsp == 1) {
				System.out.println("컴퓨터 : 가위");
				System.out.println("- - 당신이 이겼습니다 - -");
			}else if(rsp == 2) {
				System.out.println("컴퓨터 : 바위");
				System.out.println("- - -비겼습니다- - -");
			}else if(rsp == 3){
				System.out.println("컴퓨터 : 보");
				System.out.println("- - 당신이 졌습니다 - -");
			}
		}else if(str.equals("보")) {
			if(rsp == 1) {
				System.out.println("컴퓨터 : 가위");
				System.out.println("- - 당신이 졌습니다 - -");
			}else if(rsp == 2) {
				System.out.println("컴퓨터 : 바위");
				System.out.println("- - 당신이 이겼습니다 - -");
			}else if(rsp == 3){
				System.out.println("컴퓨터 : 보");
				System.out.println("- - -비겼습니다- - -");
			}
		}else {
			System.out.println("잘못입력하였습니다.");
		}
	}
}

// 컴퓨터가 데이터 입력하는 메서드
//class ComInput extends Thread{
//	
//	@Override
//	public void run() {
//		
//		Integer rsp = (int)(Math.random() * 3) + 1;
//		String rspp;
//		
//		if(HumanInput.inputck == true) {
//			if(rsp == 1) { // 컴퓨터 : 가위
//				if(HumanInput.num == 1) {
//					System.out.println("컴퓨터 : 가위");
//					System.out.println("컴퓨터와 비겼습니다.");
//				}else if(HumanInput.num == 2) {
//					System.out.println("컴퓨터 : 가위");
//					System.out.println("사용자가 이겼습니다.");
//				}
//			}else if(rsp == 2) {  // 컴퓨터 : 바위
//				rspp = "바위";
//			}else if(rsp == 3){  // 컴퓨터 : 보
//				rspp = "보";
//			}
//		}
//		System.out.println("컴퓨터 : " + rsp);
//	}
//}

// 카운트다운을 진행하는 메서드
class Count extends Thread{
	@Override
	public void run() {
		for(int i = 5; i >= 1; i--) {
			System.out.println(i);
			
			if(Input.inputck == true) {
				return;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("시간초과로 당신이 졌습니다.");
		System.exit(0);
	}
}


