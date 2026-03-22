package org.example;
import java.util.Scanner;
public class seven {

    public static void generate(int n, int k, int[] seq, int pos) {
        if (pos == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(seq[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= k; i++) {
            seq[pos] = i;
            generate(n, k, seq, pos + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] seq = new int[n];
        generate(n, k, seq, 0);
        scanner.close();
    }
}
