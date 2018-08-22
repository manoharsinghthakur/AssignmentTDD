package com.java.TDDAssignments;

public class FizzBuzz {
	public String checkNumber(int number){
		
		boolean divideByThree = number%3==0;
		boolean divideByfive = number%5==0;
		if(divideByThree&divideByfive)
			return "FizzBuzz";
		 else if(divideByThree)
			 return "Fizz";
		 else if(divideByfive)
			 return "Buzz";
		 else	
			 return String.valueOf(number);
		 
	}
}
