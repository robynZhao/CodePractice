import java.util.*;

public class JewelsAndStones_771 {
    public static void main(String[] args) {
        String jewels = "aA";
        String stone = "aAAbbbb";
        int result = numJewelsInStones(jewels, stone);
        System.out.println(result);
    }

    public static int numJewelsInStones(String J, String S) {
        int result = 0;
        for(int i = 0; i < S.length(); i ++) {
            if(J.contains(S.charAt(i) + "")) {
                result ++;
            }
        }
        return result;
    }
}

