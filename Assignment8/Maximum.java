package Assignment8;

import java.util.Arrays;
import java.util.Random;

/* The structure of the code is similar to the SumValue.java in Assignment 7 */
class MultiArray implements Runnable{
	private int[] subArray;
	private long result = 0;
	public static final int   INT_MIN = 0x80000000;
	public MultiArray(int[] arr) {
		this.subArray = arr;
	}
	public long getMax() {
		return this.result;
	}
	
	public long subMax(int[] arr) {
		 long result = INT_MIN;
		 for (long i:arr) {
			 if(i > result) {
				 result = i;
			 }
		 }
		 return result;
	}
	public void run() {
		this.result = this.subMax(subArray);
	}
}
public class Maximum {
	public static final int   INT_MIN = 0x80000000;
	public static final int   INT_MAX= 0x7fffffff;

	
	static void generateRandomArray(int[] arr){
		 Random intRan = new Random();
		 for(int i = 0; i <arr.length;i++) {
			arr[i] = intRan.nextInt(INT_MAX);   //to avoid error, the random between 0 and 9
		 }
	}

	static long findMax(long[] arr){
		 long result = INT_MIN;
		 for (long i:arr) {
			 if(i > result) {
				 result = i;
			 }
		 }
		 return result;
	}
	 
	 
	public static void main(String[] args) throws InterruptedException{
		 
			int[] arr = new int[4000000];
			generateRandomArray(arr);
			 
			
			MultiArray sum1 = new MultiArray(Arrays.copyOfRange(arr,0,100000));
			MultiArray sum2 = new MultiArray(Arrays.copyOfRange(arr,100000,200000));
			MultiArray sum3 = new MultiArray(Arrays.copyOfRange(arr,200000,300000));
			MultiArray sum4 = new MultiArray(Arrays.copyOfRange(arr,300000,400000));
			
			Thread t1 = new Thread(sum1);
			Thread t2 = new Thread(sum2);
			Thread t3 = new Thread(sum3);
			Thread t4 = new Thread(sum4);
			 
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			 
			try {
				t1.join();
				t2.join(); 
				t3.join();
				t4.join();
			} 
			catch(Exception e) {}
			long res[] = {sum1.getMax(),sum2.getMax(),sum3.getMax(),sum4.getMax()};
			System.out.println("Maximun is " + findMax(res));
		}
}
