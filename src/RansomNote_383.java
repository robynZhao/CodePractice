import java.util.*;
import java.util.Hashtable;

public class RansomNote_383 {
    public static void main(String[] args) {
        canConstruct("a", "bbcddfd");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        // store magazine to a hashtable
        Hashtable<String, Integer> hashMagazine = new Hashtable<String, Integer>();
        for(int i = 0; i < magazine.length(); i ++) {
            if(hashMagazine.containsKey(magazine.charAt(i) + "")) {
                int tempValue = hashMagazine.get(magazine.charAt(i) + "") + 1;
                System.out.println("tempValue is: " + tempValue);
                hashMagazine.put(magazine.charAt(i) + "", tempValue);
            } else {
                hashMagazine.put(magazine.charAt(i) + "", 1);
            }
        }
        System.out.println(hashMagazine);

        return false;
    }
}
