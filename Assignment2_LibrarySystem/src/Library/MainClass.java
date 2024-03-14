package Library;

import java.util.*;
import java.text.*;

public class MainClass {
	
	static Library library = new Library();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		 library.getLibraryData();

		    System.out.println("~~~~ WORLD BOOK ONLINE! ~~~~~");

		    // Check if there are any registered users
		    if (library.getPatron().isEmpty()) {
		        System.out.println("There are no registered users. Please create an account first.");
		        NewUser(); // Prompt the user to create an account
		    } else {
		        presentLoginOptions(); // Proceed to present login options
		    }
	}
	
	public static void presentLoginOptions() {
		System.out.println("\nWelcome to G6 Library!");
	    System.out.println("\n1. Login\n2. Create an Account ");
	    System.out.print("\nPlease Enter Your Choice: ");
	    int answer= 0;
	    boolean validInput= false;
	    
	    
	    while(!validInput) {
	    	if (scan.hasNextInt()) {
	            answer = scan.nextInt();
	            validInput = true; // Set validInput to true once integer input is received
	        } else {
	            System.out.println("Invalid input. Please enter a valid number.");
	            scan.next(); // Consume the invalid input
	        }
	    }
	    
	    switch (answer) {
	       case 1:
	           Login(); // Proceed to login
	           break;
	
	       case 2:
	           NewUser(); // Proceed to create an account
	           break;
	
	       default:
	           System.out.println("Invalid choice.");
	           presentLoginOptions(); 
	    }
    
   }
	
		
	public static void Login() {
		Scanner scanner = new Scanner(System.in);
		int n = -1;
		do {
			System.out.println("\n-- LOGIN USER HERE! --");
			System.out.print("\nEmail: " );
		    String email = scanner.nextLine();
		    System.out.print("Phone Number: " );
		    String phone_number = scanner.nextLine();
		    n = library.checkLogin(email, phone_number);
		} while (n==-1);
				    
		System.out.print("\nHi, " + library.getPatron().get(n).getName() + "\n");
		
		if (n != -1) {
	    	if(library.getPatron().get(n) instanceof FacultyPatron) {
	    		AdminScreen(library.getPatron().get(n));
	    	}
	    	
	    	if(library.getPatron().get(n) instanceof StudentPatron) {
	    		UserScreen(library.getPatron().get(n));
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
		
	    
		StudentPatron myUser = new StudentPatron(ran_id, name, email, phone_number);
		library.addPatron(myUser);
		
		System.out.println("\nNew user is create sucessfully!");
		myUser.toString();
		
		Login();
		
		scanner.close();
	}
	
	public static void UserScreen(Patron p) {
		p.getMenu();
		System.out.print("Please Enter Your Choice: " );
	    int answer = scan.nextInt();
	    switch(answer) {
		
			case 1: 
				displayAllBooks(p);
		    	break;
		    	
			case 2:  
				BorrowBook(p);
				break; 
			
			case 3:
				ReturnBook(p);
				break; 
						
			default: 
		    	System.out.print("Error!" );
		    	UserScreen(p); 
	    }
	    scan.close();
	}
	
	public static void AdminScreen(Patron p) {
		p.getMenu();
	    System.out.print("Please Enter Your Choice: " );
	    int answer = scan.nextInt();
	    switch(answer) {
		
			case 1: 
				displayAllBooks(p);
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
				
			case 5: 
				displayUserLists();
		    	break;
		    	
			case 6:  
				ShowBorrowingHistory();
		    	break; 
		    	
			case 7:
				BorrowBook(p);
				break; 
			
			case 8:
				ReturnBook(p);
				break; 
						
			default: 
				System.out.println("Invalid choice.");
				AdminScreen(p); 
	    }
	     scan.close();
	}
	
	private static void ShowBorrowingHistory() {
		System.out.println("\n-- BORROWING HISTORY --\n");
		 for (Patron p: library.getPatron()) {
			 p.displayBorrowHistory(p);
		 }
	}
	
	private static void BorrowBook(Patron p) {
		DateFormat dateFormat = new SimpleDateFormat("MM-DD-YYYY");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\nBORROW BOOK HERE!\n");
		System.out.println("Below are all available books in the library: \n");
		for (Book book: library.getBooks()) {
			if(book.status().equals("Available")) {
				System.out.println("ISBN: " + book.getTitle() + "\n"
						+ "Title: " + book.getIsbn() + "\n"
						+ "Author: " + book.getAuthor() + "\n"
						+ "Genre: " + book.getGenre() + "\n");
			}
		}

		System.out.print("Enter ISBN of the book: ");
		String isbn = scan.nextLine();
		int result = searchBook(isbn);
			
		if(result !=-1)			
		{	
			Book book = library.getBooks().get(result);
			System.out.print("Please enter the return date (MM-DD-YYYY): ");
			String returnDate = scan.nextLine();
			Transaction transaction = new Transaction(p, book);	
			
			// change borrowedDate to string
			String borrowedDate = dateFormat.format(new Date());
			transaction.setborrowedDate(borrowedDate);
			transaction.setreturnDate(returnDate);
			
			book.setStatus("Borrowed");
				
			System.out.println("The book is borrowed successfully!");
			System.out.println ("\nName: " + transaction.patron().getName()
							+ "\nBook title: " + transaction.book().getTitle()
							+ "\nBorrow Date: " + transaction.borrowedDate() 
							+ "\nReturn Date: " + transaction.returnDate());		
		}	
			
		scan.close();
	}
	
	private static void ReturnBook(Patron p) {
		DateFormat dateFormat = new SimpleDateFormat("MM-DD-YYYY");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\nRETURN BOOK HERE!\n");
		System.out.println("Below are the books currently borrowed from Library");
		p.displayBorrowHistory(p);
		if (p.getBorrowHistory().isEmpty()) {
			System.exit(0);
        }
		System.out.print("Enter ISBN of the book: ");
		String isbn = scan.nextLine();
		int result = searchBook(isbn);
			
		if(result !=-1)			
		{	
			Book book = library.getBooks().get(result);
			Transaction tran = new Transaction(p, book);	
			
			// Find the borrowDate for the returned book
			Date borrowDate = null;
			for (Transaction tr1 : p.getBorrowHistory()) {
				if (tr1.book().getIsbn() == book.getIsbn()) {
					borrowDate = tr1.borrowedDate();
				}
			}
			
			// change returnDate to string
			String returnDate = dateFormat.format(new Date());
			tran.setreturnDate(returnDate);
			
			book.setStatus("Available");
				
			System.out.println("The book is returned successfully!");
			System.out.println ("\nName: " + p.getName()
							+ "\nBook title: " + book.getTitle()
							+ "\nBorrow Date: " + borrowDate
							+ "\nReturn Date: " + tran.returnDate());		
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
		Scanner scan = new Scanner(System.in);
		String isbn = scan.nextLine();
		int result = searchBook(isbn);
		if(result ==-1) {
			System.out.println("\nBook with the isbn " + isbn + " does not exist.");
		}
		else			
		{	
			Book book = library.getBooks().get(result);
			System.out.print("\nDo you want to delete this book? (yes or no): ");
			
			String action = scan.next().toLowerCase();
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
		String isbn = scanner.nextLine();
		
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
			int answer = scanner.nextInt();
			Scanner scan;
			
			switch(answer) {
						
			case 1: 
				System.out.print("\nTitle: ");
				scan = new Scanner(System.in);
				String title = scan.nextLine();	
				book.setTitle(title);
				break;
				    	
			case 2:  
				System.out.print("\nAuthor: ");
				scan = new Scanner(System.in);
				String author = scan.nextLine();		
				book.setAuthor(author);
				break; 
				    	
			case 3:
				System.out.print("\nGenre: ");
				scan = new Scanner(System.in);
				String genre = scan.nextLine();
				book.setGenre(genre);
				break; 
						
			case 4:
				System.out.print("\nStatus (Available or Borrowed): ");
				scan = new Scanner(System.in);
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
		String isbn = scanner.nextLine();

		System.out.print("\nTitle: ");
		String title = scanner.nextLine();
		
		System.out.print("\nAuthor: ");
		String author = scanner.nextLine();
		
		System.out.print("\nGenre: ");
		String genre = scanner.nextLine();

		Book myBook = new Book(isbn, title, author, genre, "Available");
		library.addBook(myBook);
		
		System.out.println("\nThe book is added into the library!");
		scanner.close();
	}
	
	public static void displayAllBooks(Patron p)
    {
		System.out.println("\nBOOKS IN THE LIBRARY:\n");
		System.out.println(" ISBN\t\t\tTitle\t\t\t\t\t Author\t\t\t Genre\t\t Status");
	    for (Book book: library.getBooks()) {
	    	System.out.println(book.getIsbn() + "\t\t" + book.getTitle() + 
		    			"\t\t" + book.getAuthor() + "\t\t" + book.getGenre() + 
		    				"\t\t" + book.status());
	    }

	    System.out.print("\nDo you want to borrow any of the books? (yes or no): ");
	    scan.nextLine();
	    // Convert user answer to lowe-rcase for case-insensitive comparison
	    String userAnswer = scan.nextLine().toLowerCase(); 
	    if (userAnswer.equals("yes")) {
	    	BorrowBook(p);
	    } else {
	        System.out.println("\nThank you for using our library");
	    }
    }
	
	
	public static void displayUserLists()
    {
		System.out.println("\n~~~~ USERS LIST ~~~~\n");
	    for (Patron p: library.getPatron()) {
	    	System.out.println("ID: " + p.ID() 
	    	+ "\nName: " + p.getName() 
	    	+ "\nEmail: " + p.email() 
	    	+ "\nPhone number: " + p.phone_number()
	    	+ "\n");
	    }
    } 
	
}

