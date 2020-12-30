package main.test.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.tdd.StringCalculator;

class StringCalculatorTest {

	StringCalculator calculator = new StringCalculator();

	/**
	 * Test Case 1
	 * @throws Exception 
	 */
	@Test
	void testEmptyString() throws Exception {
			assertEquals(0, calculator.add(""));
	}

	/**
	 * Test Case 2
	 * @throws Exception 
	 */
	@Test
	void test2NumberString() throws Exception {
			assertEquals(3, calculator.add("1,2"));
			assertEquals(3, calculator.add("1,2,"));
	}

	/**
	 * Test Case 3
	 * @throws Exception 
	 */
	@Test
	void test2NumberStringWithLineBreak() throws Exception {
			assertEquals(6, calculator.add("1\n2,3"));
			assertEquals(1, calculator.add("1,\n"));
	}

	/**
	 * Test Case 4
	 * @throws Exception 
	 */
	 @Test
	void test2NumberStringWithLineBreakAndDiffDelimiters() throws Exception {
			assertEquals(6, calculator.add("//;1\n2;3"));
			assertEquals(1, calculator.add("//-1-\n"));
			assertEquals(10, calculator.add("5\n2,3"));
	}

	/**
	 * Test Case 5
	 */
	 @Test
	void test2NumberStringWithLineBreakAndDiffDelimitersAndNegativeNmbrException() {

		Exception exception = assertThrows(Exception.class, () -> {
			calculator.add("//;1\n2;-3");
		});
		String expectedMsg = "negatives not allowed -3";
		String exceptionMsg = exception.getMessage();

		assertEquals(expectedMsg, exceptionMsg);

		exception = assertThrows(Exception.class, () -> {
			calculator.add("//;1\n2;3;-7;9;-12");
		});
		expectedMsg = "negatives not allowed -7,-12";
		exceptionMsg = exception.getMessage();

		assertEquals(expectedMsg, exceptionMsg);
	}

	/**
	 * Test Case 6
	 */
	 @Test
	void test2NumberStringWithLineBreakAndDiffDelimitersAndNegativeNmbrExceptionAndIgnoreAbove1000Values() {
		try {
			assertEquals(4, calculator.add("//;1\n2000;3"));
			assertEquals(7, calculator.add("5\n2,3000"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test Case 7
	 * 
	 * @throws Exception
	 */
	@Test
	void test2NumberStringWithLineBreakAndDiffDelimitersAndNegativeNmbrExceptionAndIgnoreAbove1000ValuesAndLengthDelimiter()
			throws Exception {
		assertEquals(7, calculator.add("//[***]\n1***3***3"));
		assertEquals(6, calculator.add("//[%%%]\n2%%%4"));

	}
	
	
}
