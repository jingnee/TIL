package workshop.book.entity;

public class Novel extends Publication{
	String author;
	String genre;
	
	public Novel(){

	}

	public Novel(String title, String publishingDate, int page, int price, String author, String genre) {
		super(title, publishingDate, page, price);
		this.author = author;
		this.genre = genre;
		// TODO Auto-generated constructor stub
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
	
}
