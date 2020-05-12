// An image is represented by a 2-D array of integers,
// each integer representing the pixel value of the image (from 0 to 65535).
//
// Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
// and a pixel value newColor, "flood fill" the image.
//
// To perform a "flood fill", consider the starting pixel,
// plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
// plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel),
// and so on.
// Replace the color of all of the aforementioned pixels with the newColor.
//
// At the end, return the modified image.

//  |
// -|------------------------------------
//  |            (r - 1, c)
//  | (r, c -1)    (r, c)     (r, c + 1)
//  |            (r + 1, c)

import java.util.Arrays;

public class FloodFill_733 {
    public static void main(String[] args) {
        int[][] input = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = floodFill(input, sr, sc, newColor);

        System.out.println(Arrays.deepToString(result));
        }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        if(oldColor == newColor) {
            return image;
        }

        neighbor(image, sr, sc, newColor, oldColor);

        return  image;
    }

    public static void neighbor(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor) {
            return;
        }

        image[sr][sc] = newColor;
        neighbor(image, sr - 1, sc, newColor, oldColor);
        neighbor(image, sr + 1, sc, newColor, oldColor);
        neighbor(image, sr, sc - 1, newColor, oldColor);
        neighbor(image, sr, sc + 1, newColor, oldColor);
    }
}
