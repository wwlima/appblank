package br.com.w2lima.appblank.model.enums.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.AttributeConverter;

import br.com.w2lima.appblank.model.enums.EnumBase;

/**
 * @author William Wilson Carvalho de Lima ( wwlima@gmail.com )
 *
 */
@SuppressWarnings("rawtypes")
public class AbstractEnumConverter<T extends EnumBase, E> implements AttributeConverter<T, E> {

	@SuppressWarnings("unchecked")
	@Override
	public E convertToDatabaseColumn(T attribute) {
		if (attribute == null) {
			return null;			
		}
		return (E) attribute.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T convertToEntityAttribute(E dbData) {		
		return (T) EnumBase.fromValue(getEnumClass(), dbData);
	}

	@SuppressWarnings("unchecked")
	private Class getEnumClass() {
		Type type = getClass().getGenericSuperclass();
		
		while (!(type instanceof ParameterizedType pt) || (pt.getRawType() != AbstractEnumConverter.class)) {
			if (type instanceof ParameterizedType pt) {
				type = ((Class<?>) pt.getRawType()).getGenericSuperclass();
			} else {
				type = ((Class<?>) type).getGenericSuperclass();
			}			
		}
				
		return (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0] ;
	}

}
