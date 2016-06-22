
import java.util.Scanner;

public class Validator { // 3 options
	public static String getChoice(Scanner scan, String prompt, String opt1, String opt2, String opt3,
			String response) {
		String choice = "";
		boolean repeat = true;
		String answer = ""; // need to initialize the variable
		System.out.println(prompt);
		while (repeat) {
			choice = scan.nextLine();
			if (choice.substring(0, 1).equalsIgnoreCase(opt1.substring(0, 1))) {
				choice = opt1;
				repeat = false;
			} else if (choice.substring(0, 1).equalsIgnoreCase(opt2.substring(0, 1))) {
				choice = opt2;
				repeat = false;
			} else if (choice.substring(0, 1).equalsIgnoreCase(opt3.substring(0, 1))) {
				choice = opt3;
				repeat = false;
			} else {
				System.out.println(response);
				repeat = true;

			}
		}
		return choice;
	}

	public static String getChoice(Scanner scan, String prompt, String opt1, String opt2, String response) {
		String action = "";
		boolean repeat = true;
		// String action = ""; // need to initialize the variable
		while (repeat) {
			System.out.println(prompt);
			action = scan.nextLine();
			if (action.substring(0, 1).equalsIgnoreCase(opt1.substring(0, 1))) {
				action = opt1;
				repeat = false;

			} else if (action.substring(0, 1).equalsIgnoreCase(opt2.substring(0, 1))) {
				action = opt2;
				repeat = false;

			} else {
				System.out.println(response);

				continue;
			}
		}
		return action;
	}

	public static Boolean getYorN(Scanner scan, String prompt) {
		// Yes or No that has one String Prompt and one no response
		boolean repeat = true;
		boolean yOrN = true;
		String answerRepeat = ""; // need to initialize the variable
		while (yOrN) {
			System.out.println(prompt);
			answerRepeat = scan.nextLine();

			if (answerRepeat.toLowerCase().contains("y")) {
				repeat = true;
				break;
			} else if (answerRepeat.toLowerCase().contains("n")) {

				repeat = false;
				break;
			} else {
				System.out.println("Invalid Answer, Please Try Again.\r");
				continue;
			}
		}
		return repeat;
	}

	public static Boolean getYorN(Scanner scan, String prompt, String response) {
		// Yes or No that has one String Prompt and one no response
		boolean repeat = true;
		boolean yOrN = true;
		String answerRepeat = ""; // need to initialize the variable
		while (yOrN) {
			System.out.println(prompt);
			answerRepeat = scan.nextLine();

			if (answerRepeat.toLowerCase().contains("y")) {
				repeat = true;
				break;
			} else if (answerRepeat.toLowerCase().contains("n")) {
				System.out.println(response);
				repeat = false;
				break;
			} else {
				System.out.println("Invalid Answer, Please Try Again.\r");
				continue;
			}
		}
		return repeat;
	}

	// this one has a prompt, a crafted error response, and a no response
	public static Boolean getYorN(Scanner scan, boolean repeat, String prompt, String responseNo, String stringError) {

		repeat = true;
		boolean yOrN = true;
		String answerRepeat = ""; // need to initialize the variable
		while (yOrN) {
			System.out.println(prompt);

			answerRepeat = scan.nextLine();

			if (answerRepeat.toLowerCase().contains("y")) {
				repeat = true;
				break;
			} else if (answerRepeat.toLowerCase().contains("n")) {
				System.out.println(responseNo);
				repeat = false;
				break;
			} else {
				System.out.println(stringError + "\r");

				continue;
			}
		}
		return repeat;
	}

	// Get a string
	public static String getString(Scanner scan, String prompt) {
		System.out.print(prompt);
		String s = scan.next(); // read user entry
		scan.nextLine(); // discard any other data entered on the line
		return s;
	}

	// Get an int, takes a prompt, gives response and Min Max
	// public static int getInt(Scanner scan, String prompt, String response,
	// int min, int max) {
	// int i = 0;
	// boolean isValid = false;
	// while (isValid == false) {
	// System.out.print(prompt);
	// if (scan.hasNextInt()) { // this is the key scanner method
	// i = scan.nextInt();
	//
	// if ((i < min) || (i > max))
	// System.out.println("Error! Number must be between " + min + " and " +
	// max);
	// isValid = true;
	// } else {
	// System.out.println(response);
	//
	// }
	// scan.nextLine(); // discard any other data entered on the line
	// }
	// return i;
	// }
	// // Get an int, takes a prompt, gives response
	public static int getInt(Scanner scan, String prompt, String response) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (scan.hasNextInt()) { // this is the key scanner method
				i = scan.nextInt();
				isValid = true;
			} else {
				System.out.println(response);

			}
			scan.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	// Get and int with Prompt and min Max
	public static int getInt(Scanner scan, String prompt, int min, int max, String response) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(scan, prompt, response);
			if ((i < min) || (i > max))
				System.out.println("Error! Number must be between " + min + " and " + max);
			else
				isValid = true;
		}
		return i;
	}

	// get a double with a prompt
	public static double getDouble(Scanner scan, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (scan.hasNextDouble()) {
				d = scan.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			scan.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	// Get a double with min and max
	public static double getDouble(Scanner scan, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(scan, prompt);
			if (d <= min)
				System.out.println("Error! Number must be greater than " + min + ".");
			else if (d >= max)
				System.out.println("Error! Number must be less than " + max + ".");
			else
				isValid = true;
		}
		return d;
	}
}
