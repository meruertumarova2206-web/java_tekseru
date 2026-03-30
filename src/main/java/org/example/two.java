package org.example;
import java.util.Scanner;
public class two {
    public static int sum(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sum(n - 1);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("n= ");
        int n = scanner.nextInt();

        int result= sum(n);
        System.out.println(result);

        scanner.close();
    }
}