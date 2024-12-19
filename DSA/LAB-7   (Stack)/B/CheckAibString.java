import java.util.*;

public class CheckAibString {
    public static boolean isValid(String s) {
        Stack<Character> st1 = new Stack<Character>();
        Stack<Character> st2 = new Stack<Character>();

        if (!s.contains("b")) 
            return false;
            
        int index = s.indexOf("b");

        for (int i = 0; i < index; i++)
        {
            char ch = s.charAt(i);
            if(ch!='a') return false;
            st1.push(ch);

        }

        for (int i = index; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch!='b') return false;
            st2.push(ch);
        }

        if (st1.size() != st2.size())
            return false;


        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.next();
        sc.close();
        if (isValid(str)) {
            System.out.println("given string is valid");
        } else {
            System.out.println("given string is not valid");

        }
    }
}
