import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the first array: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of elements in the second array: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        int[] mergedArray = new int[size1 + size2];
        int index = 0;

        // Copy elements from array1 to mergedArray
        for (int i = 0; i < size1; i++) {
            mergedArray[index] = array1[i];
            index++;
        }

        // Copy elements from array2 to mergedArray
        for (int i = 0; i < size2; i++) {
            mergedArray[index] = array2[i];
            index++;
        }

        System.out.print("Merged Array: [");
        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i]);
            if (i != mergedArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}


//Using only one for loop 
// int n=n1+n2;
// for(int i =0;i<n;i+){
//     if(i<n1){
//         c[i]=a[i];
//     }
//     else{
//         c[i]=b[i-n1];
//     }
// }