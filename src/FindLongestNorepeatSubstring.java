//Given a string S. Can you find the length of the longest substring without repeating characters.
// "asdffg"
// length = 4 (asdf)

// "aabcd"
// l = 4 (abcd)

// "aabccdef"
// l = 1 (a)
// l = 3 (abc) result = Math.max(result, temp);
// l = 4 (cdef)

// abcabcbb
// l = 3 (abc)
// l = 3 (bca)

import java.util.*;

public class FindLongestNorepeatSubstring {
    public static void main(String[] args) {
        String s = "aabccdef";
        System.out.println(longestSubString(s));
    }

    public static int longestSubString(String s) {
        // abcabcbb
        // set: null
        // result = 3
        // temp =0

        Set<Character> set = new HashSet<>();
        int result = 0;
        int temp = 0;

        // go through the input s
        for(int i = 0; i < s.length(); i ++) {
            for(int j = i; j < s.length(); j ++) {
                if(!set.contains(s.charAt(j))) {
                    temp += 1;
                    set.add(s.charAt(j));
                } else {
                    result = Math.max(temp, result);
                    temp = 0;
                    set.clear();
                    break;
                }
            }
        }

        return result;
    }
}
