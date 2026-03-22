package org.example;
import java.util.Scanner;
public class eight {
    public static void fillSpiral(int[][] matrix, int start, int end, int num) {
        if (start > end) {
            return;
        }
        for (int i = start; i <= end; i++) {
            matrix[start][i] = num++;
        }
        for (int i = start + 1; i <= end; i++) {
            matrix[i][end] = num++;
        }
        for (int i = end - 1; i >= start; i--) {
            matrix[end][i] = num++;
        }
        for (int i = end - 1; i > start; i--) {
            matrix[i][start] = num++;
        }
        fillSpiral(matrix, start + 1, end - 1, num);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];
        fillSpiral(matrix, 0, N - 1, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
