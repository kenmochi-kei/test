package com.internousdev.cherry.dto.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.internousdev.cherry.dto.SearchDTO;

public class SearchDTOTest{



	//自動生成IDに関するテスト
	@Test
	public void testGetId1() {
		SearchDTO dto = new SearchDTO();
		int expected = 0;

		dto.setId(expected);

		assertEquals(expected, dto.getId());

	}
	@Test
	public void testGetId2() {
		SearchDTO dto = new SearchDTO();
		int expected = 2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId3() {
		SearchDTO dto = new SearchDTO();
		int expected = -2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId4() throws Exception {
		SearchDTO dto = new SearchDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetId5() throws Exception {
		SearchDTO dto = new SearchDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//商品IDに関するテスト
	@Test
	public void testGetProductId1() {
		SearchDTO dto = new SearchDTO();
		int expected = 0;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());

	}
	@Test
	public void testGetProductId2() {
		SearchDTO dto = new SearchDTO();
		int expected = 2147483647;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId3() {
		SearchDTO dto = new SearchDTO();
		int expected = -2147483647;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId4() throws Exception {
		SearchDTO dto = new SearchDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setProductId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetProductId5() throws Exception {
		SearchDTO dto = new SearchDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setProductId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//商品名に関するテスト
	@Test
	public void testGetProductName1() {
		SearchDTO dto = new SearchDTO();
		String expected=null;

		dto.setProductName(expected);
		String actual=dto.getProductName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProductName2() {
		SearchDTO dto = new SearchDTO();
		String expected="";

		dto.setProductName(expected);
		String actual= dto.getProductName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProductName3() {
		SearchDTO dto = new SearchDTO();
    	String expected=" ";

    	dto.setProductName(expected);
    	String actual=dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName4() {
		SearchDTO dto = new SearchDTO();
    	String expected ="　";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName5() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName6() {
		SearchDTO dto = new SearchDTO();
    	String expected ="あいう１２３";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName7() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName8() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }




	//商品名に関するテスト
	@Test
	public void testGetProductNameKana1() {
		SearchDTO dto = new SearchDTO();
		String expected=null;

		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProductNameKana2() {
		SearchDTO dto = new SearchDTO();
		String expected="";

		dto.setProductNameKana(expected);
		String actual= dto.getProductNameKana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProductNameKana3() {
		SearchDTO dto = new SearchDTO();
    	String expected=" ";

    	dto.setProductNameKana(expected);
    	String actual=dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana4() {
		SearchDTO dto = new SearchDTO();
    	String expected ="　";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana5() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana6() {
		SearchDTO dto = new SearchDTO();
    	String expected ="あいう１２３";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana7() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana8() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }



	//商品名に関するテスト
	@Test
	public void testGetProductDescription1() {
		SearchDTO dto = new SearchDTO();
		String expected=null;

		dto.setProductDescription(expected);
		String actual=dto.getProductDescription();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProductDescription2() {
		SearchDTO dto = new SearchDTO();
		String expected="";

		dto.setProductDescription(expected);
		String actual= dto.getProductDescription();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProductDescription3() {
		SearchDTO dto = new SearchDTO();
    	String expected=" ";

    	dto.setProductDescription(expected);
    	String actual=dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription4() {
		SearchDTO dto = new SearchDTO();
    	String expected ="　";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription5() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription6() {
		SearchDTO dto = new SearchDTO();
    	String expected ="あいう１２３";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription7() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription8() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }





	//カテゴリーIDに関するテスト
	@Test
	public void testGetCategoryId1() {
		SearchDTO dto = new SearchDTO();
		int expected = 0;

		dto.setCategoryId(expected);

		assertEquals(expected, dto.getCategoryId());

	}
	@Test
	public void testGetCategoryId2() {
		SearchDTO dto = new SearchDTO();
		int expected = 2147483647;

		dto.setCategoryId(expected);

		assertEquals(expected, dto.getCategoryId());
	}
	@Test
	public void testGetCategoryId3() {
		SearchDTO dto = new SearchDTO();
		int expected = -2147483647;

		dto.setCategoryId(expected);

		assertEquals(expected, dto.getCategoryId());
	}
	@Test
	public void testGetCategoryId4() throws Exception {
		SearchDTO dto = new SearchDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setCategoryId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetCategoryId5() throws Exception {
		SearchDTO dto = new SearchDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setCategoryId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//商品価格に関するテスト
	@Test
	public void testGetPrice1() {
		SearchDTO dto = new SearchDTO();
		int expected = 0;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}

	@Test
	public void testGetPrice2() {
		SearchDTO dto = new SearchDTO();
		int expected = 9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice3() {
		SearchDTO dto = new SearchDTO();
		int expected = -9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice4() throws Exception {
		SearchDTO dto = new SearchDTO();
		try {
		     int postalMax = 10000000;
		     dto.setPrice(postalMax);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetPrice5() throws Exception {
		SearchDTO dto = new SearchDTO();
	    try{
	    	int postalMin = -10000000;
	    	dto.setPrice(postalMin);

	    }catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
	    }
	}




	//商品画像パスに関するテスト
	@Test
	public void testGetImageFileName1() {
		SearchDTO dto = new SearchDTO();
		String expected=null;

		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetImageFileName2() {
		SearchDTO dto = new SearchDTO();
		String expected="";

		dto.setImageFileName(expected);
		String actual= dto.getImageFileName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetImageFileName3() {
		SearchDTO dto = new SearchDTO();
    	String expected=" ";

    	dto.setImageFileName(expected);
    	String actual=dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName4() {
		SearchDTO dto = new SearchDTO();
    	String expected ="　";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName5() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName6() {
		SearchDTO dto = new SearchDTO();
    	String expected ="あいう１２３";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName7() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName8() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }




	//発売日
	@Test
	public void testGetReleaseDate1() {
		SearchDTO dto = new SearchDTO();
		Date expected = null;

		dto.setReleaseDate(expected);
		Date actual=dto.getReleaseDate();

		assertEquals(expected,actual);
	}



	//商品画像パスに関するテスト
	@Test
	public void testGetReleaseCompany1() {
		SearchDTO dto = new SearchDTO();
		String expected=null;

		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetReleaseCompany2() {
		SearchDTO dto = new SearchDTO();
		String expected="";

		dto.setReleaseCompany(expected);
		String actual= dto.getReleaseCompany();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetReleaseCompany3() {
		SearchDTO dto = new SearchDTO();
    	String expected=" ";

    	dto.setReleaseCompany(expected);
    	String actual=dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany4() {
		SearchDTO dto = new SearchDTO();
    	String expected ="　";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany5() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany6() {
		SearchDTO dto = new SearchDTO();
    	String expected ="あいう１２３";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany7() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany8() {
		SearchDTO dto = new SearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }



	//ステータス
	@Test
    public void testGetStatus1() {
		SearchDTO dto = new SearchDTO();
    	short expected =1;

    	dto.setStatus(expected);
    	short actual = dto.getStatus();
    	assertEquals(expected, actual);
    }
	@Test
    public void testGetStatus2() {
		SearchDTO dto = new SearchDTO();
    	short expected =0;

    	dto.setStatus(expected);
    	short actual= dto.getStatus();

    	assertEquals(expected, actual);
    }



	//登録日
	@Test
	public void testGetRegistDate1() {
		SearchDTO dto = new SearchDTO();
		Date expected = null;

		dto.setRegistDate(expected);
		Date actual=dto.getRegistDate();

		assertEquals(expected,actual);
	}



	//更新日
	@Test
	public void testGetUpdateDate1() {
		SearchDTO dto = new SearchDTO();
		Date expected = null;

		dto.setUpdateDate(expected);
		Date actual=dto.getUpdateDate();

		assertEquals(expected,actual);
	}


}
