package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 이 클래스는 소켓을 통해서 메시지를 보내는 역할을 담당하는 클래스이다.

public class Sender extends Thread{
	private Socket socket;
	// 주로 채팅할때 문자열로 하니까...
	private DataOutputStream dos;
	
	//메세지를 보낼때 입력하기 위해서...
	private Scanner scan;
	//누가 메시지를 보냈는지 구분...
	private String name;
	
	//생성자
	public Sender(Socket socket) {
		// 소켓초기화
		this.socket = socket;
		scan = new Scanner(System.in);
		
		System.out.println("이름 입력 : ");
		name = scan.nextLine();
		
		try {
			// 실제 데이터를 주고받을수있는 객체 생성
			dos = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		while(dos!=null) {
			try {
				// 이름과 입력한 문자열을 연결하여 전송한다.
				dos.writeUTF(name + " : " + scan.nextLine());
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
	
}
