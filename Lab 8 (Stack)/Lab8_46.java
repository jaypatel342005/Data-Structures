// 46. Write a program to convert infix notation to prefix notation using stack.
import java.util.Scanner;
import java.util.Stack;

public class Lab8_46  {
    // Function to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Function to check the precedence of operators
    private static int precedence(char c) {
        switch (c) {
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

    // Function to convert infix to prefix
    private static String infixToPrefix(String infix) {
        Stack<Character> operators = new Stack<>();
        Stack<String> operands = new Stack<>();

        // Reverse the infix expression
        StringBuilder infixReversed = new StringBuilder(infix).reverse();
        for (int i = 0; i < infixReversed.length(); i++) {
            char c = infixReversed.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                operands.push(c + "");
            } else if (c == ')') {
                operators.push(c);
            } else if (c == '(') {
                while (!operators.isEmpty() && operators.peek() != ')') {
                    String op1 = operands.pop();
                    String op2 = operands.pop();
                    char op = operators.pop();
                    String tmp = op + op1 + op2;
                    operands.push(tmp);
                }
                operators.pop(); // pop ')'
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(c) < precedence(operators.peek())) {
                    String op1 = operands.pop();
                    String op2 = operands.pop();
                    char op = operators.pop();
                    String tmp = op + op1 + op2;
                    operands.push(tmp);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            String op1 = operands.pop();
            String op2 = operands.pop();
            char op = operators.pop();
            String tmp = op + op1 + op2;
            operands.push(tmp);
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String infix = scanner.nextLine().trim();

        System.out.println("Infix Expression: " + infix);
        String prefix = infixToPrefix(infix);
        System.out.println("Prefix Expression: " + prefix);
    }
}
