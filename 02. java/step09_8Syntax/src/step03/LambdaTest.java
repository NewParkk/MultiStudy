package step03;

import java.util.Arrays;
import java.util.function.Supplier;

import model.domain.Developer;

class Weapon {
	public void skill() {
		System.out.println("무기");
	};
}

class Sword extends Weapon{
	@Override
	public void skill() {
		System.out.println("빳칭");
	};
}

class Gun extends Weapon{
	@Override
	public void skill() {
		System.out.println("빵야");
	};
}

class Warrior {
	public void attack(Weapon weapon) {
		weapon.skill();
	}

	public void attack(WeaponInterface weaponInterface) {
		weaponInterface.skill();
	}
}

@FunctionalInterface
interface WeaponInterface {
	void skill();
}


public class LambdaTest {
	
	// 함수형 인터페이스
	@FunctionalInterface
	interface Lambda1 {
		void method1(int x, int y);
	}
	
	public static void main(String[] args) {
		Lambda1 l1 = (x, y) -> {
			System.out.println("함수형 인터페이스");
		};
		l1.method1(5, 5);
//		System.out.println(l1);
//	
//		
//	Warrior warrior = new Warrior();
//	warrior.attack(new Sword());
//	warrior.attack(new Gun());
//
//	System.out.println();
//	
//	WeaponInterface wi1 = () -> System.out.println("빳칭");
//	
//	
//	warrior.attack(() -> System.out.println("빳칭"));
//	warrior.attack(() -> System.out.println("빵야"));
//	
//	warrior.attack(wi1);
//	warrior.attack(wi1);
	
	
	// Developer 객체 생성
	Supplier<Developer> dev = () -> new Developer();
	Supplier<Developer> dev2 = Developer::new;
	
	//
	Double[] nums = {1.0, 4.0, 9.0, 16.0};
	// Math
	for(int i = 0; i < nums.length; i++) {
		System.out.println(Math.sqrt(nums[i]));
	}
	
	//
	Arrays.stream(nums)
			.map(Math::sqrt)
			.forEach(num -> System.out.println(num));
	
	
	
	
	
	}
}