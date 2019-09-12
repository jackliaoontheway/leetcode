package leetcode.primary.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int x[][] = {
                {
                        1, 2, 22, 3, 44
                },
                {
                        4, 5, 55, 6, 66
                },
                {
                        7, 8, 88, 9, 10
                }
        };
        List<Integer> result = new SpiralOrder().spiralOrder(x);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int loops = matrix.length / 2;
        if (matrix.length % 2 != 0) {
            loops += 1;
        }

        int xMin = 0;
        int xMax = matrix.length - 1;

        int yMin = 0;
        int yMax = matrix[0].length - 1;
        for (int i = 0; i < loops; i++) {
            List temp = top(xMin, yMin, yMax, matrix);
            if (temp.isEmpty()) {
                break;
            }
            result.addAll(temp);

            temp = right(xMin, xMax, yMax, matrix);
            if (temp.isEmpty()) {
                break;
            }
            result.addAll(temp);

            temp = down(xMax, yMin, yMax, matrix);
            if (temp.isEmpty()) {
                break;
            }
            result.addAll(temp);
            temp = left(xMin, xMax, yMin, matrix);
            if (temp.isEmpty()) {
                break;
            }
            result.addAll(temp);
            xMin += 1;
            xMax -= 1;
            yMin += 1;
            yMax -= 1;
        }

        return result;
    }

    private List<Integer> top(int xMin, int yMin, int yMax, int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for (int i = yMin; i <= yMax; i++) {
            result.add(matrix[xMin][i]);
        }
        return result;
    }

    private List<Integer> right(int xMin, int xMax, int yMax, int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        xMin += 1;
        for (int i = xMin; i <= xMax; i++) {
            result.add(matrix[i][yMax]);
        }
        return result;
    }

    private List<Integer> down(int xMax, int yMin, int yMax, int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        yMax -= 1;
        for (int i = yMax; i >= yMin; i--) {
            result.add(matrix[xMax][i]);
        }
        return result;
    }

    private List<Integer> left(int xMin, int xMax, int yMin, int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        xMax -= 1;
        xMin += 1;
        for (int i = xMax; i >= xMin; i--) {
            result.add(matrix[i][yMin]);
        }
        return result;
    }

}

