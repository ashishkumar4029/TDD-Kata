package main.java.tdd;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int add(String numbers) throws Exception {
		int sum = 0;
		if (numbers == null || numbers.trim().isEmpty())
			sum = 0;
		else {
			StringBuilder delimiterRegex = new StringBuilder();
			/**
			 * Checking if string different delimiters by recognizing //
			 */
			int index = numbers.indexOf("//");
			if (index != -1 && index < 2) {
				numbers = getProcessedString(numbers, delimiterRegex);
			} else {
				delimiterRegex.append("[,\n]");
			}
			System.out.println("regex => " + delimiterRegex);
			/**
			 * Splitting string based on regex
			 */
			String[] numbersArray = numbers.split(delimiterRegex.toString());
			List<String> errorList = new ArrayList<>();
			for (int i = 0; i < numbersArray.length; i++) {
				int nmbr = Integer
						.parseInt(numbersArray[i] != null && !numbersArray[i].trim().isEmpty() ? numbersArray[i] : "0");
				if (nmbr < 0) 
					errorList.add(String.valueOf(nmbr));
				if (nmbr <= 1000)
					sum = sum + nmbr;
			}
			if (!errorList.isEmpty())
				throw new Exception("negatives not allowed " + String.join(",", errorList));
		}
		System.out.println("Sum => " + sum);
		return sum;
	}

	public static String getProcessedString(String numbers, StringBuilder delimiterRegex) {
		/**
		 * if there is square bracket ([]) then different number and size of delimiters are there and hence, different regex
		 * 
		 * else single delimiter present
		 */
		if (numbers.indexOf('[') != -1 && numbers.indexOf(']') != -1) {
			/**
			 * If there are more than one delimiters but different sizes
			 * 
			 * else there is one delimiter of size more than 1
			 */
			if (numbers.indexOf("][") != -1) {
				String delString = numbers.substring(numbers.indexOf('[') + 1, numbers.lastIndexOf(']'));
				String[] delArr = delString.split("\\]\\[");
				delimiterRegex.append("[");
				for (int i = 0; i < delArr.length; i++) {
					String del = delArr[i];
					/**
					 * escaping reserved characters of regex
					 */
					if (del.charAt(0) == '+' || del.charAt(0) == '*' || del.charAt(0) == '^') 
						delimiterRegex.append("(\\");
					delimiterRegex.append(del);
				}
					
				delimiterRegex.append("]");
				numbers = numbers.substring(numbers.lastIndexOf(']') + 1, numbers.length());
				numbers = numbers.replaceAll("[\n]", delArr[0]);
			} else {
				String str = numbers.substring(numbers.indexOf('[') + 1, numbers.indexOf(']'));
				delimiterRegex.append("(" );
				/**
				 * escaping reserved characters of regex
				 */
				if (str.charAt(0) == '+' || str.charAt(0) == '*' || str.charAt(0) == '^') 
					delimiterRegex.append("(\\");
				delimiterRegex.append(str.charAt(0) + "){" + str.length() + "}");
				numbers = numbers.substring(numbers.indexOf(']') + 1, numbers.length());
				numbers = numbers.replaceAll("[\n]", str);
			}
		} else {
			delimiterRegex.append("[" + numbers.charAt(2) + "\n]");
			numbers = numbers.substring(3, numbers.length());
		}

		System.out.println(delimiterRegex);
		System.out.println(numbers);
		return numbers;
	}

}
