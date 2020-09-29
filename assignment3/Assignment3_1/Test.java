package Assignment3;

public class Test {
	
	public static void main(String[] args) {
		Course courseInfo5100 = new Course("INFO5100");
		Student student1 = new Student("ben","NU202001");
		courseInfo5100.registerStudent(student1);
		System.out.println("the number of student is:"+courseInfo5100.getNumberOfStudent());	

/*
 //The example to test the condition when the course is full

		Student[] students = new Student[10];
		for(int i = 0; i < 10 ; i++) {
			students[i] = new Student("ben"+String.valueOf(i),"NU20200"+String.valueOf(i));
			System.out.println(courseInfo5100.getNumberOfStudent());
			courseInfo5100.registerStudent(students[i]);
		}
*/
	}
}
