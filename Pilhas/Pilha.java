package EstruturaDados.Pilhas;

import EstruturaDados.EstruturaEstatica;

public class Pilha<T> extends EstruturaEstatica<T>
{
    public Pilha(int capacidade) {
        super(capacidade);
    }

    public T top()
    {
        if(this.isEmpty()){
            return null;
        }

        else{
            return this.totalCapacity[amountOf_Elements-1];
        }
    }

    public T desempilhar()
    {
		if (this.isEmpty()){
			return null;
		}

        else
        {
            T lastItem = this.totalCapacity[amountOf_Elements-1];
		    amountOf_Elements--;
		
		    return lastItem;
        }
	}
}