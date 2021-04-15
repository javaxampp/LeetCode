package interview.top100;

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
        if (height == null || height.length < 3)
            return 0;
        int maxIndex = 0;
        int maxHeight = height[0];
        for(int i=0; i<height.length; i++){
            if(maxHeight < height[i]){
                maxHeight = height[i];
                maxIndex = i;
            }
        }

        int res = 0;
        return res;
    }
}