package interview.top100;

/**
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。：x = -121也不是
 */
public class IsPalindrome_9 {
    /**
     * 使用数字反转，反转后的数字与原数字相等，即为回文数
     */
    public boolean isPalindrome_0(int x) {
        if (x < 0) {
            return false;
        }
        long reverse = 0;
        int temp = x;
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        return x == reverse ? true : false;
    }

    /**
     * 每次都取前后各一位进行相比较
     *
     * @param x
     * @return
     */
    public boolean isPalindrome_1(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
//        div ，对这个数进行除余得到左边的数字
        int div = 1;
        int temp = x;
//        while (temp >= 10) {
//            div *= 10;
//            temp /= 10;
//        }
        while(x/div >= 10) div *= 10;
        temp = x;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x%div) / 10;
            div /= 100;
        }
        return true;
    }
}
