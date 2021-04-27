package interview.tag.dfs;

import data.structrue.TreeNode;

/**
* 给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
*/
public class IsBalanced_110 {
	/**
	
	*/
    public boolean isBalanced(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	if(root.left==null && root.right==null) {
    		return true;
    	}
    	int left = getDepth(root.left);
    	int right = getDepth(root.right);
    	return Math.abs(right-left)>1 ? false : true;
    }
    
    public int getDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		if(node.left==null && node.right==null) {
			return 1;
		}
		int left = getDepth(node.left)+1;
		int right = getDepth(node.right)+1;
		return Math.max(left, right);
	}
}
