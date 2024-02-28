package Library;

import java.util.*;

public class MainClass {
	
	static Library library = new Library();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		library.getLibraryData();
		library.getLibraryUser();
		
		System.out.println("Welcome to Library Management!");
		
		System.out.println("\n1. Login\n2. Create a New User");
		System.out.print("\nPlease Enter Your Choice: " );
		int answer = scan.nextInt();
	    switch(answer) {
		    case 1: 
				Login();
		    	break;
		    	
			case 2:  
				NewUser();
		    	break; 
		    
			default: 
		    	System.out.print("Error!" );
	    }
	}
	
		
	public static void Login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n-- LOGIN USER HERE! --");
		System.out.print("\nEmail: " );
	    String email = scanner.nextLine();
	    System.out.print("Phone Number: " );
	    String phone_number = scanner.nextLine();
	    int n = library.checkLogin(email, phone_number);
	    
	    if (n != -1) {
	    	if(library.getPatron().get(n).typeUser().equals("Admin")) {
	    		AdminScreen();
	    	}
	    	
	    	if(library.getPatron().get(n).typeUser().equals("User")) {
	    		UserScreen();
	    	}   		
	    }
	    
	    scanner.close();
	}
	
	public static void NewUser() {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		int ran_id = rand.nextInt(100);
		
		System.out.println("\n-- CREATE NEW USER HERE! --");

		
		System.out.print("\nName: ");
		String name = scanner.nextLine();
		
		System.out.print("\nEmail: ");
		String email = scanner.nextLine();
		
		System.out.print("\nPhone: ");
		String phone_number = scanner.nextLine();
		

		Patron myUser = new Patron(ran_id, name, email, phone_number, "User");
		library.addPatron(myUser);
		
		System.out.println("\nNew user is create sucessfully!");
		myUser.toString();
		
		Login();
		
		scanner.close();
	}
	
	public static void UserScreen() {
		String myMultiLineText = """
			\n-- LIBRARY COLLECTIONS --\n
			1.  View Library Books
			2.  Borrow Book
	        """;
		System.out.println(myMultiLineText);
	}
	
	public static void AdminScreen() {
		
		String myMultiLineText = """
	    		\n-- LIBRARY COLLECTIONS --\n
	    		1.  View Library Books
	    		2.  Add Book
	    		3.  Update Book
	    		4.  Delete Book
                """;
	    System.out.println(myMultiLineText);
	    System.out.print("Please Enter Your Choice: " );
	    int answer = scan.nextInt();
	    switch(answer) {
		
			case 1: 
				displayAllBooks();
		    	break;
		    	
			case 2:  
				addBook();
		    	break; 
		    	
			case 3:
				updateBook();
				break; 
				
			case 4:
				deleteBook();
				break;
			
			default: 
		    	System.out.print("Error!" );
	    }
	    scan.close();
	}
	
	private static int searchBook(String isbn) {
		int index = - 1;
		for (Book book: library.getBooks()) {
			if(book.getIsbn().equals(isbn)) {
				index = library.getBooks().indexOf(book);
				System.out.println(library.getBooks().get(index).toString());
			}
		}
		return index;
	}
		
	private static void deleteBook() {
		
		System.out.println("\nDELETE BOOKS HERE!");
		System.out.print("\nEnter ISBN: ");
		
		String isbn = scan.nextLine();
		int result = searchBook(isbn);
		if(result ==-1) {
			System.out.println("\nBook with the isbn " + isbn + " does not exist.");
		}
		else			
		{	
			Book book = library.getBooks().get(result);
			System.out.print("\nDo you want to delete this book? (yes or no): ");
			
			String action = scan.next();
			if (action.equals("yes")) {			
				library.removeBook(book);
				System.out.println("\nBook is deleted successfully!");
			}
			if (action.equals("no")) {			
				System.out.println("\nSuccessfully cancelled!");
			}
		}
		scan.close();
	}

	private static void updateBook() {
		
		System.out.println("\nUPDATE BOOKS HERE!");
		System.out.print("\nEnter ISBN: ");

		Scanner scanner = new Scanner(System.in);
		
		String isbn = scan.nextLine();
		int result = searchBook(isbn);
		if(result ==-1) {
			System.out.println("\nBook with the isbn " + isbn + " does not exist.");
		}
		else			
		{	
			Book book = library.getBooks().get(result);
			String myMultiLineText = """
			    \n-- Do you want to update --\n
			    1.  Title
			    2.  Author
			    3.  Genre
			    4.  Status
			    """;
			System.out.println(myMultiLineText);
			System.out.print("Please Enter Your Choice: " );
			int answer = scan.nextInt();
			switch(answer) {
						
			case 1: 
				System.out.print("\nTitle: ");
				String title = scanner.nextLine();	
				book.setTitle(title);
				break;
				    	
			case 2:  
				System.out.print("\nAuthor: ");
				String author = scanner.nextLine();		
				book.setAuthor(author);
				break; 
				    	
			case 3:
				System.out.print("\nGenre: ");
				String genre = scanner.nextLine();
				book.setGenre(genre);
				break; 
						
			case 4:
				System.out.print("\nStatus (Available or Borrowed): ");
				String status = scanner.nextLine();
				book.setStatus(status);
				break;
			
			default: 
		    	System.out.print("Error!" );
		    	
			 }

		}
		
		System.out.println("\nBook information is updated successfully!");
		System.out.println(library.getBooks().get(result).toString());
		scan.close();
		scanner.close();
	}
	
	private static void addBook() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nADD BOOKS HERE!");
		
		System.out.print("\nISBN: ");
		String isbn = scan.nextLine();
		
		System.out.print("\nTitle: ");
		String title = scanner.nextLine();
		
		System.out.print("\nAuthor: ");
		String author = scanner.nextLine();
		
		System.out.print("\nGenre: ");
		String genre = scanner.nextLine();

		Book myBook = new Book(isbn, title, author, genre, "Available");
		library.addBook(myBook);
		
		System.out.println("\nThe book is added into the library!");
		scan.close();
		scanner.close();
	}
	
	public static void displayAllBooks()
    {
		System.out.println("\nBooks in the library:\n");
		System.out.println(" ISBN\t\t\tTitle\t\t\t\t\t Author\t\t\t Genre\t\t Status");
	    for (Book book: library.getBooks()) {
	    	System.out.println(book.getIsbn() + "\t\t" + book.getTitle() + 
	    			"\t\t" + book.getAuthor() + "\t\t" + book.getGenre() + 
	    				"\t\t" + book.status());

	    }
    }
}

