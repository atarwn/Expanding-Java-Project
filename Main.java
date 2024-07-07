import java.util.Scanner;

public class Main {
	private static double calculator(double num1, String operation, double num2) {
		double result;
		switch (operation) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			if (num2 != 0) {
				result = num1 / num2;
			} else {
				System.out.println("Division by zero is not allowed.");
				result = Double.NaN;
			}
			break;
		default:
			result = Double.NaN;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Hello world!");
		System.out.println("This is a simple Java calculator");
		Scanner scanner = new Scanner(System.in);

		boolean loop = true;

		while (loop) {
			System.out.print("> ");
			String input = scanner.nextLine();
			if (input.equals("!")) {
				System.out.println("Exiting...");
				loop = false;
				continue;
			}
			String[] arguments = input.split(" ");
			if (arguments.length == 3) {
				try {
					double num1 = Double.parseDouble(arguments[0]);
					double num2 = Double.parseDouble(arguments[2]);
					String operator = arguments[1];
					if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
						double result = calculator(num1, operator, num2);
						System.out.println("Result: " + result);
					} else {
						System.out.println("Invalid operator. Use +, -, * or /.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid number format.");
				}
			} else {
				System.out.println("Incorrect input. Format: <number1> <operator> <number2>");
			}
		}
		scanner.close();
	}
}
