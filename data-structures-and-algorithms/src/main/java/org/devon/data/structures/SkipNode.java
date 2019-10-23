package org.devon.data.structures;

public class SkipNode<E> {

    private E data;
    private SkipNode[] forwards = new SkipNode[Integer.MAX_VALUE];
    private int maxLevel;


}
