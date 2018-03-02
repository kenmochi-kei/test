package com.internousdev.cherry.dto.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.internousdev.cherry.dto.CartInfoDTO;


public class CartInfoDTOTest {

	//商品価格に関するテスト
	@Test
	public void testGetPrice1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}

	@Test
	public void testGetPrice2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     int postalMax = 10000000;
		     dto.setPrice(postalMax);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetPrice5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try{
	    	int postalMin = -10000000;
	    	dto.setPrice(postalMin);

	    }catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
	    }
	}


	//カートIDに関するテスト
	@Test
	public void testGetCart_id1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setId(expected);

		assertEquals(expected, dto.getId());

	}
	@Test
	public void testGetCart_id2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetCart_id3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetCart_id4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetCart_id5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//ユーザーIDに関するテスト
	@Test
	public void testGetUser_id1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUser_id2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUser_id3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUser_id4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try {
	    	String postalMax = "2147483648";
	    	dto.setUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetUser_id5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     String postalMin = "-2147483649";
		     dto.setUserId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//一時ユーザーIDに関するテスト
	@Test
	public void testGetTempUserId1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setTempUserId(expected);

		assertEquals(expected, dto.getTempUserId());
	}
	@Test
	public void testGetTempUserId2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setTempUserId(expected);

		assertEquals(expected, dto.getTempUserId());
	}
	@Test
	public void testGetTempUserId3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setTempUserId(expected);

		assertEquals(expected, dto.getTempUserId());
	}
	@Test
	public void testGetTempUserId4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try {
	    	String postalMax = "2147483648";
	    	dto.setTempUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetTempUserId5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     String postalMin = "-2147483649";
		     dto.setTempUserId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//商品IDに関するテスト
	@Test
	public void testGetProductId1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483647;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try {
	    	String postalMax = "2147483648";
	    	dto.setTempUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetProductId5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     String postalMin = "-2147483649";
		     dto.setTempUserId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//商品在庫に関するテスト
	@Test
	public void testGetProductCount1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setProductCount(expected);

		assertEquals(expected, dto.getProductCount());
	}
	@Test
	public void testGetProductCount2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductCount(expected);

		assertEquals(expected, dto.getProductCount());
	}
	@Test
	public void testGetProductCount3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483647;

		dto.setProductCount(expected);

		assertEquals(expected, dto.getProductCount());
	}
	@Test
	public void testGetProductCount4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setProductCount(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetProductCount5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setProductCount(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//カートINSERT日
	@Test
	public void testGetRegistDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setRegistDate(expected);
		Date actual = dto.getRegistDate();

		assertEquals(expected,actual);
	}




	//カートUPDATE日
	@Test
	public void testGetUpdateDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setUpdateDate(expected);
		Date actual = dto.getUpdateDate();

		assertEquals(expected,actual);
	}

}
