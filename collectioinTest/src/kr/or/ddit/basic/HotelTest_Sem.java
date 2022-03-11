package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class HotelTest_Sem {
	private HashMap<Integer, Room> hotelMap;
	private Scanner scan;

	// 생성자 -> 방번호와 방종류를 초기화 작업 진행
	public HotelTest_Sem() {
		hotelMap = new HashMap<Integer, Room>();
		scan = new Scanner(System.in);

		// 객실 초기화 작업
		for (int i = 2; i <= 4; i++) {
			String roomType = null;
			switch (i) {
			case 2:
				roomType = "싱글룸";
				break;
			case 3:
				roomType = "더블룸";
				break;
			case 4:
				roomType = "스위트룸";
				break;
			}

			for (int j = 1; j <= 9; j++) {
				int roomNum = i * 100 + j;
				Room r = new Room(roomNum, roomType);
				hotelMap.put(roomNum, r);
			}
		}
	}

	public static void main(String[] args) {

		new HotelTest_Sem().hotelStart();

	}

	private void hotelStart() {
		System.out.println("[호텔문을 열었습니다. 어서오십쇼~]");
		System.out.println();
		
		while (true) {
			int choice = displayMenu();
			
			switch (choice) {
			case 1: // 체크인
				checkIn(); break;
			case 2: // 체크아웃
				chechOut(); break;
			case 3: // 객실상태
				displayRoomState(); break;
			case 4: // 업무종료
				System.out.println("[호텔문을 닫습니다.]");
				return;
			default:
				System.out.println("잘못입력했습니다.");
				System.out.println("다시 입력하세요.");
			}
		}
	}

	private void chechOut() {
		System.out.print("체크아웃할 방번호 입력>>");
		int num = scan.nextInt();
		
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		if(hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}
		
		// 체크아웃 작업은 해당 객실의 투숙객 이름을 null로 변경하는것
		// 해당 방에 있는 투숙객 이름 저장
		String name = hotelMap.get(num).getGuestName();
		
		// 투숙객 이름을 null로 변경
		hotelMap.get(num).setGuestName(null);
		
		System.out.println(num + "호 객실의 " + name + "님 체크아웃 완료했습니다.");
		
	}

	// 체크인 메서드
	private void checkIn() {
		System.out.println("--------------------");
		System.out.println("  201~209 : 싱글룸");
		System.out.println("  301~309 : 더블룸");
		System.out.println("  401~409 : 스위트룸");
		System.out.println("--------------------");
		System.out.print("방번호 입력>>");
		int num = scan.nextInt();
		
		// 입력한 값이 Map의 키 값에 없으면 없는 방번호이다.
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		// 해당 객실에 다른 투숙객이 있는지 검사
		if(hotelMap.get(num).getGuestName()!=null) {
			System.out.println(num + "호 객실에는 이미 손님이 있습니다.");
			return;
		}
		
		System.out.print("체크인 이름 입력>>");
		String name = scan.next();
		
		// 해당 방번호의 Room객체의 투숙객저장변수에 입력받은 이름을 저장한다.
		hotelMap.get(num).setGuestName(name);
		
		System.out.println(name + "님이 " + num + "호 객실에 체크인 하였습니다.");
	}

	// 객실상태를 출력하는 메서드
	private void displayRoomState() {
		System.out.println();
		System.out.println("[현재 객실 상태]");
		System.out.println("----------------------");
		System.out.println("방번호    방종류    이름");
		System.out.println("----------------------");

		// 전체 방번호를 가져와 처리한다.

		// 방번호를 순서대로 나오게 하기 위해서 방번호(Map의 key값)만 List에 넣은 후 정렬하여 사용한다.
		ArrayList<Integer> roomNumList = new ArrayList<Integer>(hotelMap.keySet());
		// 정렬하기
		Collections.sort(roomNumList);

		for (Integer roomNum : roomNumList) {
			Room r = hotelMap.get(roomNum);

			String name = " - ";
			if (r.getGuestName() != null) {
				name = r.getGuestName();
			}

			System.out.print(r.getRoomNum() + "\t");
			System.out.print(r.getRoomType() + "\t");
			System.out.println(name);
		}
		System.out.println("----------------------");
		System.out.println();
	}

	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println("-------------------------------");
		System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("-------------------------------");
		System.out.print("번호입력>>");
		return scan.nextInt();
	}

}

class Room {
	private int roomNum; // 방번호
	private String roomType; // 방종류
	private String guestName; // 투숙객 이름

	// 생성자
	public Room(int roomNum, String roomType) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

}
