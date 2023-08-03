//96. Valid BST Permutations
//Given an integer, determine the number of valid Binary Search Trees that can be created by nodes numbered from 1 to that integer.
//
//Input: Integer denoting the nodes
//Output: Number of total BST
//
//Input: 2
//Output: 2
//
//Input: 1
//Output: 1
//
//Input: 3
//Output: 5

import java.util.*;

public class ValidBSTPermutations {
    public static void  main(String[] args) {
        int input = 3;
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] possibles = new int[n + 1];

        possibles[0] = 1;

        for (int i = 1; i <= n; i ++) {
            possibles[i] = 0;
            for (int j = 1; j <= i; j ++) {
                possibles[i] += possibles[j - 1] * possibles[i - j];
            }
        }

        return possibles[n];
    }
}
