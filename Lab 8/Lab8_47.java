// 47. Write a program for evaluation of postfix Expression using Stack.


import java.util.Stack;
import java.util.Scanner;

public class Lab8_47 {

    
    public static int evaluatePostfix(String expression) {
        
        Stack<Integer> stack = new Stack<>();
        
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            }
            
            
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
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
        
        
        System.out.println("Enter a postfix expression:");
        String postfixExpression = scanner.nextLine();
        
        
        int result = evaluatePostfix(postfixExpression);
        
        
        System.out.println("The result of the postfix expression is: " + result);
        
        scanner.close();
    }
}
