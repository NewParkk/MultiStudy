package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import step02.DevType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Developer {
	private String name;
	private int carreer;
	private DevType devType;
}
