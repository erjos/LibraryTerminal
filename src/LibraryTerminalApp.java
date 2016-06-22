import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTerminalApp {
	public static void main(String[] args) throws Exception {

		// declare variable for user input
		int choice;
		String action;
		int chooseBook = 0;

		// temporary Library card creation
		int libraryCard = (int) (Math.random() * 1000 + 1);
		System.out.println("your library card number is: " + libraryCard);
		
		// create scanner object
		Scanner input = new Scanner(System.in);

		// instantiate the Arraylist of book objects using the instantiateArray
		// method to istantiate the Array of book objects
		ArrayList<Book> bookList = BookObject.instatiateArray();

		// ask user to checkout or return a book
		System.out.print(
				"Welcome to the Library!" + "\n" + "Are you here to search/checkout or return a book? (checkout / return) : ");
		
		//separate welcome line and collect name/ assign library card number before asking for an action
		action = input.nextLine();

		if (action.equalsIgnoreCase("checkout") || action.equalsIgnoreCase("check out") || action.equalsIgnoreCase("search")) {
			System.out.println("Please select a search option (1,2,3,4) : " + "\n" + "1. See all books" + "\n"
					+ "2. Search by Author keyword" + "\n" + "3. Search by Title keyword" + "\n" + "4. Search by Subject");

			choice = input.nextInt();

			// if else statement that calls different search methods and lets the user checkout
			if (choice == 1) {
				BookObject.returnAll(bookList, libraryCard, input);
			} 
			else if (choice == 2) {
				BookObject.authorSearch(bookList, input, libraryCard);
			} 
			else if (choice == 3) {
	
				BookObject.titleSearch(bookList, chooseBook, input, libraryCard);
			} 
			
			else if (choice == 4){
				BookObject.subjectSearch(input, bookList, chooseBook, libraryCard);
			}
			else {
				System.out.println("Sorry! That is not a valid browsing option...");
			}

		} 
		
		else {	
					//calls method that lets the user view books they have checked out as well as return books
					Checkout.displayBook(bookList, input);
						
				}
		
			//method that writes the changes back into the BookDataBase1.csv
			BookObject.writeCSV(bookList);
			System.out.println("Thank you for visiting the Grant Chirpus Memorial Library!");
		}
	
	}