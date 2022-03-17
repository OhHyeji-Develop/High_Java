// 2022-03-10-08
package kr.or.ddit.basic.stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		// 입출력 향상을 위하여 Buffered스트림을 사용한다.
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(char i = '1'; i <= '9'; i++) {
				bout.write(i);
			}
			
//			bout.flush();
			bout.close();
			
			System.out.println("작업 끝.");
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
