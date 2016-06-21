import java.time.LocalDate;

public class Book {
	//immutable fields
	private int index;
	private String title;
	private String author;
	private int subject;
	// setting 1 = History
	// 2 = Mystery/Thriller
	// 3 = SciFi/Fantasy/Horror
	// 4 = Historical Fiction

	// settable fields
	private String status;
	// Why did we go with status when a
	// filled in or null borrower ID would work?
	private LocalDate due;
	private int libraryCard;

	// constructor
	public Book(int index, String title, String author, int subject, String status, int libraryCard) {
		this.index = index;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.status = status;
		this.libraryCard = libraryCard;
		// don't we need to have void fields for borrower and due date?
		// The data file will have or store records of who has checked out what
		// book.
	}

	// getter methods
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

	public int libraryCard() {
		return libraryCard;
	}

	// setter methods
	public void setStatus(String status) {
		this.status = status;
	}

	public void setDue(LocalDate due) {
		this.due = due;
	}

	public void libraryCard(int libraryCard) {
		this.libraryCard = libraryCard;
	}

}
