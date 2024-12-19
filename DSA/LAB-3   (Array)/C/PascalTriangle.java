class PascalTriangle {
	public int factorial(int i)
	{
		if (i == 0)
			return 1;
		return i * factorial(i - 1);
	}
	public static void main(String[] args)
	{
		int n = 4, i, j;
		PascalTriangle g = new PascalTriangle();
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= n - i; j++) {

				// for left spacing
				System.out.print(" ");
			}
			for (j = 0; j <= i; j++) {

				// nCr formula
				System.out.print(
					" "
					+ g.factorial(i)
						/ (g.factorial(i - j)
							* g.factorial(j)));
			}

			// for newline
			System.out.println();
		}
	}
}


// public static void main(String[] args) {
//     Scanner sc=new Scanner(System.in);
//     System.out.print("Enter the number : ");
//     int number=sc.nextInt();
//     for (int line = 1; line <= number; line++) {
//         for (int j = 0; j <= number - line; j++) {
//             System.out.print(" ");
//         }
//         int k = 1;
//         for (int i = 1; i <= line; i++) {
//             System.out.print(k + " ");
//             k = k * (line - i) / i;
//         }
//         System.out.println();
//     }
// }
