package Library;

public class FacultyPatron extends Patron {
	
	public FacultyPatron(int ID, String name, String email, String phone_number) {
		super(ID, name, email, phone_number);
	}

	@Override
	public void getMenu() {
		String myMultiLineText = """
	    		\n-- LIBRARY COLLECTIONS --\n
	    		1.  View Library Books
	    		2.  Add Book
	    		3.  Update Book
	    		4.  Delete Book
	    		~~~~~~~~~~~~~~~~~~~~
	    		5.  View Users List
	    		6.  Show Borrowing History
	    		7.  Borrow Books
	    		8.  Return Books
                """;
	    System.out.println(myMultiLineText);
    }
}

