package Assignment7;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class HospitalRoom {
    //TODO: implement your code here
	private final int LIMIT = 3;
	private final int FREE = 0;
	private final int DOCLIM = 1;
	private Set<Patient> patients = new HashSet<>();
	private Doctor doctors;
	private Set<Patient> waitingP = new HashSet<>();
	private Set<Doctor> waitingD = new HashSet<>();
	private final Object lock = new Object();

    public boolean doctorEnter(Doctor d) throws InterruptedException {
        if(doctors != null) {
    		if(!waitingD.contains(d)) {
    			System.out.println("Doctor "+d.name+" is waiting to enter, number of doctor 1");
    			waitingD.add(d);
    		}
            return false;
        } 
        else{
        	doctors = d;
        	if(waitingD.contains(d)) {
            	waitingD.remove(d);	
        	}
            System.out.println("Doctor "+d.name+" entered, number of doctor 1");
            return true;
        }
    }

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        //TODO: implement your code here
    	if(doctors!=null) {
	    	if(doctors.equals(d)) {
	            doctors = null;
	            System.out.println("Doctor "+d.name+" left, number of doctor 0");
	            return true;
	    	}
    	}
    	return false;
    }

    public boolean patientEnter(Patient p) throws InterruptedException {
        //TODO: implement your code here

            if(patients.size() == LIMIT) {
        		if(!waitingP.contains(p)) {
            		System.out.println("Patient "+p.name+" is waiting to enter, number of patients 3");
            		waitingP.add(p);
        		}
            	return false;
            } 
            else {
        		if(waitingP.contains(p)) {
        			waitingP.remove(p);
        		}
                patients.add(p);
                System.out.println("Patient "+p.name+" entered, number of patients"+patients.size());
                return true;
            }
    }

    public boolean patientLeave(Patient p) throws InterruptedException {
        //TODO: implement your code here
    	if(patients.contains(p)) {
            patients.remove(p);
            System.out.println("Patient "+p.name+"left");
            return true;
    	}
        return false;
    }

}

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}