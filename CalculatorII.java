package Stack;

import java.util.Stack;

public class CalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+'; // default operator before any number
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Build the current number if digit
            if (Character.isDigit(c)) {
                // Example: reading "325" →
                // '3' → 3
                // '2' → 3*10 + 2 = 32
                // '5' → 32*10 + 5 = 325
                currentNumber = currentNumber * 10 + (c - '0');
            }

            // If operator or end of string → process the number
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                // Reset for next round
                operation = c;
                currentNumber = 0;
            }
        }

        // Final result = sum of everything in stack
        int result = 0;
        for (int num : stack) {
            result += num;
        }

        return result;
    }
}