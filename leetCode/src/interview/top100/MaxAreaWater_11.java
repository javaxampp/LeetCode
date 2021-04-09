package interview.top100;

/**
 * 输入：[1,8,6,2,5,4,8,3,7]
输出：49 
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * @author Minghao Ding
 *
 */
public class MaxAreaWater_11 {
	/**
	 * (0)面积 = 长 * 宽， 相同长的情况下，越宽则面积越大
	 * （1）左右两个长取决于较短的那个，故哪个长更短，哪个方向的指针移动
	 * （2）移动的同时，宽度也减小，故比较移动前后面积大小
	 * @param height
	 * @return
	 */
    public int maxArea(int[] height) {
    	int len = height.length;
    	if(height==null || len<2)
    		return 0;
    	int maxArea = 0;
    	int left = 0;
    	int right = len-1;
    	int localMax = 0;
    	while(left<right) {
    		int temp = Math.min(height[left], height[right]);
    		localMax = temp * (right-left);
    		maxArea = Math.max(maxArea, localMax);
    		if(height[left] < height[right]) {
    			left++;
    		}else if(height[left] == height[right]) {
    			left++;
    			right--;
    		}else {
    			right--;
    		}
    	}
    	return maxArea;
	}
}
