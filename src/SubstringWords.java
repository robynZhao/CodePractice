import com.sun.jdi.connect.Connector;

import java.util.*;

//You are given a encrypted message. In order to decode it,
// you first need to identify the starting and end point of each encrypted word,
// which are indicated by `s` and `e` respectively. Given a encrypted message,
// return a list of starting and end points.
// Every starting index needs to have a end index. However, not every end index has a starting index.
//
//
//Example input:
//
//		("abcsabce") should return [{3,7}]
//		("ssacecae") should return [{0,4},{1,7}]
//		("abcsdee") should return [{3,5}]
//		("abcs") should return `ArgumentException`

public class SubstringWords {
    public static void main(String[] args) {
        String str = "ssacecae";
        List<ArrayList<Integer>> result = PairsWithQueue(str);

        for(int i = 0; i < result.size(); i ++) {
            System.out.println(result.get(i).toString());
        }
    }

    public static List<ArrayList<Integer>> PairsWithQueue(String str) {
        List<ArrayList<Integer>> results = new ArrayList<> ();

        Stack<Character> temp_value = new Stack<>();
        Stack<Integer> temp_position = new Stack<> ();

        if( str.length() == 0) {
            return results;
        }

        int result_index = 0;
        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) == 's' || str.charAt(i) == 'e') {
                 if(str.charAt(i) == 's') {
                     temp_value.push(str.charAt(i));
                     temp_position.push(i);
                 } else {
                     if(temp_value.size() > 0 && temp_value.peek() == 's') {
                         System.out.println(temp_position.size());
                         results.set(result_index, new ArrayList<>(temp_position.pop()));
                         results.set(result_index, new ArrayList<>(i));
                         result_index ++;
                         temp_value.pop();
                     } else {
                         results.get(result_index).add(i);
                         result_index ++;
                     }
                 }
            }
        }

        if(temp_value.size() != 0) {

        }

        return results;
    }
}
