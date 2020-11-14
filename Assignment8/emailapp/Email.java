package Assignment8.emailapp;

import java.util.Scanner;
import java.util.Random;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.password = randomPassword(defaultPasswordLength);
    	this.email = this.SetDepartmentAndEmail();
    }

    // Ask for the department
    @SuppressWarnings("resource")
	private String SetDepartmentAndEmail() {
    	String emailName = this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@";
    	Scanner dept = new Scanner(System.in);
    	while(true) {
	    	System.out.print("New Worker:"+this.firstName+" "+this.lastName+". Department Codes:\n"
	    	    + "1 for Sales\n"
	    		+ "2 for Development\n"
	    		+ "3 for Accounting\n"
	    		+ "0 for none\n"
	    		+ "Enter department code:\n" );
	    	if(dept.hasNext()) {
		    	switch(dept.next()) {
		    		case "1":
		    			this.department = "Sales";
		    			return emailName+"sal."+companySuffix;
		    		case "2":
		    			this.department = "Development";
		    			return emailName+"dev."+companySuffix;
		    		case "3":
		    			this.department = "Accounting";
		    			return emailName+"acc."+companySuffix;
		    		case "0":
		    			this.department = "None";
		    			return emailName+companySuffix;
		    		default:
		    			System.out.println("Invalid input,You need input again");
		    	}
	    	}
    	}
    }

    // Generate a random password
    private String randomPassword(int length) {
    	if (length < 8) {
    		System.out.println("The length of the Password need to be longer than 7");
    		return ""; 
    	}
    	String PasswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    	Random random = new Random();
    	StringBuffer password = new StringBuffer();
    	for(int i = 0; i < length; i++) {
    		password.append(PasswordSet.charAt(random.nextInt(PasswordSet.length())));
    	}
    	return password.toString();
    }
    
    public void setPassword() {
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    	boolean flag = true;
    	String PasswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%"; 
    	String PasswordInput = input.nextLine().toString();
    	if(PasswordInput.length() < 8) {
    		flag = false ;
    		System.out.println("The length of the Password need to be longer than 7");
    		return;
    	}
    	for(int i = 0; i < PasswordInput.length(); i++) {
			if(!PasswordSet.contains(String.valueOf(PasswordInput.charAt(i)))){
				System.out.println("Invalid Characters");
				flag = false;
				break;
			}
    	}
    	if (flag) this.password = PasswordInput;
    }
    
    public void setMailCapacity(int Capacity) {
    	if (Capacity > 0) {
    		this.mailboxCapacity = Capacity;
    	}
    	else {
    		System.out.println("Fail to set capacity!!!");
    		this.mailboxCapacity = 500;
    	}
    }
    
    public void getName() {
    	System.out.println("DISPLAY NAME: "+this.firstName+" "+this.lastName);
    }
    
    public void getDept() {
    	System.out.println("DEPARTMENT: "+this.department);
    }
    
    public void getEmail() {
    	System.out.println("COMPANY EMAIL: "+this.email);
    }
    
    public void getPassword() {
    	System.out.println("PASSWORD: "+this.password);
    }
    public void getMailboxCapacity() {
    	System.out.println("MAILBOX CAPACITY: "+this.mailboxCapacity+"mb");
    }
    
    public String showInfo() {
    	return 
    	"DISPLAY NAME: "+this.firstName+" "+this.lastName+"\n"+
    	"DEPARTMENT: "+this.department+"\n"+
    	"COMPANY EMAIL: "+this.email+"\n"+
    	"PASSWORD: "+this.password+"\n"+
    	"MAILBOX CAPACITY: "+this.mailboxCapacity+"mb";
    }
}
