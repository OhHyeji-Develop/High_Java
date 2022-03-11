//package kr.or.ddit.basic;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Scanner;
//import java.util.Set;
//
//public class HotelTest_Me {
//	
//	private Scanner scan = new Scanner(System.in);
//	private HashMap<Integer, Room> hotelMap = new HashMap<>();
//
//	public static void main(String[] args) {
//		
//		System.out.println("[호텔문을 열었습니다]");
//		
//		new HotelTest_Me().menu();
//
//	}
//
//	//메인 화면
//	public void menu() {
//		
//		while(true) {
//			System.out.println();
//			System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
//			System.out.print(" 번호입력 ➜ ");
//			int input = scan.nextInt();
//			
//			switch(input) {
//			case 1: checkIn(); break;
//			case 2: checkOut(); break;
//			case 3: condition(); break;
//			case 4: 
//				System.out.println("[호텔문을 닫았습니다]");
//				System.exit(0); break;
//			default : System.out.println("잘못입력했습니다.");
//			}
//		}
//		
//		
//		
//	}
//
//	//체크인
//	public void checkIn() {
//		
//		System.out.println("┌──────[체크인]──────┐");
//		System.out.println("   201~209 : 싱글룸");
//		System.out.println("   301~309 : 싱글룸");
//		System.out.println("   401~409 : 싱글룸");
//		System.out.println("└──────────────────┘");
//		System.out.print("객실 번호 입력 ➜ ");
//		int roomNo = scan.nextInt();
//		
//		// 객실존재여부
//		if(roomNo < 201 || roomNo > 409) {
//			System.out.println(roomNo + "호 객실은 존재하지 않습니다.");
//			System.out.println("메뉴화면으로 돌아갑니다.");
//			return;
//		}
//		// 객실중복체크
//		if (hotelMap.containsKey(roomNo)) {
//			System.out.println(roomNo + "호 객실은 이미 손님이 있습니다.");
//			System.out.println("메뉴화면으로 돌아갑니다.");
//			System.out.println();
//			return;
//		}
//		
//		System.out.println("누구를 체크인 하시겠습니까?");
//		System.out.print("이름 입력 ➜ ");
//		String guest = scan.next();
//		
//		// 방번호에 맞는 방종류부여
//		if(roomNo >= 401) {
//			hotelMap.put(roomNo, new Room(roomNo, "스위트룸", guest));
//		}else if(roomNo >= 301) {
//			hotelMap.put(roomNo, new Room(roomNo, "더블룸", guest));
//		}else {
//			hotelMap.put(roomNo, new Room(roomNo, "싱글룸", guest));
//		}
//		
//		System.out.println("체크인 완료하였습니다.");
//		
////		System.out.println(hotelMap);
//		
//	}
//
//	// 체크아웃
//	public void checkOut() {
//		
//		System.out.println("체크아웃할 방번호를 입력해주세요.");
//		System.out.print("방번호 입력 ➜ ");
//		int roomNo = scan.nextInt();
//		
//		if(hotelMap.remove(roomNo) == null) {
//			System.out.println(roomNo + " 번 방에 사용 중인 고객님은 없습니다.");
//			return;
//		} else {
//			System.out.println(roomNo + "호 객실 체크아웃을 완료하였습니다.");
//		}
//
//		hotelMap.remove(roomNo);
//		
//	}
//
//	//객실상태
//	public void condition() {
//		Set<Integer> keySet = hotelMap.keySet();
//		System.out.println("방번호\t객실종류\t고객이름");
//		System.out.println("──────────────────────────────────");
//		
////		System.out.println("현재 객실 상태입니다.");
//		Iterator<Integer> it = keySet.iterator();
//		while(it.hasNext()) {
//			Integer roomNo = it.next();
//			Room value = hotelMap.get(roomNo);
//			System.out.println(roomNo + "\t" + hotelMap.get(roomNo).getRoomName() + "\t" + hotelMap.get(roomNo).getGuest());
//			System.out.println("- - - - - - - - - - - - - - - - - ");
//		}
//		
//	}
//
//}
//
//
//class Room{
//	int roomNo;
//	String roomName;
//	String guest;
//	
//	public Room(int roomNo, String roomName, String guest) {
//		super();
//		this.roomNo = roomNo;
//		this.roomName = roomName;
//		this.guest = guest;
//	}
//	
//	@Override
//	public String toString() {
//		return "Room [roomNo=" + roomNo + ", roomName=" + roomName + ", guest=" + guest + "]";
//	}
//
//
//	public int getRoomNo() {
//		return roomNo;
//	}
//
//
//	public void setRoomNo(int roomNo) {
//		this.roomNo = roomNo;
//	}
//
//
//	public String getRoomName() {
//		return roomName;
//	}
//
//
//	public void setRoomName(String roomName) {
//		this.roomName = roomName;
//	}
//
//
//	public String getGuest() {
//		return guest;
//	}
//
//
//	public void setGuest(String guest) {
//		this.guest = guest;
//	}
//
//
//	
//	
//}