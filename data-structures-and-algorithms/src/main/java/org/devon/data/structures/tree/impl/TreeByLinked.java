package org.devon.data.structures.tree.impl;

/**
 * @author Devonmusa
 * @date 2019/8/9 5:38
 * @since
 */
public class TreeByLinked {

    public class Node<T>{
        private Node<T> pro;
        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(Node<T> pro, T data, Node<T> next) {
            this.pro = pro;
            this.data = data;
            this.next = next;
        }

        public Node<T> getPro() {
            return pro;
        }

        public void setPro(Node<T> pro) {
            this.pro = pro;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"pro\":")
                    .append(pro);
            sb.append(",\"data\":")
                    .append(data);
            sb.append(",\"next\":")
                    .append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}
