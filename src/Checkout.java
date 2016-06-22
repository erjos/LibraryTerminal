import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Checkout {
	
	//method to checkout a book and change fields
	public static void checkoutBook(ArrayList<Book> bookArrayList, int libraryCard, Scanner input) {
		System.out.print("Which book would you like to check out? (please enter the Index number): ");
		int index = input.nextInt();
		
		for (int i = 0; i < bookArrayList.size(); i++) {

			Book b = bookArrayList.get(i);
			if (b.getIndex() == (index)) {
				if(b.getStatus().equals("Available")){
						b.setStatus("Checked Out");
						LocalDate due = LocalDate.now();
						b.setDue(due.plusDays(14));
						b.setLibraryCard(libraryCard);
				System.out.println("You have successfully checked out \"" + b.getTitle() + "\" by " + b.getAuthor());
				System.out.println("Your book is due on: " + b.getDue() + "\n" + "You will need your Library card to return your book. Don't forget your card number is: " + libraryCard);
				
				} else {
					System.out.println("I'm sorry, this book is unavailable for checkout at this time!");
				}
			}
		}
	}
	
	//method to display a list of books checked out and return a book if applicable (calls next method and uses recursion)
	public static void displayBook(ArrayList<Book> bookArrayList, Scanner input){
		int count = 0;
		System.out.print("Please enter your library card number: ");
		int libraryCard = input.nextInt();
		
		//how many books does the user have checked out
		for (int i = 0; i < bookArrayList.size(); i++) {
			Book b = bookArrayList.get(i);
			if(b.getlibraryCard() == (libraryCard)) {
				count++;
			}
		}
		
		//if the user has any books checked out
		if(count > 0){
			System.out.println("You have the following books checked out under your name: ");
			for (int i = 0; i < bookArrayList.size(); i++) {
				Book b = bookArrayList.get(i);
				if(b.getlibraryCard() == (libraryCard)) {
					System.out.println("\"" + b.getTitle() + "\"" + "\n" + "Number: " + b.getIndex());
				}
			}
			//prompt the user to return a book
			System.out.print("Enter the number of the book you would like to return: ");
			int returnIndex = input.nextInt();
			
			//go through array list, find selected book, get library card and verify that it matches the users
			
			if ((bookArrayList.get(returnIndex-1)).getlibraryCard() == libraryCard) {
				//call method to set book status and card number back to default
				Checkout.returnBook(bookArrayList, libraryCard, returnIndex);
				
				System.out.print("Would you like to return another book? (Y/N) ");
				input.nextLine();
				String anotherBook = input.nextLine();
				if(anotherBook.equalsIgnoreCase("y")){
					//RECURSION!!!!!
					displayBook(bookArrayList, input);
				}
			}else{
				System.out.println("Invalid Entry!");
				displayBook(bookArrayList, input); //NEED TO FIX - add a separate validator
			}
		}
		
		//if the user does not have any books checked out or they enter an invalid card number
		if(count == 0){
			System.out.println("Sorry there are no books under that Library card!");
			displayBook(bookArrayList, input);
		}
	}
	
	//method that is called in the previous method to reset status and fields of the returned book
	public static void returnBook(ArrayList<Book> bookArrayList, int libraryCard, int index){
		
		for (int i = 0; i < bookArrayList.size(); i++){
			
			Book r = bookArrayList.get(i);
			if(r.getIndex() == index){
				r.setStatus("Available");
				r.setLibraryCard(0);
				r.setDue(null);
				System.out.println("You have successfully returned: " + r.getTitle());
			}
		}
	}
}
