package interview.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 */
public class LetterCombinations_17 {

	/**
	 * 输入：digits = "23" 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"] 示例 2：
	 * 
	 * 输入：digits = "" 输出：[] 示例 3：
	 * 
	 * 输入：digits = "2" 输出：["a","b","c"] "234"
	 * ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi",
	 * "bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi",
	 * "cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
	 */
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if (digits.length() == 0)
			return res;
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "gkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
//        for(int i=0; i<digits.length(); i++) {
//        	String string = dfs();
//        	res.add(string);
//        }
		StringBuilder sb = new StringBuilder();
		dfs(res, sb, map, digits, 0);
		return res;
	}

	public void dfs(List<String> list , StringBuilder sb, Map<Character, String> map, String digits, int index) {
//	   递归的结束条件	
	   if(index == digits.length()) {
		   list.add(sb.toString());
		   return;
	   }
//	   参数中的递归变量是针对于digits的
	   char digit = digits.charAt(index);
	   String letterString = map.get(digit);
	   for(int i=0; i<letterString.length(); i++) {
		   sb.append(letterString.charAt(i));
		   dfs(list, sb, map, digits, index+1);
		   sb.deleteCharAt(index);
	   }
	}

}
