import java.util.*;

public class PostfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix string");
        String postfix = sc.nextLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else  {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(c, operand1, operand2);
                stack.push(result);
            }
        }

        System.out.println("ANS ::"+stack.pop());
    }

    static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '^':
            case '$':
                return (int) Math.pow(operand1, operand2);
        }
        return -1;
    }
}
