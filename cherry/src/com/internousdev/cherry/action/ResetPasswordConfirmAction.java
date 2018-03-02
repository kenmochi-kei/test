
package com.internousdev.cherry.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordDAO;
import com.internousdev.cherry.dto.UserInfoDTO;
import com.internousdev.cherry.util.ErrorMessageConstants;
import com.internousdev.cherry.util.InputChecker;
import com.internousdev.cherry.util.RandomTokenizer;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware,ErrorMessageConstants {

	//ユーザーID
	private String userId;
	//新規パスワード
	private String password;
	//確認用パスワード
	private String passwordc;

	//分割して*に変換する部分のパスワード
	private String confirmpass1;
	private String confirmpass2;
	private String confirmpass3;
	private String confirmpass4;
	private String confirmpass5;
	private String confirmpass6;
	private String confirmpass7;
	private String confirmpass8;
	private String confirmpass9;
	private String confirmpass10;
	private String confirmpass11;
	private String confirmpass12;
	private String confirmpass13;
	private String confirmpass14;
	private String confirmpass01;
	private String confirmpass02;
	private String confirmpass1n;

	//確認画面で表示するパスワード
	private String s;

	//エラーメッセージリスト
	private ArrayList<String> errMsgList = new ArrayList<>();
	//セッション
	public Map<String,Object> session;
	//DAO,DTO
	private ResetPasswordDAO DAO = new ResetPasswordDAO();
	private UserInfoDTO userInfoDTO = new UserInfoDTO();

	//メソッドの実行
	public String execute(){
	//----------トークン生成------------
		if(new RandomTokenizer().checkToken(session)) return ERROR;
		System.out.println(String.valueOf(session.get("token")));
		session.put("nextToken",String.valueOf(session.get("nextToken")));
		//----------------------------------------
		String result =SUCCESS;
		userInfoDTO=DAO.UserInfoByUserId(userId);
		String str=userInfoDTO.getUserId();

		//インプットチェッカー利用して条件判定とエラーメッセージ表示
		InputChecker i = new InputChecker();
		if(!i.userIdChk(userId).equals("OK")){
			errMsgList.add(i.userIdChk(userId));
			result = ERROR;
		}
		if(!i.passwordChk(password).equals("OK")){
			errMsgList.add(i.passwordChk(password));
			result = ERROR;
		}
		if(!i.passwordcChk(passwordc,password).equals("OK")){
			errMsgList.add(i.passwordcChk(passwordc,password));
			result = ERROR;
		}

		//入力されたuserIdがDBにあるか(会員登録済みか)チェック
		if(i.userIdChk(userId).equals("OK")
				&& i.passwordChk(password).equals("OK")
				&& i.passwordcChk(passwordc,password).equals("OK")){
			if(str==null || str.isEmpty()){
			errMsgList.add("このIDは存在しません。登録済みのIDを入力してください。");
			result = ERROR;
			}
		}

		//パスワード1文字の時はそのまま表示
		if(password.length() < 2){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			s = password;
		//パスワード2文字の時は先頭1文字のみ表示
		}else if(password.length() < 3){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass01 = password.substring(0,1);
			confirmpass1 = password.substring(1).replaceAll("^[0-9a-zA-Z]+$","*");
			s = confirmpass01 + confirmpass1;
		//パスワード3文字以上の時は先頭2文字のみ表示
		}else if(password.length() < 4){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass1n = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","*");
			s = confirmpass02 + confirmpass1n;
		}else if(password.length() < 5){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass2 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","**");
			s = confirmpass02 + confirmpass2;
		}else if(password.length() < 6){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass3 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","***");
			s = confirmpass02 + confirmpass3;
		}else if(password.length() < 7){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass4 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","****");
			s = confirmpass02 + confirmpass4;
		}else if(password.length() < 8){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass5 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","*****");
			s = confirmpass02 + confirmpass5;
		}else if(password.length() < 9){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass6 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","******");
			s = confirmpass02 + confirmpass6;
		}else if(password.length() < 10){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass7 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","*******");
			s = confirmpass02 + confirmpass7;
		}else if(password.length() < 11){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass8 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","********");
			s = confirmpass02 + confirmpass8;
		}else if(password.length() < 12){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass9 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","*********");
			s = confirmpass02 + confirmpass9;
		}else if(password.length() < 13){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass10 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","**********");
			s = confirmpass02 + confirmpass10;
		}else if(password.length() < 14){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass11 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","***********");
			s = confirmpass02 + confirmpass11;
		}else if(password.length() < 15){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass12 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","************");
			s = confirmpass02 + confirmpass12;
		}else if(password.length() < 16){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass13 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","*************");
			s = confirmpass02 + confirmpass13;
		}else{
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass02 = password.substring(0,2);
			confirmpass14 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","**************");
			s = confirmpass02 + confirmpass14;
		}


		 System.out.println("userIDは"+userInfoDTO.getUserId());

		return result;
	}


	//ユーザーIDのゲッターセッター
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	//新規パスワードのゲッターセッター
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//確認用パスワードのゲッターセッター
	public String getPasswordc() {
		return passwordc;
	}
	public void setPasswordc(String passwordc) {
		this.passwordc = passwordc;
	}

	//DAO,DTOのゲッター、セッター
	public ResetPasswordDAO getDAO() {
		return DAO;
	}
	public void setDAO(ResetPasswordDAO dAO) {
		DAO = dAO;
	}
	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}
	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}


	//確認画面用パスワードのゲッターセッター
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}

	//エラーメッセージのゲッターセッター
	public ArrayList<String> getErrMsgList() {
		return errMsgList;
	}
	public void setErrMsgList(ArrayList<String> errMsgList) {
		this.errMsgList = errMsgList;
	}

	//セッションのゲッターセッター
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
