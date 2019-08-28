import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		println("Calculator made by Akilan Gnanavel");
		
		Scanner input = new Scanner(System.in);
		
		double answer = 0;
		
		while (true) {
			println("Enter an operation (or enter 0 to exit)");
			String userInput = input.nextLine();
			
			if (userInput.equalsIgnoreCase("0")) break;
			
			String idk = userInput.substring(0, 1);
			if (userInput.substring(0, 1).equalsIgnoreCase("+") || userInput.substring(0, 1).equalsIgnoreCase("-") || userInput.substring(0, 1).equalsIgnoreCase("*") || userInput.substring(0, 1).equalsIgnoreCase("/")) {
				double rest = Double.parseDouble(userInput.substring(2));
				switch (idk) {
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
			} else {
			
				int firstSpace = 0;
				int secondSpace = 0;
				for (int i = 0; i < userInput.length(); i++) {
					if (userInput.substring(i, i + 1).equalsIgnoreCase(" ")) {
						if (firstSpace == 0) {
							firstSpace = i;
						} else {
							secondSpace = i;
						}
					}
				}
			
				double firstNumber = Double.parseDouble(userInput.substring(0, firstSpace));
				String operation = userInput.substring(firstSpace + 1, firstSpace + 2);
				double secondNumber = Double.parseDouble(userInput.substring(secondSpace + 1));
			
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
			
			println("= " + answer);
			println("");
			
		}
		
		println("Thank you for using the calculator");
		input.close();
	}
	
	public static void print(String str) {
		System.out.print(str);
	}
	
	public static void println(String str) {
		System.out.println(str);
	}
}
