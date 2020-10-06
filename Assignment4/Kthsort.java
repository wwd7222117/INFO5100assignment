package Assignment4;

import java.util.Scanner;
import java.util.PriorityQueue;

public class Kthsort {
	public int findKth(int[] array, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num:array) {
			queue.add(num);
			if(queue.size()>k) {
				queue.poll();
			}
		}
		return queue.peek();
	}
	public static void main(String[] args) {
		//[3,2,1,5,6,4] k = 2
		//[3,2,3,1,2,4,5,5,6] k = 4
		//I use .next() of Scanner, so space is not allowed in the array.
		Scanner input = new Scanner(System.in);
		String str = input.next().toString();
		String stringNum = input.nextLine();
		String[] inputArray  = str.replace("[", "").replace("]", "").split(",");
		String[] num = stringNum.strip().split(" ");
		
		int[] nums = new int[inputArray.length];
		
		for(int j = 0; j < nums.length; j++) {
			nums[j] = Integer.parseInt(inputArray[j]);
		}
		int knum = Integer.parseInt(num[2]);
		Kthsort solution = new Kthsort();
		System.out.println("The "+knum+"th largest num is: "+ solution.findKth(nums,knum));
	}
}
