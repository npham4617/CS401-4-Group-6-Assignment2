package Library;

public class FictionBook extends Book {
	private String Fictioncode;
	
	public FictionBook(String isbn, String title, String author, String genre, String Fictioncode, String status) {
		super(isbn, title, author, genre, status);
		this.Fictioncode = Fictioncode;
    }
    
	public String getFictioncode() {
        return Fictioncode;
    }
	
	public String toString()
	{
	    return(super.toString() + " \t " + "Fiction Code: " + Fictioncode + "\n");
	}

}
