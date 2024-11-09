package EstruturaDados.LinkedList;

public class ListaEncadeada<T>
{
    private Node<T> firstElement;
    private Node<T> lastElement;
    private Node<T> currentElement;
    private Node<T> newNode;
    private Node<T> previous;
    private T removedElement;
    private int size;
    private final int NOT_FOUND = -1;

    public void add(T elemento)
    {
        Node<T> celula = new Node<>(elemento);

        if(this.size == 0){
            this.firstElement = celula;
        }
        else{
            this.lastElement.setNextElement(celula);
        }

        this.lastElement = celula;
        this.size++;
    }

    public void addAtBeginning(T element)
    {
        if(this.getSize() == 0) {
            add(element);
        }

        else {
            newNode = new Node<>(element, this.firstElement);
            this.firstElement = newNode;
        }
        this.size++;
    }

    public void addAtPos(int previousElementPos, T element)
    {
        if(!this.doesPosExist(previousElementPos)) {
            throw new IllegalArgumentException("Invalid Pos");
        }

        else if(previousElementPos == 0){
            this.addAtBeginning(element);
        }

        else if(previousElementPos == this.getSize()){
            this.add(element);
        }

        else
        {
            previous = this.search_BY_Pos(previousElementPos);
            Node<T> next = previous.getNextElement();
            newNode = new Node<>(element, next);
            previous.setNextElement(newNode);
            this.size++;
        }
    }

    public int searchElement(T element)
    {
        int pos = 0;
        currentElement = this.firstElement;

        while (currentElement != null)
        {
            if(currentElement.getElemento().equals(element)){
                return pos;
            }
            pos++;
            currentElement = currentElement.getNextElement();
        }

        return NOT_FOUND;
    }

    private Node<T> search_BY_Pos(int pos)
    {
        if(!this.doesPosExist(pos)){
            throw new IllegalArgumentException("Invalid Position");
        }
        else
        {
            Node<T> current = this.firstElement;
            for (int i = 0; i < pos; i++) {
                current = current.getNextElement();
            }
            return current;
        }
    }

    public T searchElement_IN_Pos(int pos) {
        return this.search_BY_Pos(pos).getElemento();
    }

    public T retrieveFirstElement()
    {
        if(this.getSize() == 0){
            throw new RuntimeException("The list is already empty");
        }

        removedElement = this.firstElement.getElemento();
        this.firstElement = this.firstElement.getNextElement();
        this.size--;

        if(this.getSize() == 0){
            this.lastElement = null;
        }

        return removedElement;
    }

    public T retrieveElement(int pos)
    {
        if(!this.doesPosExist(pos)){
            throw new IllegalArgumentException("Invalid Pos");
        }
        else if (pos == 0) {
            return this.retrieveFirstElement();
        }
        else if(pos == this.getSize() - 1){
            return this.retrieveLastElement();
        }

        else
        {
            previous = this.search_BY_Pos(pos - 1);
            currentElement = previous.getNextElement();

            previous.setNextElement( currentElement.getNextElement() );
            currentElement.setNextElement(null);
            this.size--;
            return currentElement.getElemento();
        }
    }

    public T retrieveLastElement()
    {
        if(this.getSize() == 0){
            throw new RuntimeException("The list is already empty");
        }
        else if (this.getSize() == 1) {
            return this.retrieveFirstElement();
        }

        Node<T> penultimate = this.search_BY_Pos( this.getSize()-2 );
        removedElement = penultimate.getNextElement().getElemento();
        penultimate.setNextElement(null);
        this.lastElement = penultimate;
        this.size--;

        return removedElement;
    }

    public void cleanList()
    {
        currentElement = this.firstElement;

        while (currentElement != null)
        {
            Node<T> next = currentElement.getNextElement();
            currentElement.setElemento(null);
            currentElement.setNextElement(null);
            currentElement = next;
        }
        this.firstElement = null;
        this.lastElement = null;
        this.size = 0;
    }

    @Override
    public String toString()
    {
       if(this.getSize() == 0){
           return "[]";
       }
       else
       {
           StringBuilder builder = new StringBuilder("[");
           currentElement = this.firstElement;

           for (int i = 0; i < this.getSize() - 1; i++)
           {
               builder.append(currentElement.getElemento()).append(", ");
               currentElement = currentElement.getNextElement();
           }
           builder.append(currentElement.getElemento()).append("]");

           return builder.toString();
       }
    }

    public int getSize() {
        return this.size;
    }

    private boolean doesPosExist(int pos){
        return (pos >= 0 && pos <= this.getSize());
    }
}
