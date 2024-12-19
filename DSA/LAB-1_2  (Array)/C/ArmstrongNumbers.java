public class ArmstrongNumbers {
    public static void main(String[] args) {
        System.out.println("Armstrong numbers from 1 to 1000:");
        for (int i = 1; i <= 1000; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isArmstrong(int number) {
        int originalNumber, remainder, result = 0;
        int n = 0;

        originalNumber = number;

        while (originalNumber != 0) {
            originalNumber /= 10;
            ++n;
        }

        originalNumber = number;

        // Calculate result
        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
            originalNumber /= 10;
        }

        return result == number;
    }
}
