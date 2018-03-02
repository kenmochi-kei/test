package com.internousdev.cherry.dto;


public class PurchaseHistoryDTO {
	private int id;
	//商品名
	private String productName;

	//商品名かな
	private String productNameKana;

	//商品画像
	private String productImage;

	//値段
	private int price;

	//個数
	private int count;

	//発売会社
	private String releaseCompany;

	//発売年月日
	private String releaseDate;

	//注文日
	private String registDate;

/*----------------------ゲッ他セッタ--------------------------------*/
	//ID
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	//商品名
	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}

	//商品名かな
	public String getProductNameKana(){
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}

	//値段
	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}

	//個数
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}

	//発売会社
	public String getReleaseCompany(){
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}

	//発売年月日
	public String getReleaseDate(){
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	//注文日
	public String getRegistDate(){
		return registDate;
	}
	public void setRegistDate(String registDate){
		this.registDate = registDate;
	}


	//商品画像
	public String getProductImage(){
		return productImage;
	}
	public void setProductImage(String productImage){
		this.productImage = productImage;
	}
}






