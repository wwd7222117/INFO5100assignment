package Assignment5;

public class IceCream extends DessertItem {
	protected float cost;
	
	public IceCream(String name,float cost) {
		super(name);
		this.cost = cost;
	}
	
	@Override
	public int getCost() {
		return Math.round(cost);
	}
	
	public String toString() {
		return "";
	}
}
