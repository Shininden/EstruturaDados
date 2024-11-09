package EstruturaDados.LinkedList;

public class Teste
{
    public static void main(String[] args)
    {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();


        lista.add(1);
        lista.add(2);
        lista.add(4);
        lista.addAtPos(0,0);
        lista.addAtPos(4,5);
        lista.addAtPos(2,3);
        System.out.println(lista);

        System.out.println(lista.retrieveElement(0));
        System.out.println(lista);

        System.out.println(lista.retrieveElement(2));
        System.out.println(lista);

    }
}
