package org.devon.design.pattern.nullobject;

/**
 * @author devon.ye
 * @datetime 2020/4/12 5:11 PM
 * @since
 */
public interface Nullable {

	default boolean isNull() {
		return  false;
	}

	void setNull(boolean flag);
}
