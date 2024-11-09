package EstruturaDados.Pilhas;

import EstruturaDados.EstruturaEstatica;

@SuppressWarnings("rawtypes")
public class ArrayLista<T> extends EstruturaEstatica
{

	
    public ArrayLista() {
        super();
    }
	
	@SuppressWarnings("unchecked")
	public boolean adiciona(T elemento) {
		return super.addElement(elemento);
	}

	@SuppressWarnings("unchecked")
	public boolean adiciona(int posicao, T elemento){
		return super.addAtPos(posicao, elemento);
	}
	
}