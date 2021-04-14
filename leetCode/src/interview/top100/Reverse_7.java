package interview.top100;

import org.junit.Test;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 −
 * 1] ，就返回 0。
 * 
 * @author Minghao Ding
 *
 */
public class Reverse_7 {
	/**
	 * 输入：x = -123 输出：-321
	 *
	 * @param x
	 * @return
	 */
	@Test
	public int reverse_0(int x) {
		if (x < 10 && x > -10)
			return x;
		int abs = Math.abs(x);
		int isPositive = x > 0 ? 1 : -1;
		int v = abs;
		int newVal = 0;
		int num = 1;
		v = v / 10;
		while (v > 0) {
			num = num * 10;
			v = v / 10;
		}
		v = abs;
		while (v > 0) {
			newVal = v % 10 * num + newVal;
			v = v / 10;
			num = num / 10;
		}
		return newVal * isPositive;
	}

	/**
	 * 正常的反转 reverseValue = reverseValue*10 +x%10; 例如1234，反转过程应该是 0+1=4,40+3=43；430+2=432;4320+1=4321
	 * 如果反转后的数字超过了int范围，则返回0
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		int rev = 0;
		while(x!=0){
			int temp = x%10;
//			Integer.MAX_VALUE=2147483647  Min_value= -2147483648
			if(rev>Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && temp>Integer.MAX_VALUE%10)){
				return 0;
			}
			if(rev<Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && temp<Integer.MIN_VALUE/10)){
				return 0;
			}
			rev = rev*10 + temp;
			x /= 10;
		}
		return rev;

	}
}
