package com.internousdev.cherry.dto.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.internousdev.cherry.dto.DestinationInfoDTO;

public class DestinationInfoDTOTest {

	//デフォルトIDに関するテスト
	@Test
	public void testGetId1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		int expected = 0;

		dto.setId(expected);

		assertEquals(expected, dto.getId());

	}
	@Test
	public void testGetId2() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		int expected = 2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId3() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		int expected = -2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId4() throws Exception {
		DestinationInfoDTO dto = new DestinationInfoDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetId5() throws Exception {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//ユーザーIDに関するテスト
	@Test
	public void testGetUserId1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "0";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());

	}
	@Test
	public void testGetUserId2() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUserId3() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "-2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUserId4() throws Exception {
		DestinationInfoDTO dto = new DestinationInfoDTO();
	    try{
	    	String postalMax = "2147483648";
	    	dto.setUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetUserId5() throws Exception {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		try {
		     String postalMin = "-2147483649";
		     dto.setUserId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}


	//名に関するテスト
	@Test
	public void testGetFamilyName1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected=null;

		dto.setFamilyName(expected);
		String actual=dto.getFamilyName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName2() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected="";

		dto.setFamilyName(expected);
		String actual= dto.getFamilyName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFamilyName3() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected=" ";

    	dto.setFamilyName(expected);
    	String actual=dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName4() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="　";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName5() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName6() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="あいう１２３";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName7() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName8() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }




	//姓に関するテスト
	@Test
	public void testGetFirstName1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected=null;

		dto.setFirstName(expected);
		String actual=dto.getFirstName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName2() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected="";

		dto.setFirstName(expected);
		String actual= dto.getFirstName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFirstName3() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected=" ";

    	dto.setFirstName(expected);
    	String actual=dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName4() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="　";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName5() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName6() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="あいう１２３";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName7() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName8() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }




	//名（かな）に関するテスト
	@Test
	public void testGetFamilyNameKana1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected=null;

		dto.setFamilyNameKana(expected);
		String actual=dto.getFamilyNameKana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana2() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected="";

		dto.setFamilyNameKana(expected);
		String actual= dto.getFamilyNameKana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFamilyNameKana3() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected=" ";

    	dto.setFamilyNameKana(expected);
    	String actual=dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana4() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="　";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana5() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana6() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="あいう１２３";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana7() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana8() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }



	//姓（かな）に関するテスト
	@Test
	public void testGetFirstNameKana1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected=null;

		dto.setFirstNameKana(expected);
		String actual=dto.getFirstNameKana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana2() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected="";

		dto.setFirstNameKana(expected);
		String actual= dto.getFirstNameKana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFirstNameKana3() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected=" ";

    	dto.setFirstNameKana(expected);
    	String actual=dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana4() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="　";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana5() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana6() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="あいう１２３";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana7() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana8() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }



	//メアドに関するテスト
	@Test
	public void testGetEmail1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = null;

		dto.setEmail(expected);
		String actual = dto.getEmail();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetEmail2() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "";

		dto.setEmail(expected);
		String actual = dto.getEmail();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail3() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = " ";

		dto.setEmail(expected);
		String actual = dto.getEmail();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail4() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "　";

		dto.setEmail(expected);
		String actual = dto.getEmail();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail5() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "abc123";

		dto.setEmail(expected);
		String actual = dto.getEmail();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail6() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "あいう１２３";

		dto.setEmail(expected);
		String actual = dto.getEmail();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail7() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setEmail(expected);
		String actual = dto.getEmail();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail8() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setEmail(expected);
		String actual = dto.getEmail();

		assertEquals(expected,actual);
	}



	//電話番号に関するテスト
	@Test
	public void testGetTelNumber1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = null;

		dto.setTelNumber(expected);
		String actual = dto.getTelNumber();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetTelNumber2() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "";

		dto.setTelNumber(expected);
		String actual = dto.getTelNumber();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetTelNumber3() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = " ";

		dto.setTelNumber(expected);
		String actual = dto.getTelNumber();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetTelNumber4() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "　";

		dto.setTelNumber(expected);
		String actual = dto.getTelNumber();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetTelNumber5() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "abc123";

		dto.setTelNumber(expected);
		String actual = dto.getTelNumber();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetTelNumber6() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "あいう１２３";

		dto.setTelNumber(expected);
		String actual = dto.getTelNumber();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetTelNumber7() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setTelNumber(expected);
		String actual = dto.getTelNumber();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetTelNumber8() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setTelNumber(expected);
		String actual = dto.getTelNumber();

		assertEquals(expected,actual);
	}



	//住所に関するテスト
	@Test
	public void testGetUserAddress1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = null;

		dto.setUserAddress(expected);
		String actual = dto.getUserAddress();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetUserAddress2() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "";

		dto.setUserAddress(expected);
		String actual = dto.getUserAddress();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetUserAddress3() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = " ";

		dto.setUserAddress(expected);
		String actual = dto.getUserAddress();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetUserAddress4() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "　";

		dto.setUserAddress(expected);
		String actual = dto.getUserAddress();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetUserAddress5() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "abc123";

		dto.setUserAddress(expected);
		String actual = dto.getUserAddress();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetUserAddress6() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "あいう１２３";

		dto.setUserAddress(expected);
		String actual = dto.getUserAddress();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetUserAddress7() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setUserAddress(expected);
		String actual = dto.getUserAddress();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetUserAddress8() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setUserAddress(expected);
		String actual = dto.getUserAddress();

		assertEquals(expected,actual);
	}


	//UPDATE日
	@Test
	public void testGetUpdateDate1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		Date expected = null;

		dto.setUpdateDate(expected);
		Date actual = dto.getUpdateDate();

		assertEquals(expected,actual);
	}



	//登録日
	@Test
	public void testGetRegistDate1() {
		DestinationInfoDTO dto = new DestinationInfoDTO();
		Date expected = null;

		dto.setRegistDate(expected);
		Date actual = dto.getRegistDate();

		assertEquals(expected,actual);
	}


}
