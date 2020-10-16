package Assignment5;

public class Cookie extends DessertItem {
	private int number;
	private int pricePerDozen;
	
	public Cookie(String name, int number, int pricePerDozen) {
		super(name);
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}
	
	@Override
	public int getCost() {
		float totalCost = (float) ((float)pricePerDozen/12.0*(float)number);
		return Math.round(totalCost);
	}
	
	public String toString() {
		DessertShoppe info =new DessertShoppe();
		return String.valueOf(number)+ " @ "+info.cents2dollarsAndCents(pricePerDozen)+" /dz." +"\n";
	}
}
