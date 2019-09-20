package leetcode.primary.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * https://leetcode-cn.com/submissions/detail/30497224/
 */
public class YHTriangle2 {

    public static void main(String[] args) {

        List<Integer> result = generate(0);
        System.out.println();
        for (int i : result) {
            System.out.print(i);
        }
    }

    public static List<Integer> generate(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result.get(result.size() - 1);
    }

}
