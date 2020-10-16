package Assignment5;

public abstract class DessertItem {
	private String name;
	

	public DessertItem(String name) {
		this.name = name;
	}
	
	public final String getName() {
		return name;
	}
	
	public abstract int getCost();
	
	
}
