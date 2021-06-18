public class SNode<E> {
    E element;
    SNode<E> next;

    public SNode() {
    }

    public SNode(E element) {
        this.element = element;
        this.next = null;
    }
}
