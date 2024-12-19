import java.util.*;

public class InfixToPrefix {
    // Function to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Function to get the precedence of an operator
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    // Function to convert infix expression to prefix notation
    public static String infixToPrefix(String infix) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Reverse the infix expression
        String reversedInfix = new StringBuilder(infix).reverse().toString();


        for (char ch : reversedInfix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                // Operand, add to the output
                prefix.insert(0, ch);
            } else if (ch == ')') {
                // Closing parenthesis, push onto the stack
                stack.push(ch);
            } else if (ch == '(') {
                // Opening parenthesis, pop and output operators until closing parenthesis is encountered
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.insert(0, stack.pop());
                }
                stack.pop(); // Pop the closing parenthesis
            } else if (isOperator(ch)) {
                // Operator
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(ch)) {
                    prefix.insert(0, stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop and output any remaining operators from the stack
        while (!stack.isEmpty()) {
            prefix.insert(0, stack.pop());
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "((a+b^c^d)*(e+f/d))";
        System.out.println("Infix expression: " + infixExpression);
        System.out.println("Prefix expression: " + infixToPrefix(infixExpression));
    }
}
