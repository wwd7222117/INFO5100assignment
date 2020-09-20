/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */
import java.util.Scanner;
public class Assignment2_2 {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    public int maxSubArray(int[] nums) {
        //write your code here
    	if (nums.length == 1) {
    		return nums[0];
    	}
    	int[] dp = new int[nums.length];;
    	dp[0] = nums[0];
    	
    	for(int i = 1; i < nums.length; i++) {
    		dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
    	}
    	int maxnum = dp[0];
    	for(int i = 1; i < dp.length; i++) {
    		if (dp[i]>maxnum) {
    			maxnum = dp[i];
    		}
    	}
    	return maxnum;
    }

    public static void main(String[] args) {
        //write your code here
    	//Firstly,we should transfer the input into integer array
    	
		Scanner input = new Scanner(System.in);
		String str = input.next().toString();
		String[] inputArray  = str.split(",");
		
		int[] nums = new int[inputArray.length];
		
		for(int j = 0; j < nums.length; j++) {
			nums[j] = Integer.parseInt(inputArray[j]);
		}
		Assignment2_2 test = new Assignment2_2();
		System.out.println(test.maxSubArray(nums));
    }
}