package EstruturaDados;

public class Aula4 
{
    public static void main(String[] args)
    {
		Vetor vetor = new Vetor(10);

		vetor.adiciona("elemento 1");
		vetor.adiciona("elemento 2");
		vetor.adiciona("elemento 3");

		System.out.println(vetor.getAmountOf_Elements());
		
		System.out.println(vetor.toString());
	}    
}