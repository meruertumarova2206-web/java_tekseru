package org.example;
import java.util.Scanner;
public class two {
    public static int ToN(int n) {
        if (n <= 1) {
            return n;
        }
        return n + ToN(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n= ");
        int n = scanner.nextInt();

        int result = ToN(n);
        System.out.println(result);

        scanner.close();
    }
}
