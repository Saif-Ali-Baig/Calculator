import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Calculator {
    private static double memory = 0;
    private static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result = 0;
        char operator;
        boolean continueCalc = true;

        System.out.println("Advanced Calculator");
        System.out.println("Operations: +, -, *, /, % (percentage), S (square root), s (sin), c (cos), t (tan)");
        System.out.println("Memory: M+ (add to memory), M- (subtract from memory), MR (recall memory), MC (clear memory)");
        System.out.println("Unit Conversions: L (length: cm to inch), T (temp: C to F), C (currency: USD to EUR)");
        System.out.println("History: H (show history), Q (quit)");

        while (continueCalc) {
            System.out.println("\nEnter operation or command: ");
            String input = scanner.next();

            if (input.equals("Q")) {
                continueCalc = false;
                System.out.println("Calculator terminated.");
                break;
            } else if (input.equals("H")) {
                showHistory();
                continue;
            } else if (input.equals("MR")) {
                System.out.println("Memory: " + memory);
                history.add("MR: " + memory);
                continue;
            } else if (input.equals("MC")) {
                memory = 0;
                System.out.println("Memory cleared");
                history.add("MC: Memory cleared");
                continue;
            }

            operator = input.charAt(0);

            // Handle operations requiring one number
            if (operator == 'S' || operator == 's' || operator == 'c' || operator == 't' || 
                operator == 'M' || operator == 'L' || operator == 'T' || operator == 'C') {
                System.out.println("Enter number: ");
                num1 = scanner.nextDouble();

                switch (operator) {
                    case 'S': // Square root
                        if (num1 >= 0) {
                            result = Math.sqrt(num1);
                            System.out.printf("√%.2f = %.2f", num1, result);
                            history.add("√" + num1 + " = " + result);
                        } else {
                            System.out.println("Error: Cannot calculate square root of negative number");
                        }
                        break;

                    case 's': // Sine (degrees)
                        result = Math.sin(Math.toRadians(num1));
                        System.out.printf("sin(%.2f°) = %.2f", num1, result);
                        history.add("sin(" + num1 + "°) = " + result);
                        break;

                    case 'c': // Cosine (degrees)
                        result = Math.cos(Math.toRadians(num1));
                        System.out.printf("cos(%.2f°) = %.2f", num1, result);
                        history.add("cos(" + num1 + "°) = " + result);
                        break;

                    case 't': // Tangent (degrees)
                        result = Math.tan(Math.toRadians(num1));
                        System.out.printf("tan(%.2f°) = %.2f", num1, result);
                        history.add("tan(" + num1 + "°) = " + result);
                        break;

                    case 'M': // Memory operations
                        System.out.println("Memory operation (+ for M+, - for M-): ");
                        char memOp = scanner.next().charAt(0);
                        if (memOp == '+') {
                            memory += num1;
                            System.out.println("Added " + num1 + " to memory. Current memory: " + memory);
                            history.add("M+: " + num1 + " -> Memory = " + memory);
                        } else if (memOp == '-') {
                            memory -= num1;
                            System.out.println("Subtracted " + num1 + " from memory. Current memory: " + memory);
                            history.add("M-: " + num1 + " -> Memory = " + memory);
                        } else {
                            System.out.println("Invalid memory operation");
                        }
                        break;

                    case 'L': // Length conversion (cm to inch)
                        result = num1 * 0.393701; // cm to inches
                        System.out.printf("%.2f cm = %.2f inches", num1, result);
                        history.add(num1 + " cm = " + result + " inches");
                        break;

                    case 'T': // Temperature conversion (C to F)
                        result = (num1 * 9 / 5) + 32;
                        System.out.printf("%.2f°C = %.2f°F", num1, result);
                        history.add(num1 + "°C = " + result + "°F");
                        break;

                    case 'C': // Currency conversion (USD to EUR, fixed rate for simplicity)
                        double rate = 0.92; // Example rate as of 2023
                        result = num1 * rate;
                        System.out.printf("%.2f USD = %.2f EUR", num1, result);
                        history.add(num1 + " USD = " + result + " EUR");
                        break;

                    default:
                        System.out.println("Error: Invalid operator");
                        break;
                }
            } else {
                // Handle operations requiring two numbers
                System.out.println("Enter first number: ");
                num1 = scanner.nextDouble();
                System.out.println("Enter second number: ");
                num2 = scanner.nextDouble();

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        System.out.printf("%.2f + %.2f = %.2f", num1, num2, result);
                        history.add(num1 + " + " + num2 + " = " + result);
                        break;

                    case '-':
                        result = num1 - num2;
                        System.out.printf("%.2f - %.2f = %.2f", num1, num2, result);
                        history.add(num1 + " - " + num2 + " = " + result);
                        break;

                    case '*':
                        result = num1 * num2;
                        System.out.printf("%.2f * %.2f = %.2f", num1, num2, result);
                        history.add(num1 + " * " + num2 + " = " + result);
                        break;

                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                            System.out.printf("%.2f / %.2f = %.2f", num1, num2, result);
                            history.add(num1 + " / " + num2 + " = " + result);
                        } else {
                            System.out.println("Error: Division by zero is not allowed");
                        }
                        break;

                    case '%':
                        result = (num1 * num2) / 100;
                        System.out.printf("%.2f%% of %.2f = %.2f", num2, num1, result);
                        history.add(num2 + "% of " + num1 + " = " + result);
                        break;

                    default:
                        System.out.println("Error: Invalid operator");
                        break;
                }
            }
        }

        scanner.close();
    }

    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No calculations in history.");
        } else {
            System.out.println("Calculation History:");
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ": " + history.get(i));
            }
        }
    }
}