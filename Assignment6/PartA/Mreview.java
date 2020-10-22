package Assignment6.PartA;
import java.util.*;

public class Mreview implements Comparable<Mreview>{
	private String title;
	private ArrayList<Integer> ratings;
	
	public Mreview() {
		title = "";
		ratings = new ArrayList<>();
	}
	
	public Mreview(String ttl) {
		title = ttl;
		ratings = new ArrayList<>();
	}
	
	public Mreview(String ttl, int firstRating) {
		title = ttl;
		ratings.add(firstRating);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addRating(int r) {
		ratings.add(r);
	}
	
	public double aveRating() {
		int sum = 0;
		Iterator<Integer> iter = ratings.iterator();
		while (iter.hasNext()) {
			int item = iter.next();
			sum += item;
		}
		return (double)sum/(double)ratings.size();
	}
	
	public int numRatings() {
		return ratings.size();
	}
	
	@Override
	public int compareTo(Mreview obj) {
		return title.compareTo(obj.title);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return title.equals(((Mreview)obj).title);
	}
	
	public String toString() {
		return 	(title + ",average "+String.valueOf(aveRating())+" out of "+String.valueOf(numRatings())+" ratings");
	}
	
	public static void main(String[] args) {
		Mreview test =new Mreview("Kill Bill");
		test.addRating(3);
		test.addRating(4);
		test.addRating(3);
		System.out.println(test);
	}
}
