package step01;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex02CharacterStream {
	
	// fileSave : fileWriter
	public static void fileSave() throws IOException {
		FileWriter fw = new FileWriter("CharacterStream.txt");
		
		
		char[] city = {'하', '노', '이'};
		fw.write(city);
		fw.write("시드니");
		
		fw.close();
	}
		
		
		// fileOpen : fileReader
	public static void fileOpen() throws IOException {
		FileReader fw = new FileReader("CharacterStream.txt");
		
		int data;
		while((data = fw.read()) != -1) {
			System.out.println(data);
		}
		
	}
	
	
	

	
	
	
	public static void main(String[] args) {
		try {
//			fileSave();
			fileOpen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
