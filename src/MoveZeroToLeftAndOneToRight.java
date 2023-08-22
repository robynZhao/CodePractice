public class MoveZeroToLeftAndOneToRight {
    public static void main(String[] args) {
        int[] input = {0,1,1,1,0,0,1};
        result(input);
    }

    public static void result(int[] input) {
        int left = 0;
        int right = input.length - 1;

        while(left <= right) {
            if(input[left] != 0 && input[right] != 1) {
                input[left] = 0;
                input[right] = 1;
                left ++;
                right --;
            } else {
                if(input[left] == 0) {
                    left ++;
                }

                if(input[right] == 1) {
                    right --;
                }
            }
        }

        for (int j : input) {
            System.out.print("not a good method" + j);
        }
    }
}
