package Library;
import java.util.Date;
import java.util.Locale;
import java.text.*;


public class Transaction {
	private Patron patron;
	private Book book;
	private Date borrowedDate;
	private Date returnDate;
	private SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy", Locale.US);

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

	public void setborrowedDate(String dateString) {
		// change dateString to date
		try {
			Date date = formatter.parse(dateString);
			this.borrowedDate = date;
		}
	    catch (ParseException e) {
            System.out.println("Exception: " + e);
        }
	}
	
	public Date returnDate() {
	    return returnDate;
	}
	
	public void setreturnDate(String dateString) {
		// change dateString to date
		try {
			Date date = formatter.parse(dateString);
			this.returnDate = date;
		}
	    catch (ParseException e) {
            System.out.println("Exception: " + e);
        }
	}
	
 }
