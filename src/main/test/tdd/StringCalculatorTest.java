package main.test.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.tdd.StringCalculator;

class StringCalculatorTest {

	@Test
	void testEmptyString() {
		StringCalculator calculator = new StringCalculator();
		assertEquals(0, calculator.add(""));
		
	}
	

}
