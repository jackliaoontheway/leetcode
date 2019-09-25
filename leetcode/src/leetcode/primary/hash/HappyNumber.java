package leetcode.primary.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.print(new HappyNumber().isHappy(2));
    }

    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if(set.contains(n)) {
            return false;
        }
        set.add(n);
        return isHappy(calculate(n));
    }

    private int calculate(int n) {
        if (n < 10) {
            return n * n;
        }
        int m = n % 10;
        return calculate(n / 10) + (m * m);
    }
}
