package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
 * 		문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고 
 * 			 Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * 
 * 			 전화번호 정보는 Map에 저장하여 관리한다.
 * 			 (key값은 입력받은 사람의 '이름'으로 하고, value값은 'Phone클래스의 인스턴스'로 한다.
 * 
 * 			 아래 메뉴의 기능을 모두 작성하시오.
 * 			 (삭제, 검색 기능 -> '이름'을 입력받아 처리)		
 * 
 * 				Map<String, Phone> map
 * 				map.put(name, new Phone(name, tel, addr))	 
 *
 * 			 실행)
 * 
 * 			 1. 전화번호 등록
 * 			 2. 전화번호 수정  
 * 			 3. 전화번호 삭제  
 * 			 4. 전화번호 검색
 * 			 5. 전화번호 전체 출력
 * 			 0. 프로그램 종료
 * 			-------------------
 * 			 번호입력>> 1
 * 			 
 * 			 새롭게 등록할 전화번호 정보를 입력하세요.
 * 			 이름 >> 홍길동
 * 			 전화번호 >> 010-1111-1111
 * 			 주소 >> 대전시 중구 오류동
 * 			(입력한 데이터를 phone 객체에 저장하고 저장한 객체를 Map에 넣음)
 * 			 '홍길동'전화번호 정보 등록 완료!
 * 			-------------------
 * 			 실행)
 * 			 1. 전화번호 등록
 * 			 2. 전화번호 수정  
 * 			 3. 전화번호 삭제  
 * 			 4. 전화번호 검색
 * 			 5. 전화번호 전체 출력
 * 			 0. 프로그램 종료
 * 			-------------------
 * 			 번호입력>>
 * 			 -------------------
 * 			 (중복된 이름 입력할 때 : '홍길동'은 이미 등록된 사람입니다.
 * 			  -> 다시 메뉴 출력)
 * 			-------------------
 * 			 실행)
 * 			 1. 전화번호 등록
 * 			 2. 전화번호 수정  
 * 			 3. 전화번호 삭제  
 * 			 4. 전화번호 검색
 * 			 5. 전화번호 전체 출력
 * 			 0. 프로그램 종료
 * 			-------------------
 * 			 번호입력>>5
 * 			-------------------
 * 			 번호		이름	 	전화번호		   주소
 * 			  1		홍길동	010-1111-1111  대전시 중구 오류동
 * 			-------------------
 * 			 출력완료 후 다시 메뉴 출력
 * 
 * 
 * 
 * 		전화번호 중복확인
 * 

 */

public class PhoneBookTest {

	private Scanner scan = new Scanner(System.in);
	private HashMap<String, Phone> map = new HashMap<String, Phone>();

 /*선생님 풀이
	public PhoneBookTest() {
		phoneBookMap = new HashMap<String, Phone>();
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {

		new PhoneBookTest().phoneStart();

	}
	
	// 전화번호 정보 전체 자료를 출력하는 메서드
	 * private void displayAll(){
	 * System.out.println();
	 * 
	 * 모든 key값 가져오기
	 * Set<String> phoneKeySet = phoneBookMap.keySet();
	 * System.out.println("번호    이름    전화번호    주소");
	 * if(phoneKeySet.size()==0){
	 *		System.out.println("등록된 전화번호가 없습니다.");
	 *	}else{
	 *		for cnt = 0;
	 *		for(String name : phoneKeySet){
	 *			cnt++;
	 *			phone p = phoneBookMap.get(name);
	 *			System.out.println(cnt + " " + name + " " + p.getTel() + " " + p.getAddr());
	 *		}
	 *	}
	 * System.out.println("출력 끝");
	 * }
	*/
	
	/* 전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요");
		System.out.print("이름>>");
		String name = scan.next();
		//입력한 사람의 이름이 전화번호목록에 없으면....
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 등록되지 않은 사람입니다.");
			System.out.println("수정작업을 마칩니다.");
			return;
		}
		
		System.out.print("수정할 전화번호>>");
		String newTel = scan.next();
		
		System.out.print("수정할 주소>>");
		String newAddr = scan.next();
		
		phoneBookMap.put(name, newTel, newAddr);
		System.out.println(name + "님의 전화번호 수정완료!");
	}
	*/
	
	/* 삭제
	private void delete() {
		System.out.println("삭제할 이름을 입력하세요");
		System.out.print("이름>>");
		String name = scan.next();
		
		//containsKey로 이름이 있나없나 확인
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 등록되지 않은 사람입니다.");
			System.out.println("수정작업을 마칩니다.");
			return;
		}
		
		phoneBookMap.remove(name);
		System.out.println(name + "님의 전화번호 정보 삭제완료!");
		
	}
	*/
	
	/*검색
	private void search() {
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		String name = scan.next();
		
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 등록되지 않은 사람입니다.");
			System.out.println("검색작업을 마칩니다.");
			return;
		}
		
		Phone p = phoneBookMap.get(name);
		System.out.println(name + "님의 전화번호정보");
		System.out.println("---------------------------");
		System.out.println("이름 : " + p.getName());
		System.out.println("전화번호 : " + p.getTel());
		System.out.println("주소 : " + p.getAddr());
		System.out.println("---------------------------");
		
	}
	*/
	
	
	
	//------------------------------------------------------
	// 내풀이
	public static void main(String[] args) {

		new PhoneBookTest().start();

	}
	

	public void start() {

		while(true) {
						
			System.out.println("┌──────────────┐");
			System.out.println("  1. 전화번호 등록");
			System.out.println("  2. 전화번호 수정");
			System.out.println("  3. 전화번호 삭제");
			System.out.println("  4. 전화번호 검색");
			System.out.println("  5. 전화번호 목록");
			System.out.println("  0. 프로그램 종료");
			System.out.println("└──────────────┘");
			System.out.print(" 번호 입력 ➜ ");
			System.out.println();
		
			int select = scan.nextInt();

			switch (select) {
			case 1:
				insertPhone();
				break; // 등록
			case 2:
				updatePhone();
				break; // 수정
			case 3:
				deletePhone();
				break; // 삭제
			case 4:
				searchPhone();
				break; // 검색
			case 5:
				listPhone();
				break;
			case 0:
				System.exit(0);
				System.out.println("프로그램을 종료합니다.");
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	// 번호 등록
	public void insertPhone() {
		scan.nextLine();
		// 입력버퍼 비우기(스캐너로 입력받는 명령중에 nextLine쓰기전에 nextLine이 아닌 명령이 있으면 첫줄에 scan.nextLine();을 적어줘야함)
		
		/*
		 * Scanner 객체의 입력메서드의 특징
		 *  - next(), nextInt(), nextDouble(),...등
		 *     => 사이띄기, Tab키, Enter키를 구분 문자로 분리해서 분리된 자료만 읽어간다.
		 *  - nextLine()
		 *     => 한 줄 단위로 입력한다.
		 *     => 즉, 자료를 입력하고 Enter키를 누르면 Enter키까지 읽어간다.
		 *  - Scanner는 입력한 값이 입력버퍼에 먼저 저장된 후에 차례로 꺼내와서 처리된다. 
		 */

		System.out.print("이름을 입력해주세요 ➜ ");
		String name = scan.nextLine();
		// nextLine() -> 한문장으로 저장됨(엔터키값까지 저장)

		if (map.containsKey(name)) {
			System.out.println(name + "은 등록된 사람입니다.");
			System.out.println("메뉴화면으로 돌아갑니다.");
			System.out.println();
			return;
		}
		

		System.out.print("전화번호를 입력해주세요 ➜ ");
		String tel = scan.nextLine();

		System.out.print("주소를 입력해주세요 ➜ ");
		String addr = scan.nextLine();

		map.put(name, new Phone(name, tel, addr));
		System.out.println(name + "님 등록 완료! ");
		
//		System.out.println(map);
		
	


	}

	// 번호 수정
	public void updatePhone() {
		
		
		System.out.print("수정할 이름을 입력해주세요 ➜ ");
		String name = scan.next();
		
		if (map.get(name) == null) {
			System.out.println(name + "은 등록된 사람이 아닙니다.");
			System.out.println("메뉴화면으로 돌아갑니다.");
			System.out.println();
			return;
		}
		
		System.out.print("수정할 전화번호를 입력해주세요 ➜ ");
		String tel = scan.next();
		System.out.print("수정할 주소를 입력해주세요 ➜ ");
		String addr = scan.next();
		
		
		Phone p = new Phone(name, tel, addr);
		map.put(name, p);
		
		System.out.println(name + "님 수정완료!");
		
//		System.out.println(map);
		
		
		

	}

	// 번호 삭제
	public void deletePhone() {
		
		System.out.print("삭제할 이름을 입력해주세요 ➜ ");
		String name = scan.next();
		
		if (map.get(name) == null) {
			System.out.println(name + "은 등록된 사람이 아닙니다.");
			System.out.println("메뉴화면으로 돌아갑니다.");
			System.out.println();
			return;
		}
		
		System.out.println(name + "님 삭제완료!");
		map.remove(name);
		
		

	}

	// 번호 검색
	public void searchPhone() {
		
		System.out.print("조회할 이름을 입력해주세요 ➜ ");
		String name = scan.next();
		
		if (map.get(name) == null) {
			System.out.println(name + "은 등록된 사람이 아닙니다.");
			System.out.println("메뉴화면으로 돌아갑니다.");
			System.out.println();
			return;
		}
		
		System.out.println(name + "님의 전화번호 : " + map.get(name).getTel());
		System.out.println(name + "님의 주소 : " + map.get(name).getAddr());
		

	}

	// 목록 출력
	private void listPhone() {
		
		Set<String> keySet = map.keySet();
		
		System.out.println("이름\t전화번호\t\t주소");
		System.out.println("──────────────────────────────────");
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String name = it.next();
			Phone value = map.get(name);
			System.out.println(name + "\t" + map.get(name).getTel() + "\t" + map.get(name).getAddr());
		}

	}

}

// 하나의 전화번호 정보가 저장될 class 작성
class Phone {

	String name;
	String tel;
	String addr;

	// 생성자
	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	// getter, setter 생성(alt+Shift+S)
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}

}
