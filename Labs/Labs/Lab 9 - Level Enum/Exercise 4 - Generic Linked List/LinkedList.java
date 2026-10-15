import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private static class Node<E> {
        private final E data;
        private Node<E> next;

        Node(E data) { this.data = data; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            T value = current.data;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T item : this) {
            if (sb.length() > 1) sb.append(", ");
            sb.append(item);
        }
        return sb.append("]").toString();
    }
}
