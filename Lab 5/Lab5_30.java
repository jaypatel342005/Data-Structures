import java.util.Scanner;

public class Lab5_30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize matrices
        int[][] matrix1 = new int[2][2];
        int[][] matrix2 = new int[2][2];
        int[][] resultMatrix = new int[2][2];

        // Input elements for matrix1
        System.out.println("Enter elements for Matrix 1 (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter " + i +" row " + j +" coloumn " +" elements for the first array: ");
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input elements for matrix2
        System.out.println("Enter elements for Matrix 2 (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter " + i +" row " + j +" coloumn " +" elements for the second array: ");
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix addition
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Print the result matrix
        System.out.println("Resultant Matrix (Matrix1 + Matrix2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
