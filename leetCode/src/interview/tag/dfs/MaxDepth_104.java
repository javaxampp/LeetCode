package interview.tag.dfs;

import data.structrue.TreeNode;

/**
* 树的最大深度
* 给定二叉树 [3,9,20,null,null,15,7]，
返回它的最大深度 3 。
*/
public class MaxDepth_104 {
	/**
	
	*/
    public int maxDepth(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	if(root.left==null && root.right==null) {
    		return 1;
    	}
    	int left = maxDepth(root.left)+1;
    	int right = maxDepth(root.right)+1;
    	return Math.max(left, right);
    }
}
