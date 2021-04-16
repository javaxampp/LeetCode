package interview.top100;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.print.attribute.DateTimeSyntax;


/**
 * 
 * @author Minghao Ding
 *给定一个 没有重复 数字的序列，返回其所有可能的全排列。

 */
public class Permute_46 {
	
	/**
		输入: [1,2,3]
		输出:
		[
		  [1,2,3],
		  [1,3,2],
		  [2,1,3],
		  [2,3,1],
		  [3,1,2],
		  [3,2,1]
		]
	*/
    public List<List<Integer>> permute(int[] nums) {
//    	(0)采用dfs算法
//    	(1)需要定义一个数组表示当前元素是否被访问过
//    	(2)递归结束条件就是当nums数组大小 == list.size()，说明已经排列完一种个情况
//    	(3)如果递归结束条件不满足，则遍历数组
//    		（3.1）如果当前节点没有被访问，则把元素加入list中
//    		（3.2）被访问过，就跳过该元素
//    	（4）遍历数组结束后，说明此深度已经遍历完毕，需要回退至上一节点，同时将该节点访问状态重置，list剔除该节点
    	 if(nums==null || nums.length<1)
    		 return new ArrayList<List<Integer>>();
    	 List<List<Integer>> resList = new ArrayList<>();
    	 boolean isVisited[] = new boolean[nums.length];
    	 List<Integer>list = new ArrayList<Integer>(); 
    	 dfs(resList, list, nums, isVisited);
    	 return resList;
    }
    
    /**
	
	*/
    public void dfs(List<List<Integer>> res, List<Integer>list, int[]nums, boolean isVisited[]) {
//    	递归结束条件
    	if(list.size() == nums.length) {
    		res.add(new ArrayList<Integer>(list));
    		return;
    	}
//    	遍历数组
    	for(int i=0; i<nums.length; i++) {
    		
		/**
		 * 不能采用这种循环，如果当前一旦访问过，就会执行else，会删除刚加入的节点并且重新置为false
		 * 这样第一个元素始终会重复加入和删除，陷入死循环

    		if(!isVisited[i]) {
    			list.add(nums[i]);
    			isVisited[i] = true;
    			dfs(res, list, nums, isVisited);
    		}else {
//    			删除刚新添加的节点，表示回退到上一个状态
    			list.remove(list.size()-1);
    			isVisited[i] = false;
    		}
		*/
//    		如果被访问过，则结束本次循环，继续执行下一次循环
    		if( isVisited[i])
    			continue;
    		list.add(nums[i]);
    		isVisited[i] = true;
    		dfs(res, list, nums, isVisited);
    		list.remove(list.size()-1);
    		isVisited[i] = false; 
    	}
		
	}

}
