package interview.tag.dfs;

import data.structrue.TreeNode;

/**
* 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

*/
public class isValidBST_98 {
	/**
	  错误典型1：
	*/
	public boolean isValidBST_dfs(TreeNode root) {
		boolean isBST = false;
		if(root==null || (root.left==null) && (root.right==null)) {
			return true;
		}
//		必须得拆开，否则对于只有一个子树的，就没法进入判断
		if(root.left.val < root.val && root.val<root.right.val) {
			return isValidBST_dfs(root.left) && isValidBST_dfs(root.right); 
		}
		return isBST;
	}
	
	/**
	错误典型2：
	*/
	public boolean isValidBST_2(TreeNode root) {
		boolean isBST = false;
		if(root==null || (root.left==null) && (root.right==null)) {
			return true;
		}
//		这样只能判断父节点和左右孩子，不能判断左右孩子与父节点的上面节点
		if(root.left != null && root.left.val>=root.val) {
			return false;
		}
		if(root.right !=null && root.right.val <= root.val) {
			return false;
		}
		return isValidBST_2(root.left) && isValidBST_2(root.right); 
    }
	
	/**
	正例：针对与错误典型2来说，需要找一个上下限的值，来规定左子树所有的值均小于根节点的值，
		遍历完左子树后，对于右子树所有的值均大于根节点的值
	*/
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		if(root.left!=null && root)
	}
	
	public boolean dfs() {
		
	}
}
