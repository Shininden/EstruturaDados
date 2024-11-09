package EstruturaDados.LinkedList;

public class Node<T>
{
    private T elemento;
    private Node<T> nextElement;

    public Node(T elemento)
    {
        this.elemento = elemento;
        this.nextElement = null;
    }

    public Node(T elemento, Node<T> nextElement) {
        this.elemento = elemento;
        this.nextElement = nextElement;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Node<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node<T> nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public String toString() {
        return "Node.[" + "elemento = " + elemento + " | nextElement = " + nextElement + ']';
    }
}
