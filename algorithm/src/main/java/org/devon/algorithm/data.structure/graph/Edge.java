package org.devon.algorithm.data.structure.graph;

import java.io.Serializable;

/**
 * @author Devonmusa
 * @date 2019/8/18 18:06
 * @since
 */
public class Edge<K1, K2, V> implements Serializable {

    private static final long serialVersionUID = 1L;
    private K1 source;
    private K2 target;
    private V value;


    public Edge() {
    }

    public Edge(K1 source, K2 target, V value) {
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
