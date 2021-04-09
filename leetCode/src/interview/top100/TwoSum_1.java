package interview.top100;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * @author Minghao Ding
 *
 */
public class TwoSum_1 {
	
	/**
	 * 输入：nums = [2,7,11,15], target = 9
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] twoSum(int[] nums, int target) {
    	int res[] = new int[2];
    	if(nums==null || nums.length<2)
    		return null;
//    	计算a+b == target, 可以固定a，然后遍历数组，寻找target-a 的值
//    	使用Map存储：<target-a, 数组下标>
    	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//    	如果采用先存入map中，对于[3,2,4] target=6, 这种情况会出现结果为【0，0】
//    	for(int i=0; i<nums.length; i++) {
//    		hashMap.put(nums[i], i);
//    	}
    	for(int i=0; i<nums.length; i++) {
    		if(hashMap.containsKey(target-nums[i])) {
    			res[0] = i;
    			res[1] = hashMap.get(target-nums[i]);
    			return res;
    		}
    		hashMap.put(nums[i], i);
    	}
    	
    	return res;
    }
}
