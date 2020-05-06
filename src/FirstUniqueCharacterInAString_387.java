import java.util.*;

// Given a string, find the first non-repeating character in it and return it's index.
// If it doesn't exist, return -1.

public class FirstUniqueCharacterInAString_387 {
    public static void main(String[] args) {
        String s = "leetcode";
        int result = firstUniqChar(s);
        System.out.println(result);
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashS = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i ++) {
            if(hashS.containsKey(s.charAt(i))) {
                int tempValue = hashS.get(s.charAt(i)) + 1;
                hashS.put(s.charAt(i), tempValue);
            }else {
                hashS.put(s.charAt(i), 1);
            }
        }

        for(int i = 0; i < s.length(); i ++) {
            if(hashS.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
