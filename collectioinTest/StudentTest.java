package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 	문제) 학번, 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
 * 		 이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 한다.
 * 		 이 클래스는 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현한다.
 *  	 
 *  	 이 Student객체는 List에 저장하여 관리한다.
 *  	 List에 저장된 Student객체를 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부정렬 기준 클래스도 작성하시오.
 *  	 (단, 등수는 List에 전체 데이터가 모두 저장된 후에 구한다.)
 */

public class StudentTest {
	
	//등수를 구하는 메서드
	public void setRanking(List<Student> stuList) {
		// 기준이 되는 데이터를 위한 반복문( 등수를 구할 값 )
		for(Student stu1 : stuList) {
			int rank = 1; // 처음에는 등수를 1로 초기화
			
			// 비교대상을 찾기 위한 반복문
			for(Student stu2 : stuList) {
				// 기준보다 큰 값을 만나면 rank값을 증가시킴
				if(stu1.getTot() < stu2.getTot()) { // 나보다 다음사람 점수가 더 크면
					rank++;  // 내 등수는 1 증가
				}
			}
			
			// 구해진 등수를 Student객체의 rank변수에 저장한다.
			stu1.setRank(rank);
			
		}
	}

	public static void main(String[] args) {

		StudentTest test = new StudentTest(); //setRanking메서드를 호출하기위해 StudentText객체생성
		
		ArrayList<Student> studentList = new ArrayList<>();
		
		
		
		studentList.add(new Student(1, "어피치", 70, 85, 94));
		studentList.add(new Student(6, "라이언", 90, 85, 81));
		studentList.add(new Student(3, "무지", 73, 61, 25));
		studentList.add(new Student(2, "니니즈", 24, 54, 88));
		studentList.add(new Student(5, "제이지", 38, 76, 43));
		studentList.add(new Student(4, "네오", 100, 91, 94));

		// 등수구하기
		test.setRanking(studentList);
		
		System.out.println("정렬 전");
		for(Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println();
		
		// 학번의 오름차순으로 정렬하기
		Collections.sort(studentList);
		System.out.println("(학번의 오름차순 정렬)");
		for(Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println();
		
		Collections.sort(studentList, new SortByTotal());
		System.out.println("(총점의 내림차순 정렬)");
		for(Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println();
		
	}

}

class Student implements Comparable<Student> {

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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot="
				+ tot + ", rank=" + rank + "]";
	}

	private int num; // 학번
	private String name; // 이름
	private int kor; // 국어점수
	private int eng; // 영어점수
	private int math; // 수학점수
	private int tot; // 총점
	private int rank; // 등수

	public Student(int num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = kor + eng + math;
	}

	// 학번의 오름차순의 내부정렬기준
	@Override
	public int compareTo(Student stu) {
		return Integer.compare(num, stu.getNum());
	}

}


// 총점의 역순으로 정렬 : 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 클래스
class SortByTotal implements Comparator<Student>{

	@Override
	public int compare(Student stu1, Student stu2) {
		if(stu1.getTot() == stu2.getTot()) {
			return stu1.getName().compareTo(stu2.getName());
		}else {
			return Integer.compare(stu1.getTot(), stu2.getTot()) * -1;
		}
	}
	
}




//class Student implements Comparable<Student> {
//
//	private int num; // 학번
//	private String name; // 이름
//	private int korScore; // 국어점수
//	private int engScore; // 영어점수
//	private int mathScore; // 수학점수
//	private int score; // 총점
//	private int rank; // 등수
//
//	public Student(int num, String name, int korScore, int engScore, int mathScore, int score, int rank) {
//		super();
//		this.num = num;
//		this.name = name;
//		this.korScore = korScore;
//		this.engScore = engScore;
//		this.mathScore = mathScore;
//		this.score = korScore+engScore+mathScore;
//		this.rank = rank;
//	}
//
//	// 학번의 오름차순정렬 : 내부 정렬
//	@Override
//	public int compareTo(Student stu) {
//		return num.compareTo(stu.g());
//	}
//	
////	 회원이름의 오름차순 정렬 기준 만들기 
////	@Override
////	public int compareTo(Member mem) { // 매개변수로 들어온 데이터가 뒤에 데이터 
////		return name.compareTo(mem.getName());
////	}
//
//	public int getNum() {
//		return num;
//	}
//	
//	public void setNum(int num) {
//		this.num = num;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getKorScore() {
//		return korScore;
//	}
//
//	public void setKorScore(int korScore) {
//		this.korScore = korScore;
//	}
//
//	public int getEngScore() {
//		return engScore;
//	}
//
//	public void setEngScore(int engScore) {
//		this.engScore = engScore;
//	}
//
//	public int getMathScore() {
//		return mathScore;
//	}
//
//	public void setMathScore(int mathScore) {
//		this.mathScore = mathScore;
//	}
//
//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int score) {
//		this.score = score;
//	}
//
//	public int getRank() {
//		return rank;
//	}
//
//	public void setRank(int rank) {
//		this.rank = rank;
//	}
//	
//}
//
//class newSortDesc implements Comparator<Student> {
//
//	@Override
//	public int compare(Student stu1, Student stu2) {
//		
//		return 0;
//	}
//
//}