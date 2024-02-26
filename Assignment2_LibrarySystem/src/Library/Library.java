package Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
	
	private ArrayList<Book> books;
	
	
	public Library() {
		books = new ArrayList<Book>();
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
	
}
