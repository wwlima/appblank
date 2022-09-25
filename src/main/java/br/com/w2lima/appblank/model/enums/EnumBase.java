package br.com.w2lima.appblank.model.enums;

/**
 * @author William Wilson Carvalho de Lima ( wwlima@gmail.com )
 *
 */
public interface EnumBase<E extends Enum<E>, T> {

	T getValue();
	
	public static <E extends EnumBase<?, T>, T> E fromValue(Class<E> enumType, T value) {
		for (E item : enumType.getEnumConstants()) {
			if (item.getValue().equals(value)) {
				return item;
			}
		}
		return null;
	}
	
}
