package workshop.person.entity;

public class PersonEntity {
	String name;
	char gender;
	String ssn;
	String address;
	String phone;
	
	PersonEntity(){
		
	}

	public PersonEntity(String name, String ssn, String address, String phone) {
		super();
		this.name = name;
		//this.ssn = ssn;
		setSsn(ssn);
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
		char flag = this.ssn.charAt(6);
		if(flag == '1' || flag == '3')setGender('³²');
		else if(flag == '2' || flag == '4')setGender('¿©');
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
