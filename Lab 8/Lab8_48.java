// 48. Write a program for evaluation of prefix Expression using Stack. 

import java.util.Stack;

import java.util.Scanner;

public class Lab8_48 {

    
    public static int evaluatePrefix(String expression) {
        
        Stack<Integer> stack = new Stack<>();

        
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            }
            
            
            else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter a prefix expression:");
        String prefixExpression = scanner.nextLine();

        
        int result = evaluatePrefix(prefixExpression);

        
        System.out.println("The result of the prefix expression is: " + result);

        scanner.close();
    }
}
