// You are given an array coordinates,
// coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
// Check if these points make a straight line in the XY plane.

// Formula for area of triangle is :
// 0.5 * [x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)]
// 0 == true

public class CheckIfItIsAStraightLine_1232 {
    public static void main(String[] args) {
        int [][]input = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        boolean result = checkStraightLine(input);
        System.out.println(result);
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 1) {
            return true;
        } else {
            for(int i = 1; i < coordinates.length - 2; i ++) {
                double formularResult = 0.5 * (coordinates[i][0] * (coordinates[i + 1][1] - coordinates[i + 2][1]) + coordinates[i + 1][0] * (coordinates[i + 2][1] - coordinates[i][1]) + coordinates[i + 2][0] * (coordinates[i][1]- coordinates[i + 1][1]));
                if(formularResult != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
