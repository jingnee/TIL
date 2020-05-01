package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.pet;

public class TestAnimals {

	public static void main(String[] args) {
		
		//Cat 객체를 생성하는 방법 3가지
		Cat cat1 = new Cat();
		cat1.setName("플러피");
		System.out.println(cat1.getName());
		cat1.play();
		cat1.eat();
		cat1.walk();
		
		Animal cat2 = new Cat("나비");
		cat2.eat();
		cat2.walk();
		
		pet cat3 = new Cat();
		cat3.setName("야옹이");
		System.out.println(cat3.getName());
		cat3.play();
		
	}

}
