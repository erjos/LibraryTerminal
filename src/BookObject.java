import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookObject {

	// The Main Method to Populate the Array
	public static ArrayList<Book> instatiateArray() {
		ArrayList<Book> bookArrayList = new ArrayList<Book>(); // Create Array

		try {
			// String filePath = new File("BookDataBase1").getAbsolutePath();
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

				String s = ar[3]; // parsing the strings where we use ints
				int sub = Integer.parseInt(s);
				String b = ar[5];
				int bID = Integer.parseInt(b);
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
			// System.out.println(record);
			outfile.write(record);

		} // end for

		outfile.close();
	}

	// Author Search

	public static void authorSearch(ArrayList<Book> bookArrayList, Scanner input, int libraryCard) {
		System.out.print("Please enter an author: ");

		String author = input.nextLine();
		System.out.format("%-12s%-30s%-30s%-12s", "INDEX #", "TITLE", "AUTHOR", "STATUS");
		System.out.println("");
		int repeat = 0;
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			if (((b.getAuthor()).toLowerCase()).contains(author.toLowerCase())) {
				// change author to lowercase and see if it is contained in
				// author field for each book
				System.out.format("%-12d%-30s%-30s%-12s", b.getIndex(), b.getTitle(), b.getAuthor(), b.getStatus());
				System.out.println("");
				repeat = 1;
			} // repeat =1 is necessary to see if anything was printed out
		} // there was a problem if the last line was blank looking like it was
			// all a blank
		if (repeat == 0) {

			System.out.println("\rSorry your entry returned zero results." + "\n"
					+ "To view a list of our selections, press \"enter\" ");
			input.nextLine();
			returnAll(bookArrayList, libraryCard, input);

			//Checkout.checkoutBook(bookArrayList, libraryCard, input);
		}else{

			Checkout.checkoutBook(bookArrayList, libraryCard, input);

		}
	}

	// Return All
	public static void returnAll(ArrayList<Book> bookArrayList, int libraryCard, Scanner input) {
		System.out.format("%-12s%-30s%-30s%-12s", "INDEX #", "TITLE", "AUTHOR", "STATUS");
		System.out.println("");
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			System.out.format("%-12d%-30s%-30s%-12s", b.getIndex(), b.getTitle(), b.getAuthor(), b.getStatus());
			System.out.println("");
		}
		Checkout.checkoutBook(bookArrayList, libraryCard, input);
	}

	// setting 1 = History
	// 2 = Mystery/Thriller
	// 3 = SciFi/Fantasy/Horror
	// 4 = Historical Fiction
	public static void subjectSearch(Scanner input, ArrayList<Book> bookArrayList, int chooseBook, int libraryCard) {
		System.out.println("");
		System.out.println("The Subject options are:");
		System.out.println("1. History");
		System.out.println("2. Mystery/Thriller");
		System.out.println("3. SciFi/Fantasy/Horror");
		System.out.println("4. Historical Fiction");

		int result = Validator.getInt(input, "\r Please enter a choice: ", 1, 4, "Please enter 1-4.");
		System.out.format("%-12s%-30s%-30s%-12s", "INDEX #", "TITLE", "AUTHOR", "STATUS");
		System.out.println("");
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			if (b.getSubject() == result) {
				System.out.format("%-12d%-30s%-30s%-12s", b.getIndex(), b.getTitle(), b.getAuthor(), b.getStatus());
				System.out.println("");
			}
		}
		Checkout.checkoutBook(bookArrayList, libraryCard, input);
	}

	// Title Search

	public static void titleSearch(ArrayList<Book> bookArrayList, int chooseBook, Scanner input, int libraryCard) {
		System.out.print("Please enter a title: ");

		String title = input.nextLine();
		System.out.format("%-12s%-30s%-30s%-12s", "INDEX #", "TITLE", "AUTHOR", "STATUS");
		System.out.println("");
		int repeat = 0;
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			if (((b.getTitle()).toLowerCase()).contains(title.toLowerCase())) {
				System.out.format("%-12d%-30s%-30s%-12s", b.getIndex(), b.getTitle(), b.getAuthor(), b.getStatus());
				System.out.println("");
				repeat = 1;
			}
		}
		if (repeat == 0) {

			System.out.println("\rSorry your entry returned zero results." + "\n"
					+ "To view a list of our selections, press \"enter\" ");
			input.nextLine();
			returnAll(bookArrayList, libraryCard, input);
			
			//Checkout.checkoutBook(bookArrayList, libraryCard, input);
		}else{

			Checkout.checkoutBook(bookArrayList, libraryCard, input);

		}
	}
}
