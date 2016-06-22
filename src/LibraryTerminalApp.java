import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTerminalApp {
	public static void main(String[] args) {

		// declare variable for user input
		int choice;
		String action;
		int chooseBook;

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
		action = input.nextLine();

		if (action.equalsIgnoreCase("checkout") || action.equalsIgnoreCase("check out") || action.equalsIgnoreCase("search")) {
			System.out.println("Please select a search option: " + "\n" + "1. See all books" + "\n"
					+ "2. Search by Author keyword" + "\n" + "3. Search by Title keyword");

			choice = input.nextInt();

			// if else statement
			if (choice == 1) {
				BookObject.returnAll(bookList);
				System.out.println("Which book would you like to check out? (please enter the ID number) ");
				chooseBook = input.nextInt();
				Checkout.checkoutBook(chooseBook, bookList, libraryCard);
			} else if (choice == 2) {
				System.out.println("Please enter an author: ");
				input.nextLine();
				String author = input.nextLine();

				// still need to modify these methods to make them ignore case
				BookObject.authorSearch(author, bookList);
				System.out.println("Which book would you like to check out? (please enter the ID number) ");
				chooseBook = input.nextInt();
				Checkout.checkoutBook(chooseBook, bookList, libraryCard);
			} else if (choice == 3) {
				System.out.println("Please enter a title: ");
				input.nextLine();
				String title = input.nextLine();
				BookObject.titleSearch(title, bookList);

				// prompt user to enter a book ID number
				System.out.println("Which book would you like to check out? (please enter the ID number) ");
				chooseBook = input.nextInt();
				Checkout.checkoutBook(chooseBook, bookList, libraryCard);
			} else {
				System.out.println("Sorry! That is not a valid search option...");
				// loop with a boolean?
			}

		} else {
			// let user return a book

			// prompt user for borrowID aka library card

			System.out.println("Please enter your library card number");
			int returnUser = input.nextInt();

			// setting variables to use through return program

			boolean keepReturning = true;

			boolean moreBooks = true;

			boolean returnList = true;

			Book r = null;
			int bookCounter = 0;

						
						
						//display the list of books that the user has checked out
						Checkout.displayBook(bookList, returnUser, input);
						
						//change the status of the book to "available"
						//set the libraryCard field back to 0
						//print message confirming the return
						

					 // need to know how we will be
											// formatting Library Card #

					//System.out.println(r.getTitle() + "has successfully been returned.");

					// display user an updated list of checked out books (if
					// any)

				/*	for (int i = 0; i < bookList.size(); i++) {

						if (r.getlibraryCard() == returnUser) {
							System.out.println("Book ID: " + r.getIndex() + "Title: " + r.getTitle());
							bookCounter++;
							// ask if they would like to return another book
							System.out.println("Would you like to return another book?");

							String anotherBook = input.nextLine();

							if (anotherBook.equalsIgnoreCase("no")) {
								System.out.println("Have a great day! Goodbye!");
								keepReturning = false;
							}
						}
						// if no more books, exits

					}
					if (bookCounter == 0) {
						System.out.println("You do not have any additional books checked out under your name.");
						System.out.println("Have a great day! Goodbye!");

						moreBooks = false;
						keepReturning = false;
					}
*/
					// if "no", app terminates.
					// if yes, continues back to top of return section.

				}

			}
	}

