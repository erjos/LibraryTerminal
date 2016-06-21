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
						b.setlibraryCard(libraryCard);
				System.out.println("You have successfully checked out \"" + b.getTitle() + "\" by " + b.getAuthor());
				System.out.println("Your book is due on: " + b.getDue() + "\n" + "You will need your Library card to return your book. Don't forget your card number is: " + libraryCard);
				
				} else {
					System.out.println("I'm sorry, this book is unavailable for checkout at this time!");
				}
			}
		}
	}
}
