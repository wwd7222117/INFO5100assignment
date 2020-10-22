package Assignment6.PartC;

import java.util.Date;

public class Dog extends Pet implements Boardable{
	private String size;
	private Date startDate;
	private Date endDate;
	
	public Dog (String name, String ownerName, String color, String size) {
		super(name,ownerName,color);
		this.size = size;
	}
	
	public String getSize() {
		return size;
	}
	
	public String toString() {
		return super.toString()+"\nSize:"+this.getSize();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setBoardStart(int month, int day, int year) {
		startDate = new Date(year,month,day);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setBoardEnd(int month, int day, int year) {
		endDate = new Date(year,month,day);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean boarding(int month, int day, int year) {
		Date now = new Date(year,month,day);
		if (now.equals(startDate)||now.equals(endDate)||(now.after(startDate)&&now.before(endDate))) {
			return true;
		}
		else {
			return false;
		}
	}
}
