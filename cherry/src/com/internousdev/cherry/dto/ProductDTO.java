package com.internousdev.cherry.dto;

import java.io.Serializable;


public class ProductDTO implements Serializable{

	private int def_id;
	private int product_id;
	private String product_name;
	private String product_name_kana;
	private String product_description;
	private int category_id;
	private int price;
	private int stock;
	private String image_file_name;
	private String release_date;
	private String release_company;
	private String status;
	private String regist_date;
	private String update_date;

	public ProductDTO(){};

	//商品テーブル取得
	public ProductDTO(int def_id, int product_id, String product_name, String product_name_kana, String product_description, int category_id, int price, int stock, String image_file_name, String release_date, String release_company, String status, String regist_date, String update_date){
		this.def_id = def_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_name_kana = product_name_kana;
		this.product_description = product_description;
		this.category_id = category_id;
		this.price = price;
		this.stock = stock;
		this.image_file_name = image_file_name;
		this.release_date = release_date;
		this.release_company = release_company;
		this.status = status;
		this.regist_date = regist_date;
		this.update_date = update_date;
	}

	public int getDef_id() {
		return def_id;
	}

	public void setDef_id(int def_id) {
		this.def_id = def_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_name_kana() {
		return product_name_kana;
	}

	public void setProduct_name_kana(String product_name_kana) {
		this.product_name_kana = product_name_kana;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public String getImage_file_name() {
		return image_file_name;
	}

	public void setImage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getRelease_company() {
		return release_company;
	}

	public void setRelease_company(String release_company) {
		this.release_company = release_company;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}











}
