package EstruturaDados;

public class EstruturaEstatica<T>
{
    protected T[] totalCapacity; 
	protected int amountOf_Elements;

	@SuppressWarnings("unchecked")
	public EstruturaEstatica(int capacidade)
    {
		this.totalCapacity = (T[]) new Object[capacidade];
		this.amountOf_Elements = 0;
	}

    public EstruturaEstatica() {
    }

    public boolean addElement(T elemento)
	{
		this.increaseCapacity();
		
		if (this.amountOf_Elements < this.totalCapacity.length)
		{
			this.totalCapacity[this.amountOf_Elements] = elemento;
			this.amountOf_Elements++;
			return true;
		} 

		return false;
	}

	public boolean addAtPos(int pos, T elemento)
	{
		if (pos < 0 || pos > amountOf_Elements){
			throw new IllegalArgumentException("Posição inválida");
		}

		this.increaseCapacity();

		for (int i = this.amountOf_Elements-1; i >= pos; i--) {
			this.totalCapacity[i+1] = this.totalCapacity[i];
		}

		this.totalCapacity[pos] = elemento;
		this.amountOf_Elements++;
		return true;
	}

    private void increaseCapacity()
	{
		if(this.amountOf_Elements == this.totalCapacity.length)
		{
			@SuppressWarnings("unchecked")
			T[] newCapacity = (T[]) new Object[this.totalCapacity.length * 2];

			for(int i = 0; i < this.totalCapacity.length; i++) {
				newCapacity[i] = this.totalCapacity[i];
			}

			this.totalCapacity = newCapacity;
		}
	}



    public int getAmountOf_Elements() {
		return this.amountOf_Elements;
	}

	public boolean isEmpty(){
		return this.amountOf_Elements == 0;
	}

	public void removeElementAtPos(int pos)
	{
		verifyPosValidity(pos);

		for (int i = pos; i < amountOf_Elements-1; i++) {
			this.totalCapacity[i] = this.totalCapacity[i+1];
		}
		this.amountOf_Elements--;
	}

	public boolean verifyPosValidity(int pos)
	{
		if(!(pos >= 0 && pos < amountOf_Elements)){
			throw new IllegalArgumentException("Invalid Position");
		}

		return true;
	}

	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		for (int i = 0; i < this.amountOf_Elements-1; i++)
		{
			sb.append(this.totalCapacity[i]);
			sb.append(", ");
		}
		
		if (this.amountOf_Elements > 0){
			sb.append(this.totalCapacity[this.amountOf_Elements-1]);
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}