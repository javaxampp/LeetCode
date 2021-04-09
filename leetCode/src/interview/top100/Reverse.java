package interview.top100;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 −
 * 1] ，就返回 0。
 * 
 * @author Minghao Ding
 *
 */
public class Reverse {
	/**
	 * 输入：x = -123 输出：-321
	 * @param x
	 * @return
	 */
    public int reverse(int x) {
    	if(x<10 && x>-10)
    		return x;
        int abs = Math.abs(x);
        boolean isPositive = x>0 ? true : false;
        while()
    }
}
