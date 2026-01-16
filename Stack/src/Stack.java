public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        size = 0;
        top = new Node<T>(null, null);
    }
    public void push(T value){
        if (value == null)
            throw new IllegalArgumentException();
        top.next = new Node<T>(value, top.next);
        size++;
    }
    public T pop(){
        if( size == 0)
            throw new IllegalStateException("Stack is empty!");
        T topValue = top.next.value;
        top.next = top.next.next;
        size--;
        return topValue;
    }
    public T peek(){
        if( size == 0)
            throw new IllegalStateException("Stack is empty!");
        return top.next.value;
    }

    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top.next;

        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    private static class Node<T> {

        public final T value;
        public Node<T> next;

        public Node(final T value, final Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }
}