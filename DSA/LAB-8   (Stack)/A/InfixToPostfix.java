import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an infix string");
        String s = sc.nextLine();
        String postfix = convertInfixToPostfix(s);
        System.out.println("Postfix string " + postfix);
        sc.close();
    }

    static String convertInfixToPostfix(String s) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        stack.push('(');
        s += ')';
        int rank = 0;
        for (char i : s.toCharArray()) {

            if (Character.isLetterOrDigit(i)) {
                postfix += i + " ";
                rank++;
            } else if (i == '(') {
                stack.push(i);
            } else if (i == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    postfix += stack.pop() + " ";
                }
                if (stack.empty() || stack.peek() != '(') {
                    return "Invalid input string";
                } else {
                    stack.pop();
                }
            } else if (isOperator(i)) {
                rank--;
                if (i == '^' || i == '$') {
                    stack.push(i);
                } else {

                    while (!stack.empty() && getPrecedence(i) <= getPrecedence(stack.peek())) {
                        postfix += stack.pop() + " "; 
                    }
                    stack.push(i);
                }
            }
        }

        if (rank != 1)
            return "Invalid input string";

        return postfix;
    }

    static int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 3;
            case '^':
            case '$':
                return 6;
        }
        return -1;
    }

    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '$';
    }

}