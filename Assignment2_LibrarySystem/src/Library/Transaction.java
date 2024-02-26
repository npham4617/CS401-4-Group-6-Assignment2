package Library;
import java.util.Date;

public class Transaction {
	private Patron patron;
	private Book book;
	private Date checkoutDate;
	private Date returnDate;

	public Transaction(Patron patron, Book book, Date checkoutDate, Date returnDate) {
	    this.patron = patron;
	    this.book = book;
	    this.checkoutDate = checkoutDate;
	    this.returnDate = returnDate; 
	}

	public Patron patron() {
	    return patron;
	}

	public Book book() {
	    return book;
	}

	public Date checkoutDate() {
	    return checkoutDate;
	}

	public Date returnDate() {
	    return returnDate;
	}
}
