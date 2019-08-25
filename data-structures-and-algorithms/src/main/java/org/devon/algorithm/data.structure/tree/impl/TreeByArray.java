package org.devon.algorithm.data.structure.tree.impl;

import org.devon.algorithm.data.structure.tree.Tree;

/**
 * @author Devonmusa
 * @date 2019/8/9 5:37
 * @since
 */
public class TreeByArray implements Tree {

    private int DEFAULT_SIZE = 64;

    private int size;

    private Object[] data;


    public TreeByArray() {
        this.data = new Object[DEFAULT_SIZE];
    }


    private void check(int nodeIndex) {
        if (nodeIndex < 0 || nodeIndex >= size) {
            throw new IndexOutOfBoundsException("nodeIndex  out of bounds!");
        }
    }



    @Override
    public <T> T get(int index) {
        check(index);
        return (T) data[index];
    }

    @Override
    public <T> boolean add(T t) {
        return false;
    }

    @Override
    public void delete(int index) {

    }
}
