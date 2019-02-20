package learn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述： 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 示例: 给定 nums = [2, 7, 11, 15], 
 * target = 9 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1] 
 *  
 * @author MML
 *
 */
public class Solution1 {

	public static void main(String[] args) {
		int[] nums = { 2, 11, 15, 7 };
		int target = 9;
		long start = System.currentTimeMillis();
		int[] result = twoSum2(nums, target);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(Arrays.toString(result)); // 使用Arrays.toString()把数组转化为字符串输出
	}

	/**
	 * 暴力法，循环两遍数组，第一次选择元素之后，再遍历数组，看是否有满足条件的值，时间复杂度o(n*n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int x = target - nums[i];
			for (int j = 0; j < nums.length; j++) {
				if (x == nums[j]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("nonono");
	}

	/**
	 * 循环一次哈希表，遍历数组是时，把遍历的值作为key存在map中，把i作为值存储, 然后用目标值判断map中是否存在该key 时间复杂度o（n）
	 * (但是写入map不消耗时间？比查询还快吗)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum2(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// 一遍哈希
		for (int i = 0; i < nums.length; i++) {
			System.out.println(map.toString());
			// i=3时， {2=0, 11=1, 15=2}
			int x = target - nums[i];
			if (map.containsKey(x)) {  //i=3时，nums[3] = 7  ,找到key为2的则返回[key的值, i]
				return new int[] { map.get(x), i };
			}
			map.put(nums[i], i); // 重点，把值作为key，把i作为值存储，判断key是否跟差数相等
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
