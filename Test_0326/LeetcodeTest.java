package Test_0326;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


/*
169. 求众数
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在众数。
示例 1:
输入: [3,2,3]
输出: 3
示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
*/
/*
 * 排序后众数一定出现在索引为nums.length/2的位置上
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] nums = {2,2,1,1,1,2,2};
//		System.out.println(So.majorityElement(nums));
//	}
//}
//class Solution {
//    public int majorityElement(int[] nums) {
//    	Arrays.sort(nums);
//        return nums[nums.length/2];
//    }
//}
/*
229. 求众数 II
给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
示例 1:
输入: [3,2,3]
输出: [3]
示例 2:
输入: [1,1,1,3,3,2,2,2]
输出: [1,2]
 */
/*
扫描整个数组，每次从其中选择三个不相同的数字删除掉，最后留下的就是出现次数超过1/3的数。
（1）同样先定义基数nums[i]、nums[j]和计数器count1,count2,这里我们同样可以推断出在整组数据中出现次数超过 [ n/3 ]的数不多于两个。
（2）扫描整个数组，遇到与基数相同的数为对应计数器加1，遇到不同的数减1。
（3）当计数器count1或count2为0时，对应前面的数据段舍弃，以下一个数为基数继续遍历。
（4）完毕之后索引i、j记录的数就是出现次数超过 [ n/3 ]的数。
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[] nums = {1,1,1,3,3,2,2,2};
		List<Integer> res = So.majorityElement(nums);
		System.out.println(res);
	}
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int i = 0; 
        int j = 1;
        int count1 = 0;
        int count2 = 0;
        for(int k=0; k<nums.length;k++){
            if(nums[k] == nums[i]){
                count1++;
            }else if(nums[k] == nums[j]){
                count2 ++;
            }else if(count1 == 0){
                i = k;
                count1 = 1;
            }else if(count2 == 0){
                j = k;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        //检验
        count1 = 0;
        count2 = 0;
        for(int k=0; k<nums.length; k++){
        	if(nums[k] == nums[i]){
        		count1++;
        	}else if(nums[k] == nums[j]){
        		count2++;
        	}
        }
        if(count1 > nums.length/3){
        	res.add(nums[i]);
        }
        if(count2 > nums.length/3){
        	res.add(nums[j]);
        }
        return res;
    }
}
