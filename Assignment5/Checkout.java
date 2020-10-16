package Assignment5;
import java.util.*;

public class Checkout {
	private Vector<DessertItem> items = new Vector<>();
	
	public Checkout() {
		
	}
	
	public int numberOfItems() {
		return items.size();
	}
	
	public void enterItem(DessertItem item) {
		items.add(item);
	}
	
	public void clear() {
		items.clear();
	}
	
	public int totalCost() {
		int totalcost = 0;
		for (DessertItem i:items) {
			totalcost += i.getCost();
		}
		return totalcost;
	}
	
	public int totalTax() {
		DessertShoppe tax = new DessertShoppe();
		return Math.round(tax.getTaxrate()*((float)this.totalCost()));
	}
	
	public String toString() {
		DessertShoppe shop = new DessertShoppe();
		String blankSpace;
		String content;
		blankSpace = " ".repeat((int)(((shop.getMaxnameSize()+shop.getwidthOnRecepit())-shop.getName().length())/2));
		content = blankSpace+shop.getName()+blankSpace+"\n";  //the name of shop in receipt
		content = content + blankSpace + "-".repeat(shop.getName().length())+blankSpace + "\n"+'\n';   
		for(DessertItem i: items) {
			content = content + i.toString();		//the detail of item
			content = content + formalization(i) + String.format("%"+shop.getwidthOnRecepit()+"s",shop.cents2dollarsAndCents(i.getCost()))+"\n";	//length constraint
		}
		content = content +"\n"+String.format("%-"+ shop.getMaxnameSize()+"s", "Tax") + String.format("%"+shop.getwidthOnRecepit()+"s",shop.cents2dollarsAndCents(totalTax()))+"\n";   
		content = content + String.format("%-"+ shop.getMaxnameSize()+"s", "Total Cost") + String.format("%"+shop.getwidthOnRecepit()+"s",shop.cents2dollarsAndCents(totalTax()+totalCost()))+"\n";   
		
		return content;
	}
		
	public String formalization(DessertItem inputItem) { //to make detail of items satisfy the constraint.
		DessertShoppe shop = new DessertShoppe();
		String formalItem = "";
		int lastIndex = 0;
		int nameSize = shop.getMaxnameSize();
		int formalTimes = 0;
		if (inputItem.getName().length() <= nameSize) {
			formalItem = inputItem.getName()+" ".repeat(nameSize-inputItem.getName().length());
		}
		else {
			formalTimes = inputItem.getName().length()/nameSize;
			for (int i = 0; i < formalTimes; i++) {
				formalItem += inputItem.getName().substring(i*nameSize,(i+1)*nameSize)+"\n";
				lastIndex = (i+1)*nameSize;
			}
			formalItem += inputItem.getName().substring(lastIndex);
			formalItem += " ".repeat(nameSize-lastIndex-1);
		}
		
		return formalItem;
	}
}
