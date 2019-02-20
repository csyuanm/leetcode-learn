package learn.leetcode;

/**
 * 一串字符串中找出最长子字符串的长度
 * 思路1： 用hash[c] 记录每个字符出现的位置，重复出现时，两者相减+1得到子字符串长度，并覆盖改字符之前记录的位置，继续遍历，直到结束
 * 思路2：题意是计算不带重复字符的最长子字符串的长度，开辟一个 hash 数组来存储该字符上次出现的位置，
 * 比如 `hash[a] = 3` 就是代表 `a` 字符前一次出现的索引在 3，遍历该字符串，获取到上次出现的最大索引（只能向前，不能退后），
 * 与当前的索引做差获取的就是本次所需长度，从中迭代出最大值就是最终答案。
 * @author MML
 * @Date    2019-02-20
 * @version    V1.0
 */
public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLongestCharLength("asdfg"));
	}
	
	public static int getLongestCharLength(String s) {
		int len = 0;
		if(s == null || s.length() == 0) {
			return len;
		} else {
			len = s.length();
		}
		int max = 0, pre = 0;
		int[] hash = new int[128];  //定义长度为128的数组，用于记录每个字母的位置
		for(int i = 0;i < len;i++) {
			char c = s.charAt(i);  //获取字符，用于记录字符出现的位置
			if(hash[c] > pre) {  //当前位置与之前出现的比较，如果第二次后出现，把当前位置覆盖之前位置，没有再次出现的说明没有重复
				pre = hash[c];  //覆盖之前位置，没有再次出现的说明没有重复
			}
			int l = i - pre + 1;  //计算子字符串长度
			hash[c] = i + 1;  //记录当前字符出现的位置(重复时会覆盖之前的位置)
			if(l > max) {
				max = l;  //记录子字符串长度。 如果出现更长的则覆盖
			}
		}
		
		return max;
	}

}
