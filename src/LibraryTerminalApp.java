import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTerminalApp {
	public static void main(String[] args) {

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
		// method
		ArrayList<Book> bookList = BookObject.instatiateArray();
		System.out.println((bookList.get(2)).getlibraryCard());

		// ask user to checkout or return a book
		System.out.println(
				"Welcome to the Library!" + "\n" + "Are you here to search/checkout or return a book? (checkout / return) : ");
		
		//separate welcome line and collect name/ assign library card number before asking for an action
		action = input.nextLine();

		if (action.equalsIgnoreCase("checkout") || action.equalsIgnoreCase("check out") || action.equalsIgnoreCase("search")) {
			System.out.println("Please select a search option: " + "\n" + "1. See all books" + "\n"
					+ "2. Search by Author keyword" + "\n" + "3. Search by Title keyword" + "\n" + "4. Search by subject");

			choice = input.nextInt();

			// if else statement
			
			if (choice == 1) {
				BookObject.returnAll(bookList);
				System.out.println("Which book would you like to check out? (please enter the ID number) ");
				chooseBook = input.nextInt();
				Checkout.checkoutBook(chooseBook, bookList, libraryCard);
			} 
			
			else if (choice == 2) {
				System.out.println("Please enter an author: ");
				input.nextLine();
				String author = input.nextLine();

				// still need to modify these methods to make them ignore case
				BookObject.authorSearch(author, bookList, chooseBook, input, libraryCard);
				
			} 
			
			else if (choice == 3) {
				System.out.println("Please enter a title: ");
				input.nextLine();
				String title = input.nextLine();
				BookObject.titleSearch(title, bookList, chooseBook, input, libraryCard);

			} 
			
			else if (choice == 4){
				BookObject.subjectSearch(input, bookList, chooseBook, libraryCard);
			}
			
			else {
				System.out.println("Sorry! That is not a valid search option...");
				// loop with a boolean?
			}

		} 
		
		else {
			// let user return a book

			// prompt user for borrowID aka library card

			System.out.println("Please enter your library card number");
			int returnUser = input.nextInt();
						
						
						//calls method that lets the user view books they have checked out as well as return books
						Checkout.displayBook(bookList, returnUser, input);
						
				}
			}
	}