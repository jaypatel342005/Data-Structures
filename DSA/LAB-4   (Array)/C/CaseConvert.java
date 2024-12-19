import java.util.Scanner;

public class CaseConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the input string : ");
        String str=sc.next();
        String ans_String="";
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch>='a' && ch<='z')
            {
                ans_String+=(char)((int)ch-32);
            }
            else if(ch>='A' && ch<='Z')
            {
                ans_String+=(char)((int)ch+32);
            }
        }
        System.out.println("Answer string : "+ans_String);
    }
    
}