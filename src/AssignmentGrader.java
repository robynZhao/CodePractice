import java.util.*;

// You need to grade student essays.
// You want to grade them in as few days as possible.
//
// Rules:
//    1. Each work day is exactly 8 hours long.
//    2. Each essay takes between 1 and 7 hours to grade (inclusive.)
//    3. Each essay must be marked to completion within a given day.
//
//Write a function, `AssignmentGrader`, that returns the number of days it will take you to grade all the essays:
//
//    int AssignmentGrader(int[] numOfEssays);
//
//where numOfEssays is 7 elements long, numOfEssays[0] is the number of 1 hour essays.
//
//Example:    `AssignmentGrader( [3, 1, 0, 3, 1, 0, 1] )`
//
//Correct, Optimal answer: `4`
//
//    Day 1: 7, 1
//    Day 2: 5, 2, 1
//    Day 3: 4, 4
//    Day 4: 4, 1
//
//Incorrect, non-optimal answer: `5`
//
//    Day 1: 7, 1
//    Day 2: 5, 1
//    Day 3: 4, 1
//    Day 4: 4, 2
//    Day 5: 4
//
// Example:    [3, 1, 0, 3, 1, 0, 1] : Output: 4
// Example:    [3, 1, 1, 1, 1, 0, 3] : Output: 5
// Example: all zeroes   [0, 0, 0, 0, 0, 0, 0] : Output: 0
// Example: fill in from the bottom(this test case will fail if fill in the day starting from the bottom)   [1, 0, 3, 0, 1, 0, 0] : Output: 2
// Example: ending on complete day    [1, 1, 1, 2, 1, 1, 1] : Output: 4
// Example: all ones    [1, 1, 1, 1, 1, 1, 1] : Output: 4
// Example: no high numbers   [8, 8, 4, 0, 0, 0, 0] : Output: 5

public class AssignmentGrader {
    public static void main(String[] args) {
        int[] numOfEssays = {3, 1, 0, 3, 1, 0, 1};
        System.out.println(AssignmentGrader(numOfEssays));
    }

    public static int AssignmentGrader(int[] numOfEssays) {
        int day = 0;
        HashMap<Integer, Integer> essay_hashmap = new HashMap<> ();

        for(int i = 0; i < numOfEssays.length; i ++) {
            if(numOfEssays[i] != 0) {
                essay_hashmap.put(i + 1, numOfEssays[i]);
            }
        }

        while(essay_hashmap.size() != 0) {
            day ++;

            // hour of an essay = essay_type_position + 1
            int essay_hour = numOfEssays.length;
            int essay_type_position = essay_hour - 1;
            int day_hour = 8;

            while (essay_type_position >= 0) {
                if(numOfEssays[essay_type_position] > 0 && (day_hour - essay_hour >= 0)) {
                    numOfEssays[essay_type_position] --;

                    essay_hashmap.replace(essay_hour, essay_hashmap.get(essay_hour) - 1);
                    if(essay_hashmap.get(essay_hour) == 0) {
                        essay_hashmap.remove(essay_hour);
                    }

                    day_hour = day_hour - essay_hour;
                } else {
                    essay_type_position --;
                    essay_hour --;
                }
            }
        }

        return day;
    }
}
