/**
 *
 */
package com.internousdev.solare.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.PaymentInformationDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * PaymentInformationAction クレジットカードの情報を取得し、セッションに格納するクラス
 *
 * @version 1.0
 * @since 1.0
 */
public class PaymentInformationAction extends ActionSupport implements SessionAware {

	/**
	 *
	 */

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @version 1.0
	 * @since 1.0
	 *
	 */
	private static final long serialVersionUID = 8910913364964151265L;

	/**
	 * セッション
	 *
	 * @version 1.0
	 * @since 1.0
	 */
    private Map<String,Object> session;

    /**
	 * クレジットカード種別
	 *
	 * @version 1.0
	 * @since 1.0
	 */
    private String card;

    /**
	 * クレジットカード番号
	 *
	 * @version 1.0
	 * @since 1.0
	 */
    private String cardNumber;

    /**
	 * 有効期限(月)
	 *
	 * @version 1.0
	 * @since 1.0
	 */
    private String cardMonth;

    /**
	 * 有効期限(年)
	 *
	 * @version 1.0
	 * @since 1.0
	 */
    private String cardYear;

    /**
	 * クレジットカード名義
	 *
	 * @version 1.0
	 * @since 1.0
	 */
    private String cardHolder;

    /**
	 * セキュリティコード
	 *
	 * @version 1.0
	 * @since 1.0
	 */
    private String securityCode;

    /**
	 * 一時テーブルのID
	 *
	 * @version 1.0
	 * @since 1.0
	 */
    private int tempId;
    
    /**
	 * エラーメッセージ
	 *
	 * @version 1.0
	 * @since 1.0
	 */
    private String errorMessage;

    /**
	 * kuruyamaデータベースのtempテーブルにクレジットカード情報を登録し、tempIdを取得できたらサクセスを返す
	 *
	 * @return SUCCESS tempIdをセッションに格納し、SUCCESSを返します。
	 */
    public String execute(){
        if(card.equals("")
                || cardNumber.equals("")
                || cardMonth.equals("")
                || cardYear.equals("")
                || cardHolder.equals("")
                || securityCode.equals("")){
            errorMessage = getText("cardInfmation");
            return ERROR;
        }
        PaymentInformationDAO dao = new PaymentInformationDAO();
        if(dao.deleteTemp()<0){
            return ERROR;
        }
        if( dao.insertTemp(cardNumber, cardMonth, cardYear, cardHolder, securityCode)<0){
            return ERROR;
        }
        tempId = dao.getTempId();
        if(tempId < 1){
            return ERROR;
        }
        session.put("tempId", tempId);
        return SUCCESS;
    }

    /**
	 * セッションを取得するメソッド
	 *
	 * @return session セッション
	 */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
	 * セッションを格納するメソッド
	 *
	 * @param session
	 *            セッション
	 */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
	 * クレジットカード種別を取得するメソッド
	 *
	 * @return card クレジットカード種別
	 */
    public String getCard() {
        return card;
    }


	/**
	 * クレジットカード種別を格納するメソッド
	 *
	 * @param card
	 *            クレジットカード種別
	 */
    public void setCard(String card) {
        this.card = card;
    }

    /**
	 * クレジットカード番号を取得するメソッド
	 *
	 * @return cardNumber クレジットカード番号
	 */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
	 * クレジットカード番号を格納するメソッド
	 *
	 * @param cardNumber
	 *            クレジットカード番号
	 */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
	 * 有効期限(年)を格納するメソッド
	 *
	 * @param cardYear
	 *            有効期限(年)
	 */
    public String getCardMonth() {
        return cardMonth;
    }

    /**
	 * 有効期限(年)を取得するメソッド
	 *
	 * @return cardYear 有効期限(年)
	 */
    public void setCardMonth(String cardMonth) {
        this.cardMonth = cardMonth;
    }

    /**
	 * 有効期限(年)を格納するメソッド
	 *
	 * @param cardYear
	 *            有効期限(年)
	 */
    public String getCardYear() {
        return cardYear;
    }

    /**
	 * 有効期限(年)を格納するメソッド
	 *
	 * @param cardYear
	 *            有効期限(年)
	 */
    public void setCardYear(String cardYear) {
        this.cardYear = cardYear;
    }

    /**
	 * クレジットカード名義を取得するメソッド
	 *
	 * @return cardHolder クレジットカード名義
	 */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
	 * クレジットカード名義を格納するメソッド
	 *
	 * @param cardHolder
	 *            クレジットカード名義
	 */
    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
	 * セキュリティコードを取得するメソッド
	 *
	 * @return securityCode セキュリティコード
	 */
    public String getSecurityCode() {
        return securityCode;
    }

    /**
	 * セキュリティコードを格納するメソッド
	 *
	 * @param securityCode
	 *            セキュリティコード
	 */
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    /**
	 * @return errorMessage
	 */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
	 * @param errorMessage
	 *            セットする errorMessage
	 */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
