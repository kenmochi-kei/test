package com.internousdev.cherry.dto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.internousdev.cherry.dto.PurchaseHistoryDTO;

public class PurchaseHistoryDTOTest {


	//IDに関するテスト
	@Test
	public void testGetDef_id1() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		int expected = 0;

		dto.setId(expected);

		assertEquals(expected, dto.getId());

	}
	@Test
	public void testGetDef_id2() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		int expected = 2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetDef_id3() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		int expected = -2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetDef_id4() throws Exception {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetDef_id5() throws Exception {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//商品名に関するテスト
	@Test
	public void testGetProductName1() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected=null;

		dto.setProductName(expected);
		String actual=dto.getProductName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProductName2() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected="";

		dto.setProductName(expected);
		String actual= dto.getProductName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProductName3() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected=" ";

    	dto.setProductName(expected);
    	String actual=dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName4() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="　";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName5() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName6() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="あいう１２３";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName7() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName8() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }



	//商品名（かな）に関するテスト
	@Test
	public void testGetProductNameKana1() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected=null;

		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProductNameKana2() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected="";

		dto.setProductNameKana(expected);
		String actual= dto.getProductNameKana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProductNameKana3() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected=" ";

    	dto.setProductNameKana(expected);
    	String actual=dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana4() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="　";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana5() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana6() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="あいう１２３";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana7() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana8() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }




	//商品価格に関するテスト
	@Test
	public void testGetPrice1() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		int expected = 0;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}

	@Test
	public void testGetPrice2() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		int expected = 9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice3() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		int expected = -9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice4() throws Exception {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		try {
		     int postalMax = 10000000;
		     dto.setPrice(postalMax);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetPrice5() throws Exception {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
	    try{
	    	int postalMin = -10000000;
	    	dto.setPrice(postalMin);

	    }catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
	    }
	}




	//個数に関するテスト
	@Test
	public void testGetCount1() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		int expected = 0;

		dto.setCount(expected);

		assertEquals(expected, dto.getCount());
	}

	@Test
	public void testGetCount2() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		int expected = 9999999;

		dto.setCount(expected);

		assertEquals(expected, dto.getCount());
	}
	@Test
	public void testGetCount3() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		int expected = -9999999;

		dto.setCount(expected);

		assertEquals(expected, dto.getCount());
	}
	@Test
	public void testGetCount4() throws Exception {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		try {
		     int postalMax = 10000000;
		     dto.setCount(postalMax);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetCount5() throws Exception {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
	    try{
	    	int postalMin = -10000000;
	    	dto.setCount(postalMin);

	    }catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
	    }
	}



	//発売元会社に関するテスト
	@Test
	public void testGetReleaseCompany1() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected=null;

		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetReleaseCompany2() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected="";

		dto.setReleaseCompany(expected);
		String actual= dto.getReleaseCompany();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetReleaseCompany3() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected=" ";

    	dto.setReleaseCompany(expected);
    	String actual=dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany4() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="　";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany5() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany6() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="あいう１２３";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany7() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany8() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }



	//発売日に関するテスト
	@Test
	public void testGetReleaseDate1() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected=null;

		dto.setReleaseDate(expected);
		String actual=dto.getReleaseDate();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetReleaseDate2() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected="";

		dto.setReleaseDate(expected);
		String actual= dto.getReleaseDate();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetReleaseDate3() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected=" ";

    	dto.setReleaseDate(expected);
    	String actual=dto.getReleaseDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseDate4() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="　";

    	dto.setReleaseDate(expected);
    	String actual= dto.getReleaseDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseDate5() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123";

    	dto.setReleaseDate(expected);
    	String actual= dto.getReleaseDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseDate6() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="あいう１２３";

    	dto.setReleaseDate(expected);
    	String actual= dto.getReleaseDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseDate7() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３";

    	dto.setReleaseDate(expected);
    	String actual= dto.getReleaseDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseDate8() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setReleaseDate(expected);
    	String actual= dto.getReleaseDate();

    	assertEquals(expected, actual);
    }


	//登録日に関するテスト
	@Test
	public void testGetRegistDate1() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected=null;

		dto.setRegistDate(expected);
		String actual=dto.getRegistDate();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetRegistDate2() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected="";

		dto.setRegistDate(expected);
		String actual= dto.getRegistDate();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetRegistDate3() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected=" ";

    	dto.setRegistDate(expected);
    	String actual=dto.getRegistDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegistDate4() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="　";

    	dto.setRegistDate(expected);
    	String actual= dto.getRegistDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegistDate5() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123";

    	dto.setRegistDate(expected);
    	String actual= dto.getRegistDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegistDate6() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="あいう１２３";

    	dto.setRegistDate(expected);
    	String actual= dto.getRegistDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegistDate7() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３";

    	dto.setRegistDate(expected);
    	String actual= dto.getRegistDate();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegistDate8() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setRegistDate(expected);
    	String actual= dto.getRegistDate();

    	assertEquals(expected, actual);
    }



	//登録日に関するテスト
	@Test
	public void testGetProductImage1() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected=null;

		dto.setProductImage(expected);
		String actual=dto.getProductImage();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProductImage2() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
		String expected="";

		dto.setProductImage(expected);
		String actual= dto.getProductImage();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProductImage3() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected=" ";

    	dto.setProductImage(expected);
    	String actual=dto.getProductImage();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductImage4() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="　";

    	dto.setProductImage(expected);
    	String actual= dto.getProductImage();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductImage5() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123";

    	dto.setProductImage(expected);
    	String actual= dto.getProductImage();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductImage6() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="あいう１２３";

    	dto.setProductImage(expected);
    	String actual= dto.getProductImage();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductImage7() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProductImage(expected);
    	String actual= dto.getProductImage();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductImage8() {
		PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProductImage(expected);
    	String actual= dto.getProductImage();

    	assertEquals(expected, actual);
    }


}
