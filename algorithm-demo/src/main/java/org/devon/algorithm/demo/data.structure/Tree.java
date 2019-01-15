package org.devon.algorithm.demo.data.structure;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/5 17:03
 * @since 1.0.0
 */
public class Tree {



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
