package EstruturaDados.Filas;
import EstruturaDados.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica<T>
{
    public Fila(int capacidade) {
        super(capacidade);
    }

    public T peek()
    {
        if(this.isEmpty()){
            return null;
        }

        else{
            return this.totalCapacity[0];
        }
    }

    public T moveQueueForward()
    {
        final int POS = 0;

        if(this.isEmpty()){
            return null;
        }

        T firstElement = this.totalCapacity[POS];

        this.removeElementAtPos(POS);

        return firstElement;
    }
}
