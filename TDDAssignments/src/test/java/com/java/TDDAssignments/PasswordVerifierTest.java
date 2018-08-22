package com.java.TDDAssignments;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class PasswordVerifierTest {

	public static PasswordVerifier createPasswordverifier(){
		return new PasswordVerifier();
	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none(); 
	
	@Test
	public void shouldReturnExceptionWithMessageIfPasswordIsEmpty(){
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password shouldn't be empty");
		createPasswordverifier().verify("");
	}
	
	@Test
	public void shouldReturnExceptionWithMessageIfPasswordIsLessThan8(){
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password length should be greater than 8");
		createPasswordverifier().verify("pass");
	}
	
	@Test
	public void shouldReturnExceptionWithMessageIfPasswordNotHaveAtleastOneUpperCase(){
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password must has atleast one upper case");
		createPasswordverifier().verify("passwords");
	}
	
	@Test
	public void shouldReturnExceptionWithMessageIfPasswordNotHaveAtleastOneLowerCase(){
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password must hase atleast one lower case");
		createPasswordverifier().verify("PASSWORDS");
	}
	
	@Test
	public void shouldReturnExceptionWithMessageIfPasswordNotHaveAtleastOneNumber(){
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password has atleast one number");
		createPasswordverifier().verify("Passwords");
	}
	
	@Test
	public void passwordShouldPassAllCondition(){
		
		Assert.assertEquals("password is ok", createPasswordverifier().verify("passworD11"));
		Assert.assertEquals("password is ok", createPasswordverifier().verify("pD1"));
	}
	
	
	
	
}
