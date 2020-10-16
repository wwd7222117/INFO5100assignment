package Assignment5;

public class Candy extends DessertItem {
	private float weight;
	private int pricePerPound;
	
	public Candy(String name,double weight,int pricePerPound) {
		super(name);
		this.weight = (float)weight;
		this.pricePerPound = pricePerPound;
	}
	
	@Override
	public int getCost() {
		return Math.round(weight*(float)pricePerPound);
	}
	
	public String toString() {
		DessertShoppe info =new DessertShoppe();
		return String.valueOf(weight) + " lbs. @ " + info.cents2dollarsAndCents(pricePerPound) + " /lb." +"\n";
	}
}
