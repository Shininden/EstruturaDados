package EstruturaDados;

public class Vetor 
{
    private String[] elementos; 
	private int amountOf_Elements;

	public Vetor(int capacidade)
    {
		this.elementos = new String[capacidade];
		this.amountOf_Elements = 0;
	}

	public boolean adiciona(String elemento) 
	{
		//this.aumentaCapacidade();

		if (this.amountOf_Elements < this.elementos.length)
		{
			this.elementos[this.amountOf_Elements] = elemento;
			this.amountOf_Elements++;
			return true;
		} 

		return false;
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
			sb.append(this.elementos[i]);
			sb.append(", ");
		}
		
		if (this.amountOf_Elements > 0){
			sb.append( this.elementos[this.amountOf_Elements-1] );
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
