package org.devon.algorithm.demo.data.structure;

/**
 * @author dewen.ye
 * @date 2019/1/21 00:19
 */
public interface Linked {

    default Node node(){
        return new Node();
    }

    class Node<Item>{
        Item item;
        Node next;
    }
}
