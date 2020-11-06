package Assignment7;
import java.util.*;

class MultiSum implements Runnable{
	private int[] subArray;
	private long result = 0;
	public MultiSum(int[] arr) {
		this.subArray = arr;
	}
	public long getSum() {
		return this.result;
	}
	
	public long subsum(int[] arr) {
		 long result = 0;
		 for (int i:arr) {
			 result += i;
		 }
		 return result;
	}
	public void run() {
		this.result = this.subsum(subArray);
	}
}
public class SumValue {


	 static void generateRandomArray(int[] arr){
		 Random intRan = new Random();
		 for(int i = 0; i <arr.length;i++) {
			arr[i] = intRan.nextInt(10);   //to avoid error, the random between 0 and 9
		 }
	 }

	 static long sum(long[] arr){
		 long result = 0;
		 for (long i:arr) {
			 result += i;
		 }
		 return result;
	 }
	 
	 
	 public static void main(String[] args) throws InterruptedException{
		 
	 int[] arr = new int[4000000];
	 generateRandomArray(arr);
	 
	
	 MultiSum sum1 = new MultiSum(Arrays.copyOfRange(arr,0,100000));
	 MultiSum sum2 = new MultiSum(Arrays.copyOfRange(arr,100000,200000));
	 MultiSum sum3 = new MultiSum(Arrays.copyOfRange(arr,200000,300000));
	 MultiSum sum4 = new MultiSum(Arrays.copyOfRange(arr,300000,400000));
	
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
	 long res[] = {sum1.getSum(),sum2.getSum(),sum3.getSum(),sum4.getSum()};
	 System.out.println("Sum: " + sum(res));
	 }
}
