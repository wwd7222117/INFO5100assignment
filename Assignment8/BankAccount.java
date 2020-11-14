package Assignment8;
import java.util.Arrays;

public class BankAccount {
	
	private final Object lock = new Object();
	private int balance;
	
	BankAccount(int balance){
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		if(amount > 0) {
			synchronized(lock) {
				balance+=amount;
				System.out.println("You have deposited $"+amount);
				this.getBalance();
			}	
		}
		else {
			System.out.println("the deposit amount can't be negative number");
		}
	}
	public void withdraw(int amount) {
		if(amount > 0) {
			synchronized(lock) {
				if(balance >= amount) {
					balance-=amount;
					System.out.println("You have withdrawed $"+amount);
					this.getBalance();
				}
				else {
					System.out.println("Fail to withdraw. Insufficient balance");
				}
			}	
		}
		else {
			System.out.println("the withdraw amount can't be negative number");
		}
	}
	public void getBalance() {
		synchronized(lock) {
			System.out.println("Balance: "+balance);
		}
	}
	
	public static void main(String[] args) {
		BankAccount test = new BankAccount(1000);
		Thread t1 = new Thread(()->test.deposit(100));
		Thread t2 = new Thread(()->test.withdraw(500));
		Thread t3 = new Thread(()->test.withdraw(1000));
		Thread t4 = new Thread(()->test.deposit(400));
		 
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}