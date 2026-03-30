package org.example;
import java.util.Scanner;
public class PS {
    public static long sum(int b, int n) {
        if (n == 0) {
            return 1;
        }
        return (long)Math.pow(b, n) + sum(b, n - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("b = ");

        int b = scanner.nextInt();
        System.out.print("n = ");

        int n = scanner.nextInt();
        long result = sum(b, n);
        System.out.println(result);

        scanner.close();
    }
}
