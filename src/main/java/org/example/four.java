package org.example;
import java.util.Scanner;
public class four{
    public static int sum(int[] arr, int n) {
        if(n<=0){
            return 0;
        }
        int last = arr[n - 1] > 0 ? arr[n - 1] : 0;
        return last + sum(arr, n - 1);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        int result = sum(numbers, size);
        System.out.println(result);
        scanner.close();
    }
}