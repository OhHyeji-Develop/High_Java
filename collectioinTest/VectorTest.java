package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
		// Collection들은 자바의 객체만 저장할 수 있다.
		
		//Vector를 사용하려면 vector객체를 생성해야함
		Vector v1 = new Vector(); // 벡터의 객체생성
		
		System.out.println("처음 크기 : " + v1.size()); // 0 출력
		//------------------------------------------------
		// 벡터에 데이터 추가하기 : add(추가할 데이터)
		// add메서드를 사용하면 반환값이 나옴 : 성공(true), 실패(false)
		v1.add("aaaa");
		v1.add(new Integer(123));
		v1.add(111);  // 숫자를 쓰면 자동으로 일반데이터를 객체화시켜줌 -> 오토박싱 <=> 오토언박싱
		v1.add('a');
		v1.add(true);// 논리형데이터도 추가 가능
		
		boolean r = v1.add(3.14); // 실수형데이터도 추가 가능
		
		System.out.println("현재 크기 : " + v1.size()); // 6 출력
		System.out.println("반환값 : " + r); // 반환값 true 출력
		//------------------------------------------------
		// 데이터 추가하기 2 : addElement(추가할 데이터)
		// └> 이전 버전에서부터 지원하는 메서드
		// 	  이전 버전의 프로그램도 사용할 수 있도록 하기 위해서 남아잇는 메서드
		v1.addElement("cccc");
		
		System.out.println("v1 -> " + v1); // [aaaa, 123, 111, a, true, 3.14, cccc] 출력
		//------------------------------------------------
		// 데이터 추가하기 3 : add(index, 추가할 데이터)
		// 벡터는 데이터를 보관할때 배열을 이용
		// ==> 'index'번째에 '데이터'를 끼워 넣는다.
		// ==> 'index'는 0부터 시작한다.
		// ==> 반환값이 없다.
		v1.add(1, "kkkk");
		System.out.println("v1 -> " + v1); // [aaaa, kkkk, 123, 111, a, true, 3.14, cccc] 출력
		System.out.println();
		//------------------------------------------------
		// 데이터 꺼내오기 : get(index)
		// ==> 'index'번째의 데이터를 꺼내와 반환한다.
		String temp = (String)v1.get(0); // 벡터에서 꺼내온 값은 object타입이기때문에 형변환해줘야함
		System.out.println("꺼내온 값 -> " + temp);
		int i = (int)v1.get(2); // 오토 언박싱작업
		System.out.println("꺼내온 값 -> " + i);
		System.out.println();
		//------------------------------------------------
		// 데이터 수정하기 : set(index, 새로운 데이터)
		// ==> 'index'번째의 데이터를 '새로운 데이터'로 덮어쓴다.
		// ==> 반환값 : 원래의 데이터가 나옴
		String temp2 = (String)v1.set(0, "zzzz");
		System.out.println("temp2 -> " + temp2);  // aaaa 출력
		System.out.println("v1 => " + v1); // [zzzz, kkkk, 123, 111, a, true, 3.14, cccc]출력
		System.out.println(); 
		//------------------------------------------------
		// 데이터 삭제하기 : remove(index)
		// ==> 'index'번재의 자료를 삭제
		// ==> 반환값 : 삭제된 데이터가 나옴
		String temp3 = (String)v1.remove(0);
		System.out.println("삭제된 데이터 -> " + temp3);
		System.out.println("삭제 후 v1 -> " + v1); // [kkkk, 123, 111, a, true, 3.14, cccc]출력
		System.out.println();
		// 데이터 삭제하기 2 : remove(삭제할 데이터)
		// ==> '삭제할 데이터'를 찾아서 삭제한다.
		// ==> '삭제할 데이터'가 여러개이면 앞에서부터 삭제된다.
		// ==> 반환값 : 삭제성공(true), 삭제실패(false)
		// ==> '삭제할 데이터'가 '정수형'이거나 'char형'일 경우에는 반드시 객체로 변환해서 사용해야 한다.
		v1.remove("cccc");
		System.out.println("삭제 후 v1 -> " + v1);
		
		// v1.remove(123); -> 123이 index로 인식되어 처리된다.
		v1.remove(new Integer(123));
		System.out.println("삭제 후 v1 -> " + v1); // [kkkk, 111, a, true, 3.14] 출력
		
		// v1.remove('a');
		v1.remove(new Character('a'));
		System.out.println("삭제 후 v1 -> " + v1); // [kkkk, 111, true, 3.14] 출력
		v1.remove(true);
		v1.remove(3.14);
		System.out.println("삭제 후 v1 -> " + v1); // [kkkk, 111] 출력
		System.out.println("------------------------------");
		//------------------------------------------------
		/*
		 * - 제네릭타입(Generic Type) ==> 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법으로 객체를 생상할 때
		 *   < > 괄호안에 그 객체의 내부에서 사용할 데이터의 타입을 지정해 주는 것을 말한다.
		 *   이런식으로 객체를 생성하면 제네릭 타입으로 지정한 종류의 데이터 이외의 다른 데이터는 저장할 수 없다.
		 * - 제네릭 타입으로 지정할 수 있는 데이터 타입은 '클래스형'이어야 한다.
		 *   (int는 Integer, boolean은 Boolean, char는 Character 등으로 대체해서 기술해야 한다.)
		 *   
		 * - 제네릭 타입으로 생성하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요없다.
		 */
		
		//String형을 저장할 수 있는 Vector 객체 생성
		Vector<String> v2 = new Vector<String>();
		
		//int형을 저장할 수 있는 Vector 객체 생성
		Vector<Integer> v3 = new Vector<>();
		
		v2.add("안녕하세요");
		// v2.add(100);  -> 오류 : 다른 종류의 데이터를 저장할 수 없다.
		String temp4 = v2.get(0); // 형변환 필요없음
		
		Vector<Vector> vv = new Vector<Vector>(); // 2차원배열과 비슷
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
		//------------------------------------------------
		// 모든 데이터 삭제하기  : clear()
		v2.clear();
		System.out.println("v2의 size : " + v2.size());
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBBB");
		v4.add("EEEE");
		
		System.out.println("v2 -> " + v2);
		System.out.println("v4 -> " + v4);
		//------------------------------------------------
		// 데이터 삭제하기 3 : removeAll(Collection객체)
		// ==> 'Collection객체'가 가지고 있는 데이터를 모두 삭제한다.
		// ==> 반환값 : 삭제성공(true), 삭제실패(false)
		v2.removeAll(v4); // v2가 가지고있는 데이터 중 v4와 같은 데이터를 지우기
		System.out.println("v2 -> " + v2); // [AAAA, CCCC, DDDD] 출력
		
		//------------------------------------------------
		v2.clear();
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		// Vector의 데이터를 순서대로 모두 가져와 처리
		// 이 때 반복문을 사용한다. (주로 for문 사용)
		for(int j = 0; j < v2.size(); j++) {
			System.out.println(j + "번째 자료 : " + v2.get(j));
		}
		//------------------------------------------------
		// 향상된 for문 -> for(자료형 변수 : 꺼내올 대상)
		for(String str : v2) { // v2에서 꺼내옴
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
