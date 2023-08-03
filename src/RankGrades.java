import java.util.*;

//Given an array of student grades, return an array of ranks for each value in the array.
//
//* The highest grade has rank 1, the second highest rank 2, and so on.
//* Ties should be handled by assigning the same rank to all tied values.
//
//Example input:
//
//		[74, 29, 94, 80, 82] should return [4, 5, 1, 3, 2]
//		[75, 75, 75, 75, 99, 50] should return [2, 2, 2, 2, 1, 6]


public class RankGrades {
    public static void main(String[] args) {
        int [] input = {74, 29, 94, 80, 82};
        int [] result = RankGradesUsingIndexOf(input);

        for(int i = 0; i < result.length; i ++) {
            System.out.print(result[i] + "; ");
        }
    }

    public static int[] RankGradesUsingIndexOf( int[] grades ) {
        int[] result = new int[grades.length];
        int[] ordered_grades = Arrays.copyOf(grades, grades.length);
        Arrays.sort(ordered_grades);

        // <key, value>: <grade, rank>
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int rank = 1;

        for(int i = grades.length - 1; i >= 0; i --) {
            if(!hashmap.containsKey(ordered_grades[i])) {
                hashmap.put(ordered_grades[i], rank);
                rank++;
            }
        }

        for(int i = 0; i < grades.length; i ++) {
            result[i] = hashmap.get(grades[i]);
        }

        return result;
    }
}
