package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
	 *
	 *  문제2) 문제1에서 별명의 길이가 같은것이 있을경우를 처리하시오
	 */

public class ArrayListTest04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		ArrayList<String> aliasList = new ArrayList<>();

		System.out.println("별명을 5번 입력하세요.");

		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 별명 입력 : ");
			String alias = scan.nextLine();
			aliasList.add(alias);
		}

		// 제일 긴 별명의 길이가 저장될 변수 선언
		// -> 첫번째 별명의 길이로 초기화한다.
		int maxLength = aliasList.get(0).length();
		for (int i = 1; i < aliasList.size(); i++) {
			if (maxLength < aliasList.get(i).length()) {
				maxLength = aliasList.get(i).length();
			}
		}

		System.out.println("제일 긴 별명들...");
		for (String alias : aliasList) {
			if (maxLength == alias.length()) {
				System.out.println(alias);
			}
		}
	}

}
