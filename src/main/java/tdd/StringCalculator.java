package main.java.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringCalculator {

	
	public int add(String numbers) throws Exception {
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
			System.out.println(delimiterRegex);
			String[] numbersArray = numbers.split(delimiterRegex);
			List<String> errorList = new ArrayList<>();
			for(int i= ++index;i<numbersArray.length;i++) {
				int nmbr = Integer.parseInt(numbersArray[i] != null && !numbersArray[i].trim().isEmpty() ? numbersArray[i] : "0");
				if(nmbr < 0) {
					errorList.add(String.valueOf(nmbr));
				}
				if(nmbr <= 1000)
					sum = sum+nmbr;
			}
			if(!errorList.isEmpty())
				throw new Exception("negatives not allowed "+String.join(",", errorList));
		}
		return sum;
	}
}
