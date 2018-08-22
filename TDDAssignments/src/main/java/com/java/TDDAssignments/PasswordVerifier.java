package com.java.TDDAssignments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordVerifier {

	public String verify(String string){
		boolean isDigit = false;
		boolean isUpperCase = false;
		boolean isLowerCase = false;
	
		char[] ch = string.toCharArray();
		for(int i=0;i<ch.length;i++){
			if(Character.isUpperCase(ch[i])) 
				isUpperCase=true;
			if(Character.isLowerCase(ch[i]))
				isLowerCase=true;
			if(Character.isDigit(ch[i]))
				isDigit=true;
		}
		
		if(!isUpperCase || !isDigit || !isLowerCase){
			
		if(string.isEmpty())  throw new RuntimeException("Password shouldn't be empty");
		else if(string.length()<8)  throw new RuntimeException("Password length should be greater than 8");
		else if(isLowerCase==false)  throw new RuntimeException("Password must hase atleast one lower case");
		else if(isUpperCase==false)  throw new RuntimeException("Password must has atleast one upper case");
		else if(isDigit==false)  throw new RuntimeException("Password has atleast one number");
		}
		return "password is ok";

	}
}
