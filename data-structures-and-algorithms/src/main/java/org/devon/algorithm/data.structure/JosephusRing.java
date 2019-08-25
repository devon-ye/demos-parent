package org.devon.algorithm.data.structure;

/**
 * @author dewen.ye
 * @date 2019/3/24 10:14
 */
public class JosephusRing {

    public int linkMethod(int total, int index, int num) {
        Node head = buildLinkedRing(total);
        while (head.next != null) {
            for (int i = 0; i < num - 1; i++) {
                head = head.next;
            }
            System.out.println("out linked data:" + head.element);
        }
        return (int) head.element;
    }


    public int simulateMethod(int total,int index,int num){

        while (true){

        }
    }


    class Node<E> {
        E element;
        Node<E> next;

        public Node() {
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }


    private Node buildLinkedRing(int total) {
        Node head = new Node();
        head.element = 1;
        Node temp = head;
        for (int i = 0; i < total; i++) {
            Node newNode = new Node();
            newNode.element = i + 1;
            temp.next = newNode;
            temp = newNode;
        }
        temp.next = head.next;
        return head;
    }
}
