import java.util.*;

public class StringRecognizer {
    // public static boolean isValid(String s) {
    //     Stack<Character> st = new Stack<Character>();

    //     if (!s.contains("c"))
    //         return false;

    //     int index = s.indexOf("c");

    //     for (int i = 0; i < index; i++) {
    //         st.push(s.charAt(i));
    //     }

    //     for (int i = index + 1; i < s.length(); i++) {
    //         if (st.empty()){
    //             return false;
    //         }
            
    //         if (st.pop() != s.charAt(i)){
    //             return false;
    //         }
    //         if (!st.empty())
    //             return false;
    //     }

    //     return true;

    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");

        String str = sc.next();


        StackDemo st = new StackDemo(10);
        int index=0;
        for (int i = 0; i <str.length(); i++) { 
            if(str.charAt(i)!='c'){
                st.push(str.charAt(i));
                index++;
            }
            else{
                break;
            }
        }
        boolean flag=true;
        for(int j=index+1; j < str.length(); j++) {
            if(str.charAt(j) != st.pop()){
                flag=false;
            }
        }

        if(flag){
            System.out.println("Valida String ");
        }else{
            System.out.println("Invalid String");
        }

        // if (isValid(str)) {
        //     System.out.println("given string is valid");
        // } else {
        //     System.out.println("given string is not valid");

        // }
    }
}

class StackDemo {
    Scanner sc = new Scanner(System.in);
    char[] stack;
    int top;
    int size;

    StackDemo(int size) {
        stack = new char[size];
        this.size = size;
        top = -1;
    }

    public void push(char x) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
        } else {
            System.out.println("Enter a value to insert");

            stack[++top] = x;
            System.out.println("Pushed " + x + " onto the stack.");
        }
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return  ' ';
        } else {
            System.out.println("Popped " + stack[top] + " from the stack.");
		    top--;
            return stack[top+1];  
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("The elements in the stack are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}
