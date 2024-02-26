package Library;

public class Book {
	private int isbn;
	private String title;
	private String author;
	private String genre;
	private String status;

	public Book(int isbn, String title, String author, String genre, String status) {
	    this.isbn = isbn;
	    this.title = title;
	    this.author = author;
	    this.genre = genre;
	    this.status = status; 
	}

	// Settlers and Getters
	public int getIsbn() {
	    return isbn;
	}
	
	public void setIsbn(int isbn) {
	    this.isbn = isbn;
	}

	public String getTitle() {
	    return title;
	}
	
	public void setTitle(String title) {
	    this.title = title;
	}

	public String getAuthor() {
	    return author;
	}
	
	public void setAuthor(String author) {
	    this.author = author;
	}

	public String getGenre() {
	    return genre;
	}
	
	public void setGenre(String genre) {
	    this.genre = genre;
	}

	public String status() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
	}
	
	public String toString() {
		String text = "ISBN: " + isbn + " \t " + "Title: " + title + " \t " + "Author: " + author + " \t " +
				"Genre: " + genre + " \t " + "Status: " + status + "\n";
		return text;
	}
	
}
