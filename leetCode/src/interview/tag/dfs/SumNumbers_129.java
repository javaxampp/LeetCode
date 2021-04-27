package interview.tag.dfs;

import data.structrue.TreeNode;

/**
* 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：

输入：root = [4,9,0,5,1]
输出：1026
解释：
从根到叶子节点路径 4->9->5 代表数字 495
从根到叶子节点路径 4->9->1 代表数字 491
从根到叶子节点路径 4->0 代表数字 40
因此，数字总和 = 495 + 491 + 40 = 1026
*/
public class SumNumbers_129 {
	/**
	
	*/
    public int sumNumbers(TreeNode root) {
    	if(root == null) {
    		return -1;
    	}
    	int sum = 0;
    	int preSum = 0;
    	dfs(root, sum, preSum);
    	return sum;
    }
    
    public int dfs(TreeNode node, int sum, int preSum) {
    	if(node == null) {
    		return sum;
    	}
    	int val = node.val;
    	sum = preSum*10 +val;
    	return dfs(node.left, sum, sum) + dfs(node.right, sum, preSum);
    }
}
