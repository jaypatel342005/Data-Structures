import java.util.*;

public class PrefixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a prefix string");
        String prefix = sc.nextLine();
        int result = evaluatePrefix(prefix);
        System.out.println("Result: " + result);
        sc.close();
    }

    private static int evaluatePrefix(String prefix) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else if (isOperator(c)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                System.out.println(operand1 + " " + operand2);
                int result = performOperation(c, operand1, operand2);
                System.out.println(result);
                stack.push(result);
                System.out.println(stack);
            }
        }
        
        return stack.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
        }
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }
}
