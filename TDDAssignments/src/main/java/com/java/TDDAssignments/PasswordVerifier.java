package com.java.TDDAssignments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordVerifier {
//
	public String verify(String string){
		boolean isDigit = false;
		boolean isUpperCase = false;
		boolean isLowerCase = false;
		int count=0;
		char[] ch = string.toCharArray();
		for(int i=0;i<ch.length;i++){
			if(Character.isUpperCase(ch[i])) 
				isUpperCase=true;
			if(Character.isLowerCase(ch[i]))
				isLowerCase=true;
			if(Character.isDigit(ch[i]))
				isDigit=true;
		}
		
		if(!string.isEmpty()){
			if(isLowerCase){
				if(isUpperCase) count++;
				if(isDigit)   count++;
				if(string.length()>8) count++;
			}
			else{
				throw new RuntimeException("Password must have atleast one lower case");
			}
		}
		else { 
			throw new RuntimeException("Password shouldn't be empty"); }
		
		if(count<1){
			throw new RuntimeException("Password should have atleast one lower case or one digit or length greater than 8");
		}
		return "password is ok";	
	}
}
