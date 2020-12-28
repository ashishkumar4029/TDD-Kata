package main.java.tdd;

public class StringCalculator {

	
	public int add(String numbers) {
		int sum = 0;
		if(numbers == null || numbers.trim().isEmpty())
			return sum;
		else {
			int index = numbers.indexOf("//");
			String delimiterRegex;
			if(index != -1 && index < 2) {
				delimiterRegex = "["+numbers.charAt(2)+"\n]";
			}
			else {
				delimiterRegex = "[,\n]";
			}
			String[] numbersArray = numbers.split(delimiterRegex);
			for(int i= ++index;i<numbersArray.length;i++) {
				sum = sum+Integer.parseInt(numbersArray[i] != null && !numbersArray[i].trim().isEmpty() ? numbersArray[i] : "0");
			}
		}
		return sum;
	}
}
