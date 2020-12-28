package main.test.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.tdd.StringCalculator;

class StringCalculatorTest {

	StringCalculator calculator = new StringCalculator();
	/**
	 * Test Case 1
	 */
	@Test
	void testEmptyString() {
		assertEquals(0, calculator.add(""));
		
	}
	
	/**
	 * Test Case 2
	 */
	@Test
	void test2NumberString() {
		assertEquals(3, calculator.add("1,2"));
		assertEquals(3, calculator.add("1,2,"));
	}
	
	/**
	 * Test Case 3
	 */
	@Test
	void test2NumberStringWithLineBreak() {
		assertEquals(6, calculator.add("1\n2,3"));
		assertEquals(1, calculator.add("1,\n"));
	}
	
	/**
	 * Test Case 4
	 */
	@Test
	void test2NumberStringWithLineBreakAndDiffDelimiters() {
		assertEquals(6, calculator.add("//;1\n2;3"));
		assertEquals(1, calculator.add("//-1-\n"));
		assertEquals(10, calculator.add("5\n2,3"));
	}
	
	
}
