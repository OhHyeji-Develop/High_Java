package kr.or.ddit.basic.tcp;

import java.net.Socket;

public class TcpClient02 {

	public static void main(String[] args) {

			try {
				Socket socket = new Socket("localhost",7777);
				System.out.println("서버에 연결되었습니다.");
				System.out.println();
				
				// 보내는거
				Sender sender = new Sender(socket);
				// 받는거
				Receiver receiver = new Receiver(socket);
				
				sender.start();
				receiver.start();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

}
