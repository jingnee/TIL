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
		System.out.println("������ ���׿��� ��ƿ�");
		
	}

	@Override
	public void eat() {
		System.out.println("������ �ö�ũ���� �Ծ��");
		
	}
	
	@Override
	public void walk() {
		System.out.println("������ ���� �ʰ� ����Ŀ�");
	}


}
