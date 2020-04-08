package workshop.animal.entity;

public class Cat extends Animal implements pet {
	String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}

	public Cat() {
		this("");
	}
	
	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void play() {
		System.out.println("고양이는 쥐랑 놀아요");

	}

	@Override
	public void eat() {
		System.out.println("고양이는 물고기를 먹어요");

	}

}
