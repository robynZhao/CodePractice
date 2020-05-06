import java.util.*;

public class RansomNote_383 {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "bbcddfd";
        boolean result = canConstruct(ransomNote, magazine);
        System.out.println(result);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        // store magazine to a hashtable
        HashMap<Character, Integer> hashMagazine = new HashMap<Character, Integer>();
        for(int i = 0; i < magazine.length(); i ++) {
            if(hashMagazine.containsKey(magazine.charAt(i))) {
                int tempValue = hashMagazine.get(magazine.charAt(i)) + 1;
                hashMagazine.put(magazine.charAt(i), tempValue);
            } else {
                hashMagazine.put(magazine.charAt(i), 1);
            }
        }
        // System.out.println(hashMagazine);

        for(int i = 0; i < ransomNote.length(); i ++) {
            if(!hashMagazine.containsKey(ransomNote.charAt(i))) {
                return false;
            } else {
                int tempValue = hashMagazine.get(ransomNote.charAt(i)) - 1;

                if(tempValue < 0) {
                    return false;
                } else if(tempValue == 0) {
                    hashMagazine.remove(ransomNote.charAt(i));
                } else {
                    hashMagazine.put(ransomNote.charAt(i), tempValue);
                }
            }
        }

        return true;
    }
}
