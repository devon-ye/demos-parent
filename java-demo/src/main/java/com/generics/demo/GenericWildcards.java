package com.generics.demo;

import java.util.Collection;

/**
 * @see <code>?</code>   extends/super T
 * 
 * <P>Producer uses "Extends" and Consumer uses "Super".，</p>
 *  * <p>
 * this means Producer has only write access, and Consumer has only read access.
 * </p>
 * @param 
 * @param t
 * 
 * @author Devonmusa
 * @date 2017年8月16日
 */
public class GenericWildcards<T> {

	public void getSuper(Collection<? extends T> t) {

	}

	public void getSup(Collection<? super T> t) {

	}

}
