package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
	 *  문제1) 5명 별명을 입력받아 ArrayList에 저장하고 이 별명 중에 제일 긴 별명을 출력하시오.
	 *  (단, 별명의 길이는 모두 다르게 입력한다.)
	 *  
	 *  문제2) 문제1에서 별명의 길이가 같은것이 있을경우를 처리하시오
	 */


public class ArrayListTest03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> aliasList = new ArrayList<>();
		
		System.out.println("서로 다른길이의 별명을 5번 입력하세요.");
		
		for(int i = 1; i <= 5 ; i++) {
			System.out.print(i + "번째 별명 입력 : ");
			String alias = scan.nextLine();
			aliasList.add(alias);
		}
		
		// 제일 긴 별명이 저장될 변수 선언
		//         -> List의 첫번째 자료로 초기화
		String maxAlias = aliasList.get(0);
		for(int i = 1; i < aliasList.size(); i++) {
			if(maxAlias.length() < aliasList.get(i).length()) {
				maxAlias = aliasList.get(i);
			}
		}
		System.out.println("제일 긴 별명 : " + maxAlias);
		
	}

}
