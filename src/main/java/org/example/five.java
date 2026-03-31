package org.example;
import java.util.Scanner;
public class five {
    public static void sum(int n,Scanner scanner) {
        if (n <= 0) {
            return;
        }
        int x = scanner.nextInt();
        sum(n - 1, scanner);
        System.out.print(x + " ");
    }
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        sum(n,scanner);
        scanner.close();
    }
}