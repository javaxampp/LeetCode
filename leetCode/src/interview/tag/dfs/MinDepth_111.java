package interview.tag.dfs;

import data.structrue.TreeNode;

/**
* 给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
*/
public class MinDepth_111 {
    public int minDepth1(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	int left = dfs(root.left, 1);
    	int right = dfs(root.right, 1);
    	return Math.min(left, right);
    }
    
	/**
	 * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
当 root 节点左右孩子都为空时，返回 1
当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
	 * 
	此种方法对于只有左孩子或者只有右孩子，例如[2,null,3,null,4,null,5,null,6]便只返回1
	*/
    public int dfs(TreeNode node, int depth) {
    	if(node == null) {
    		return depth;
    	}
    	depth++;
    	return dfs(node.left, depth);
    }
    
    public int minDepth(TreeNode node) {
    	if(node == null) {
    		return 0;
    	}
    	if(node.left==null && node.right==null) {
    		return 1;
    	}
    	int leftDepth = minDepth(node.left);
    	int rightDepth = minDepth(node.right);
//    	如果左孩子或者右孩子有一个为空，说明必然有一个深度为0，则返回不为空的那个孩子+1即可
    	if(node.left==null || node.right==null) {
    		return leftDepth+rightDepth+1;
    	}
    	return Math.min(leftDepth, rightDepth)+1;
    }
    
    public int minDepth_2(TreeNode node) {
    	if(node == null) {
    		return 0;
    	}
    	if(node.left==null && node.right==null) {
    		return 1;
    	}
    	int left = minDepth_2(node.left)+1;
    	int right = minDepth_2(node.right)+1;
    	return Math.min(left, right);
    }
}
