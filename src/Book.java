import java.time.LocalDate;

public class Book {
	//immutable fields
	private int index;
	private String title;
	private String author;
	private int subject;
	
	//settable fields
	private String status;
	private LocalDate due;
	private int borrowID;
	
	//constructor
	public Book(String title, String author, int subject, String status){
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.status = status;
	}
	
	
	//getter methods
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getStatus() {
		return status;
	}
	public int getSubject() {
		return subject;
	}
	public LocalDate getDue() {
		return due;
	}
	public int getBorrowID() {
		return borrowID;
	}
	
	//setter methods
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setDue(LocalDate due) {
		this.due = due;
	}
	public void setBorrowID(int borrowID) {
		this.borrowID = borrowID;
	}
	
}
