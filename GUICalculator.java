import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUICalculator extends JFrame {
    private JTextField inputField;
    private double num1, num2, result;
    private char operator;
    private boolean isSecondNumber = false;
    private boolean startNewNumber = true;

    public GUICalculator() {
        // Set up the main frame
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));
        setSize(300, 400);

        // Input field
        inputField = new JTextField("0");
        inputField.setEditable(false);
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        inputField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(inputField, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Button labels in phone calculator layout
        String[] buttons = {
            "7", "8", "9", "÷",
            "4", "5", "6", "×",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "%", "", ""
        };

        // Create and add buttons
        for (String label : buttons) {
            if (label.isEmpty()) {
                buttonPanel.add(new JLabel()); // Empty space
            } else {
                JButton button = new JButton(label);
                button.setFont(new Font("Arial", Font.PLAIN, 18));
                button.addActionListener(new ButtonListener());
                buttonPanel.add(button);
            }
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Center the window
        setLocationRelativeTo(null);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // Handle clear button
            if (command.equals("C")) {
                inputField.setText("0");
                num1 = 0;
                num2 = 0;
                result = 0;
                operator = '\0';
                isSecondNumber = false;
                startNewNumber = true;
                return;
            }

            // Handle number and decimal point input
            if (command.matches("[0-9]") || command.equals(".")) {
                if (startNewNumber || inputField.getText().equals("0")) {
                    inputField.setText(command);
                    startNewNumber = false;
                } else {
                    // Prevent multiple decimal points
                    if (command.equals(".") && inputField.getText().contains(".")) {
                        return;
                    }
                    inputField.setText(inputField.getText() + command);
                }
                return;
            }

            // Handle operators
            if ("+-×÷%".contains(command)) {
                try {
                    num1 = Double.parseDouble(inputField.getText());
                    operator = command.charAt(0);
                    isSecondNumber = true;
                    startNewNumber = true;
                } catch (NumberFormatException ex) {
                    inputField.setText("Error");
                    startNewNumber = true;
                }
                return;
            }

            // Handle equals
            if (command.equals("=") && isSecondNumber) {
                try {
                    num2 = Double.parseDouble(inputField.getText());
                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '×':
                            result = num1 * num2;
                            break;
                        case '÷':
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                inputField.setText("Error: Div by 0");
                                return;
                            }
                            break;
                        case '%':
                            result = (num1 * num2) / 100;
                            break;
                    }
                    inputField.setText(String.format("%.2f", result));
                    isSecondNumber = false;
                    startNewNumber = true;
                } catch (NumberFormatException ex) {
                    inputField.setText("Error");
                    startNewNumber = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUICalculator calc = new GUICalculator();
            calc.setVisible(true);
        });
    }
}