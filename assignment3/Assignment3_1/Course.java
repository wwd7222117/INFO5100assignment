package Assignment3;

public class Course{
	private String name;
	private int numberOfStudent = 0;
	private Student[] registeredStudent = new Student[10];
	
	Course(String name) {
		this.name = name;
	}
	
	public Student[] getStudents() {
		return registeredStudent;
	}
	
	public boolean isFull() {
		return (numberOfStudent==10)?true:false;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfStudent() {
		return numberOfStudent;
	}
	
	public void registerStudent(Student student) {
		if (!isFull()) {
			registeredStudent[numberOfStudent] = student;
			numberOfStudent += 1;
		}
		else {
			System.out.println("Sorry,the course is full!");
		}
	}
}
