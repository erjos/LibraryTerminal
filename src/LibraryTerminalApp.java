import java.util.Scanner;

public class LibraryTerminalApp {
	public static void main(String[] args) {

		// declare variable for user input
		int choice;
		String action;
		// create scanner object
		Scanner input = new Scanner(System.in);

		// ask user to checkout or return a book
		System.out.println(
				"Welcome to the Library!" + "\n" + "Are you here to checkout or return a book? (checkout / return) : ");
		action = input.nextLine();

		if (action.equalsIgnoreCase("checkout")) {
			System.out.println("Please select a search option: " + "\n" + "1. See all books" + "\n"
					+ "2. Search by Author keyword" + "\n" + "3. Search by Title keyword");

			String garbage = input.nextLine();
			choice = input.nextInt();

			// switch statement
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
			
			//checkout method
			//create borrowID
			
			
		} else {
			//let user return a book
			
			//prompt user for borrowID aka library card
			
			//display list of books with that borrowID
			
			//prompt them to enter title of book to return
			
			//change status of book to return
			
			//reset borrowID to null
		}
	}
}