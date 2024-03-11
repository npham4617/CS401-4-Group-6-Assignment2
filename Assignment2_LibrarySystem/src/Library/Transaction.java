package Library;
import java.util.Date;


public class Transaction {
	private Patron patron;
	private Book book;
	private Date borrowedDate;
	private Date returnDate;

	public Transaction(Patron patron, Book book) {
	    this.patron = patron;
	    this.book = book;
	}

	public Patron patron() {
	    return patron;
	}

	public Book book() {
	    return book;
	}

	public Date borrowedDate() {
	    return borrowedDate;
	}

	public void setborrowedDate(Date dateString) {
		this.borrowedDate = dateString;
	}
	
	public Date returnDate() {
	    return returnDate;
	}
	
	public void setreturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public boolean borrowBook() {
        if (book.status().equals("Available")) {
        	borrowedDate = new Date();
            return true;
        } else {
        	System.out.println("The book is borrowed, sorry");
            return false;
        }
    }

    public boolean returnBook() {
        if (book.status().equals("Borrowed")) {
        	returnDate = new Date();
            return true;
        } else {
        	System.out.println("Cannot return book at this time, sorry!");
            return false;
        }
    }
}
