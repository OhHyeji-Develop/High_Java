package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		/*
		 * - List와 Set의 차이점
		 *  1. List
		 *   - 데이터 순서(index)가 있다.
		 *   - 중복되는 데이터를 저장할 수 있다.
		 *  
		 *  2.Set
		 *   - 데이터 순서(index)가 없다.
		 *   - 중복되는 데이터를 저장할 수 없다.
		 *   - 중복을 제거하는 상황으로 많이 사용됨
		 */
		
		HashSet hs1 = new HashSet();
		
		// set에 데이터를 추가할 때도 add()메서드를 사용
		hs1.add("AAA");
		hs1.add("DDD");
		hs1.add(200);
		hs1.add("CCC");
		hs1.add("BBB");
		hs1.add(100);
		hs1.add(300);
		
		System.out.println("hs1 -> " + hs1);
		System.out.println("set의 개수 : " + hs1.size());
		
		// set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지않는다.
		boolean isAdd = hs1.add("FFF");
		System.out.println("중복되지 않을때 : " + isAdd); // true반환
		System.out.println("hs1 -> " + hs1);
		
		isAdd = hs1.add("CCC");
		System.out.println("중복될 때 : " + isAdd);  // false반환
		System.out.println("hs1 -> " + hs1);
		
		// Set의 데이터를 수정하려면 수정작업을 처리하는 메서드가 따로 없기 때문에
		// 해당 자료를 삭제한 후 추가해 주는 방식으로 처리한다.
		
		//  삭제하는 메서드 : remove(삭제할 데이터)
		//  	  반환값 : 삭제성공(true), 삭제실패(false) 반환
		// 전체 데이터 삭제 : clear()
		
		// 예) "FFF"문자열을 "EEE"문자열로 변경하기
		hs1.remove("FFF");
		System.out.println("삭제 후 hs1 -> " + hs1);
		hs1.add("EEE");
		System.out.println("hs1 -> " + hs1);
		
		System.out.println("---------------------------------------------");
		
		/*
		 *   Set의 데이터는 순서(index)가 없기때문에 List처럼 index를 이용해서 데이터를
		 *   하나씩 불러올 수 없다.
		 *   그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해야 한다.
		 *   
		 *   - Set형의 데이터들을 Interator형 객체로 변환하는 메서드 => iterator()
		 * 
		 */
		
		Iterator it = hs1.iterator(); // Set데이터를 Iterator로 변환하기
		
		// Iterator의 hasNext()메서드  => Iterator에서 현재 데이터를 가리키는 포인터가 있는데 
		//								현재 포인터가 가리키는 곳의 다음번째 자리에 데이터가 있는지 검사한다.
		//			데이터가 있으면 true, 없으면 false를 반환
		while(it.hasNext()) {
			// Iterator의 next()메서드
			// -> Iterator의 포인터를 다음번째로 이동시킨 후 이동한 자리의 데이터를 읽어와 반환한다.
			System.out.println(it.next());
		}
		System.out.println("---------------------------------------------");
		
		// 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
		// 번호는 1번부터 25번까지 있고, 추첨할 인원은 3명이다.
		// 당첨자를 출력해 보시오.
		
		// 최소값부터 최대값 사이의 난수 만들기
		//   (int)(Math.random() * (최대값 - 최소값 + 1) + 최소값_
		
		HashSet<Integer> testSet = new HashSet<Integer>();
		
		while(testSet.size() <3) { //testSet의 갯수가 3보다 작으면 반복
			int rnd = (int)(Math.random() * (25) + 1);
			testSet.add(rnd);
		}
//		System.out.println("당첨자 번호 : " + testSet);
		for(int num : testSet) {
			System.out.println(num);
		}
		
		// Set유형의 자료를 List형 자료로 변환하기
		ArrayList<Integer> testList = new ArrayList<Integer>(testSet) ;
		for(int i = 0; i < testList.size(); i++) {
			System.out.println(i + " : " + testList.get(i));
		}
	}
}
