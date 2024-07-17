// 46. Write a program to convert infix notation to prefix notation using stack.
import java.util.Scanner;
import java.util.Stack;

public class Lab8_46 {

    // Method to get precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Method to reverse the string and swap '(' with ')' and vice versa
    private static String reverseAndReplace(String exp) {
        StringBuilder reversed = new StringBuilder();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (c == '(') {
                reversed.append(')');
            } else if (c == ')') {
                reversed.append('(');
            } else {
                reversed.append(c);
            }
        }
        return reversed.toString();
    }

    // Method to convert infix expression to postfix expression
    private static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the character is an operand, add it to output
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop and output from the stack until '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '(' from stack
            }
            // If an operator is encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Method to convert infix expression to prefix expression
    public static String infixToPrefix(String exp) {
        // Step 1: Reverse the infix expression
        String reversed = reverseAndReplace(exp);

        // Step 2: Get postfix of the reversed expression
        String postfix = infixToPostfix(reversed);

        // Step 3: Reverse the postfix expression to get the prefix expression
        StringBuilder prefix = new StringBuilder(postfix).reverse();

        return prefix.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the infix expression: ");
        String exp = sc.nextLine();

        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + infixToPrefix(exp));

        sc.close();
    }
}
