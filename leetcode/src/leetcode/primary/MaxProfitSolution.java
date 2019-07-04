package leetcode.primary;

/**
 * 买卖股票的最佳时机 II
 * 
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 设计一个算法来计算你所能获取的最大利润。
 *
 */

public class MaxProfitSolution {
	public int maxProfit(int[] nums) {
		int profit = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				profit += nums[i] - nums[i - 1];
			}
		}
		return profit;
	}
}
