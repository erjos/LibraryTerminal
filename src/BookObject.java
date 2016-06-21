import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookObject {

	public static ArrayList<Book> instatiateArray() {
		ArrayList<Book> bookArrayList = new ArrayList<Book>(); // Create Array

		try {
			String filePath = new File("BookDataBase1").getAbsolutePath();
			// System.out.println(filePath);

			FileReader r = new FileReader("BookDataBase1.csv");
			// required importation of FileReader
			// creating an object
			BufferedReader in = new BufferedReader(r);
			// required importation of Buffered Reader
			// The buffered reader saves space differently than
			// the file reader.
			// Creates object in

			String line = in.readLine(); // First it reads

			while (line != null) { // do not want to read a blank line.
				String[] ar = line.split(",");
				// can not seem to make the subject number
				// which comes in as a string into an int to go into object
				String subj = ar[3];
				int sub = Integer.parseInt(subj);
				String borrower = ar[5];
				int bID = Integer.parseInt(borrower);
				String index = ar[0];
				int indexID = Integer.parseInt(index);
				Book book = new Book(indexID, ar[1], ar[2], sub, ar[4], bID); // creating
																				// obj

				// Then it writes
				// System.out.println("This book was entered:" +
				// book.getTitle()); // Then
				// it
				// writes
				bookArrayList.add(book);
				line = in.readLine(); // Then it reads next line, if line is not
										// blank
			}

			in.close();

		} catch (IOException e) {
			// required importation of IOException Class
			System.out.println(e);

		}
		return bookArrayList;
	}

	public static void authorSearch(String author, ArrayList<Book> bookArrayList) {

		for (int i = 0; i < bookArrayList.size(); i++) {

			Book b = bookArrayList.get(i);
			if (b.getAuthor().contains(author)) {
				System.out.println("Index #  Title \t\t\tAuthor \t\tStatus");
				System.out.println(b.getIndex() + "\t" + b.getTitle() + "\t\t" + b.getAuthor() + "\t" + b.getStatus());

			}
		}
	}

	// setting 1 = History
	// 2 = Mystery/Thriller
	// 3 = SciFi/Fantasy/Horror
	// 4 = Historical Fiction
	public static void subjectSearch(Scanner, scan String author, ArrayList<Book> bookArrayList) {
		System.out.println("The subject options are:");
		System.out.println("1. History");
		System.out.println("2. Mystery/Thriller");
		System.out.println("3.  SciFi/Fantasy/Horror");
		System.out.println("4. Historical Fiction");
		System.out.println("Pease enter a number:");
		
		switch (choice) {
		case 1: //display all books
			break;
		case 2: // ask user to search by Author (enter author keyword)
			break;
		case 3: // ask user to search by title (enter title keyword)
			break;
		case 4: // ask user to return a book
			break;
		default: //maybe make it say "invalid entry" and print out a list of the books
		}
		
		System.out.println("The subject options are:");
		for (int i = 0; i < bookArrayList.size(); i++) {

			Book b = bookArrayList.get(i);
			if (b.getAuthor().contains(author)) {
				System.out.println("Index #  Title \t\t\tAuthor \t\tStatus");
				System.out.println(b.getIndex() + "\t" + b.getTitle() + "\t\t" + b.getAuthor() + "\t" + b.getStatus());

			}
		}
	}

	public static void titleSearch(String title, ArrayList<Book> bookArrayList) {

		for (int i = 0; i < bookArrayList.size(); i++) {

			Book b = bookArrayList.get(i);
			if (b.getAuthor().contains(title)) {
				System.out.println("Index #  Title \t\t\tAuthor \t\tStatus");
				System.out.println(b.getIndex() + "\t" + b.getTitle() + "\t\t" + b.getAuthor() + "\t" + b.getStatus());

			}
		}
	}

	public static void main(String[] args) throws IOException {

		ArrayList<Book> bookArrayList = instatiateArray();

		authorSearch("Child", bookArrayList);
	}
	//
	//

}

// for (int i = 0; i < bookArrayList.size(); i++) {
//
// Book b = bookArrayList.get(i);
// // (Book b : bookArrayList) {
//
// // System.out.println("Title " + b.getTitle());
// if (b.getTitle().contains("The")) {
//
// System.out.print("Number " + a + "\t");
// System.out.println(
// "This book" + b.getTitle() + "subject number is " + b.getSubject() + "
// has the in it");
// a++;
// ArrayList<Book> temporaryBookArrayList = new ArrayList<Book>();
// temporaryBookArrayList.add(b);
// // System.out.println(bookArrayList());
