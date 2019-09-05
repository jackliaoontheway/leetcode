package leetcode.primary.array;

/**
 * 对角线遍历
 */
public class FindDiagonalOrder {

    public static void main(String[] args) {
        int[][] params = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] result = findDiagonalOrder2(params);
        for (int x : result) {
            System.out.print(x);
        }
    }

    public static int[] findDiagonalOrder(int[][] matrix) {

        int times = matrix.length + matrix[0].length - 1;
        int[] result = new int[matrix.length * matrix[0].length];
        boolean right = true;
        int x = 0;
        int y = 0;
        int index = 0;
        for (int i = 0; i < times; i++) {
            if (right) {
                while (x >= 0) {
                    result[index++] = matrix[x][y];
                    --x;
                    ++y;
                    if (y == matrix[0].length) {
                        break;
                    }
                }
                x = 0;
                if (y == matrix[0].length) {
                    x = 1;
                    y--;
                }
                right = false;
            } else {
                while (x < matrix.length) {
                    result[index++] = matrix[x][y];
                    if (x == matrix.length - 1) {
                        y++;
                        break;
                    }
                    if (y == 0) {
                        x++;
                        break;
                    }
                    ++x;
                    --y;
                }
                right = true;
            }
        }


        return result;
    }

    public static int[] findDiagonalOrder2(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int [0];
        }
        int times = matrix.length + matrix[0].length - 1;
        int[] result = new int[matrix.length * matrix[0].length];
        boolean right = true;
        int x = 0;
        int y = 0;
        int index = 0;
        for (int i = 0; i < times; i++) {
            if (right) {
                while (x > -1) {
                    result[index++] = matrix[x][y];
                    if (x == 0 || y == matrix[0].length - 1) {
                        break;
                    }
                    --x;
                    ++y;
                }
                if (y < matrix[0].length - 1) {
                    y++;
                } else if (y == matrix[0].length - 1) {
                    x++;
                }
                right = false;
            } else {
                while (x < matrix.length) {
                    result[index++] = matrix[x][y];
                    if (y == 0 || x == matrix.length - 1) {
                        break;
                    }
                    ++x;
                    --y;
                }
                if (x < matrix.length - 1) {
                    x++;
                } else if (x == matrix.length - 1) {
                    y++;
                }
                right = true;
            }
        }
        return result;
    }

}
