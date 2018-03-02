package com.internousdev.cherry.dto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.internousdev.cherry.dto.CartInfoDTO;
import com.internousdev.cherry.dto.ProductDTO;

public class ProductDTOTest {



	//商品IDに関するテスト
	@Test
	public void testGetDef_id1() {
		ProductDTO dto = new ProductDTO();
		int expected = 0;

		dto.setDef_id(expected);

		assertEquals(expected, dto.getDef_id());

	}
	@Test
	public void testGetDef_id2() {
		ProductDTO dto = new ProductDTO();
		int expected = 2147483647;

		dto.setDef_id(expected);

		assertEquals(expected, dto.getDef_id());
	}
	@Test
	public void testGetDef_id3() {
		ProductDTO dto = new ProductDTO();
		int expected = -2147483647;

		dto.setDef_id(expected);

		assertEquals(expected, dto.getDef_id());
	}
	@Test
	public void testGetDef_id4() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setDef_id(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetDef_id5() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setDef_id(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//商品IDに関するテスト
	@Test
	public void testGetProduct_id1() {
		ProductDTO dto = new ProductDTO();
		int expected = 0;

		dto.setProduct_id(expected);

		assertEquals(expected, dto.getProduct_id());

	}
	@Test
	public void testGetProduct_id2() {
		ProductDTO dto = new ProductDTO();
		int expected = 2147483647;

		dto.setProduct_id(expected);

		assertEquals(expected, dto.getProduct_id());
	}
	@Test
	public void testGetProduct_id3() {
		ProductDTO dto = new ProductDTO();
		int expected = -2147483647;

		dto.setProduct_id(expected);

		assertEquals(expected, dto.getProduct_id());
	}
	@Test
	public void testGetProduct_id4() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setProduct_id(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetProduct_id5() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setProduct_id(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//名に関するテスト
	@Test
	public void testGetProduct_name1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setProduct_name(expected);
		String actual=dto.getProduct_name();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProduct_name2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setProduct_name(expected);
		String actual= dto.getProduct_name();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProduct_name3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setProduct_name(expected);
    	String actual=dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }




	//商品名（かな）に関するテスト
	@Test
	public void testGetProduct_name_kana1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setProduct_name_kana(expected);
		String actual=dto.getProduct_name_kana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProduct_name_kana2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setProduct_name_kana(expected);
		String actual= dto.getProduct_name_kana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProduct_name_kana3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setProduct_name_kana(expected);
    	String actual=dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }




	//商品説明に関するテスト
	@Test
	public void testGetProduct_description1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setProduct_description(expected);
		String actual=dto.getProduct_description();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProduct_description2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setProduct_description(expected);
		String actual= dto.getProduct_description();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProduct_description3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setProduct_description(expected);
    	String actual=dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }



	//カテゴリーIDに関するテスト
	@Test
	public void testGetCategory_id1() {
		ProductDTO dto = new ProductDTO();
		int expected = 0;

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());

	}
	@Test
	public void testGetCategory_id2() {
		ProductDTO dto = new ProductDTO();
		int expected = 2147483647;

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());
	}
	@Test
	public void testGetCategory_id3() {
		ProductDTO dto = new ProductDTO();
		int expected = -2147483647;

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());
	}
	@Test
	public void testGetCategory_id4() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setCategory_id(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetCategory_id5() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setCategory_id(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//商品価格に関するテスト
	@Test
	public void testGetPrice1() {
		ProductDTO dto = new ProductDTO();
		int expected = 0;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}

	@Test
	public void testGetPrice2() {
		ProductDTO dto = new ProductDTO();
		int expected = 9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice3() {
		ProductDTO dto = new ProductDTO();
		int expected = -9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice4() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     int postalMax = 10000000;
		     dto.setPrice(postalMax);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetPrice5() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	int postalMin = -10000000;
	    	dto.setPrice(postalMin);

	    }catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
	    }
	}





	//商品説明に関するテスト
	@Test
	public void testGetImage_file_name1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setImage_file_name(expected);
		String actual=dto.getImage_file_name();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetImage_file_name2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setImage_file_name(expected);
		String actual= dto.getImage_file_name();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetImage_file_name3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setImage_file_name(expected);
    	String actual=dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }




	//発売日（!=登録日）
	@Test
	public void testGetRelease_date1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setRelease_date(expected);
		String actual=dto.getRelease_date();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetRelease_date2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setRelease_date(expected);
		String actual= dto.getRelease_date();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetRelease_date3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setRelease_date(expected);
    	String actual=dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }




	//出品会社
	@Test
	public void testGetRelease_company1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setRelease_company(expected);
		String actual=dto.getRelease_company();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetRelease_company2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setRelease_company(expected);
		String actual= dto.getRelease_company();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetRelease_company3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setRelease_company(expected);
    	String actual=dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }


	//ステータス
	@Test
	public void testGetStatus1() {
		ProductDTO dto = new ProductDTO();
		String expected = "0";

		dto.setStatus(expected);

		assertEquals(expected, dto.getStatus());

	}
	@Test
	public void testGetStatus2() {
		ProductDTO dto = new ProductDTO();
		String expected = "2147483647";

		dto.setStatus(expected);

		assertEquals(expected, dto.getStatus());
	}
	@Test
	public void testGetStatus3() {
		ProductDTO dto = new ProductDTO();
		String expected = "-2147483647";

		dto.setStatus(expected);

		assertEquals(expected, dto.getStatus());
	}
	@Test
	public void testGetStatus4() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	String postalMax = "2147483648";
	    	dto.setStatus(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetStatus5() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     String postalMin = "-2147483649";
		     dto.setStatus(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//登録日（!=発売日）
	@Test
	public void testGetRegist_date1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setRegist_date(expected);
		String actual=dto.getRegist_date();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetRegist_date2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setRegist_date(expected);
		String actual= dto.getRegist_date();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetRegist_date3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setRegist_date(expected);
    	String actual=dto.getRegist_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegist_date4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setRegist_date(expected);
    	String actual= dto.getRegist_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegist_date5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setRegist_date(expected);
    	String actual= dto.getRegist_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegist_date6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setRegist_date(expected);
    	String actual= dto.getRegist_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegist_date7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setRegist_date(expected);
    	String actual= dto.getRegist_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRegist_date8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setRegist_date(expected);
    	String actual= dto.getRegist_date();

    	assertEquals(expected, actual);
    }



	//登録日（!=発売日）
	@Test
	public void testGetUpdate_date1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setUpdate_date(expected);
		String actual=dto.getUpdate_date();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetUpdate_date2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setUpdate_date(expected);
		String actual= dto.getUpdate_date();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetUpdate_date3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setUpdate_date(expected);
    	String actual=dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetUpdate_date8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setUpdate_date(expected);
    	String actual= dto.getUpdate_date();

    	assertEquals(expected, actual);
    }




	//商品在庫
	@Test
	public void testGetStock1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setStock(expected);

		assertEquals(expected, dto.getStock());
	}

	@Test
	public void testGetStock2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 9999999;

		dto.setStock(expected);

		assertEquals(expected, dto.getStock());
	}
	@Test
	public void testGetStock3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -9999999;

		dto.setStock(expected);

		assertEquals(expected, dto.getStock());
	}
	@Test
	public void testGetStock4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     int postalMax = 10000000;
		     dto.setStock(postalMax);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetStock5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try{
	    	int postalMin = -10000000;
	    	dto.setStock(postalMin);

	    }catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
	    }
	}





}
