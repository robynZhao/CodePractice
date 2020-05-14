import java.util.Stack;

// Given a non-negative integer num represented as a string,
// remove k digits from the number so that the new number is the smallest possible.

public class RemoveKDigits_402 {
    public static void main(String[] args) {
        // options for input and k: expected result
        // 1432219, 3: 1219
        // 10200, 1: 200
        // 10, 2: 0

        String input = "112";
        int k = 1;
        // expect result: 11

        String result = removeKdigits(input, k);
        System.out.println(result);
    }

    public static String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == 0)  return num;
        if(k == len) return "0";

        Stack<Character> stack = new Stack<>();
        int index = 0;

        while(index < len){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++));
        }
        while(k-- > 0) stack.pop();

        String smallest = "";
        while(!stack.isEmpty()) smallest = stack.pop() + smallest;

        // delete leading zeros
        while(smallest.length() > 1 && smallest.charAt(0) == '0')
            smallest = smallest.substring(1);

        return smallest;
    }
}
