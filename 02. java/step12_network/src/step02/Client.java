package step02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		//연결
		Socket socket = new Socket();
		System.out.println("연결요청중입니다.");
		try {
			socket.connect(new InetSocketAddress("localhost", 9999));
			System.out.println("서버 접속 완료입니다.");
		
			// 데이터 전달
			Scanner sc = new Scanner(System.in);
			String msg = sc.nextLine();
			
			OutputStream os = socket.getOutputStream();
			os.write(msg.getBytes());
			os.flush();
		
			System.out.println("메세지 전송 완료입니다.");
		
		
		
		
		
		
		
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
