package Assignment5;

public class DessertShoppe {
	private float taxRate;
	private String name;
	private int maxNamesize;
	private int widthOnReceipt;
	
	public DessertShoppe(){
		taxRate = (float) 0.065;
		name = "M & M Dessert Shoppe";
		maxNamesize = 30;
	    widthOnReceipt = 10;
	}
	
	public DessertShoppe(float taxRate,String name,int maxname,int width){
		this.taxRate = taxRate;
		this.name= name;
		maxNamesize = maxname;
	    widthOnReceipt = width;
	}
	
	public String cents2dollarsAndCents(int cost) {
		if (cost < 100) {
			return "." + String.valueOf(cost);
		}
		return String.valueOf((float)cost/100);
	}
	
	public String getName() {
		return name;
	}
	public int getMaxnameSize(){
		return this.maxNamesize;
	}
	public int getwidthOnRecepit() {
		return this.widthOnReceipt;
	}
	public float getTaxrate() {
		return taxRate;
	}
	
	
	
}
