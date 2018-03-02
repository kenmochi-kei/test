/**
 *
 */
package com.internousdev.solare.dto;

/**
 * tempテーブル情報を取得、格納するためのクラス
 *
 * @since 1.0
 * @version 1.0
 */
public class PaymentInformationDTO {
	/**
	 * クレジットカード番号
	 *
	 * @since 1.0
	 * @version 1.0
	 */
	private String cardNumber;

	/**
	 * クレジットカード名義
	 *
	 * @since 1.0
	 * @version 1.0
	 */
	private String cardHolder;

	/**
	 * 有効期限(月/年)
	 *
	 * @since 1.0
	 * @version 1.0
	 */
	private String expirationDate;

	/**
	 * セキュリティコード
	 *
	 * @since 1.0
	 * @version 1.0
	 */
	private String securityCode;

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
	 * 有効期限(月/年)を取得するメソッド
	 *
	 * @return expirationDate 有効期限(月/年)
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * 有効期限(月/年)を格納するメソッド
	 *
	 * @param expirationDate
	 *            有効期限(月/年)
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

}
