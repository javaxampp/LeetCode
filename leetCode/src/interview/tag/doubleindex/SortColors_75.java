package interview.tag.doubleindex;
/**
* 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
*/
public class SortColors_75 {
	/**
	错误示范1：
	*/
    public void sortColors(int[] nums) {
    	if(nums==null || nums.length<2) {
    		return;
    	}
//    	元素0的指針
    	int indexZero = 0;
//    	元素2的指針
    	int indexTwo = nums.length-1;
    	int current = indexZero;
//		对于[2,0,1]，来说，执行一次循环后变为[1,0,2],right--，则会执行current++，current=1,
//    	right=1,跳出循环，故应该是小于等于
//    	while(current < indexTwo) {
    	while(current <= indexTwo) {
    		if(nums[current] == 0) {
//    			swap(nums, current, indexZero);
//    			因为数组中就三个数，所以也可以不用换，直接复制
                nums[current] = nums[indexZero];
     			nums[indexZero] = 0;
    			indexZero++;
    			current++;
    		}else if(nums[current] == 2) {
//    			swap(nums, current, indexTwo);
                nums[current] = nums[indexTwo];
                nums[indexTwo] = 2;
                indexTwo--;
    		}else {
    			current++;
    		}
    	}
    }
    
    public void swap(int[] nums, int a, int b) {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}
