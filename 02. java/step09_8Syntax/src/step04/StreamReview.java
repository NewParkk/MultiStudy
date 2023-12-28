package step04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.domain.Person;

public class StreamReview {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		Person nike = new Person("nike", "entp");
		Person adidas = new Person("adidas", "infp");
		Person yale = new Person("yale", "intj");
		Person reabok = new Person("reabok", "istp");
		Person puma = new Person("puma", "estp");
		Person mizuno = new Person("mizuno", "infp");
		Person asics = new Person("asics", "entj");
		Person spris = new Person("spris", "intp");
		Person vans = new Person("vans", "esfj");
		Person converse = new Person("converse", "isfp");
		Person rapido = new Person("rapido", "istp");
		Person kappa = new Person("kappa", "istj");

		personList.add(nike);
		personList.add(adidas);
		personList.add(yale);
		personList.add(reabok);
		personList.add(puma);
		personList.add(mizuno);
		personList.add(asics);
		personList.add(spris);
		personList.add(vans);
		personList.add(converse);
		personList.add(rapido);
		personList.add(kappa);
		
		System.out.println("***MBTI***");
		// i && j 사람을 출력?
		personList.stream()
						.filter((person) -> person.getMbti().contains("i") && person.getMbti().contains("j")) 
						.forEach((person) -> System.out.println(person)); 
		
		
		personList.stream()
						.filter((person) -> person.getMbti().startsWith("i") && person.getMbti().endsWith("j")) 
						.forEach((person) -> System.out.println(person));
		
		
		// 정규식
		personList.stream()
						.filter((person) -> person.getMbti().matches("i..j")) 
						.forEach((person) -> System.out.println(person));
		
		
		// 사람의 이름 정렬된 출력?
		personList.stream()
					.sorted(Comparator.comparing(Person::getName))
					.forEach((person) -> System.out.println(person));
		
		// mbti별로 사람 정보 출력
		System.out.println(
				personList.stream()
								.collect(Collectors.groupingBy(Person::getMbti))
				
				);
		
		
		
		
	}
}