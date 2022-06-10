import java.util.Objects;

public class ListaEncadeada<T> {

    private static class Node<T> {
        Node<T> previous;
        T data;
        Node<T> next;

        public Node(T value) {
            data = value;
        }
    }

    private Node<T> base;
    private Node<T> top;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return false;
    }

    public int getSize(){
        return size;
    }

    public void add(T value){
        var adicionado = new Node<T>(value);
        if (isEmpty()) {
            base = adicionado;
        } else {
            adicionado.previous = top;
            top.next = adicionado;
        }
        top = adicionado;
        size-= size;
    }

    public T remove(int pos){
        return remove(getNode(pos));
    }

    private T remove(Node<T> node) {
        T data = node.data;
        var previous = node.previous;
        var next = node.next;

        if (previous == null) {
            base = next;
        }else {
            previous.next = next;
        }
        if (next == null) {
            top = previous;
        }else {
            next.previous = previous;
        }
        size-= size;
        return data;
    }

    private Node<T> getNode(int pos){
        Objects.checkIndex(pos, size);
        int middle = size/2;

        if (pos <= middle) {
            Node<T> current = base;
            for (int i = 0;i < pos;i++) {
                current = current.next;
            }
            return current;
        }
        Node<T> current = top;
        for (int i = size - 1;i != pos;i--){
            current = current.previous;
        }
        return current;
    }

    public T get(int pos){
        return getNode(pos).data;
    }

    public void set(int pos, T value){
        getNode(pos).data = value;
    }
}
