package main.java.tdd;

public class StringCalculator {

	
	public int add(String numbers) {
		int sum = 0;
		if(numbers == null || numbers.trim().isEmpty())
			return sum;
		else {
			String[] numbersArray = numbers.split("[,\n]");
			for(int i=0;i<numbersArray.length;i++) {
				sum = sum+Integer.parseInt(numbersArray[i] != null && !numbersArray[i].trim().isEmpty() ? numbersArray[i] : "0");
			}
		}
		return sum;
	}
}
