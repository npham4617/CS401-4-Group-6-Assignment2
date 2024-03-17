package Library;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private String genre;
	private String status;
	
	public Book(String isbn, String title, String author, String genre, String status) {
	    this.isbn = isbn;
	    this.title = title;
	    this.author = author;
	    this.genre = genre;
	    this.status = status; 
	} 
      
	public String getIsbn() {
	    return isbn;
	}
	
	public void setIsbn(String isbn) {
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
		String text = "ISBN: " + isbn + "\t " + "Title: " + title + "\t " + "Author: " + author + "\t " +
				"Genre: " + genre + "\t " + "Status: " + status;
		return text;
	}
	
}
