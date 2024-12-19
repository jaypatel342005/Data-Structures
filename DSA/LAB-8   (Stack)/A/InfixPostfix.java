import java.util.Stack;

public class InfixPostfix {
    public static void main(String[] args) {
        System.out.println(convertInfixToPostfix("a+b*c/d-e+f/g/(h+i)) "));
    }
    
    static String convertInfixToPostfix(String s) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        stack.push('(');
        int rank = 0;
        int index = 0;
        char next=s.charAt(index);
        while(next!=' ') {
            if(stack.isEmpty()){
                System.out.println("Invalid String: " + s);
                return null;
            }

            while(stackPrecedence(stack.peek())>inputPrecedence(next)){
                char temp=stack.pop();
                postfix+=temp;
                rank+=rank(temp);
                if(rank<1){
                    System.out.println("Invalid String");
                    return  null;
                }
            }

            if(stackPrecedence(stack.peek())!=inputPrecedence(next)){
                stack.push(next);
            }else{
                stack.pop();
            }
            index++;
            next=s.charAt(index);
        }
        if(!stack.isEmpty() ||rank!=1){
            return  null;
        }else{
            return postfix;
        }
    }

    static int inputPrecedence(char ch) {
        if(ch>='a' && ch<='z'){
            return 7;
        }
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
            case '(':
                return 9;
            case ')':
                return  0;
        }
        return -1;
    }
    static int stackPrecedence(char ch) {
        if(ch>='a' && ch<='z'){
            return 8;
        }
        switch (ch) {
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 4;
            case '^':
            case '$':
                return 5;
            case '(':
                return 0;
        }
        return -1;
    }
    static  int rank(char ch) {
        if(ch>='a' && ch<='z'){
            return 1;
        }
        return -1;
    }
}
