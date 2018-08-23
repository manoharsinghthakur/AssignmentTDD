package com.java.TDDAssignments;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.java.TDDAssignments.PasswordVerifier;

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
	public void shouldReturnExceptionWithMessageIfPasswordHasOnlyLowerCaseAndLengthLessThanEight(){
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password should have atleast one lower case or one digit or length greater than 8");
		createPasswordverifier().verify("pass");
	}
		
	@Test
	public void shouldReturnExceptionWithMessageIfPasswordNotHaveAtleastOneLowerCase(){
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password must have atleast one lower case");
		createPasswordverifier().verify("PASSWORDS");
	}
		
	
	@Test
	public void passwordShouldPassIfPassingLowerAndUpperCaseWithDigitAndMaitainLegth(){
		Assert.assertEquals("password is ok", createPasswordverifier().verify("passworD11"));
		}
	
	@Test
	public void passwordShouldPassIfPassingLowerAndUpperCaseAndDigitWithoutMaintainingLength(){
		Assert.assertEquals("password is ok", createPasswordverifier().verify("Pass12"));
	}
	
	@Test
	public void passwordShouldPassIfPassingLowerAndUpperCaseWithoutMaintainingLength(){
		Assert.assertEquals("password is ok", createPasswordverifier().verify("Pass"));
	}

	@Test
	public void passwordShouldPassIfPassingLowerCaseAndNumberWithoutMaintainingLength(){
		Assert.assertEquals("password is ok", createPasswordverifier().verify("pass12"));
	}
}
