package br.com.w2lima.appblank.model.enums;

/**
 * @author William Wilson Carvalho de Lima ( wwlima@gmail.com )
 *
 */
public enum UserStatusEum implements EnumBase<UserStatusEum, String> {
	
	ATIVO("A"),
	BLOQUEADO("B"),
	INATIVO("I");

	private String value;
	
	UserStatusEum(String value) {
		this.value = value; 
	}

	@Override
	public String getValue() {
		return value;
	}

}
