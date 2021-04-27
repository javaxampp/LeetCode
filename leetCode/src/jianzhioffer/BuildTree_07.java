package jianzhioffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import data.structrue.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 * 前序遍历 preorder =
 * [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7]
 * 
 */
public class BuildTree_07 {
	/**
	 * 使用分治的思想，但是每次都需要重新截取数组，增加了时间复杂度和空间复杂度
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		int i = 0;
		while (i < inorder.length && inorder[i] != preorder[0]) {
			i++;
		}
//		copyOfRange(original, from, to) 包含from, 不包含to
		root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
		root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
				Arrays.copyOfRange(inorder, i + 1, inorder.length));
		return root;
	}

	/**
	 * 先序+中序遍历
	 */
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public TreeNode buildTree_01(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
			return null;
		}
//		由于先序遍历的第一个节点就是根节点，故其位置不用存储
//		需要存储的是中序遍历中根节点的位置，在中序遍历中根节点的左边是其左子树，右边是其右子树
//		得到中序遍历中的根节点位置，用中序遍历的根节点-中序遍历的左边界就是左子树的个数，
//		现在确定先序遍历中左子树左右边界：左边界即根节点位置+1，右边界即为根节点+前一步左子树的个数
		for(int i=0; i<inorder.length; i++) {
			map.put(inorder[i], i);
		}
		int len = preorder.length - 1;
		TreeNode root = recursive(preorder, inorder, 0, len, 0, len);
		return root;
	}

	public TreeNode recursive(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart,
			int inorderEnd) {
		if (preorderStart > preorderEnd) {
			return null;
		}
//		根节点的值：先序遍历的第一个元素
		int rootVal = preorder[preorderStart];
//		根据先序遍历根节点的值，在中序遍历中找到根节点的下标
		int rootIndex = map.get(rootVal);
//		中序遍历中根节点为中心，左边是左子树，右边是右子树，故中序遍历的左右子树的左右边界都很好确定，先序遍历需要根据左右子树的个数进行确定
//		中序的下标-中序遍历起始下标，即为左子树的个数
		int sizeLeftTree = rootIndex - inorderStart;
		TreeNode root = new TreeNode(rootVal);
//		递归生成根节点的左子树：
//			先序遍历左边界即为先序遍历根节点+1，右边界就是先序遍历起始位置；
//			中序遍历中左右边界：左边界为中序遍历的起始位置，右边界为根节点-1
		root.left = recursive(preorder, inorder, preorderStart+1, preorderStart+sizeLeftTree , inorderStart, rootIndex-1);
//    	递归生成右子树：
//			先序遍历的左边界为先序遍历的起始位置+左子树的个数+1， 右边界为源先序遍历的右边界
//			中序遍历的左边界为根节点位置+1， 右边界为源中序遍历的右边界
		root.right = recursive(preorder, inorder, preorderStart+sizeLeftTree+1, preorderEnd, rootIndex+1, inorderEnd);
		return root;
	}
}
