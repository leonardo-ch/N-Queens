/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.queens;

import java.util.Scanner;

/**
 *
 * @author LeonardoChassot
 */
public class NQueens {
    static int count = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 0;
        System.out.println("Integer value: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        System.out.println("Calculating " + n + "-Queens");

        solveNQueens(n);
        System.out.println(count);
    }

    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) {
                return false;   // same column
            }
            if ((q[i] - q[n]) == (n - i)) {
                return false;   // diagonal maior
            }
            if ((q[n] - q[i]) == (n - i)) {
                return false;   // diagonal menor 
            }
        }
        return true;
    }

    public static void printQueens(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        count++;
        System.out.println();
    }

    public static void solveNQueens(int n) {
        int[] a = new int[n];
        solveNQueensArray(a, 0);
    }

    public static void solveNQueensArray(int[] q, int k) {
        int n = q.length;
        if (k == n) {
            printQueens(q);
        } else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) {
                    solveNQueensArray(q, k + 1);
                }
            }
        }
    }
}
