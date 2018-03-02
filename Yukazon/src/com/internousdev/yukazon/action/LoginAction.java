package com.internousdev.yukazon.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yukazon.dao.BuyItemDAO;
import com.internousdev.yukazon.dao.LoginDAO;
import com.internousdev.yukazon.dto.BuyItemDTO;
import com.internousdev.yukazon.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *↓ログイン認証処理
 * Login.jspからログインID、PASSを受け取りDAO,DTOを通してDBへ問い合わせる
 * @author internous
 * @param loginUserId
 * @param loginPassword
 *
 * @return result
 */
public class LoginAction extends ActionSupport implements SessionAware{
	//ユーザーID
	private String loginUserId;
	//パスワード
	private String loginPassword;
	//ログイン情報を格納しておくMap
	public Map<String, Object> session;
	// ログイン情報取得DAO
	private LoginDAO ldao = new LoginDAO();
	//ログイン情報格納DTO
	private LoginDTO ldto = new LoginDTO();
	//アイテム情報を取得
	private BuyItemDAO bdao=new BuyItemDAO();
	private BuyItemDTO bdto=new BuyItemDTO();
	private List<BuyItemDTO> bdtoList;

	/* 実行メソッドexecute--------------------------------------- */
	public String execute() {
		//resultに初期値EROORを代入
		String result = ERROR;

		// LoginDAOのgetLoginUserInfoメソッドの結果をldtoに代入
		ldto = ldao.getLoginUserInfo(loginUserId, loginPassword);
		//上のldtoを"loginUser"というkeyでsessionに置いておく
		session.put("loginUser", ldto);
		/* ログイン情報を比較-------------------------------------------------- */
		// 管理者か、一般かログイン情報を比較
		if(((LoginDTO) session.get("loginUser")).getLoginMaster()){
			//管理者画面で在庫確認などのときにsession使えるようにMap作っておく
			bdtoList=bdao.getBuyItemInfo();
			session.put("buyItemDTOList", bdtoList);
			session.put("masterId",loginUserId);
			//dtoにsetしたLoginMasterと合えば管理者とし"result"に"master"を代入
			result = "master";
		}
		//もし管理者ではなかったら
		if(result != "master"){
			//LoginDTO型にキャスト→Object型のsessionをLoginDTO型に変更
			//(Object型はそのままgetできないので)
			// ※jspでは自動的にObject型→String型に変更してくれる
			//LoginDTO型にキャストしたsessionの"LoginFlg"を呼び出す
			if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
				//"result"に"SUCCESS"を代入
				result = SUCCESS;

				/* アイテム情報を取得-------------------------------------------------- */
				//BuyItemDAOのgetBuyItemInfoメソッドの結果をbdtoに代入
				bdtoList=bdao.getBuyItemInfo();
				// BuyItemActionで利用したいからsessionに置いておく
				session.put("buyItemDTOList", bdtoList);
				session.put("id", bdto.getId());
				session.put("login_user_id",ldto.getLoginId());
			}
		}
		return result;
	}

	//ログイン情報とsessionはprivateにしているため呼び出せるようにしておく
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public List<BuyItemDTO> getBuyItemDTOList(){
		return bdtoList;
	}
	public void setBuyItemDTOList(List<BuyItemDTO> bdtoList){
		this.bdtoList=bdtoList;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}