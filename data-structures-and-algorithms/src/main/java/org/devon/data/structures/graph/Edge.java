package org.devon.data.structures.graph;

import java.io.Serializable;

/**
 * @author Devonmusa
 * @date 2019/8/18 18:06
 * @since
 */
public interface Edge<K1, K2, V> extends Serializable {


	K1 getSource();

	void setSource(K1 source);

	K2 getTarget();

	void setTarget(K2 target);

	V getValue();

	void setValue(V value);


}
