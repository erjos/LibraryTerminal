import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BookObject {

	// The Main Method to Populate the Array
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

	public static void writeCSV(ArrayList<Book> bookArrayList) throws Exception {

		// create a File class object and give the file the name employees.csv
		java.io.File bookCSV = new java.io.File("BookDataBase1.csv");

		// Create a Printwriter text output stream and link it to the CSV File
		java.io.PrintWriter outfile = new java.io.PrintWriter(bookCSV);

		// Iterate the elements actually being used
		for (int i = 0; i < bookArrayList.size(); i++) {
			String record = bookArrayList.get(i).getIndex() + "," + bookArrayList.get(i).getTitle() + ","
					+ bookArrayList.get(i).getAuthor() + "," + bookArrayList.get(i).getSubject() + ","
					+ bookArrayList.get(i).getStatus() + "," + bookArrayList.get(i).getlibraryCard() + "\r\n";
			System.out.println(record);
			outfile.write(record);

		} // end for

		outfile.close();
	}

	// Author Search
	public static void authorSearch(String author, ArrayList<Book> bookArrayList) {
		System.out.format("%-12s%-30s%-30s%-12s", "INDEX #", "TITLE", "AUTHOR", "STATUS");
		System.out.println("");
		int repeat = 0;
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			if (b.getAuthor().contains(author)) {

				System.out.format("%-12d%-30s%-30s%-12s", b.getIndex(), b.getTitle(), b.getAuthor(), b.getStatus());
				System.out.println("");
				repeat = 1;
			}
		}
		if (repeat == 0) {
			System.out.println("\rSorry your entry returned zero results.");
		}
	}

	// Return All
	public static void returnAll(ArrayList<Book> bookArrayList) {
		System.out.format("%-12s%-30s%-30s%-12s", "INDEX #", "TITLE", "AUTHOR", "STATUS");
		System.out.println("");
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			System.out.format("%-12d%-30s%-30s%-12s", b.getIndex(), b.getTitle(), b.getAuthor(), b.getStatus());
			System.out.println("");
		}
	}

	// setting 1 = History
	// 2 = Mystery/Thriller
	// 3 = SciFi/Fantasy/Horror
	// 4 = Historical Fiction
	public static void subjectSearch(Scanner scan, ArrayList<Book> bookArrayList) {
		System.out.println("The subject options are:");
		System.out.println("1. History");
		System.out.println("2. Mystery/Thriller");
		System.out.println("3. SciFi/Fantasy/Horror");
		System.out.println("4. Historical Fiction");

		int result = Validator.getInt(scan, "\r Please enter a choice:", 1, 4);
		System.out.format("%-12s%-30s%-30s%-12s", "INDEX #", "TITLE", "AUTHOR", "STATUS");
		System.out.println("");
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			if (b.getSubject() == result) {
				System.out.format("%-12d%-30s%-30s%-12s", b.getIndex(), b.getTitle(), b.getAuthor(), b.getStatus());
				System.out.println("");
			}
		}

	}

	// Title Search
	public static void titleSearch(String title, ArrayList<Book> bookArrayList) {
		System.out.format("%-12s%-30s%-30s%-12s", "INDEX #", "TITLE", "AUTHOR", "STATUS");
		System.out.println("");
		int repeat = 0;
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			if (b.getTitle().contains(title)) {
				System.out.format("%-12d%-30s%-30s%-12s", b.getIndex(), b.getTitle(), b.getAuthor(), b.getStatus());
				System.out.println("");
				repeat = 1;
			}
		}
		if (repeat == 0) {
			System.out.println("\rSorry your entry returned zero results.");
		}
	}

	// Testing area
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		// Array
		// ArrayList<Book> bookArrayList = null;

		ArrayList<Book> bookArrayList = instatiateArray();
		// returnAll(bookArrayList);
		// authorSearch("boy", bookArrayList);
		// authorSearch("Clarke", bookArrayList);
		// titleSearch("Clarke", bookArrayList);
		// titleSearch("the", bookArrayList);
		// bookArrayList.get(1).setStatus("cheese");
		// writeCSV(bookArrayList);
		// String record = bookArrayList.get(1).getIndex() + "," +
		// bookArrayList.get(1).getTitle() + ","
		// + bookArrayList.get(1).getAuthor() + "," +
		// bookArrayList.get(1).getSubject() + ","
		// + bookArrayList.get(1).getStatus() + "," +
		// bookArrayList.get(1).getlibraryCard() + "\n";
		// System.out.println(record);
		System.out.println(bookArrayList.get(1).getStatus());

	}

}
