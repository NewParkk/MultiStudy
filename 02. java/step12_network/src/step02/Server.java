package step02;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		
		
		try {
			ServerSocket serverSocket = new ServerSocket();
			// bind() : IP, port
			serverSocket.bind(new InetSocketAddress("localhost", 9999));
			
			while(true) {
				//연결
				Socket socket = serverSocket.accept();				
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println(isa.getHostName() + "님이 입장했습니다.");
				
				// 데이터 응답
				InputStream is = socket.getInputStream();
				byte[] data = new byte[100];
				int countByte = is.read(data);
				String msg = new String(data, 0, countByte, "UTF-8");
				System.out.println("정상적으로 메세지를 받았습니다 : " + msg);
				
			
			
			
			
			
			
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
