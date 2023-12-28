package step01;

import java.io.File;
import java.io.IOException;

public class Ex04File {

	public static void main(String[] args) {
		File file = new File("fileTest.txt");
		String loc = "C:\\java";
		File directory = new File(loc);
//		directory.mkdir();
		
		//java 폴더에 java.txt 파일을 생성?
		File javaFile = new File(loc, "java.txt");

		System.out.println(javaFile.getName());
		System.out.println(javaFile.getAbsoluteFile());
		
		
//		try {
//			javaFile.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		

		
		
		
		
		
		
		
		
		
		
	}

}
