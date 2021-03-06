package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후 이들 중 '김'씨 성의 이름을 모두 출력하시오.
 * 		(입력은 Scanner객체를 이용한다.)
 */

public class ArrayListTest02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		ArrayList<String> nameList = new ArrayList<String>();

		System.out.println("이름을 입력해주세요.");


		 // 5명의 사람을 입력받아 추가하는 부분
		for(int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 사람 이름 : ");
			String name = scan.next();
			nameList.add(name);
		}
		
		System.out.println();
		System.out.println("김씨 성을 가진 사람들...");
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).substring(0,1).equals("김")) {
				System.out.println(nameList.get(i));
			}
		}
		
		System.out.println();
		System.out.println("김씨 성을 가진 사람들...");
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).charAt(0)=='김') {
				System.out.println(nameList.get(i));
			}
		}
		
		System.out.println();
		System.out.println("김씨 성을 가진 사람들...");
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).indexOf("김") == 0) {
				System.out.println(nameList.get(i));
			}
		}
		
		System.out.println();
		System.out.println("김씨 성을 가진 사람들...");
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).startsWith("김") == true) {
				System.out.println(nameList.get(i));
			}
		}



//		for (int i = 0; i < name.size(); i++) {
//			if (name.get(i).substring(0, 1).equals("김")) {
//				System.out.println("김씨 성을 가진 사람은 " + name.get(i));
//			}
//		}

	}
}
