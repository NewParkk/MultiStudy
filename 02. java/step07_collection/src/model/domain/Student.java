package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student implements Comparable<Student>{
	private String name;
	private int studentNo;
	private String grade;
	
	
	
	@Override
	public int compareTo(Student student) {
		if (student.getStudentNo() < this.getStudentNo()) {
			return 1;
		} else if(this.getStudentNo() < student.getStudentNo()) {
			return -1;
		}
		return 0;
	}
}