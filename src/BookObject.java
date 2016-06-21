import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookObject {
	public static void main(String[] args) throws IOException {

		ArrayList<Book> bookArrayList = new ArrayList<Book>();

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
				Book book = new Book(ar[1], ar[2], sub, line); // creating obj

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
		int a = 1;
		for (int i = 0; i < bookArrayList.size(); i++) {

			Book b = bookArrayList.get(i);
			// (Book b : bookArrayList) {

			// System.out.println("Title " + b.getTitle());
			if (b.getTitle().contains("The")) {

				System.out.print("Number " + a + "\t");
				System.out.println(
						"This book" + b.getTitle() + "subject number is  " + b.getSubject() + " has the in it");
				a++;
			}

		}

	}
}
