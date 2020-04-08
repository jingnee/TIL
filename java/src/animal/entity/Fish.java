package workshop.animal.entity;

public class Fish extends Animal implements pet{

	public Fish() {
		super(0);
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void play() {
		System.out.println("물고기는 어항에서 놀아요");
		
	}

	@Override
	public void eat() {
		System.out.println("물고기는 플랑크톤을 먹어요");
		
	}
	
	@Override
	public void walk() {
		System.out.println("물고기는 걷지 않고 헤엄쳐요");
	}


}
