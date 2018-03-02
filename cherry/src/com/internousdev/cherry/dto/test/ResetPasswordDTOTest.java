package com.internousdev.cherry.dto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.internousdev.cherry.dto.ResetPasswordDTO;

public class ResetPasswordDTOTest {



	//ユーザーIDに関するテスト
	@Test
	public void testGetUserId1() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
		String expected = "0";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());

	}
	@Test
	public void testGetUserId2() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
		String expected = "2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUserId3() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
		String expected = "-2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUserId4() throws Exception {
		ResetPasswordDTO dto = new ResetPasswordDTO();
	    try{
	    	String postalMax = "2147483648";
	    	dto.setUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetUserId5() throws Exception {
		ResetPasswordDTO dto = new ResetPasswordDTO();
		try {
		     String postalMin = "-2147483649";
		     dto.setUserId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//パスワードに関するテスト
	@Test
	public void testGetPassword1() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
		String expected=null;

		dto.setPassword(expected);
		String actual=dto.getPassword();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword2() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
		String expected="";

		dto.setPassword(expected);
		String actual= dto.getPassword();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetPassword3() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
    	String expected=" ";

    	dto.setPassword(expected);
    	String actual=dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword4() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
    	String expected ="　";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword5() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
    	String expected ="abc123";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword6() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
    	String expected ="あいう１２３";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword7() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
    	String expected ="abc123あいう１２３";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword8() {
		ResetPasswordDTO dto = new ResetPasswordDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }







}
