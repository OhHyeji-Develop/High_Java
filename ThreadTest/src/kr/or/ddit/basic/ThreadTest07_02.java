package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07_02 {
	public static boolean inputCheck;

	public static void main(String[] args) {
		
		GameTimer gt = new GameTimer();		// GameTimer의 객체생성
		
		// 난수를 이용해서 컴퓨터의 가위 바위 보 정하기
		String[] data = {"가위", "바위", "보"};
		int index = (int)(Math.random() * 3);	// 0~2사이의 난수만들기
		String com = data[index];	// 난수를 이용해서 컴퓨터의 가위바위보를 정한다.
		
		// 사용자의 가위 바위 보 정하기
		gt.start();		// 카운드 다운 시작
		
		String user = null;
		do {
			user = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
//		}while(!(user.equals("가위") || user.equals("바위") || user.equals("보")));   // 아래의 식과 같음
		}while(!user.equals("가위") && !user.equals("바위") && !user.equals("보"));
		
		inputCheck = true;
		
		//	결과 판정하기
		String result = "";
		if(com.equals(user)) {
			result = "비겼습니다.";
		}else if(com.equals("가위") && user.equals("보")
				|| com.equals("바위") && user.equals("가위")
				|| com.equals("보") && user.equals("바위")) {
			result = "당신이 졌습니다.";
		}else {
			result = "당신이 이겼습니다.";
		}
		
		/*	 방법2
		String temp = com + user;
		switch(temp) {
			case "가위보" : 
			case "바위가위" : 
			case "보바위" : result = "당신이 졌습니다.";
				break;
			case "보가위" : 
			case "가위바위" : 
			case "바위보" : result = "당신이 졌습니다.";
				break;
			default : result = "비겼습니다";
		}
		*/
		
		// 결과 출력하기
		System.out.println(" -- [결과] -- ");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + user);
		System.out.println("결과 : " + result);
		
	}

}

class GameTimer extends Thread{
	@Override
	public void run() {
		System.out.println("카운트다운을 시작합니다...");
		for(int i = 10; i >= 1; i--) {
			
			//입력완료 여부 검사 (입력이 완료되면 카운드다운진행X)
			if(ThreadTest07_02.inputCheck == true) {
				return;
			}
			
			System.out.println(i);
			try {
				Thread.sleep(1000); 	// 1초에 한번씩 출력
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println(" - 결과 - ");
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
	}
}