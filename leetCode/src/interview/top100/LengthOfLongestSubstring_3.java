package interview.top100;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.event.TreeWillExpandListener;

/**
 * 无重复字符的最长子串
 * @author Minghao Ding
 *
 */
public class LengthOfLongestSubstring_3 {
	
	/**
	 * 使用滑动窗口的优化算法，
	 * 重复字符——出现1次
	 * 一旦出现次数，一般都需要使用散列表（hashMap，或者声明int arr[127]
	 * 构造子串、下标存入散列表
	 * 涉及子串，考虑使用滑动窗口
	 * 
	 * @param s
	 * @return
	 */
	   public int lengthOfLongestSubstring(String s) {
	        int len = s.length();
	        if(len < 2){
	            return len;
	        }
//	        map的key存储字符，value存储该字符的下标
	        Map<Character, Integer> map = new HashMap<>();
	        int max = 0;
//	        left，right采用滑动窗口
	        int left = 0;
	        int right = 0;
	        while(left<len && right<len){
	            char ch = s.charAt(right);
	            if(map.containsKey(ch)){
//	            	如果采用left = map.get(ch)+1，对于abbbba这样，最后的a是重复的字符，但不在当前窗口中，就不适合
	                left = Math.max(left, map.get(ch)+1);
	            }
	            map.put(ch, right);
	            max = Math.max(max, right-left+1);
	            right++;
	        } 
	        return max;
	    }
	   
	   /**
	    * 暴力解法
	    * @param s
	    * @return
	    */
	   public int  lengthOfLongestSubstring2(String s) {
		   int len = s.length();
		   if(len<2) {
			   return len;
		   }
		   int max = 0;
		   Set<Character> set = new HashSet<Character>();
		   int left = 0;
		   while(left<len) {
			   int right = left;
			   while(right<len && set.add(s.charAt(right))) {
				   right++;
			   }
			   max = Math.max(max, right-left);
			   set.removeAll(set);
			   left++;
		   }
		   return max;
	   }	
}
