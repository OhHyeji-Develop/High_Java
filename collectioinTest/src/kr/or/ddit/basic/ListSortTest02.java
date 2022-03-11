package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ListSortTest02 {

	public static void main(String[] args) {

		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-4561"));
		memList.add(new Member(5, "이순신", "010-2223-4561"));
		memList.add(new Member(9, "성춘향", "010-3333-4561"));
		memList.add(new Member(3, "강감찬", "010-4444-4561"));
		memList.add(new Member(6, "일지매", "010-5555-4561"));
		memList.add(new Member(2, "변학도", "010-6666-4561"));
		
		System.out.println("정렬 전....");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		
		Collections.sort(memList);
		System.out.println("정렬 후....");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		
		Collections.sort(memList, new SortNumDesc());
		System.out.println("정렬 후....");
		for(Member mem : memList) {
			System.out.println(mem);
		}
	}

}

// Member클래스 작성하기
//  -> 회원이름을 기준으로 오름차순 정렬이 되도록 내부 정렬 기준을 추가해보자 => Comparable인터페이스를 구현한다.
class Member implements Comparable<Member>{
	private int num;	  // 회원번호
	private String name;  // 회원이름
	private String tel;   // 전화번호
	
	// 생성자(자동으로 초기화 alt+shift+S)
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

//	 회원이름의 오름차순 정렬 기준 만들기 
	@Override
	public int compareTo(Member mem) { // 매개변수로 들어온 데이터가 뒤에 데이터 
		return name.compareTo(mem.getName());
	}
	
//	// 회원이름의 내림차순 정렬 기준 만들기 
//		@Override
//		public int compareTo(Member mem) { // 매개변수로 들어온 데이터가 뒤에 데이터 
//			return name.compareTo(mem.getName()) * 1;
//		}
	
}

// Member의 회원번호(num값)의 내림차순으로 정렬하는 외부정렬기준클래서
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		
		
		// 방법 1
//		if(mem1.getNum()>mem2.getNum()) { // 현재 순서가 내림차순
//			 return -1;
//		}else if(mem1.getNum() < mem2.getNum())  {// 뒤에꺼가 더 큼
//		
//		return 1;
//		}else {
//			return 0;
//		}
		
		// 방법 2 : Wrapper클래스를 이용하는 방법 
		// 2 - 1
		// return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
		
		// 2 - 2
		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
	}
}







