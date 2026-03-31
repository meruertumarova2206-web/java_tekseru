package org.example;
import java.util.Scanner;
public class six {
    public static void sum(int n, Scanner scanner) {
        if (n <= 0) {
            return;
        }
        String s = scanner.nextLine();
        sum(n - 1, scanner);
        System.out.println(s);
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        sum(n,scanner);
        scanner.close();
    }
}