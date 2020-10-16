package Assignment5;

public class Sundae extends IceCream{
	private String toppingName;
	private float toppingCost;
	
	public Sundae(String iceCreamName, float iceCreamCost,String toppingName,float toppingCost) {
		super(iceCreamName, iceCreamCost);
		this.toppingName = toppingName;
		this.toppingCost = toppingCost;
	}
	
	public int getCost() {
		return Math.round((float)super.getCost()+toppingCost);
	}
	
	@Override
	public String toString() {
		return toppingName + " Sundae with" + "\n";
	}
	
}
