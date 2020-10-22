package Assignment6.PartB;

public class Account {
	protected String FirstName;
	protected String LastName;
	protected double CurBalance;
	
	public Account(String fname, String lname, double curbalance) {
		FirstName = fname;
		LastName = lname;
		CurBalance = curbalance;
	}
	
	public String getAcctType() {
		return this.getClass().getName();
	}
	
	public double DebitTransaction(double debitAmount) {
		CurBalance = CurBalance - debitAmount;
		return CurBalance;
	}
	
	public double CreditTransaction(double creditAmount) {
		CurBalance += creditAmount;
		return CurBalance;
	}
	
	public String toString() {
		 return "Account name: " + FirstName + " " + LastName + ", Account Type: " + getAcctType() + ", Balance: " + String.format("$%.2f", CurBalance);
	}
	
	public static void main(String[] args) {

	    Account ac1 = new Account("John", "Smith", 100);
	    System.out.println(ac1);

	    ac1.DebitTransaction(30.25); // should be $69.75
	    System.out.println(ac1);

	    ac1.CreditTransaction(10.10);
	    System.out.println(ac1); // should be $79.85

	}
}