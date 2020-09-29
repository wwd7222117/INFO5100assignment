package Assignments3_2;

public class Reverse {
	public String reverse(String input) {
		String inputStrip = input.strip();
		String[] StringArray = inputStrip.split(" +");
		String result = "";
		for (int i = StringArray.length-1; i >= 0; i--) {
			result += wordReverse(StringArray[i]);
			if(i == 0) {
				break;
			}
			result += " ";
		}
		return result;
	}
	public String wordReverse(String input) {
		char[] array = input.toCharArray();
		String result = "";
		for(int i = array.length-1; i >= 0; i--) {
			result += array[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Reverse test = new Reverse();
		String a = "   The   sky    is blue    ";
		System.out.println(test.reverse(a));
	}
}
