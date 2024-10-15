package org.example;

public class StringProcessor {
    //checks if provided password is strong
    public boolean isStrongPassword(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    //counts the number of digits in the given sentence
    public int calculateDigits(String sentence) {
        int digitCnt = 0;
        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCnt++;
            }
        }
        return digitCnt;
    }

    //calculates the number of words in the provided sentence
    public int calculateWords(String input) {
            if (input == null || input.trim().isEmpty()) {
                return 0;
            }

            //plit the string by spaces and filter out empty strings
            String[] words = input.trim().split("\\s+");
            return words.length;
        }



    //evaluates a math expression given as a string
    public double calculateExpression(String expression) {
        return evaluate(expression, 0, expression.length() - 1);
    }

    //method to evaluate expression recursively
    private double evaluate(String expression, int start, int end) {
        double result = 0;
        double currentNumber = 0;
        char operation = '+';
        int i = start;

        while (i <= end) {
            char currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = 0;
                while (i <= end && Character.isDigit(expression.charAt(i))) {
                    currentNumber = currentNumber * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--; // Adjust for the last increment
                result = applyOperation(result, currentNumber, operation);
            } else if (currentChar == '(') {
                int closingIndex = findClosingBracket(expression, i);
                currentNumber = evaluate(expression, i + 1, closingIndex - 1);
                i = closingIndex;
                result = applyOperation(result, currentNumber, operation);
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                operation = currentChar;
            }

            i++;
        }
        return result;
    }

    //method to apply an operator to two numbers
    private double applyOperation(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                return a / b;
        }
        return a;
    }

    //method to find index of the closing bracket corresponding to an opening bracket
    private int findClosingBracket(String expression, int openIndex) {
        int bracketCount = 0;
        for (int i = openIndex; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                bracketCount++;
            } else if (expression.charAt(i) == ')') {
                bracketCount--;
                if (bracketCount == 0) {
                    return i;
                }
            }
        }
        return -1; // No closing bracket found
    }
}
