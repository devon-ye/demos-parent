package org.devon.algorithm.demo.data.structure;

/**
 * @author dewen.ye
 * @date 2019/1/21 00:19
 */
public class Node<E> {
    E e;
    Node next;

    public Node(E e) {
        this.e = e;
    }

    public Node(E e, Node next) {
        this.e = e;
        this.next = next;
    }
}
