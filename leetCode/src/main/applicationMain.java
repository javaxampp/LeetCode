package main;

import java.math.BigDecimal;
import java.util.Arrays;

import interview.top100.Reverse_7;
import interview.top100.TwoSum_1;

public class applicationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TwoSum_1 twoSum_1 = new TwoSum_1();
//		int arr[] = {3,2,4};
//		int target = 6;
		Reverse_7 reverse_7 = new Reverse_7();
		int res = reverse_7.reverse(123);
//		System.err.println(Arrays.toString(twoSum_1.twoSum(arr, target)));
		res = 214748364;
		System.out.println(reverse_7.reverse(res));
	}

}
