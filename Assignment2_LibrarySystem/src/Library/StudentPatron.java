package Library;

public class StudentPatron extends Patron {
	
	public StudentPatron (int ID, String name, String email, String phone_number) {
		super (ID, name, email, phone_number);
	}

	@Override
	public void getMenu() {
		String myMultiLineText = """
				\n-- LIBRARY COLLECTIONS --\n
				1.  View Library Books
				2.  Borrow Book
				3.  Return Book
		        """;
		System.out.println(myMultiLineText);
	}

}
