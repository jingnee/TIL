package workshop.person.control;

import java.util.Scanner;

import workshop.person.entity.PersonEntity;

/*
 * java PersonManaver ��
 */

public class PersonManager {

	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("���� ���� �Է��ϼ���");
			System.exit(0);
		}
		
		char gender = args[0].charAt(0);
		System.out.println("�Էµ� ���� ���� " + gender);
		
		PersonManager manager = new PersonManager();
		
		PersonEntity[] persons = new PersonEntity[10];
		manager.fillPersons(persons);
		manager.showPersons(persons);
		
		//scanner�� �Է¹ޱ�
		/*
		 * Scanner scan = new Scanner(System.in); 
		 * System.out.println("������ �Է��ϼ���"); 
		 * char gender = scan.next().charAt(0); 
		 * System.out.println("�Էµ� ���� ���� " + gender);
		 */
		
		System.out.println(gender+ "������ " + manager.findByGender(persons, gender)+ "�� �Դϴ�.");
		
		System.out.println("�̸��� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		System.out.println("�̸�" + name + " ���� ã�� ����Դϴ�.");
		manager.showPersons(persons, name);
		scan.close();
	}
	
	public void showPersons(PersonEntity[] persons, String name) {
		for (PersonEntity person : persons) {
			if(name.equals(person.getName())) {
				System.out.println("[ �̸� ] " + person.getName());
				System.out.println("[ ���� ] " + person.getGender());
				System.out.println("[ ��ȭ��ȣ ] "+ person.getPhone());
				break;
			}
		}
		
	}

	public int findByGender(PersonEntity[] persons, char gender) {
		int cnt = 0;
		for (PersonEntity person : persons) {
			if(person.getGender() == gender) {
				cnt++;
			}
		}
		return cnt;
	}

	public void showPersons(PersonEntity[] persons) {
		//foreach : ctrl + spaceBar
		for (PersonEntity person : persons) {
			System.out.println("[�̸�] " + person.getName()+ "\t[����] " + person.getGender()+ "\t [��ȭ��ȣ] "+ person.getPhone());
		}
	}
	
	public void fillPersons(PersonEntity[] persons) {
		persons [0] = new PersonEntity("�̼�ȣ","7212121028102", "��õ ��籸", "032-392-2932");
		persons [1] = new PersonEntity("���ϴ�","7302132363217", "���� ������", "02-362-1932");
		persons [2] = new PersonEntity("�ڿ���","7503111233201", "���� ���ϱ�", "02-887-1542");
		persons [3] = new PersonEntity("���μ�","7312041038988", "���� ������", "032-384-2223");
		persons [4] = new PersonEntity("ȫ����","7606221021341", "���� ��õ��", "02-158-7333");
		persons [5] = new PersonEntity("�̹̼�","7502142021321", "���� ������", "02-323-1934");
		persons [6] = new PersonEntity("�ڼ���","7402061023101", "���� ���α�", "02-308-0932");
		persons [7] = new PersonEntity("������","7103282025101", "���� ����", "02-452-0939");
		persons [8] = new PersonEntity("Ȳ����","7806231031101", "��õ �߱�", "032-327-2202");
		persons [9] = new PersonEntity("��ö��","7601211025101", "��õ ��籸", "032-122-7832");
	}
}
