package com.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestcaseEmplogin {

	@Test
	void employeecredentialscheck() {
		assertEquals(false, EmployeeLogin.employeecredentialscheck("abc","abs"), "Invalid Credentials");
		assertEquals(false, EmployeeLogin.employeecredentialscheck("abs","abs"), "Invalid Credentials");
		assertEquals(false, EmployeeLogin.employeecredentialscheck("abc","abcc"), "Invalid Credentials");
		assertEquals(true, EmployeeLogin.employeecredentialscheck("abc","abc"), "Valid Credentials");
		assertEquals(true, EmployeeLogin.employeecredentialscheck("abc","abc"), "Valid Credentials");

		
	}
	@Test
	void checkforspecialcharacter() {
		assertEquals(false, EmployeeLogin.checkforspecialcharacter("bc44"), "valid Username");
		assertEquals(false, EmployeeLogin.checkforspecialcharacter("44abcabc"), "valid Username");
		assertEquals(false, EmployeeLogin.checkforspecialcharacter("abcc4"), "valid Username");
		assertEquals(true, EmployeeLogin.checkforspecialcharacter("44ab>cab<c"), "Invalid Username");
		assertEquals(true, EmployeeLogin.checkforspecialcharacter("abcc4!!"), "Invalid Username");
	}

}
