package EstruturaDados.Filas;

public class FilaComPrioridade<T> extends Fila<T>
{

    public FilaComPrioridade(int capacidade) {
        super(capacidade);
    }

    public void enqueue(T element)
    {
        Comparable<T> key = (Comparable<T>) element;

        int i;
        for (i = 0; i < this.amountOf_Elements; i++)
        {
            if(key.compareTo( this.totalCapacity[i]) < 0 ){
                break;
            }
        }
        this.addAtPos(i, element);
    }
}
