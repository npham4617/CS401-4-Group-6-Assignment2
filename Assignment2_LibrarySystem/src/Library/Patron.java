package Library;

public class Patron {
	private int ID;
	private String name;
	private String contactInfo;
	private String borrowingHistory;
	
	public Patron(int ID, String name, String contactInfo, String borrowingHistory) {
	    this.ID = ID;
	    this.name = name;
	    this.contactInfo = contactInfo;
	    this.borrowingHistory = borrowingHistory;
	}

	public int ID() {
	    return ID;
	}
	
	public void setID(int id) {
	   this.ID = id;
	}

	public String name() {
	    return name;
	}
	
	public void setName(String name) {
		   this.name = name;
	}

	public String contactInfo() {
	    return contactInfo;
	}
	
	public void setContactInfo(String contactInfo) {
		   this.contactInfo = contactInfo;
	}

	public String borrowingHistory() {
	    return borrowingHistory;
	}
	
	public void setBorrowingHistory(String borrowingHistory) {
		   this.borrowingHistory = borrowingHistory;
	}

}
