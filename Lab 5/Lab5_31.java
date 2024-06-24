import java.util.Scanner;

public class Lab5_31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize matrices A, B, and C
        int[][] matrixA = new int[3][2];
        int[][] matrixB = new int[2][3];
        int[][] matrixC = new int[3][3];

        // Input elements for matrix A
        System.out.println("Enter elements for Matrix A (3x2):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter " + i +" row " + j +" coloumn " +" elements for the first array: ");
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // Input elements for matrix B
        System.out.println("Enter elements for Matrix B (2x3):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter " + i +" row " + j +" coloumn " +" elements for the second array: ");
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix multiplication
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrixC[i][j] = 0;
                for (int k = 0; k < 2; k++) {

                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        // Print the result matrix C
        System.out.println("Resultant Matrix C (Matrix A * Matrix B):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                System.out.print(matrixC[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
