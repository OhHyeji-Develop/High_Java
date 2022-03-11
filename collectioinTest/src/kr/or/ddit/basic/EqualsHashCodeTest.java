// 2022-02-28-01
package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {

	public static void main(String[] args) {

		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");

		Person p2 = new Person();
//		p1.setNum(2);
//		p1.setName("이순신");

		p2.setNum(1);
		p2.setName("홍길동");

		Person p3 = p1;

		System.out.println(p1 == p2); // false 출력 -> 번지가 다름
		// == 으로 비교하는 것은 참조값을 비교하는것
		System.out.println(p1 == p3); // true 출력

		System.out.println(p1.equals(p2));
		// equals메서드는 Object에 이미 만들어진 메서드
		
		HashSet<Person> testSet = new HashSet<Person>();
		// 중복되는 데이터 X
		
		testSet.add(p1);
		testSet.add(p3);
		testSet.add(p2);
		
		System.out.println("testSet의 size : " + testSet.size());
		
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());

	}

}

/*
 *  - equals() -> 두 객체의 내용이 같은지 검사하는 메서드
 *  - hashCode() -> 두 객체의 동일성을 검사하는 메서드
 *  
 *  HashSet, Hashtable, HashMap과 같이 Hash로 시작하는 컬렉션 객체들은
 *  객체의 의미상의 동일성을 비교하기 위해서 equals()와 hashCode()메서드를 호출해서 비교한다.
 *  그러므로, 객체가 같은지 여부를 결정하려면 equals()메서드 뿐만 아니라 hashCode()메서드도 재정의 해야한다!!!
 * 
 */

class Person { // Object객체를 상속받음
	private int num;
	private String name;


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

	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}

	/*
	@Override
	public boolean equals(Object obj) {
		// 자기자신과 obj값과 비교(참인지 거짓인지 반환)
		if (this == obj) { // 참조값(주소값)이 같은지 비교
			return true;
		}

		if (obj == null) {
			return false;
		}

		// 같은 유형의 클래스인지 검사
		if (this.getClass() != obj.getClass()) { // getClass -> class종류를 나타내는 메서드
			return false;
		}
		
		// 매개변수값을 현재 객체 유형으로 형변환한다.
		Person that = (Person) obj;
		
		if(this.name==null && that.name!=null) { // 내이름은 null이고 상대편이름은 null이 아님
			return false;			
		}
		
		if(this.num==that.num && this.name==that.name) { // 내번호=상대편번호 그리고 내이름=상대편이름
			return true;
		}
		
		if(this.num==that.num && this.name.equals(that.name)) {
			return true;
		}
		
		return false;
	}
	*/
	
	

	
}
