package Library;

import java.util.*;

public class MainClass {
	
	static Library library = new Library();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Book book1 = new Book(202001, "Adventures of Tom Sawyer         ", "Mark Twain", "Mystery", "Available");
	    Book book2 = new Book(202002, "Charlie and the Chocolate Factory", "Roald Dahl", "Fiction", "Borrowed");
	    Book book3 = new Book(202003, "The Lunar Chronicles series      ", "Marissa Meyer", "Fairy", "Available");
	    Book book4 = new Book(202004, "One Hundred Years of Solitude    ", "Gabriel Márquez", "Magical", "Available");
	    Book book5 = new Book(202005, "Learn Java for Dummies           ", "John Smith", "Science", "Borrowed");
	    Book book6 = new Book(202006, "Learn JavaScript in 10 Minutes   ", "Jack Arnold", "Science", "Available");
	    Book book7 = new Book(202007, "The Haunting of Hill House       ", "Shirley Jackson", "Horror", "Borrowed");
	    Book book8 = new Book(202008, "Tomorrow, and Tomorrow, and Tomorrow", "Gabrielle Zevin", "Fiction", "Available");
	    Book book9 = new Book(202009, "Learning .Net is not boring      ", "Hungry Jack", "Science", "Available");
	    Book book10 = new Book(202010, "Shine while learing Ruby        ", "Britney Spears", "Science", "Available");
	    Book book11 = new Book(202011, "A journey to the centre of the earth", "Jules Verne", "Fiction", "Available");
	    Book book12 = new Book(202012, "Learn PHP and work in Facebook  ", "Bill Gate", "Science", "Available");
	    Book book13 = new Book(202013, "The Return of the King          ", "J.R.R. Tolkien", "Fantasy", "Borrowed");
	    Book book14 = new Book(202014, "Alice's Adventures in Wonderland", "Lewis Carroll", "Fantasy", "Borrowed");
	    Book book15 = new Book(202025, "Harry Potter and the Sorcerer's Stone", "J. K. Rowling", "Mystery", "Available");

	    library.addBook(book1);
	    library.addBook(book2);
	    library.addBook(book3);
	    library.addBook(book4);
	    library.addBook(book5);
	    library.addBook(book6);
	    library.addBook(book7);
	    library.addBook(book8);
	    library.addBook(book9);
	    library.addBook(book10);
	    library.addBook(book11);
	    library.addBook(book12);
	    library.addBook(book13);
	    library.addBook(book14);
	    library.addBook(book15);
		
		System.out.println("Welcome to Library Management!");
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
	    }
	}
	
	/*private static boolean searchBook(int isbn) {
		boolean flag = false;
		for (Book book: library.getBooks()) {
			if(book.getIsbn() == isbn) {
				System.out.println(" ISBN\t\t\tTitle\t\t\t\t\t Author\t\t\t Genre\t\t Status");
			    System.out.println(book.getIsbn() + "\t\t" + book.getTitle() + 
			    			"\t\t" + book.getAuthor() + "\t\t" + book.getGenre() + 
			    				"\t\t" + book.status());
				flag = true;
			}
		}
		return flag;
	}*/
	
	private static int searchBook(int isbn) {
		int index = - 1;
		for (Book book: library.getBooks()) {
			if(book.getIsbn() == isbn) {
				index = library.getBooks().indexOf(book);
				System.out.println(library.getBooks().get(index).toString());
			}
		}
		return index;
	}
		
private static void deleteBook() {
		
		System.out.println("\nDELETE BOOKS HERE!");
		System.out.print("\nEnter ISBN: ");
		
		int isbn = scan.nextInt();
		int result = searchBook(isbn);
		if(result ==-1) {
			System.out.println("Book with the isbn " + isbn + " does not exist.");
		}
		else			
		{	
			Book book = library.getBooks().get(result);
			System.out.println("Do you want to delete this book? (yes or no): ");
			String action = scan.nextLine();
			if (action.equals("yes")) {			
				library.removeBook(book);
				System.out.println("Book is deleted successfully!");
			}
			if (action.equals("no")) {			
				System.out.println("Successfully cancelled!");
			}
		}
		//System.out.println(library.getBooks().toString());

	}
	private static void updateBook() {
		
		System.out.println("\nUPDATE BOOKS HERE!");
		System.out.print("\nEnter ISBN: ");
		
		int isbn = scan.nextInt();
		int result = searchBook(isbn);
		if(result ==-1) {
			System.out.println("Book with the isbn " + isbn + " does not exist.");
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
				System.out.println("\nTitle: ");
				String title = scan.nextLine();	
				book.setTitle(title);
				break;
				    	
			case 2:  
				System.out.println("\nAuthor: ");
				String author = scan.nextLine();		
				book.setAuthor(author);
				break; 
				    	
			case 3:
				System.out.println("\nGenre: ");
				String genre = scan.nextLine();
				book.setGenre(genre);
				break; 
						
			case 4:
				System.out.println("\nStatus (Available or Borrowed): ");
				String status = scan.nextLine();
				book.setStatus(status);
				break;
			 }

		}
		
		System.out.println("Book information is updated successfully!");
		//System.out.println(library.getBooks().get(result).toString());
	}
	
	

	private static void addBook() {
		int isbn;
		String title, author, genre;
		
		System.out.println("\nADD BOOKS HERE!");
		
		System.out.print("\nISBN: ");
		isbn = scan.nextInt();
		
		System.out.print("\nTitle: ");
		title = scan.nextLine();
		
		System.out.print("\nAuthor: ");
		author = scan.nextLine();
		
		System.out.print("\nGenre: ");
		genre = scan.nextLine();
		
		Book myBook = new Book(isbn, title, author, genre, "Available");
		library.addBook(myBook);
		
		System.out.println("\nThe book is added into the library!");
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

