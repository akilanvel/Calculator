import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		println("Calculator made by Akilan Gnanavel");

		// Create Scanner object to read user input
		Scanner input = new Scanner(System.in);

		double answer = 0; // Holds the solution to the operation

		// Print instructions to user and get their input
		println("Enter an operation (or enter 0 to exit)");
		println("Input must have spaces between numbers and the operation");
		println("For example, 5 + 6 is valid while 5+6 is invalid");
		String userInput = input.nextLine();

		try {
			// While the user does not request to quit, carry out the calculator loop
			while (!userInput.contentEquals("0")) {

				// String variable that holds the first character that the user input
				String first = userInput.substring(0, 1);

				// If the first character is an operation, use the answer of the previous operation as the first number
				if (userInput.substring(0, 1).equalsIgnoreCase("+") || userInput.substring(0, 1).equalsIgnoreCase("-")
						|| userInput.substring(0, 1).equalsIgnoreCase("*")
						|| userInput.substring(0, 1).equalsIgnoreCase("/")) {
					// The variable that holds the second number in the operation (if the first
					// character is an operation)
					double rest = Double.parseDouble(userInput.substring(2));

					// Use previous answer (or 0 if there isn't one) and apply the operation that
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
				} else { // If the user entered two numbers
					// Variables to hold the index of the space in the string
					int firstSpace = 0;
					int secondSpace = 0;
					// Loop through the string that the user entered to find the indexes of the two
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

					// Use the indexes of the spaces to determine the first number, the second
					// number, and the operation
					double firstNumber = Double.parseDouble(userInput.substring(0, firstSpace));
					String operation = userInput.substring(firstSpace + 1, firstSpace + 2);
					double secondNumber = Double.parseDouble(userInput.substring(secondSpace + 1));

					// Depending on which operation the user entered, apply appropriate computation
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

				// Print the answer of the operation
				println("= " + answer);
				println("");

				// Prompt the user for input again
				println("Enter an operation (or enter 0 to exit)");
				userInput = input.nextLine();
			}
		} catch (NumberFormatException e) { // If the user entered input in an invalid format, let them know
			println("Input must have spaces between numbers and the operation");
			println("For example, 5 + 6 is valid while 5+6 is invalid");
		}

		println("");
		println("Thank you for using the calculator");
		input.close();
	}

	// This method prints a string to the console
	// Its purpose is to reduce the time needed to type System.out.print
	public static void print(String str) {
		System.out.print(str);
	}

	// This method prints a string to the console with a newline character at the
	// end. Its purpose is to reduce the time needed to type System.out.println
	public static void println(String str) {
		System.out.println(str);
	}
}
