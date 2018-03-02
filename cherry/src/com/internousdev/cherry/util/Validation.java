package com.internousdev.cherry.util;

import java.util.regex.Pattern;

public class Validation {

	//空だったらtrue
	public boolean emptyValid(String target){
		if(target == null || target.equals("")){
			return true;
		}
		return false;
	}

	//以上以下の範囲外だった場合true
	public boolean overUnderValid(String target, int max){
		if(target.length() > max){
			return true;
		}
		return false;
	}


	//半角英数字でなかった場合true
	public boolean harfEngNumValied(String target){
		return !Pattern.matches("^[a-zA-Z0-9]*$", target);
	}

	//半角英でなかった場合true
	public boolean harfEnglishValied(String target){
		return !Pattern.matches("^[a-zA-Z]*$", target);
	}

	//半角記号でなかった場合true
	public boolean harfMarkValied(String target){
		return !Pattern.matches("^[\\p{Punct}]*$", target);
	}

	//漢字でなかった場合true
	public boolean kanjiValid(String target){
		return !Pattern.matches("^[亜-龠]*$", target);
	}

	//ひらがなでなかった場合true
	public boolean hiraganaValid(String target){
		return !Pattern.matches("^[あ-んが-ぼぁ-ょゎっー]*$", target);
	}

	//カタカナでなかった場合true
	public boolean katakanaValid(String target){
		return !Pattern.matches("^[ア-ンガ-ボァ-ョヮッー]*$", target);
	}

	//正しいメールアドレスかどうか
	public boolean emailAddressValid(String target){
		return !Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", target);
	}
}
