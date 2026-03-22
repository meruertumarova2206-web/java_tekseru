package org.example;
import java.util.Scanner;
public class recursia {
    public static int recursia(int n) {
        if (n == 1) {
            return 1; // базовый случай
        }
        return n * n + recursia(n - 1); // рекурсия
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n= ");
        int n = scanner.nextInt();

        int result = recursia(n);
        System.out.println(result);

        scanner.close();
    }
}
