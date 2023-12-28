package dto;
import lombok.*;
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

public class ITCompany extends Company{
	private String field;
	private String skill;
	private int teamnum;
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("개발 분야 : ");
		builder.append(field);
		builder.append(", 사용 언어 : ");
		builder.append(skill);
		builder.append(", 팀인원 : ");
		builder.append(teamnum);
		builder.append("명");
		
		return builder.toString();
	}
}
