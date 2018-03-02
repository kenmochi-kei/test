package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.SearchDAO;
import com.internousdev.cherry.dto.SearchDTO;
import com.internousdev.cherry.util.ToHiragana;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 * @author yuzan-sakurai
 *
 */

public class SearchAction extends ActionSupport implements SessionAware {
	private String searchWord;
	private String keyword;
	private int categoryId;
	private SearchDAO searchDAO = new SearchDAO();
	private List<SearchDTO> searchDTOList = new ArrayList<SearchDTO>();
	private ToHiragana toHiragana = new ToHiragana();
	private String[] searchWords;
	public Map<String, Object> session;
	private ArrayList<String> msgList = new ArrayList<String>();

	public String execute() throws SQLException {

		String ret = ERROR;

		if (searchWord.length() > 16) {
			msgList.add("16字以内で検索してください");
			ret = SUCCESS;
			return ret;
		} else {
			msgList.add(searchWord);
		}

		/*---------------------------------------------------------
				検索値を全て全角に変換、適切な値に加工
		-----------------------------------------------------------*/
		keyword = Normalizer.normalize(searchWord, Normalizer.Form.NFKC);
		keyword = toHiragana.toZenkakuHiragana(keyword);
		System.out.println(keyword);
		keyword = keyword.trim();
		if (keyword.matches("^[\\p{Punct}]+$")) {
			msgList.add("一般的な検索ワードを使ってください");
			ret = SUCCESS;
			return ret;
		}

		/*---------------------------------------------------------
				複数検索 カテゴリーなし
		-----------------------------------------------------------*/
		/*
		空白の場所を確認
		*/
		int kuuhakunobasho = keyword.indexOf(" ");

		if (categoryId == 1 && kuuhakunobasho > 0) {

			List<SearchDTO> notUniqueSearchDTOList = new ArrayList<SearchDTO>();

			String[] searchWords = keyword.replace("|", "hogehoge").replace("_", "|_").replace("　", " ")
					.replace("~", "～").replace("%", "|%").split("[\\s]+");
			for (String str : searchWords) {
				System.out.println(str);
			}

			/*
			 * 検索ワードを作って重複ありのリストを作成
			 *
			 */ for (String str : searchWords) {
				notUniqueSearchDTOList = searchDAO.BySerchWord(str);
			}
			/*
			 * 重複ありのidリストを作成
			 *
			 *
			 */ List<Integer> idList = new ArrayList<Integer>();
			for (int i = 0; i < notUniqueSearchDTOList.size(); i++) {
				int id = notUniqueSearchDTOList.get(i).getId();
				idList.add(id);
			}
			/*
			 * jspで引っ張られてしまうので、削除
			 */
			notUniqueSearchDTOList.clear();

			/*
			 * 重複なしのリストを作成
			 *
			 */

			List<Integer> uniqueIdList = new ArrayList<Integer>(new HashSet<>(idList));
			System.out.println("重複削除後は" + uniqueIdList);
			/*
			 * 検索開始
			 *
			 */ for (int uniqueId : uniqueIdList) {

				searchDTOList = searchDAO.ByPrductId(uniqueId);
			}

			for (int i = 0; i < searchDTOList.size(); i++) {

				System.out.println("検索結果は" + searchDTOList.get(i).getProductName());
			}
			ret = SUCCESS;
			return ret;

			/*---------------------------------------------------------
					複数検索 カテゴリーあり
			-----------------------------------------------------------*/

		} else if (categoryId >= 1 && kuuhakunobasho > 0) {

			List<SearchDTO> notUniqueSearchDTOList = new ArrayList<SearchDTO>();

			String[] searchWords = keyword.replace("|", "hogehoge").replace("_", "|_").replace("　", " ")
					.replace("~", "～").replace("%", "|%").split("[\\s]+");
			for (String str : searchWords) {
				System.out.println(str);
			}

			/*
			 * 検索ワードを作って重複ありのリストを作成
			 *
			 */ for (String str : searchWords) {
				notUniqueSearchDTOList = searchDAO.BySerchWord(str);
			}
			/*
			 * 重複ありのidリストを作成
			 *
			 *
			 */ List<Integer> idList = new ArrayList<Integer>();
			for (int i = 0; i < notUniqueSearchDTOList.size(); i++) {
				int id = notUniqueSearchDTOList.get(i).getId();
				idList.add(id);
			}
			/*
			 * jspで引っ張られてしまうので、リストを削除
			 */
			notUniqueSearchDTOList.clear();

			List<Integer> uniqueIdList = new ArrayList<Integer>(new HashSet<>(idList));
			System.out.println("重複削除後は" + uniqueIdList);
			/*
			 * 検索開始
			 *
			 */ for (int uniqueId : uniqueIdList) {

				searchDTOList = searchDAO.ByPrductIdANDcate(uniqueId, categoryId);
			}

			for (int i = 0; i < searchDTOList.size(); i++) {

				System.out.println("検索結果は" + searchDTOList.get(i).getProductName());
			}
			ret = SUCCESS;
			return ret;
		}

		/*---------------------------------------------------------
					全件検索(カテゴリ、検索値なし)
		-----------------------------------------------------------*/

		else if (categoryId == 1 && keyword.isEmpty()) {
			setSearchDTOList(searchDAO.allProductInfo());
			ret = SUCCESS;

		}

		/*---------------------------------------------------------
				ひらがな、カタカナ検索
		-----------------------------------------------------------*/
		else if (categoryId == 1
				&& (keyword.matches("^[\\u3040-\\u30FF]+$") || keyword.matches("^[\\u30A0-\\u30FF]+$"))) {
			keyword = toHiragana.toZenkakuHiragana(keyword);
			System.out.println(keyword);
			setSearchDTOList(searchDAO.BySerchWordKana(keyword));
			ret = SUCCESS;

		} else if (categoryId > 1
				&& (keyword.matches("^[\\u3040-\\u30FF]+$") || keyword.matches("^[\\u30A0-\\u30FF]+$"))) {
			keyword = toHiragana.toZenkakuHiragana(keyword);
			System.out.println(keyword);
			setSearchDTOList(searchDAO.ByCategoryANDSerchWordKana(categoryId, keyword));
			ret = SUCCESS;

		}

		/*---------------------------------------------------------
				カテゴリ有り、検索値なし
		-----------------------------------------------------------*/
		else if (categoryId > 1 && keyword.isEmpty()) {

			setSearchDTOList(searchDAO.ByProductCategory(categoryId));
			ret = SUCCESS;
		}

		/*---------------------------------------------------------
				カテゴリなし、検索値あり
		-----------------------------------------------------------*/
		else if (categoryId == 1 && !(keyword.isEmpty())) {
			setSearchDTOList(searchDAO.BySerchWord(keyword));
			ret = SUCCESS;
		}

		/*---------------------------------------------------------
				カテゴリあり、検索値あり
		-----------------------------------------------------------*/
		else {
			setSearchDTOList(searchDAO.ByCategoryANDSerchWord(categoryId, keyword));
			System.out.println(keyword);
			ret = SUCCESS;

		}
		keyword = getSearchWord();
		return ret;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public SearchDAO getSearchDAO() {
		return searchDAO;
	}

	public void setSearchDAO(SearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}

	public List<SearchDTO> getSearchDTOList() {
		return searchDTOList;
	}

	public void setSearchDTOList(List<SearchDTO> searchDTOList) {
		this.searchDTOList = searchDTOList;
	}

	public ToHiragana getToHiragana() {
		return toHiragana;
	}

	public void setToHiragana(ToHiragana toHiragana) {
		this.toHiragana = toHiragana;
	}

	public ArrayList<String> getMsgList() {
		return msgList;
	}

	public void setMsgList(ArrayList<String> msgList) {
		this.msgList = msgList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public String[] getSearchWords() {
		return searchWords;
	}

	public void setSearchWords(String[] searchWords) {
		this.searchWords = searchWords;
	}

}
