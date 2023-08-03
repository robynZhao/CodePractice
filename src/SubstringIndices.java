import java.util.*;

//Given a secret message and a key which indicates the start of an encrypted word, determine the starting indices of all occurrences of the key
//
//
//Example input:
//
//		("aaabcadefaefeeabcefffe", "abc") should return [2, 14]
//		("aaaa", "ab") should return []
//		("aabbaacc", "aa") should return [0,4]
//
//Edge Cases:
//
//		("acca", "a") should return [0,3]
//		("aaabbaa", "aa") should return [0,1,5]
//		("", "aa") should return []
//
//### Addition Information
//
//* A good talking point could be how to handle empty message or key

public class SubstringIndices {
    public static void main(String[] args) {
        String secret = "acca";
        String key = "a";
        List<Integer> result = findKeys(secret, key);

        for(int i = 0; i < result.size(); i ++) {
            System.out.println(result.get(i));
        }
    }

    public static List<Integer> findKeys( String secret, String key ) {
        List<Integer> result = new ArrayList<>();

        if( key.length() == 0 || secret.length() == 0) {
            return result;
        }

        for(int i = 0; i < secret.length() - key.length() + 1; i ++) {
            int start = i;
            int end = i + key.length() - 1;

            String temp_sub_string = secret.substring(start, end);
            if(temp_sub_string.equals(key)) {
                result.add(i);
            }
        }

        return result;
    }
}
