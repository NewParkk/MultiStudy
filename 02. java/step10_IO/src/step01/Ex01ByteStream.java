package step01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class Ex01ByteStream {
	// fileSave : outputStram
	public static void fileSave() throws IOException {
		FileOutputStream fos = new FileOutputStream("ByteStream.txt");
		
		
		fos.write(97);
		
		byte[] data = {65, 66, 67, 68 ,69};
		
		fos.write(data);
		
		fos.close();		
	}
	
	
	// fileOpen : inputStream
	
	public static void fileOpen() throws IOException {
		FileInputStream fis = new FileInputStream("ByteStream.txt");
		
		
		// v1
		int data;
		while(fis.read() != -1) {
			System.out.println(fis.read());
		}
		// v2
//		int fileSize = (int)new File("ByteStream.txt").length();
//		byte[] readData = new byte[fileSize];
//		fis.read(readData);
//		
//		for(int i = 0; i < fileSize; i++) {
//			System.out.println(readData[i]);
//		}
		fis.close();
	}
	
	
	
	
	
	
	public static void main(String[] args) {
			try {
//				fileSave();
				fileOpen();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
}
