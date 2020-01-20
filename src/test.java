import java.util.*;


public class test {
    public static  void main(String[] args) {
        int[] arr1 = {1,1,0,0,1};
        int result1 = solve(arr1.length, arr1);
        System.out.println(result1);


        int[] arr2 = {0,0,1};
        int result2 = solve(arr2.length, arr2);
        System.out.println(result2);
    }

    public static int solve(int n, int[] arr) {
        int result = 0;

        for(int i = 0; i < n ; i ++) {
            if (arr[i] == 1 ) {
                result ++; // operation -- enter

                if (i + 1 < n) {
                    if(arr[i + 1] ==1) {
                        result++; // go into next email
                        i = i + 1;
                    }
                } else {
                    result ++; // operation -- go back list
                }
            }
        }

        return result;
    }
}
