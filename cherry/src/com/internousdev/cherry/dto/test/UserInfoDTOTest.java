package com.internousdev.cherry.dto.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.internousdev.cherry.dto.UserInfoDTO;

public class UserInfoDTOTest {



	//自動生成IDに関するテスト
	@Test
	public void testGetId1() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 0;

		dto.setId(expected);

		assertEquals(expected, dto.getId());

	}
	@Test
	public void testGetId2() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId3() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = -2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId4() throws Exception {
		UserInfoDTO dto = new UserInfoDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetId5() throws Exception {
		UserInfoDTO dto = new UserInfoDTO();
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
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());

	}
	@Test
	public void testGetUserId2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUserId3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUserId4() throws Exception {
		UserInfoDTO dto = new UserInfoDTO();
	    try{
	    	String postalMax = "2147483648";
	    	dto.setUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetUserId5() throws Exception {
		UserInfoDTO dto = new UserInfoDTO();
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
		UserInfoDTO dto = new UserInfoDTO();
		String expected=null;

		dto.setPassword(expected);
		String actual=dto.getPassword();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected="";

		dto.setPassword(expected);
		String actual= dto.getPassword();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetPassword3() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected=" ";

    	dto.setPassword(expected);
    	String actual=dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword4() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="　";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword5() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword6() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="あいう１２３";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword7() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetPassword8() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setPassword(expected);
    	String actual= dto.getPassword();

    	assertEquals(expected, actual);
    }



	//名に関するテスト
	@Test
	public void testGetFamilyName1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected=null;

		dto.setFamilyName(expected);
		String actual=dto.getFamilyName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected="";

		dto.setFamilyName(expected);
		String actual= dto.getFamilyName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFamilyName3() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected=" ";

    	dto.setFamilyName(expected);
    	String actual=dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName4() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="　";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName5() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName6() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="あいう１２３";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName7() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyName8() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFamilyName(expected);
    	String actual= dto.getFamilyName();

    	assertEquals(expected, actual);
    }




	//姓に関するテスト
	@Test
	public void testGetFirstName1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected=null;

		dto.setFirstName(expected);
		String actual=dto.getFirstName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected="";

		dto.setFirstName(expected);
		String actual= dto.getFirstName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFirstName3() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected=" ";

    	dto.setFirstName(expected);
    	String actual=dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName4() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="　";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName5() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName6() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="あいう１２３";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName7() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstName8() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFirstName(expected);
    	String actual= dto.getFirstName();

    	assertEquals(expected, actual);
    }




	//名（かな）に関するテスト
	@Test
	public void testGetFamilyNameKana1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected=null;

		dto.setFamilyNameKana(expected);
		String actual=dto.getFamilyNameKana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected="";

		dto.setFamilyNameKana(expected);
		String actual= dto.getFamilyNameKana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFamilyNameKana3() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected=" ";

    	dto.setFamilyNameKana(expected);
    	String actual=dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana4() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="　";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana5() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana6() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="あいう１２３";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana7() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFamilyNameKana8() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFamilyNameKana(expected);
    	String actual= dto.getFamilyNameKana();

    	assertEquals(expected, actual);
    }



	//姓（かな）に関するテスト
	@Test
	public void testGetFirstNameKana1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected=null;

		dto.setFirstNameKana(expected);
		String actual=dto.getFirstNameKana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected="";

		dto.setFirstNameKana(expected);
		String actual= dto.getFirstNameKana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetFirstNameKana3() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected=" ";

    	dto.setFirstNameKana(expected);
    	String actual=dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana4() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="　";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana5() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana6() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="あいう１２３";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana7() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetFirstNameKana8() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setFirstNameKana(expected);
    	String actual= dto.getFirstNameKana();

    	assertEquals(expected, actual);
    }



	//性別テスト
	@Test
    public void testIsSex1() {
		UserInfoDTO dto = new UserInfoDTO();
    	boolean expected = true;

    	dto.setSex(expected);
    	boolean actual= dto.isSex();

    	assertEquals(expected, actual);
    }
	@Test
    public void testIsSex2() {
		UserInfoDTO dto = new UserInfoDTO();
    	boolean expected =false;

    	dto.setSex(expected);
    	boolean actual= dto.isSex();

    	assertEquals(expected, actual);
    }




	//Emailに関するテスト
	@Test
	public void testGetEmail1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected=null;

		dto.setEmail(expected);
		String actual=dto.getEmail();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected="";

		dto.setEmail(expected);
		String actual= dto.getEmail();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetEmail3() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected=" ";

    	dto.setEmail(expected);
    	String actual=dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail4() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="　";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail5() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail6() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="あいう１２３";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail7() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetEmail8() {
		UserInfoDTO dto = new UserInfoDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setEmail(expected);
    	String actual= dto.getEmail();

    	assertEquals(expected, actual);
    }



	//商品ステータスに関するテスト
	@Test
    public void testIsStatus1() {
		UserInfoDTO dto = new UserInfoDTO();
    	boolean expected = true;

    	dto.setStatus(expected);
    	boolean actual= dto.isStatus();

    	assertEquals(expected, actual);
    }
	@Test
    public void testIsStatus2() {
		UserInfoDTO dto = new UserInfoDTO();
    	boolean expected =false;

    	dto.setStatus(expected);
    	boolean actual= dto.isStatus();

    	assertEquals(expected, actual);
    }



	//ログインステータスに関するテスト
	@Test
    public void testIsLogin1() {
		UserInfoDTO dto = new UserInfoDTO();
    	boolean expected = true;

    	dto.setLogined(expected);
    	boolean actual= dto.isLogined();

    	assertEquals(expected, actual);
    }
	@Test
    public void testIsLogin2() {
		UserInfoDTO dto = new UserInfoDTO();
    	boolean expected =false;

    	dto.setLogined(expected);
    	boolean actual= dto.isLogined();

    	assertEquals(expected, actual);
    }



	//登録日
	@Test
	public void testGetRegister_date1() {
		UserInfoDTO dto = new UserInfoDTO();
		Date expected = null;

		dto.setRegister_date(expected);
		Date actual=dto.getRegister_date();

		assertEquals(expected,actual);
	}



	//更新日
	@Test
	public void testGetUpdate_date1() {
		UserInfoDTO dto = new UserInfoDTO();
		Date expected = null;

		dto.setUpdate_date(expected);
		Date actual=dto.getUpdate_date();

		assertEquals(expected,actual);
	}

}
