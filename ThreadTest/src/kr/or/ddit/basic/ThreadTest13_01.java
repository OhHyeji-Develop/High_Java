package kr.or.ddit.basic;
////2022-03-04-06
//package kr.or.ddit.basic;
//
///*
// * 		10마리의 말들이 경주하는 경마 프로그램 작성하기
// * 		말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 이 클래스는 말이름(String), 등수(int), 현재 위치(int)를 멤버변수로 갖는다.
// * 		그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.
// * 		(Compare 인터페이스 구현)
// * 		
// * 		경기 구간은 1 ~ 50 구간으로 되어 있다.
// * 
// * 		경기가 끝나면 등수 순으로 출력한다.
// * 
// * 		경기가 진행 중 일때는 중간중간에 말들의 위치를 아래와 같이 나타낸다. -> 쓰레드
// * 		
// * 		예)
// * 		01번말 : -->-----------------------------------------------
// * 		02번말 : --------->----------------------------------------
// * 		03번말 : ------>-------------------------------------------
// * 		...
// * 		10번말 : ---->---------------------------------------------
// */
//
//public class ThreadTest13 {
//
//	public static void main(String[] args) {
//		
//		Horse[] horse = new Horse[] {
//				new Horse("01번말",0,0),
//				new Horse("02번말",0,0),
//				new Horse("03번말",0,0),
//				new Horse("04번말",0,0),
//				new Horse("05번말",0,0),
//				new Horse("06번말",0,0),
//				new Horse("07번말",0,0),
//				new Horse("08번말",0,0),
//				new Horse("09번말",0,0),
//				new Horse("10번말",0,0)
//		};
//		
//		for(Horse hs : horse) {
//			hs.start();
//		}
//		
//		for(Horse hs : horse) {
//			try {
//				hs.join();
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
//		}
//		
//		System.out.println("경기 결과");
//		System.out.println("순위 : " + Horse.setRank);
//
//	}
//
//}
//
//class Horse extends Thread{
//	public String horseName;
//	public int rank;
//	public int rocation;
//	
//	public static String setRank;
//	
//	// 생성자
//	public Horse(String horseName, int rank, int rocation) {
//		super();
//		this.horseName = horseName;		// 말이름
//		this.rank = rank;				// 등수
//		this.rocation = rocation;		// 현재위치
//	}
//	
//	@Override
//	public void run() {
//		for(rocation = 1; rocation <= 50; rocation++) {
//			System.out.println(">");
//		}
//		try {
//			Thread.sleep((int)(Math.random() * 50 + 1));
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
//		
//		Horse.setRank += horseName + " ";
//	}
//}
//
//class Game extends Thread{
//	@Override
//	public void run() {
//		
//		for(int i = 1; i <= 10; i++) {
//			System.out.println(i + "번 말 : " + "--------------------------------------------------");
//		}
//	}
//}
