package com.java.TDDAssignments;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Calculator {
	private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public int add(String string) {
		String delimeter = ",|\n";
		if (string == "") {
			logger.info("" + 0);
			return 0;
		}
		else if (string.startsWith("//")) {
			String[] string1 = string.split("\n");
			string = string1[1];
			delimeter = string1[0].substring(2);
		}
		String[] stringArrayOfNumbers = string.trim().length() < 1 ? new String[0] : string.split(delimeter);
		List NegativeNumberList = Arrays.stream(stringArrayOfNumbers).filter(x -> Integer.valueOf(x) < 0).collect(Collectors.toList());
		if (NegativeNumberList.size() != 0) {
			throw new RuntimeException("Number is Negative"+NegativeNumberList);
		} 
		else {
			int sum = Arrays.stream(stringArrayOfNumbers).map(x -> Integer.parseInt(x)).filter(x -> x <= 1000)
					.reduce(Integer::sum).get();
			logger.info("" + sum);
			return sum;
		}
	}

}
