package step01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex03BufferedStream {
	// 버퍼(8192바이트 배열)
	
	public static void unuseBufferedStream() throws IOException {
		long start;
		long end;
		
		// file
		FileInputStream fis = new FileInputStream("winter.jpg");
		
		start = System.currentTimeMillis();
		while(fis.read() != -1) {}
		end = System.currentTimeMillis();
		
		System.out.println("버퍼 미사용 : " + (end - start) + "ms");
	}
	
	public static void useBufferedStream() throws IOException {
		long start;
		long end;
		
		// file
		FileInputStream fis = new FileInputStream("winter.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		
		start = System.currentTimeMillis();
		while(bis.read() != -1) {}
		end = System.currentTimeMillis();
		
		System.out.println("버퍼 사용 : " + (end - start) + "ms");
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		try {
			unuseBufferedStream();
			useBufferedStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
