import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;
        boolean continueCalc = true;

        System.out.println("Basic Calculator");
        System.out.println("Operations: +, -, *, /, % (percentage)");
        System.out.println("Enter Q to quit");

        while (continueCalc) {
            System.out.println("\nEnter operation: ");
            String input = scanner.next();

            if (input.equals("Q")) {
                continueCalc = false;
                System.out.println("Calculator terminated.");
                break;
            }

            operator = input.charAt(0);

            System.out.println("Enter first number: ");
            num1 = scanner.nextDouble();
            System.out.println("Enter second number: ");
            num2 = scanner.nextDouble();

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.printf("%.2f + %.2f = %.2f", num1, num2, result);
                    break;

                case '-':
                    result = num1 - num2;
                    System.out.printf("%.2f - %.2f = %.2f", num1, num2, result);
                    break;

                case '*':
                    result = num1 * num2;
                    System.out.printf("%.2f * %.2f = %.2f", num1, num2, result);
                    break;

                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.printf("%.2f / %.2f = %.2f", num1, num2, result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed");
                    }
                    break;

                case '%':
                    result = (num1 * num2) / 100;
                    System.out.printf("%.2f%% of %.2f = %.2f", num2, num1, result);
                    break;

                default:
                    System.out.println("Error: Invalid operator");
                    break;
            }
        }

        scanner.close();
    }
}