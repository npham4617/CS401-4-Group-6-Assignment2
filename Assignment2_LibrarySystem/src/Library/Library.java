package Library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Library {
	
	private ArrayList<Book> books;
	private ArrayList<Patron> patrons;
	
	public Library() {
		books = new ArrayList<Book>();
		patrons = new ArrayList<Patron>();
	}
	
	public void addBook(Book myBook) {
		books.add(myBook);
	}
	
	public void removeBook(Book myBook) {
	    books.remove(myBook);
	}

	public ArrayList <Book> getBooks() {
	    return books;
	}
	
	// Initial Book Data
	
	public void getLibraryData() {  
		
		Book book1 = new Book("202001", "Adventures of Tom Sawyer         ", "Mark Twain", "Mystery", "Available");
	    Book book2 = new Book("202002", "Charlie and the Chocolate Factory", "Roald Dahl", "Fiction", "Borrowed");
	    Book book3 = new Book("202003", "The Lunar Chronicles series      ", "Marissa Meyer", "Fairy", "Available");
	    Book book4 = new Book("202004", "One Hundred Years of Solitude    ", "Gabriel Márquez", "Magical", "Available");
	    Book book5 = new Book("202005", "Learn Java for Dummies           ", "John Smith", "Science", "Borrowed");
	    Book book6 = new Book("202006", "Learn JavaScript in 10 Minutes   ", "Jack Arnold", "Science", "Available");
	    Book book7 = new Book("202007", "The Haunting of Hill House       ", "Shirley Jackson", "Horror", "Borrowed");
	    Book book8 = new Book("202008", "Tomorrow, and Tomorrow, and Tomorrow", "Gabrielle Zevin", "Fiction", "Available");
	    Book book9 = new Book("202009", "Learning .Net is not boring      ", "Hungry Jack", "Science", "Available");
	    Book book10 = new Book("202010", "Shine while learing Ruby        ", "Britney Spears", "Science", "Available");
	    Book book11 = new Book("202011", "A journey to the centre of the earth", "Jules Verne", "Fiction", "Available");
	    Book book12 = new Book("202012", "Learn PHP and work in Facebook  ", "Bill Gate", "Science", "Available");
	    Book book13 = new Book("202013", "The Return of the King          ", "J.R.R. Tolkien", "Fantasy", "Borrowed");
	    Book book14 = new Book("202014", "Alice's Adventures in Wonderland", "Lewis Carroll", "Fantasy", "Borrowed");
	    Book book15 = new Book("202025", "Harry Potter and the Sorcerer's Stone", "J. K. Rowling", "Mystery", "Available");

	    addBook(book1);
	    addBook(book2);
	    addBook(book3);
	    addBook(book4);
	    addBook(book5);
	    addBook(book6);
	    addBook(book7);
	    addBook(book8);
	    addBook(book9);
	    addBook(book10);
	    addBook(book11);
	    addBook(book12);
	    addBook(book13);
	    addBook(book14);
	    addBook(book15);
	    
	    Patron user1 = new Patron(2020, "Allan Sherwood", "allan.sherwood@yahoo.com", "4088814551", "Admin");
		Patron user2 = new Patron(2021, "John Doe", "john.doe@example.com", "6698814551", "User");
		Patron user3 = new Patron(2022, "Christineb", "christineb@solarone.com", "4028814551", "User");
		Patron user4 = new Patron(2023, "David Goldstein", "david.goldstein@hotmail.com", "4058814551", "User");
	   
	    addPatron(user1);
	    addPatron(user2);
	    addPatron(user3);
	    addPatron(user4);
	    
	    String dateString;
	    Date date;
	    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy", Locale.US);
	    
	    try {
	    Transaction transaction1 = new Transaction(user1, book2);
	    user1.addToBorrowHistory(transaction1);
	    dateString = "03-10-2024";
	    date = formatter.parse(dateString);
	    transaction1.setborrowedDate(date);
	    
	    Transaction transaction2 = new Transaction(user1, book5);
	    user1.addToBorrowHistory(transaction2);
	    dateString = "01-17-2024";
	    date = formatter.parse(dateString);
	    transaction2.setborrowedDate(date);
	    
	    Transaction transaction3 = new Transaction(user2, book7);
	    user2.addToBorrowHistory(transaction3);
	    dateString = "02-24-2024";
	    date = formatter.parse(dateString);
	    transaction3.setborrowedDate(date);
	    
	    Transaction transaction4 = new Transaction(user2, book13);
	    user2.addToBorrowHistory(transaction4);
	    dateString = "02-17-2023";
	    date = formatter.parse(dateString);
	    transaction4.setborrowedDate(date);
	    
	    Transaction transaction5 = new Transaction(user4, book14);
	    user4.addToBorrowHistory(transaction5);
	    dateString = "12-24-2023";
	    date = formatter.parse(dateString);
	    transaction5.setborrowedDate(date);
	    }
	    catch (ParseException e) {
            System.out.println("Exception: " + e);
        }

	}
	
	public void addPatron(Patron myUser) {
		patrons.add(myUser);
	}
	
	public void removePatron(Patron myUser) {
	    patrons.remove(myUser);
	}

	public ArrayList <Patron> getPatron() {
	    return patrons;
	}
	
	public Patron getPatron(int n) {
	    return patrons.get(n);
	}

	public int checkLogin(String email, String phone_number) {
		int index = - 1;
		for (Patron p: getPatron()) {
			if(p.email().equals(email) && p.phone_number().equals(phone_number)) {
				index = getPatron().indexOf(p);
				break;
			}
			if(!(p.email().equals(email)) || !(p.phone_number().equals(phone_number)))
			{
				System.out.println("The inputed email or phone number is not correct!");
				break;
			}
		}
		return index;
	}
}
