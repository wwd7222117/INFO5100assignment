package Assignment6.PartC;
import java.util.Date;

public class Cat extends Pet implements Boardable{
	private String hairLength;
	private Date startDate;
	private Date endDate;
	
	public Cat(String name,String ownerName, String color, String hairLength) {
		super(name,ownerName,color);
		this.hairLength = hairLength;
	}
	
	public String getHairLength() {
		return hairLength;
	}
	
	public String toString() {
		return super.toString()+"\nHair:"+hairLength;
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
