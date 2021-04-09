package main;

import java.util.Arrays;

import interview.top100.TwoSum_1;

public class applicationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum_1 twoSum_1 = new TwoSum_1();
		int arr[] = {3,2,4};
		int target = 6;
		System.err.println(Arrays.toString(twoSum_1.twoSum(arr, target)));
	}

}
