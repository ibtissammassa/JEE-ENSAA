package JPA;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {
	@Id
	private long book_id;
    private String title;
    private String author;
    private float price;
 
	public Book(long book_id, String title, String author, float price) {
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
