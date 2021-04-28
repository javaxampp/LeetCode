package interview.tag.dfs;


import data.structrue.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric_101 {
	/**
	 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	 * 
	 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	 * 
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return dfs(root.left, root.right);
	}

	public boolean dfs(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null || p.val != q.val) {
			return false;
		}
		if (p.left == q.right && p.right == q.left) {
			return true;
		}
		return dfs(p.left, q.right) && dfs(p.right, q.left);
	}
}
