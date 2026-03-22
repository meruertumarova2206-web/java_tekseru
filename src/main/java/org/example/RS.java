package org.example;

import java.util.Scanner;

public class RS {

    public static void printReverse(int n, Scanner scanner) {
        if (n <= 0) {
            return;
        }
        String s = scanner.nextLine();
        printReverse(n - 1, scanner);
        System.out.println(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printReverse(n, scanner);
        scanner.close();
    }
}
