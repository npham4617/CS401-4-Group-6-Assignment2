package Library;

import java.util.*;

public class Patron {
	private int ID;
	private String name;
	private String email;
	private String phone_number;
	private String typeUser;
	private List<Transaction> borrowingHistory;
	
	public Patron(int ID, String name, String email, String phone_number, String typeUser) {
	    this.ID = ID;
	    this.name = name;
	    this.email = email;
	    this.phone_number = phone_number;
	    this.typeUser = typeUser;
	    this.borrowingHistory = new ArrayList<>();
	}

	public int ID() {
	    return ID;
	}
	
	public void borrowingHistory(int id) {
	   this.ID = id;
	}

	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String email() {
	    return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
		
	public String phone_number() {
		 return phone_number;
	}
		
	public void setPhone_number(String phone_number) {
		 this.phone_number = phone_number;
	}

	public void addToBorrowHistory(Transaction transaction) {
		borrowingHistory.add(transaction);
    }

    public List<Transaction> getBorrowHistory() {
        return borrowingHistory;
    }
    
    public String typeUser() {
	    return typeUser;
	}
	
	public void setType(String typeUser) {
	   this.typeUser = typeUser;
	}
	
    public String toString() {
		String text = "ID: " + ID + " \t " + "Name: " + name + " \t " 
					+ "Email: " + email + " \t " + "Phone number: " + phone_number + "\n";
		return text;
	}
    
    public void displayBorrowHistory(Patron patron) {
        List<Transaction> borrowHistory = patron.getBorrowHistory();
        System.out.println("** " + patron.getName() + " **");
        for (Transaction transaction : borrowHistory) {
       		System.out.println("ISBN: " + transaction.book().getIsbn() +
            		"\nBook: " + transaction.book().getTitle() +
	                "\n Borrowed Date: " + transaction.borrowedDate() +
	                 "\n Returned Date: " + transaction.returnDate() + "\n");
        }
    }
    
 }
