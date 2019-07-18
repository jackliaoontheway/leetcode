package leetcode.primary.array;

/**
 * 旋转图像
 *
 */
public class RotateImage {

	public static void main(String[] args)
    {
        int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

         roatete90(array);
        
        for (int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    private static void roatete90(int[][] array)
    {

        int[][] result = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[i].length; j++) {
                result[j][array[i].length - 1 - i] = array[i][j];
            }
        }
        
        for (int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[i].length; j++) {
            	array[i][j] = result[i][j];
            }
        }

    }
}
