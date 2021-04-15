package interview.top100;

import java.awt.image.RescaleOp;

import javax.swing.text.html.HTML;



/** 接雨水
 *给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap_42 {

    /**
     * 输入：height = [4,2,0,3,2,5]    height = [0,1,0,2,1,0,1,3,2,1,2,1]====>6
     * 输出：9
     *
     * @param height
     * @return
     */
    public int trap_0(int[] height) {
//        1.从左到右遍历数组
//          （1）初始化left_max=0  right_max=0
//          (2)从height[0]到当前位置，找到最大值left_max
//        (3)从当前位置到height末端，找到最大值right_max
//        (4)ans = Math.min(left_max, right_max) - height[i]
//
        if (height == null || height.length < 3)
            return 0;
        int ans = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int left_max = 0;
            int right_max = 0;
            for (int j = i; j >= 0; j--) {
                left_max = Math.max(height[j], left_max);
            }
            for (int j = i; j < height.length; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            ans = Math.min(left_max, right_max) - height[i] + ans;
        }
        return ans;
    }

    public int trap_1(int[] height) {
//    	(0)先找出最高的柱子，分成左右两边
//    	（1）从左到右遍历左侧数组
//    		（1.1）因为左侧所有的柱子都不是最大的，只要有比当前柱子还要高的，就会形成水坑，
//    				水坑大小即为之前高柱子与当前柱子的差值。
//    		（1.2)如果当前柱子比之前柱子还要高，不会出现水坑，并且更新局部最高柱子
//    	（2）遍历完毕左侧，从右到左，遍历右侧柱子，逻辑和上面一样
//    	
        if (height == null || height.length < 3)
            return 0;
        int maxIndex = 0;
        int res = 0;
        int maxHeight = height[0];
        for(int i=0; i<height.length; i++){
            if(maxHeight < height[i]){
                maxHeight = height[i];
                maxIndex = i;
            }
        }
//        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int localMax = 0;
        int current = 0;
        while(current<maxIndex) { 
        	if(localMax > height[current]) {
            	res = res + (localMax-height[current]);
        	} else {
        		localMax = height[current];
        	}
    		current++;
        }
        current = height.length-1;
        localMax = height[current];
        while(current>maxIndex) { 
        	if(localMax > height[current]) {
				res = res + (localMax-height[current]);
        	}else{
        		localMax = height[current];
        	}
        	current--;
        }
        
        return res;
    }
    
    public int trap_2(int[] height) {
//    	（0）对于前面的方法进行 优化，用一次循环即可
//    	（1）双指针，left从左到右遍历，right从右到左遍历，直至相遇即为最高的柱子
//    	（2）leftMax 代表当前左边最高的， rightMax代表当前右边最高的
//    	（3） 只要leftMax和rightMax有高低，就会与当前的柱子形成水坑
//    	（4）如果leftMax<rightMax， 说明左侧会形成水坑，水坑面积为leftMax-current, left++
//    	(5) 如果leftMax>rightMax, 说明右侧会形成水坑，水坑面积为rightMax-current, right--
//    	(6)left和right相遇时候，最终的结果就出来了 
    	
    	int res = 0;
    	if(height==null || height.length<3) {
    		return 0;
    	}
    	int left = 0;
    	int right = height.length-1;
    	int leftMax = 0;
    	int rightMax = 0;
    	while(left<right) { 
    		leftMax = Math.max(leftMax, height[left]);
    		rightMax = Math.max(height[right], rightMax);
    		if(leftMax < rightMax) {
    			res = res + (leftMax-height[left]);
        		left++;
    		}else {
    			res = res + (rightMax-height[right]);
        		right--;
    		}
    	}
    	return res;
    }
}