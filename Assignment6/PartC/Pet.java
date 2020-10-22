package Assignment6.PartC;

public class Pet {
	private String petName;
	private String ownerName;
	private String color;
	protected int sex;
	
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int SPAYED = 3;
	public static final int NEUTERED = 4;
	
	public Pet (String name, String ownerName, String color) { //Constructor
		petName = name;
		this.ownerName = ownerName;
		this.color = color;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public String getColor() {
		return color;
	}
	public void setSex(int sexid) {
		if (sexid >0 && sexid < 4) {
			sex = sexid;
		}
		else {
			System.out.println("please input sexid again");
		}
		
	}
	
	public String getSex(){// Should return the string equivalent of the gender, e.g the string “MALE” etc. 
		if (MALE == sex) {
			return "MALE";
		}
		else if (FEMALE == sex) {
			return "FEMALE";
		}
		else if (SPAYED == sex) {
			return "SPAYED";
		}
		else {
			return "NEUTERED";
		}
	}
	public String toString() { // Should return the name, owner’s name, age, color, and gender (use getSex()); 
		return this.getPetName()+" owned by "+this.getOwnerName()+"\n"+"COLOR:"+color+"\nSex:"+this.getSex();
	}
	
}








