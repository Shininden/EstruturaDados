package EstruturaDados.Filas;

import EstruturaDados.Vetores.Vetor;

import java.util.Random;

public class BatataQuente
{
    public static void main(String[] args)
    {
        Fila<Integer> fila = new Fila<>(10);
        Random rand = new Random();
        int amountOfRepetitions = 0;

        for (int i = 0; i < 10; i++) {
            fila.addElement(i);
        }

        while (amountOfRepetitions == 0) {
            amountOfRepetitions = rand.nextInt(10);
        }

        System.out.println(fila);

        while (fila.getAmountOf_Elements() > 1)
        {
            for (int i = 0; i < amountOfRepetitions; i++) {
                fila.addElement( fila.moveQueueForward() );
            }

            System.out.println("Player " + fila.moveQueueForward() + " was eliminated\n");
            System.out.println(fila);
        }

        System.out.println("The winner is the player " + fila.moveQueueForward());
    }
}
