package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		ManageBook manager = new ManageBook();
		
		Publication[] pubs = new Publication[5];
		
		pubs[0] = new Magazine("����ũ�μ���Ʈ","2007-10-01",328,9900,"�ſ�");
		pubs[1] = new Magazine("�濵����ǻ��","2007-10-03",316,9000,"�ſ�");
		pubs[2] = new Novel("���߿�","2007-07-01",396,9800,"����������������","����Ҽ�");
		pubs[3] = new Novel("���ѻ꼺","2007-04-14",383,11000,"����","���ϼҼ�");
		pubs[4] = new ReferenceBook("�ǿ��������α׷���","2007-01-14",496,25000,"����Ʈ�������");

		for (Publication publication : pubs) {
			System.out.println(publication);
		}
		System.out.println("=========���� ���� �� ===========");
		System.out.println(pubs[2].getTitle() + ": " + pubs[2].getPrice());
		
		manager.modifyPrice(pubs[2]);
		System.out.println("=========���� ���� �� ===========");
		System.out.println(pubs[2].getTitle() + ": " + pubs[2].getPrice());
	}

	//������ �ƱԸ�Ʈ(Polymorphic Argument)
	//Magazine mag = new Magazine()
	//Publication mag = new Magazine();		//������
	
	public void modifyPrice(Publication pub) {
		int price = pub.getPrice();
		double rate = 0.0;
		if(pub instanceof Magazine) {
			rate = 0.4;
		}
		else if(pub instanceof Novel) {
			rate = 0.2;
		}
		else if(pub instanceof ReferenceBook) {
			rate = 0.1;
		}
		
		pub.setPrice(price- (int)(price*rate));
	}
}
