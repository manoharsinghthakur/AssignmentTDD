package com.java.TDDAssignments;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class FizzBuzzTest {

	public static FizzBuzz createFizzBuzz(){
		return new FizzBuzz();
	}
			
	@Test
	public void shouldReturnFizzIfNumberIsDivibleBy3(){
		Assert.assertEquals("Fizz",createFizzBuzz().checkNumber(9));
	}
	
	@Test
	public void shouldReturnBizzIfNumberIsDivibleBy5(){
		Assert.assertEquals("Buzz",createFizzBuzz().checkNumber(10));
	}
	@Test
	public void shouldReturnFizzBizzIfNumberIsDivibleBy3And5(){
		Assert.assertEquals("FizzBuzz",createFizzBuzz().checkNumber(15));
	}
	@Test
	public void shouldReturnNumberIfNotDivisibleBy3Or5(){
		Assert.assertEquals("16",createFizzBuzz().checkNumber(16));
	}
}
