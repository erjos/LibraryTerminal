import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Checkout {

	// method to checkout a book and change fields
	public static void checkoutBook(ArrayList<Book> bookArrayList, int libraryCard, Scanner input) {
		boolean checkingOut = true;
		while (checkingOut) {
			int index = Validator.getInt(input,
					"Which book would you like to check out? (please enter the Index number) ", "Please try again");

			for (int i = 0; i < bookArrayList.size(); i++) {

				Book b = bookArrayList.get(i);
				if (b.getIndex() == (index)) {
					if (b.getStatus().equals("Available")) {
						b.setStatus("Checked Out");
						LocalDate due = LocalDate.now();
						b.setDue(due.plusDays(14));
						b.setLibraryCard(libraryCard);
						System.out.println(
								"You have successfully checked out \"" + b.getTitle() + "\" by " + b.getAuthor());
						System.out.println("Your book is due on: " + b.getDue() + "\n"
								+ "You will need your Library card to return your book. Don't forget your card number is: "
								+ libraryCard);
					} else {
						System.out.println("I'm sorry, this book is unavailable for checkout at this time!");

					}
				}
			}
			checkingOut = Validator.getYorN(input, "Do you want to try another checkout?");
		}
	}

	// method to display a list of books checked out and return a book if
	// applicable (calls next method and uses recursion)
	public static void displayBook(ArrayList<Book> bookArrayList, Scanner input) {
		int count = 0;
		int libraryCard = Validator.getInt(input,
				"Please enter your library card number to " + "view what books you have checked out: ",
				"Please try again.\n");

		// how many books does the user have checked out
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			if (b.getlibraryCard() == (libraryCard)) {
				count++;
			}
		}
		// if the user has any books checked out
		if (count > 0) {
			System.out.println("You have the following books checked out under your name: ");
			for (int i = 0; i < bookArrayList.size(); i++) {
				Book b = bookArrayList.get(i);
				if (b.getlibraryCard() == (libraryCard)) {
					System.out.format("%-12s%-30s%-30s%-12s", "INDEX #", "TITLE", "AUTHOR", "STATUS");
					System.out.println("");
					System.out.format("%-12d%-30s%-30s%-12s", b.getIndex(), b.getTitle(), b.getAuthor(), b.getStatus());
					System.out.println("");
				}
			}
			// prompt the user to return a book

			int returnIndex = Validator.getInt(input, "Enter the number of the book you would like to return: ", 1, 12,
					"Please enter a number\n");

			// go through array list, find selected book, get library card and
			// verify that it matches the users

			if ((bookArrayList.get(returnIndex - 1)).getlibraryCard() == libraryCard) {
				// call method to set book status and card number back to
				// default
				Checkout.returnBook(bookArrayList, libraryCard, returnIndex);
				boolean anotherBook = Validator.getYorN(input, "Would you like to return another book? (Y/N)");
				// System.out.print("Would you like to return another book?
				// (Y/N) ");
				// input.nextLine();
				// String anotherBook = input.nextLine();
				if (anotherBook) {
					// RECURSION!!!!!
					displayBook(bookArrayList, input);
				}

			} else {
				System.out.println("Sorry, you are trying to return a book that you do not have!\n");
				displayBook(bookArrayList, input);
			}
		}
		
		// if the user does not have any books checked out or they enter an
		// invalid card number
		if (count == 0) {
			System.out.println("Sorry there are no books under that Library card!");
			displayBook(bookArrayList, input);
		}
	}

	// method that is called in the previous method to reset status and fields
	// of the returned book
	public static void returnBook(ArrayList<Book> bookArrayList, int libraryCard, int index) {

		for (int i = 0; i < bookArrayList.size(); i++) {
			Book r = bookArrayList.get(i);
			if (r.getIndex() == index) {
				r.setStatus("Available");
				r.setLibraryCard(0);
				r.setDue(null);
				System.out.println("You have successfully returned: " + r.getTitle());
			}
		}
	}
}
