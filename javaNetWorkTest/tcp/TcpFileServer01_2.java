package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer01_2 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		System.out.println("접속을 기다립니다...");
		
		Socket socket = server.accept();
		
		System.out.println("클라이언트와 연결되었습니다.");
		System.out.println();
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		FileOutputStream fout = new
				 FileOutputStream("d:/d_other/down/Penguins_복사본.jpg");
		int copy;

		while ((copy = dis.read()) != -1) {
			fout.write(copy);
		}
	
		System.out.println("저장완료");
		
		System.out.println("연결을 종료합니다.");
		
		dis.close();
		socket.close();
		server.close();
		
	}
	
	
	
}