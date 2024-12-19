import java.util.Scanner;

public class ArrayFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter the element: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Min : "+min(arr));
        System.out.println("Max : "+max(arr));
        System.out.println("Sum : "+sum(arr));
        System.out.println("Avg : "+avg(arr));
    }

    public static int min(int[] arr)
    {
        int min=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(min>arr[i])
            {
                min=arr[i];
            }
        }
        return min;
    }

    public static int max(int[] arr)
    {
        int max=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
        }
        return max;
    }

    public static int sum(int[] arr)
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }

    public static double avg(int[] arr)
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum/arr.length;
    }
}
