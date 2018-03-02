package com.internousdev.cherry.dto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.internousdev.cherry.dto.MyPageDTO;

public class MyPageDTOTest {

	//ユーザーIDに関するテスト
	@Test
	public void testGetUserId1() {
		MyPageDTO dto = new MyPageDTO();
		String expected = "0";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());

	}
	@Test
	public void testGetUserId2() {
		MyPageDTO dto = new MyPageDTO();
		String expected = "2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUserId3() {
		MyPageDTO dto = new MyPageDTO();
		String expected = "-2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUserId4() throws Exception {
		MyPageDTO dto = new MyPageDTO();
	    try{
	    	String postalMax = "2147483648";
	    	dto.setUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetUserId5() throws Exception {
		MyPageDTO dto = new MyPageDTO();
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
		MyPageDTO dto = new MyPageDTO();
		String expected=null;

		dto.setFamilyName(expected);
		String actual=dto.getFamilyName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName2() {
		MyPageDTO dto = new MyPageDTO();
		String expected="";

		dto.setFamilyName(expected);
		String actual= dto.getFamilyName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFamilyName3() {
		MyPageDTO dto = new MyPageDTO();
    	String expected=" ";

    	dto.setFamilyName(expected);
    	String actual=dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName4() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="　";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName5() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName6() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="あいう１２３";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName7() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName8() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }



	//パスワードに関するテスト
	@Test
	public void testGetPassword1() {
		MyPageDTO dto = new MyPageDTO();
		String expected=null;

		dto.setPassword(expected);
		String actual=dto.getPassword();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword2() {
		MyPageDTO dto = new MyPageDTO();
		String expected="";

		dto.setPassword(expected);
		String actual= dto.getPassword();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetPassword3() {
		MyPageDTO dto = new MyPageDTO();
    	String expected=" ";

    	dto.setPassword(expected);
    	String actual=dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword4() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="　";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword5() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword6() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="あいう１２３";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword7() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword8() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }




	//名に関するテスト
	@Test
	public void testGetFirstName1() {
		MyPageDTO dto = new MyPageDTO();
		String expected=null;

		dto.setFirstName(expected);
		String actual=dto.getFirstName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName2() {
		MyPageDTO dto = new MyPageDTO();
		String expected="";

		dto.setFirstName(expected);
		String actual= dto.getFirstName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFirstName3() {
		MyPageDTO dto = new MyPageDTO();
    	String expected=" ";

    	dto.setFirstName(expected);
    	String actual=dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName4() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="　";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName5() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName6() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="あいう１２３";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName7() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName8() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }




	//名（かな）に関するテスト
	@Test
	public void testGetFamilyNameKana1() {
		MyPageDTO dto = new MyPageDTO();
		String expected=null;

		dto.setFamilyNameKana(expected);
		String actual=dto.getFamilyNameKana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana2() {
		MyPageDTO dto = new MyPageDTO();
		String expected="";

		dto.setFamilyNameKana(expected);
		String actual= dto.getFamilyNameKana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFamilyNameKana3() {
		MyPageDTO dto = new MyPageDTO();
    	String expected=" ";

    	dto.setFamilyNameKana(expected);
    	String actual=dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana4() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="　";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana5() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana6() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="あいう１２３";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana7() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana8() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }




	//姓（かな）に関するテスト
	@Test
	public void testGetFirstNameKana1() {
		MyPageDTO dto = new MyPageDTO();
		String expected=null;

		dto.setFirstNameKana(expected);
		String actual=dto.getFirstNameKana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana2() {
		MyPageDTO dto = new MyPageDTO();
		String expected="";

		dto.setFirstNameKana(expected);
		String actual= dto.getFirstNameKana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFirstNameKana3() {
		MyPageDTO dto = new MyPageDTO();
    	String expected=" ";

    	dto.setFirstNameKana(expected);
    	String actual=dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana4() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="　";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana5() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana6() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="あいう１２３";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana7() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana8() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }




	//性別テスト
	@Test
    public void testIsSex1() {
		MyPageDTO dto = new MyPageDTO();
    	boolean expected = true;

    	dto.setSex(expected);
    	boolean actual= dto.isSex();

    	assertEquals(expected, actual);
    }
	@Test
    public void testIsSex2() {
		MyPageDTO dto = new MyPageDTO();
    	boolean expected =false;

    	dto.setSex(expected);
    	boolean actual= dto.isSex();

    	assertEquals(expected, actual);
    }




	//Emailに関するテスト
	@Test
	public void testGetEmail1() {
		MyPageDTO dto = new MyPageDTO();
		String expected=null;

		dto.setEmail(expected);
		String actual=dto.getEmail();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail2() {
		MyPageDTO dto = new MyPageDTO();
		String expected="";

		dto.setEmail(expected);
		String actual= dto.getEmail();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetEmail3() {
		MyPageDTO dto = new MyPageDTO();
    	String expected=" ";

    	dto.setEmail(expected);
    	String actual=dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail4() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="　";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail5() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail6() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="あいう１２３";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail7() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail8() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }




	//登録日
	@Test
	public void testGetRegister_date1() {
		MyPageDTO dto = new MyPageDTO();
		String expected=null;

		dto.setRegister_date(expected);
		String actual=dto.getRegister_date();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetRegister_date2() {
		MyPageDTO dto = new MyPageDTO();
		String expected="";

		dto.setRegister_date(expected);
		String actual= dto.getRegister_date();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetRegister_date3() {
		MyPageDTO dto = new MyPageDTO();
    	String expected=" ";

    	dto.setRegister_date(expected);
    	String actual=dto.getRegister_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegister_date4() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="　";

    	dto.setRegister_date(expected);
    	String actual= dto.getRegister_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegister_date5() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123";

    	dto.setRegister_date(expected);
    	String actual= dto.getRegister_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegister_date6() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="あいう１２３";

    	dto.setRegister_date(expected);
    	String actual= dto.getRegister_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegister_date7() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３";

    	dto.setRegister_date(expected);
    	String actual= dto.getRegister_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegister_date8() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setRegister_date(expected);
    	String actual= dto.getRegister_date();

    	assertEquals(expected, actual);
    }




	//更新日
	@Test
	public void testGetUpdate_date1() {
		MyPageDTO dto = new MyPageDTO();
		String expected=null;

		dto.setUpdate_date(expected);
		String actual=dto.getUpdate_date();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetUpdate_date2() {
		MyPageDTO dto = new MyPageDTO();
		String expected="";

		dto.setUpdate_date(expected);
		String actual= dto.getUpdate_date();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetUpdate_date3() {
		MyPageDTO dto = new MyPageDTO();
    	String expected=" ";

    	dto.setUpdate_date(expected);
    	String actual=dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date4() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="　";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date5() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date6() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="あいう１２３";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date7() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date8() {
		MyPageDTO dto = new MyPageDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }

}
