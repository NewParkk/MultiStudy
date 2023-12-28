package step01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.domain.Person;



public class Ex06Serialization {
	
	// 객체(Obejct)의 정보를 파일로 출력
	public static void outObject() throws Exception {
		FileOutputStream fos = new FileOutputStream("Object.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(new String("IT"));
		oos.writeObject(new Integer(10));
		
		oos.flush();
		oos.close();
		fos.close();
	}
	
		
	public static void inObject() throws IOException {
			FileInputStream fis = new FileInputStream("Object.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = null;
		while(true) {
			try {
				obj = ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(obj);
		}
	}
	
	// 객체(Person) 정보를 입력
	public static void outPerson() throws IOException {
		FileOutputStream fos = new FileOutputStream("Person.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Person person = new  Person("IT", 29, 1001);
		oos.writeObject(person);
		
		oos.flush();
		oos.close();
		fos.close();
		
	}
	
	// 파일의 객체(Person) 정보를 입력
	public static void inPerson() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("Person.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Person person = (Person)ois.readObject();
		System.out.println(person);
		
		ois.close();
		fis.close();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 객체의 정보를 파일로 출력
		try {
			
	//				inPerson();
			outPerson();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
		
		
		
		
	
