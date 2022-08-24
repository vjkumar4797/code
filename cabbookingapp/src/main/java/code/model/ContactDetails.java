package code.model;

public class ContactDetails {
	private long phoneNo;

	public ContactDetails() {
	}
	
	public ContactDetails(long phoneNo) {
		super();
		this.phoneNo = phoneNo;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
