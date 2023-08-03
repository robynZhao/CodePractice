import java.util.*;

///*
//Given an array of Lego blocks representing a Lego structure, we want to know if the Lego structure is valid.
//
//
//A Lego structure is considered valid if every block is either:
//  1. A block on layer 0, or
//  2. Supported by another block 1 layer below
//
//Each Lego block is in the form (X, Y), where X is the column, and Y is the layer. It can be
//assumed that the lego are 1x1 and have no overlap.
//
//Write a function IsTowerValid which takes a collection of Lego blocks and returns true if the
//tower is valid or false if it is not.
//
//Examples
//  A. [ (4, 0) ]
//    VALID - since the block is on layer 0
//  B. [ (0, 3) ]
//    NOT VALID - since the block is floating at layer 3
//  C. [ (2, 0), (2, 3) ]
//    NOT VALID - (2,3) is not supported by (2,2)
//  D. [ (2, 2), (3, 0), (2, 0), (2, 1) ]
//    VALID - since all blocks are supported or on level 0
//  E. [ {1, 1}, {4, 1}, {2, 0}, {3, 1}, {4, 0}, {1, 2}, {1, 0} ]
//    NOT VALID - (3,1) is not supported
//
//Example D:                                Example E:
// _______                                   _______
//|       |                                 |       |
//| (2,2) |                                 | (1,2) |
//|_______|                                 |_______|
//
// _______                                   _______            _______   _______
//|       |                                 |       |          |       | |       |
//| (2,1) |                                 | (1,1) |          | (3,1) | | (4,1) |
//|_______|                                 |_______|          |_______| |_______|
//
// _______   _______                         _______   _______            _______
//|       | |       |                       |       | |       |          |       |
//| (2,0) | | (3,0) |                       | (1,0) | | (2,0) |          | (4,0) |
//|_______| |_______|                       |_______| |_______|          |_______|
//*/
//```
//### Helpful Clarifications
//
//+ If a single block doesn't have support, the whole structure is invalid
//+ You only need to check that each block has a supporting block
//+ Encourage candidate to draw diagrams, and use the example diagrams to visualize the problem
//
//### Possible Q/A
//
//**Q:** Is the array ordered at all?
//**A:** No, the array is unsorted
//
//**Q:** Can there be duplicate positions? e.g. `{(1,0), (2,1), (1,0)}`
//**A:** No, each entry in the input array is unique; there are no repeated elements
//
//**Q:** Can there be Lego at negative positions?
//**A:** No, the 'lowest' position a block can be at is (0,0)
//
//**Q:** Can the Lego blocks span more than 1 column? // do they have a set width?
//**A:** No, the blocks take up 1 unit of space. the blocks (0, 0), (1, 0), and (0, 1) have no overlap
//
//**Q:** What is the format of the input?
//**A:** An array or list of X-Y pairs. Candidate can choose what is easiest for their chosen language
//*e.g.* list of tuples in Python, List<Tuple<int,int>> in C#, etc.
//
//**Q:** Is there a maximum number of rows/columns/Lego blocks?
//**A:** Yes (feel free to set an arbitrary maximum like 1000 if it will be helpful for the candidate's solution, e.g. solution 4)
//
//**Q:** Is a structure with no blocks (i.e. empty array) valid?
//**A:** Yes, by default a structure is valid.

public class LegoStructure {
    public static void main(String[] args) {
        int[][] blocks = {{2, 2}, {3, 0}, {2, 0}, {2, 1}};

        System.out.println(IsTowerValid(blocks));
    }

    public static boolean IsTowerValid(int [][] blocks ) {
        // x: column
        // y: layer
        // for the same x: y must start from 0, must continue 1 by 1

        // <key, value>: <x, arrayList y>
        HashMap<Integer, ArrayList<Integer>> block_hashmap = new HashMap<>();

        for(int r = 0; r < blocks.length; r ++) {
            if(block_hashmap.containsKey(blocks[r][0])) {
                block_hashmap.get(blocks[r][0]).add(blocks[r][1]);
                Collections.sort(block_hashmap.get(blocks[r][0]));
            } else {
                block_hashmap.put(blocks[r][0], new ArrayList<>(blocks[r][1]));
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> temp_hashmap: block_hashmap.entrySet()) {
            return isContinue(temp_hashmap.getValue());
        }

        return true;
    }

    public static boolean isContinue(ArrayList<Integer> temp) {
        if(temp.size() < 2 && temp.get(0) == 0) {
            return true;
        }

        for(int i = 0; i < temp.size() - 1; i ++) {
            if(temp.get(0) != 0 || temp.get(i) + 1 != temp.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
