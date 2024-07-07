import java.util.Scanner;

public class Main {
	private static double calculator(double num1, String operation, double num2) {
		double result;
		switch (operation) {
		case "+":
			result = num1 + num2;
			return result;
		case "-":
			result = num1 - num2;
			return result;
		case "*":
			result = num1 * num2;
			return result;
		case "/":
			result = num1 / num2;
			return result;
		default:
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello world!");
		System.out.println("This is simle java calculator");
		Scanner scanner = new Scanner(System.in);
		
		boolean numeric;
		double num1 = 0;
		double num2 = 0;
		String operator = null;
		boolean loop = true;
		
		while (loop) {
			System.out.print("> ");
			String input = scanner.nextLine();
			String[] arguments = input.split(" ");
			if (arguments.length == 3) {
				try {
					num1 = Double.parseDouble(arguments[0]);
					num2 = Double.parseDouble(arguments[2]);
					operator = arguments[1];
					numeric = true;
				} catch (NumberFormatException e) {
					numeric = false;
				}
				if (numeric != true && (operator != "+" || operator != "-" || operator != "*" || operator != "/")) {
					System.out.println("Incorrect input");
				} else {
					System.out.println(calculator(num1, operator, num2));
				}
			} else if (arguments[0] == "!") {
				System.out.println("Incorrect input");
				loop = false;
				break;
			}
		}
		scanner.close();
	}
}
