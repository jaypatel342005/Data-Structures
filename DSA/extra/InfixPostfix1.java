// Write a program to convert infix notation to postfix notation using stack.
import java.util.Scanner;
import java.util.Stack;

public class InfixPostfix1 {
    static int stackG(char ch) {
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

    static int inputF(char ch) {
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

    public static int Rank(char c) {
        if(c>='a' && c<='z'){
            return 1;
        }
        return -1;
    }

    public static void postfix(String s) {
        char next;
        s += ')';
        int rank = 0;
        String polish = "";
        char temp;

        Stack<Character> st = new Stack<>();

        st.push('(');
        for (int i = 0; i < s.length(); i++) {
            next = s.charAt(i);

            if(st.isEmpty()){
                System.out.println("Invalid String: " + s);
            }
            while (stackG(st.peek()) > inputF(next)) {
                temp = st.pop();
                polish = polish + temp;
                rank = rank + Rank(temp);
                if (rank < 1) {
                    System.out.println("Invalid");
                    return;
                }
            }
            if (stackG(st.peek()) != inputF(next)) {
                st.push(next);
            } else {
                st.pop();
            }

        }
        if (!st.isEmpty() || rank != 1) {
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
            System.out.println(polish);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String : ");
        String s = scanner.next();
        postfix(s);
    }
}