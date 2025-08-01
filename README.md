# GUICalculator

A simple calculator application built using **Java Swing** as a learning project. This GUI-based calculator, designed with a phone-like button layout, was created to practice Java programming concepts including:

- Swing for GUI development  
- Event-driven programming  
- Basic arithmetic operations  

It supports **addition**, **subtraction**, **multiplication**, **division**, and **percentage** calculations.

---

## 📚 Purpose

This project was developed as a learning exercise to:

- Explore Java Swing for creating graphical user interfaces.
- Practice event-driven programming using `ActionListener`s.
- Implement arithmetic operations and basic error handling.
- Understand layout managers like `BorderLayout` and `GridLayout`.

---

## ✨ Features

- **Graphical Interface**: Basic GUI with a text field and calculator-style button grid.
- **Arithmetic Operations**: Supports `+`, `-`, `×`, `÷`, and `%`.
- **Error Handling**: Displays errors for invalid inputs (e.g., division by zero).
- **Clear Function**: Resets input with a `C` button.
- **Decimal Support**: Allows decimal input (one per number).
- **Phone-like Layout**: Buttons arranged like a traditional calculator.

---

## 🔧 Prerequisites

- **Java Development Kit (JDK)** – Version 8 or higher  
- **Java Runtime Environment (JRE)** – To run the compiled `.class` files  
- A code editor or IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code with Java extensions)

---

## 🚀 Setup Instructions

### 1. Download the Code

Copy or clone the `GUICalculator.java` file to your local machine.

### 2. Compile the Code

Open a terminal in the directory where `GUICalculator.java` is located and run:

```bash
javac GUICalculator.java
```
### 3. Run the Application

Launch the calculator with:

```bash
java GUICalculator
```
## 🖱️ Usage

### Start the Calculator

A window titled **"Calculator"** will appear.

### Input Numbers

- Click the number buttons (`0–9`) to enter digits.
- Use the `.` button to enter decimal points (only one decimal per number is allowed).

### Choose an Operator

- Click one of the operators: `+`, `-`, `×`, `÷`, or `%`.

### Calculate

- After entering the second number, click `=` to display the result.
- The result will be shown with two decimal places.

### Reset

- Click the `C` button to clear the input and reset the calculator.

### Percentage Operation

- The `%` button calculates: `(num1 * num2) / 100`
- Example: `50 % 200` → `100.00`

### Error Messages

- `Error: Div by 0` — displayed when dividing by zero.
- `Error` — shown for any invalid input or operation.

## ✅ Example

To compute `10 + 5`:

1. Click `1`, then `0` to input `10`.
2. Click the `+` button.
3. Click `5`.
4. Click the `=` button.

**Result:** `15.00`

## ⚠️ Limitations

- Only supports basic arithmetic operations (no square roots, exponents, etc.).
- Input is restricted to GUI button clicks — no keyboard input.
- Percentage calculation uses the formula `(num1 * num2) / 100`, which may differ from standard calculators.
- This is a beginner-friendly project and not intended for production use.

## 📝 Notes

This calculator was created as a **learning project** to:

- Practice building GUIs using Java Swing.
- Understand the fundamentals of event-driven programming.
- Explore how layout managers work in Java (e.g., `GridLayout`, `BorderLayout`).

It is not intended for production use, but provides a strong foundation for GUI development and Java application structure.
