package EstruturaDados.Listas;

public class Vetor 
{
    private String[] totalCapacity; 
	private int amountOf_Elements;

	public Vetor(int capacidade)
    {
		this.totalCapacity = new String[capacidade];
		this.amountOf_Elements = 0;
	}

	public boolean addElement(String elemento) 
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
	public boolean addAtPos(int pos, String elemento) 
	{
		verifyPosValidity(pos);

		this.increaseCapacity();

		for (int i = this.amountOf_Elements; i >= pos; i--) {
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
			String[] newCapacity = new String[this.totalCapacity.length * 2];

			for (int i = 0; i < this.totalCapacity.length; i++) {
				newCapacity[i] = this.totalCapacity[i];
			}

			this.totalCapacity = newCapacity;
		}
	}

	public void removeElementAtPos(int pos)
	{
		verifyPosValidity(pos);

		for (int i = pos; i < amountOf_Elements-1; i++) {
			this.totalCapacity[i] = this.totalCapacity[i+1];
		}
		this.amountOf_Elements--;
	}
	
	public String searchElementPos(int pos)
	{
		verifyPosValidity(pos);

		return this.totalCapacity[pos];
	}
	public int searchElement(String searchedElement)
	{
		for (int i = 0; i < amountOf_Elements; i++) 
		{
			if(totalCapacity[i].equals(searchedElement)){
				return i;
			}
		}
		return -1;
	}

	public int getAmountOf_Elements() {
		return this.amountOf_Elements;
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
			sb.append(this.totalCapacity[this.amountOf_Elements-1] );
		}
		
		sb.append("]");
		
		return sb.toString();
	}

	public boolean verifyPosValidity(int pos)
	{
		if(!(pos >= 0 && pos < amountOf_Elements)){
			throw new IllegalArgumentException("Invalid Position");
		}

		return true;
	}
}