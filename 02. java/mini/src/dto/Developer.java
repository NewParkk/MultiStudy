package dto;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Developer {
	private String name;
	private String skill;
	private int career;
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("개발자 이름 : ");
		builder.append(name);
		builder.append(", 사용가능 언어 : ");
		builder.append(skill);
		builder.append(", 연차 : ");
		builder.append(career);
		builder.append("년차");	
		return builder.toString();
}
	
}
