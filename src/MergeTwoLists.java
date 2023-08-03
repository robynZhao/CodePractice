import java.util.*;

//Given two lists of names, return a merged list of the two lists.
//
//Example:
//List A = ["Adam", "Beth", "Peter"]
//List B = ["Jill", "Peter", "Paul"]
//Return = ["Adam", "Beth", "Peter", "Jill", "Paul"]
//
//Note:
//
//The requirement to remove duplicates is included in some older versions of this question.
//In this version, that requirement is discovered either by the candidate asking questions, or by looking closely at the given example.
//When they ask, the answer is **"the output list cannot contain any duplicates"**.
public class MergeTwoLists {
    public static void main(String[] args) {
        List<String> A = new ArrayList<>();
        A.add("Adam");
        A.add("Beth");
        A.add("Peter");

        List<String> B = new ArrayList<>();
        B.add("Jill");
        B.add("Peter");
        B.add("Paul");

        List<String> result = MergeLists(A, B);
        System.out.println(result);
    }

    public static List<String> MergeLists(List<String> listA, List<String> listB) {
        // decrease running time
        Set<String> temp_output = new HashSet<> ();

        for(int i = 0; i < listA.size(); i ++) {
            temp_output.add(listA.get(i));
        }

        for(int i = 0; i < listB.size(); i ++) {
            temp_output.add(listB.get(i));
        }

        List<String> output = new ArrayList<>(temp_output);

        return output;
    }
}
