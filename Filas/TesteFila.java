package EstruturaDados.Filas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TesteFila
{
    public static void main(String[] args)
    {
        ex3();
    }

    static void usoFila()
    {
        Fila<Integer> fila = new Fila<>(5);

        fila.addElement(1);
        fila.addElement(4);
        fila.addElement(12);
        fila.addElement(5);
        fila.addElement(0);
        System.out.println(fila);

        System.out.println(fila.moveQueueForward());

        System.out.println(fila);
    }

    static void filaPriori()
    {
        FilaComPrioridade<String> fila = new FilaComPrioridade<>(10);
        fila.enqueue("Bac");
        fila.enqueue("Vaz");
        fila.enqueue("Mox");

        System.out.println(fila);
    }

    static void ex1()
    {
        Queue <Documento> filaDoc = new LinkedList<>();

        filaDoc.add(new Documento("Ficha1", 4));
        filaDoc.add(new Documento("Ficha2", 3));
        filaDoc.add(new Documento("Ficha3", 10));
        filaDoc.add(new Documento("Ficha4", 25));


        while (!filaDoc.isEmpty())
        {
            Documento doc = filaDoc.remove();
            System.out.println("Printing doc: " + doc.getName());

            try {
                Thread.sleep(200 * doc.getPages());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All docs were printed");
    }

    static void ex2()
    {
        Queue<String> regularQueue = new LinkedList<>();
        Queue<String> priorityQueue = new LinkedList<>();

        final int MAX_OF_PRIORITY_PER_TURN = 3;

        regularQueue.add("Pessoa Normal 1");
        regularQueue.add("Pessoa Normal 2");
        regularQueue.add("Pessoa Normal 3");

        priorityQueue.add("Pessoa Prioritaria 1");
        priorityQueue.add("Pessoa Prioritaria 2");
        priorityQueue.add("Pessoa Prioritaria 3");
        priorityQueue.add("Pessoa Prioritaria 4");
        priorityQueue.add("Pessoa Prioritaria 5");

        regularQueue.add("Pessoa Normal 4");
        regularQueue.add("Pessoa Normal 5");
        regularQueue.add("Pessoa Normal 6");

        while (!regularQueue.isEmpty() || !priorityQueue.isEmpty())
        {
            System.out.println();
            for (int i = 0; !priorityQueue.isEmpty() && i < MAX_OF_PRIORITY_PER_TURN; i++) {
                attendTO(priorityQueue);
            }
            System.out.println();

            if (!regularQueue.isEmpty()) {
                attendTO(regularQueue);
            }

            if (priorityQueue.isEmpty())
            {
                while (!regularQueue.isEmpty()) {
                    attendTO(regularQueue);
                }
            }
        }
    }

    static void attendTO(Queue<String> fila)
    {
        String patient = fila.remove();
        System.out.println(patient + " foi atendida.");
    }

    static void ex3()
    {
        int cont = 0;
        Random random =  new Random();
        FilaComPrioridade<EmergencyPatient> emergencyQueue = new FilaComPrioridade<>(7);
        emergencyQueue.enqueue( new EmergencyPatient("Green", 1) );
        emergencyQueue.enqueue( new EmergencyPatient("Yellow", 2) );
        emergencyQueue.enqueue( new EmergencyPatient("Red", 3) );
        emergencyQueue.enqueue( new EmergencyPatient("Red", 4) );
        emergencyQueue.enqueue( new EmergencyPatient("Yellow", 5) );
        emergencyQueue.enqueue( new EmergencyPatient("Green", 6) );

        while (!emergencyQueue.isEmpty() && cont < 10)
        {
            EmergencyPatient attendedPatient = emergencyQueue.moveQueueForward();
            System.out.println("The patient " + attendedPatient.getNumber() + " with priority " + attendedPatient.getOrderOfPriority() + " was attended, calling the next patient");

            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            try
            {
                Thread.sleep(100);
                emergencyQueue.enqueue( new EmergencyPatient(random.nextInt(1,4), random.nextInt(100)) );
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}