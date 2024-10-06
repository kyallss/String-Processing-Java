public class StringProcessor {
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

    // Method to count the number of digits in a given sentence
    public int calculateDigits(String sentence) {
        int digitCnt = 0;
        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCnt++;
            }
        }
        return digitCnt;
    }

    // Method to calculate the number of words in a given sentence
    public int calculateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Method to calculate the result of an expression
    public double calculateExpression(String expression) {
        return evaluate(expression, 0, expression.length() - 1);
    }

    // Helper method to evaluate expressions recursively
    private double evaluate(String expression, int start, int end) {
        double result = 0;
        double currentNumber = 0;
        char operation = '+';
        int i = start;

        while (i <= end) {
            char currentChar = expression.charAt(i);

            // If the current character is a digit, accumulate the number
            if (Character.isDigit(currentChar)) {
                currentNumber = 0;
                while (i <= end && Character.isDigit(expression.charAt(i))) {
                    currentNumber = currentNumber * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--; // Adjust for the last increment

                // Apply the previous operation to the current number
                result = applyOperation(result, currentNumber, operation);
            }
            // If the current character is an opening bracket, recursively evaluate the inside expression
            else if (currentChar == '(') {
                int closingIndex = findClosingBracket(expression, i);
                currentNumber = evaluate(expression, i + 1, closingIndex - 1);
                i = closingIndex;

                // Apply the previous operation to the result of the expression inside the brackets
                result = applyOperation(result, currentNumber, operation);
            }
            // If the current character is an operator, store it for the next number
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                operation = currentChar;
            }

            i++;
        }

        return result;
    }

    // Method to apply an operator to two numbers
    private double applyOperation(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                return a / b;
        }
        return a;
    }
    // Helper method to find the index of the closing bracket corresponding to an opening bracket
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
        return -1;
    }

}
