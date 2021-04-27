package interview.tag.dfs;

import data.structrue.TreeNode;

/**
* 判断两个树是不是相同的
* 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

*/
public class IsSameTree_100 {
	/**
	
	*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null && q==null) {
    		return true;
    	}
    	if( p==null || q==null || p.val!=q.val) {
    		return false;
    	}
    	if(p.val==q.val && p.left==q.left && p.right==q.right) {
    		return true;
    	}
    	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
