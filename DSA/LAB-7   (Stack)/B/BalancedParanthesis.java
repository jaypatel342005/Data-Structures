import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
    static boolean isValidParenthesis(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.empty()) {
                    return false;
                }
                if (ch == ')' && st.peek() == '(') {
                    st.pop();
                } else if (ch == ']' && st.peek() == '[') {
                    st.pop();
                } else if (ch == '}' && st.peek() == '{') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.empty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Parentheses:-");
        String str = sc.nextLine();
        boolean ans = isValidParenthesis(str);
        System.out.println("Answer::" + ans);
    }
}

