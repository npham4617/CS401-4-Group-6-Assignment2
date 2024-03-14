package Library;

public class NonFictionBook extends Book {
	private String Categorycode;
	
	public NonFictionBook(String isbn, String title, String author, String genre, String Categorycode, String status) {
		super(isbn, title, author, genre, status);
		this.Categorycode = Categorycode;
	}
    
	public String getCategorycode() {
        return Categorycode;
	}
	
	public String toString()
	{
	    return(super.toString() + " \t " + "Category Code: " + Categorycode + "\n");
	}
	
}
