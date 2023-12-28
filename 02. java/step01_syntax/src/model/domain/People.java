/* 도메인 모델(Domain Model)
 * - 객체 지향 분석 설계 기반으로 구현하고자 하는 도메인(비즈니스 영역)의 모델을 생성하는 패턴
 * - 도메인에서의 객체 판별, 목록 작성, 객체간의 관계
 * - 속성과 기능 분리
 * - 단순 : 테이블 하나 = 하나의 도메인 객체
 * - 재사용성, 유지보수 용이, 확장성
 * - 모델 구축의 어려움
 */
package model.domain;

public class People {
	// 캡슐화 Capsulation
	// : 객체의 멤버변수에 직접적으로 외부에서 접근x(객체보호)
	private String name;
	private int age;
	
	public People() {}
	

	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
