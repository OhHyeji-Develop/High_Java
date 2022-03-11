// 2022-03-02-03
package kr.or.ddit.basic.generic;

/*
 * 	Generic 클래스 만드는 방법
 * 	형식)
 * 		class 클래스명<제네릭타입글자>{        // 제네릭타입글자 : 대문자 한글자(제네릭타입 지정시 대신하는 글자)
 * 			private 제네릭타입글자 변수명;		// 변수 선언에 제네릭을 사용할 경우
 * 			...
 * 
 * 			(public || private)제네리타입글자 메서명(){		// 반환값이 있는 메서드
 * 			...
 * 			return 값;
 * 			}
 * 
 * 			void 메서드명(제네릭 타입글자 변수명){			// 메서드의 매개변수에 제네릭 사용하기
 * 			...
 * 			}
 * 		}
 * 
 * 	----- 제네릭타입글자 -----
 * 	 T => Type
 *   K => Key
 *   V => Value
 *   E => Element
 * 
 */

// 제네릭사용O
class MyGeneric<T>{
	private T value;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}


//--------------------------------------------
// 제네릭사용X
class NonGeneriClass{
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}


public class GenericTest {

	public static void main(String[] args) {
		
		// 제네릭을 사용하지 않았을때, 오류가 날 가능성 O
		NonGeneriClass ng1 = new NonGeneriClass();
		ng1.setValue("가나다라");
		
		NonGeneriClass ng2 = new NonGeneriClass();
		ng2.setValue(100);
		
		String rtnNg1 = (String)ng1.getValue();
		Integer irtnNg2 = (Integer)ng2.getValue();
		
		System.out.println("문자열 반환값 rtnNg1 : " + rtnNg1);
		System.out.println("정수형 반환값 irtnNg2 : " + irtnNg2);
		
		System.out.println("-------------------------------");
		
		// 제네릭을 사용한 클래스에서 데이터를 꺼내올 때 형변환 없이 사용 가능하다.
		MyGeneric<String> mg1 = new MyGeneric<>();
		mg1.setValue("안녕하세요");
		
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		mg2.setValue(500);
		
		String rtnMg1 = mg1.getValue();
		Integer irtnMg2 = mg2.getValue();
		
		System.out.println("문자열 반환값 rtnMg1 : " + rtnMg1);
		System.out.println("숫자열 반환값 irtnMg2 : " + irtnMg2);
		
		// ----------------------------------------
		// 제네릭을 사용했을 대와 사용하지 않았을때의 오류가 발생하는 시점이 서로 다른 경우의 예
		
		/* 제네릭 사용안했을때 에러
		NonGeneriClass test = new NonGeneriClass();
		test.setValue("우리나라");
		
		// 문법적으로는 오류가 안나지만 실행하면 오류남(빨간줄X)
		Integer num = (Integer)test.getValue();
		System.out.println("num : " + num);
		*/
		
		/* 제네릭 사용했을때 에러
		MyGeneric<String> test2 = new MyGeneric<>();
		test2.setValue("대한민국");
		
//		Integer num2 = test2.getValue(); // 컴파일 단계에서 오류생김(빨간줄O)
		String num2 = test2.getValue(); // 오류해결
		System.out.println("num2 : " + num2);
		*/
		
	}

}
