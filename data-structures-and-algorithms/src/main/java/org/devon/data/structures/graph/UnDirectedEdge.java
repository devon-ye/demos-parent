package org.devon.data.structures.graph;

/**
 * @author devon.ye
 * @datetime 2020/3/7 8:43 下午
 * @since
 */
public class UnDirectedEdge<K1,K2,V> implements Edge<K1,K2,V> {


	@Override
	public K1 getSource() {
		return null;
	}

	@Override
	public void setSource(K1 source) {

	}

	@Override
	public K2 getTarget() {
		return null;
	}

	@Override
	public void setTarget(K2 target) {

	}

	@Override
	public V getValue() {
		return null;
	}

	@Override
	public void setValue(V value) {

	}
}
