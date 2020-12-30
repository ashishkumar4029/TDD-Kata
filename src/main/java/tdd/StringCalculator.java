package main.java.tdd;

import java.util.ArrayList;
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
				if(numbers.indexOf('[') != -1 && numbers.indexOf(']') != -1) {
					String str= numbers.substring(numbers.indexOf('[')+1, numbers.indexOf(']'));
					if(str.charAt(0) == '+' || str.charAt(0) == '*'  || str.charAt(0) == '^' ) {
						delimiterRegex = "(\\"+str.charAt(0)+"){"+str.length()+"}";
					}else {
						delimiterRegex = "("+str.charAt(0)+"){"+str.length()+"}";
					}
					numbers = numbers.substring(numbers.indexOf(']')+1,numbers.length());
					numbers = numbers.replaceAll("[\n]",str );
				}
				else {
					delimiterRegex = "["+numbers.charAt(2)+"\n]";
					numbers = numbers.substring(3,numbers.length());
				}
			}
			else {
				delimiterRegex = "[,\n]";
			}
			System.out.println("regex => " +delimiterRegex);
			String[] numbersArray = numbers.split(delimiterRegex);
			List<String> errorList = new ArrayList<>();
			for(int i= 0;i<numbersArray.length;i++) {
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
		System.out.println("Sum => "+sum);
		return sum;
	}
}
