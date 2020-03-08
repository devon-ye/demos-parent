package org.devon.data.structures.graph;

/**
 * @author devon.ye
 * @datetime 2020/3/7 8:43 下午
 * @since
 */
public class DirectedEdge<K1, K2, V> implements Edge<K1,K2,V>{

	private static final long serialVersionUID = 1L;
	private K1 source;
	private K2 target;
	private V value;


	public DirectedEdge() {
	}

	public DirectedEdge(K1 source, K2 target, V value) {
		this.source = source;
		this.target = target;
		this.value = value;
	}


	public K1 getSource() {
		return source;
	}

	public void setSource(K1 source) {
		this.source = source;
	}

	public K2 getTarget() {
		return target;
	}

	public void setTarget(K2 target) {
		this.target = target;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Edge{" +
				"source=" + source +
				", target=" + target +
				", value=" + value +
				'}';
	}
}
