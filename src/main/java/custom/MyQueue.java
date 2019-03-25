package custom;

/**
 * Description:非线程安全队列
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-25
 */
public class MyQueue<E> {

    public static void main(String[] args) {

        MyQueue<String> queue = new MyQueue<>();
        queue.addLast("hello 1");
        queue.addLast("hello 2");
        queue.addLast("java");

        System.out.println(queue.removeFirst());//hello 1
        System.out.println(queue.removeFirst());//hello 2
        System.out.println(queue.removeFirst());//java
    }

    private Node<E> first, last;

    public int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E peekFirst() {
        return (first == null) ? null : first.element;
    }

    public E peekLast() {
        return (last == null) ? null : last.element;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E element = first.getElement();
        first = first.getNext();
        size--;
        if (size == 0) {
            last = null;
        }
        return element;
    }

    private static class Node<E> {

        private E element;

        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return (element == null) ? "" : element.toString();
        }
    }


}
