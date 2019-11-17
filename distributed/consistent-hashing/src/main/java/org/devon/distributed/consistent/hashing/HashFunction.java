package org.devon.distributed.consistent.hashing;

/**
 * @author dewen.ye
 * @datetime 2019/11/17 11:16 PM
 * @since
 */
public interface HashFunction {

	int hash(Object o);

}
