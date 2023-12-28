package model.domain;

public class Studentmodel {
	String name;
	int age;
	int studentid;
	String grade;
	String hobby;
	

  public  Studentmodel() {}
  public  Studentmodel(String name, int age, int studentid, String grade, String hobby ) {
	this.name = name;
	this.age = age;
	this.studentid = studentid;
	this.grade = grade;
	this.hobby = hobby;
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
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}

@Override
public String toString() {
	return "Studentmodel [name=" + name + ", age=" + age + ", studentid=" + studentid + ", grade=" + grade + ", hobby="
			+ hobby + "]";
}

}