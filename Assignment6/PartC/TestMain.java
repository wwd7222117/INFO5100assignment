package Assignment6.PartC;

public class TestMain {
	public static void main(String[] args) {	
		Cat baby = new Cat("kiki", "Ben", "Orange", "Short");
		baby.setSex(1);
		System.out.println(baby);
		
		baby.setBoardStart(10,22,2020);
		baby.setBoardEnd(11,12,2020);
		System.out.println(baby.boarding(11,1,2020));//true;
		
		baby.setBoardStart(10, 22, 2020);
		baby.setBoardEnd(10, 22, 2020);
		System.out.println(baby.boarding(10,22,2020));//true;
		
		baby.setBoardStart(10, 22, 2020);
		baby.setBoardEnd(11, 22, 2020);
		System.out.println(baby.boarding(12,22,2020));//false

		Dog smallblack =new Dog("smallblack", "Ben", "black","Large" );
		System.out.println(smallblack);
		
		smallblack.setBoardStart(10,22,2020);
		smallblack.setBoardEnd(11,12,2020);
		System.out.println(smallblack.boarding(11,1,2020));//true;
		
		smallblack.setBoardStart(10, 22, 2020);
		smallblack.setBoardEnd(10, 22, 2020);
		System.out.println(smallblack.boarding(10,22,2020));//true;
		
		smallblack.setBoardStart(10, 22, 2020);
		smallblack.setBoardEnd(11, 22, 2020);
		System.out.println(smallblack.boarding(12,22,2020));//false

	}
}