package code.model;

public abstract class Person {
	private String name;
	private Gender gender;
	private int age;
	private ContactDetails contactDetails;
	
	public Person(String name, Gender gender, int age, ContactDetails contactDetails) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.contactDetails = contactDetails;
	}

	
	public Person(String name, Gender gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}


	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
