import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Checkout {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//First prompt should ask, do you have a library card - if so "swipe" now: enter library card ID
		//If not, generates a new code and stores the user and name in the arrayList for users
		//our main needs to generate this when it starts running to call it later
		//it's ok if this is different everytime the user comes to the library we can fix that if we build out further
		int libraryCard = (int)(Math.random()*1000+1);
		System.out.println("your library card number is: " + libraryCard);

		System.out.println("Which book would you like to check out? (please enter the ID number) ");
		int chooseBook = input.nextInt();
		
		ArrayList<Book> newList = BookObject.instatiateArray();
		
		checkoutBook(chooseBook, newList, libraryCard);
		
	}
	
	
	public static void checkoutBook(int index, ArrayList<Book> bookArrayList, int libraryCard) {
		
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
	
	public static void displayBook(ArrayList<Book> bookArrayList, int libraryCard, Scanner input){
		int count = 0;
		
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
					System.out.println(b.getTitle() + " Number: " + b.getIndex());
				}
			}
			//prompt the user to return a book
			System.out.println("Enter the number of the book you would like to return: ");
			int returnIndex = input.nextInt();
			
			//go through array list, find selected book, get library card and verify that it matches the users
			
			if ((bookArrayList.get(returnIndex-1)).getlibraryCard() == libraryCard) {
				//call method to set book status and card number back to default
				Checkout.returnBook(bookArrayList, libraryCard, returnIndex);
				
				System.out.println("Would you like to return another book? (Y/N) ");
				input.nextLine();
				String anotherBook = input.nextLine();
				if(anotherBook.equalsIgnoreCase("y")){
					//RECURSION!!!!!
					displayBook(bookArrayList, libraryCard, input);
				}
			}else{
				System.out.println("Invalid Entry!");
				displayBook(bookArrayList, libraryCard, input);
			}
		}
		
		//if the user does not have any books checked out or they enter an invalid card number
		if(count == 0){
			System.out.println("Sorry there are no books under that Library card!");
		}
	}
	
	public static void returnBook(ArrayList<Book> bookArrayList, int libraryCard, int index){
		
		for (int i = 0; i < bookArrayList.size(); i++){
			
			Book r = bookArrayList.get(i);
			if(r.getIndex() == index){
				r.setStatus("Available");
				r.setLibraryCard(0);
				System.out.println("You have successfully returned: " + r.getTitle());
			}
		}
	}
	
	public static void checkBooks(ArrayList<Book> bookArrayList, int libraryCard){
			for (int i = 0; i < bookArrayList.size(); i++) {
			
			Book b = bookArrayList.get(i);
		}
	}
}
