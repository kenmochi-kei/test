package com.internousdev.cherry.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.Product_InfoDAO;
import com.internousdev.cherry.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;


public class TopAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;
	private List<ProductDTO> proList= new ArrayList<ProductDTO>();
	private static final long serialVersionUID = 1L;


	public String execute(){
		Product_InfoDAO dao = new Product_InfoDAO();
		RandomStringUtils rndStr=new RandomStringUtils();
		try {
			proList = dao.pro_list();
			session.put("proList",proList);
			if(!(session.containsKey("loginFlg"))){
				session.put("loginFlg", false);
				String userId=rndStr.randomAlphabetic(10);
				/*String userId=RandomStringUtils.randomAlphabetic(10);*/
				System.out.println(userId);
				session.put("tempUserId", userId);
				System.out.println(session.get("tempUserId").toString());
			}




		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public List<ProductDTO> getProList() {
		return proList;
	}


	public void setProList(List<ProductDTO> proList) {
		this.proList = proList;
	}


}
