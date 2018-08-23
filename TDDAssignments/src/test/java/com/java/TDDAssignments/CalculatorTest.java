package com.java.TDDAssignments;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {
	
	@InjectMocks
	Calculator calculator;
	
	
	@Mock
	Logger logger;

	@Test
	public void shouldReturnZeroWhenInputIsEmpty() {
		Assert.assertEquals(0, calculator.add(""));
	}

	@Test
	public void shouldReturnSameWhenInpuntIsOnlyOne() {
		Assert.assertEquals(123, calculator.add("123"));
	}

	@Test
	public void shouldReturnAdditionWhenInputIsTwo() {
		Assert.assertEquals(5, calculator.add("2,3"));
	}

	@Test
	public void shouldReturnAdditionWhenStringHasMultipleNumbersWithComma() {
		Assert.assertEquals(9, calculator.add("2,3,4"));
	}

	@Test
	public void shouldReturnAdditionWhenStringHasMultipleNumbersWithNewLineAndComma() {
		Assert.assertEquals(9, calculator.add("2\n3,4"));
	}

	@Test
	public void shouldReturnAdditionWhenStringHasMultipleNumbersWhereDelimeterVary() {
		Assert.assertEquals(5, calculator.add("//;\n2;3"));
	}
	
	@Test
	public void shouldIgnoreNumberIfItIsGreaterThan1000() {
		Assert.assertEquals(7, calculator.add("2,5,1001"));
	}
		
	@Test
	public void shouldPerformLogger() {
		Mockito.doNothing().when(logger).info(Mockito.any(String.class));
		calculator.add("//;\n1;2");
		Mockito.verify(logger).info(Mockito.any(String.class));
	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none(); 
	@Test
	public void shouldThrowNegativeIsNotAllowedWithValuesIfPassingNegativeValue(){
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Number is Negative[-1, -5]");
		calculator.add("-1,-5");
	}
}
