import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		println("Calculator made by Akilan Gnanavel");

		// scanner object to read user input
		Scanner input = new Scanner(System.in);

		// variable to hold solution of the operation
		double answer = 0;

		// print instructions to user
		println("Enter an operation (or enter 0 to exit)");
		println("Input must have spaces between numbers and the operation");
		println("For example, 5 + 6 is valid while 5+6 is invalid");
		// string that holds the entire line that the user enters
		String userInput = input.nextLine();

		try {
			// while the user does not request to quit, carry out operations
			while (!userInput.contentEquals("0")) {

				// string variable that holds the first character that the user input
				String first = userInput.substring(0, 1);

				// check if the first character is an operation
				if (userInput.substring(0, 1).equalsIgnoreCase("+") || userInput.substring(0, 1).equalsIgnoreCase("-")
						|| userInput.substring(0, 1).equalsIgnoreCase("*")
						|| userInput.substring(0, 1).equalsIgnoreCase("/")) {
					// the variable that holds the second number in the operation (if the first
					// character is an operation)
					double rest = Double.parseDouble(userInput.substring(2));

					// use previous answer (or 0 if there isn't one) and apply the operation that
					// the user requested
					switch (first) {
					case "+":
						answer += rest;
						break;
					case "-":
						answer -= rest;
						break;
					case "*":
						answer *= rest;
						break;
					case "/":
						answer /= rest;
						break;
					}
				} else { // if the user's input has spaces
					// if the user entered two numbers themselves

					// variables to hold the index of the space in the string
					int firstSpace = 0;
					int secondSpace = 0;
					// loop through the string that the user entered to find the indexes of the two
					// spaces
					for (int i = 0; i < userInput.length(); i++) {
						if (userInput.substring(i, i + 1).equalsIgnoreCase(" ")) {
							if (firstSpace == 0) {
								firstSpace = i;
							} else {
								secondSpace = i;
							}
						}
					}

					// use the indexes of the spaces to determine the first number, the second
					// number, and the operation
					double firstNumber = Double.parseDouble(userInput.substring(0, firstSpace));
					String operation = userInput.substring(firstSpace + 1, firstSpace + 2);
					double secondNumber = Double.parseDouble(userInput.substring(secondSpace + 1));

					// depending on which operation the user entered, apply appropriate computation
					// to the two numbers
					switch (operation) {
					case "+":
						answer = firstNumber + secondNumber;
						break;
					case "-":
						answer = firstNumber - secondNumber;
						break;
					case "*":
						answer = firstNumber * secondNumber;
						break;
					case "/":
						answer = firstNumber / secondNumber;
						break;
					}
				}

				//print the answer
				println("= " + answer);
				println("");

				//prompt the user for instructions again
				println("Enter an operation (or enter 0 to exit)");
				userInput = input.nextLine();
			}
		} catch (NumberFormatException e) { // if the user entered input in an invalid format, let them know
			println("Input must have spaces between numbers and the operation");
			println("For example, 5 + 6 is valid while 5+6 is invalid");
		}

		println("");
		println("Thank you for using the calculator");
		input.close();
	}

	// this method prints a string to the console
	// its purpose is to reduce the time needed to type System.out.print
	public static void print(String str) {
		System.out.print(str);
	}

	// this method prints a string to the console with a newline character at the
	// end
	// its purpose is to reduce the time needed to type System.out.println
	public static void println(String str) {
		System.out.println(str);
	}
}
