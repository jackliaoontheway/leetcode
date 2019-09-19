package leetcode.primary.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class YHTriangle {

    public static void main(String[] args) {

        List<List<Integer>> result = generate(5);
        for(List<Integer> list : result) {
            System.out.println();
            for(int i : list) {
                System.out.print(i);
            }
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) {
            return result;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

}
