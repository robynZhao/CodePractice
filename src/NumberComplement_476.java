import java.util.*;

// Given a positive integer, output its complement number.
// The complement strategy is to flip the bits of its binary representation.
// input = 5, binary of 5 = 101
// the complement of 101 = 010
// 010 in decimal = 2
// result = 2

public class NumberComplement_476 {
    public static void main(String[] args) {
        int num = 5;
        int result = findComplement(num);
        System.out.println(result);
    }

    public static int findComplement(int num) {
        int totalBits = (int)(Math.floor(Math.log(num) / Math.log(2))) + 1;
        return (int)(Math.pow(2, totalBits)-1) ^ num;
    }
}
