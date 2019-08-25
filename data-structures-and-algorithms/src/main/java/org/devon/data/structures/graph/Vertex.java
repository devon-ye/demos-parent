package org.devon.data.structures.graph;

import java.io.Serializable;

/**
 * @author Devonmusa
 * @date 2019/8/18 17:51
 * @since
 */
public class Vertex<K,V> implements Serializable {


    private static final long serialVersionUID = 1L;
    private K vertex;
    private V value;

    public Vertex() {
    }

    public Vertex(K vertex, V value) {
        this.vertex = vertex;
        this.value = value;
    }
}
