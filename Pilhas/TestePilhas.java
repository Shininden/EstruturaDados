package EstruturaDados.Pilhas;

import java.util.Scanner;
import java.util.Stack;

public class TestePilhas 
{
    static Scanner sc = new Scanner(System.in);
    static int[] nums = new int[10];

    static Pilha<Integer> pilha = new Pilha<>(10);
    @SuppressWarnings({ "rawtypes", "unchecked" })
    static Stack<Livro> books = new Stack();
    
    static Livro book1 = new Livro("1", "2001", "Apha");
    static Livro book2 = new Livro("2", "2002", "Beta");
    static Livro book3 = new Livro("3", "2003", "Gama");
    static Livro book4 = new Livro("4", "2004", "Bravo");
    static Livro book5 = new Livro("5", "2005", "Omega");
    static Stack<Integer> pile1 = new Stack<>();
    static Stack<Integer> pile2 = new Stack<>();
    static Stack<Integer> pile3 = new Stack<>();

    final static String OPENING_EXPRESSION = "([{";
	final static String CLOSING_EXPRESSION = ")]}";
    
    public static void main(String[] args) 
    {
        //exer1();
        //exer2();
        //exer4();
        //exer5();
        //imprimeResultado("((a+b)");
        //exer7(16);
        sc.close();
    }

    static void exer1()
    {
        for (int i = 0; i < nums.length; i++) 
        {
            nums[i] = sc.nextInt();

            if(nums[i] % 2 == 0){
                pilha.addElement(nums[i]);
            }

            else if(nums[i] % 2 != 0)
            {
                if(pilha.isEmpty()){
                    System.out.println("The pile is already empty, it cannot start with an odd number");
                }

                pilha.desempilhar();
            }
        }

        System.out.println("----------");


        if(!pilha.isEmpty())
        {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(pilha.desempilhar() + " ");
            }
        }
    }

    static void exer2()
    {
        Pilha<Integer> evenPile = new Pilha<>(5);
        Pilha<Integer> oddPile = new Pilha<>(5);

        for (int i = 0; i < nums.length; i++) 
        {
            nums[i] = sc.nextInt();

            if(nums[i] % 2 == 0 && nums[i] != 0){
                evenPile.addElement(nums[i]);
            }

            else if(nums[i] % 2 != 0){
                oddPile.addElement(nums[i]);
            }

            else if(nums[i] == 0)
            {
                if(evenPile.isEmpty() || oddPile.isEmpty()){
                    System.out.println("The pile is already empty, it cannot start with 0");
                    i = -1;
                }

                else
                {
                    evenPile.desempilhar();
                    oddPile.desempilhar();
                }
            }
        }

        System.out.println("----------");

        System.out.println("Even Pile");
        if(!evenPile.isEmpty())
        {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(evenPile.desempilhar() + " ");
            }
        }

        System.out.println("\n------------");

        System.out.println("Odd Pile");
        if(!oddPile.isEmpty())
        {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(oddPile.desempilhar() + " ");
            }
        }
    }

    static void exer4()
    {
        System.out.println("Pilha de livros criada, pilha está vazia? "+ books.isEmpty());

        System.out.println();
		
		System.out.println("Empilhando livros na pilha:");
		
		books.push(book1);
		books.push(book2);
		books.push(book3);
		books.push(book4);
		books.push(book5);

		System.out.println(books.size() + " livros foram empilhados:");
		System.out.println(books);
		

		System.out.println("\nPilha de livros criada, pilha está vazia? "+ books.isEmpty());
		
		System.out.println("\nEspiando o topo da pilha: " + books.peek());

		System.out.println("\nDesempilhando livros da pilha:");
		
		while (!books.isEmpty()){
			System.out.println("Desempilhando livro: " + books.pop());
		}
		
		System.out.println("\nTodos os livros foram desempilhandos, pilha vazia: " + books.isEmpty());
    }

    static void exer5()
    {
        System.out.println("Type the sequence");
        String sequence = sc.nextLine();
        char[] charSequence = sequence.toCharArray();

        int sequenceSize = charSequence.length;
        char[] reversedChars = new char[sequenceSize];

        for (int i = 0; i < reversedChars.length; i++) 
        {
            reversedChars[sequenceSize - 1] = charSequence[i];
            sequenceSize--;
        }
        
        String reversedSequence = "";
        for (int i = 0; i < reversedChars.length; i++) {
            reversedSequence += reversedChars[i];
        }

        System.out.println();
        System.out.println("Normal - " + sequence);
        System.out.println("Reversed - " + reversedSequence);

        if(sequence.equals(reversedSequence))
            System.out.println("It's a palindromo");
        else
            System.out.println("It's not");
    }

    static boolean exer6(String expressao)
    {
        Stack<Character> pile = new Stack<>();
		int index = 0;
		char simbol, topItem;
		
		while (index < expressao.length())
        {
			simbol = expressao.charAt(index);
			
			if (OPENING_EXPRESSION.indexOf(simbol) > -1){
				pile.push(simbol);
			} 

            else if (CLOSING_EXPRESSION.indexOf(simbol) > -1)
            {
				if (pile.isEmpty()){
					return false;
				} 

                else 
                {
					topItem = pile.pop();
					
					if (OPENING_EXPRESSION.indexOf(topItem) != CLOSING_EXPRESSION.indexOf(simbol)){
						return true;
					}
                    else{
                        return false;
                    }
				}
			}
			index++;
		}
		return pile.isEmpty();
    }

    public static void imprimeResultado(String expressao){
		System.out.println(expressao + " está balanceada? " + exer6(expressao));
	}

    static void exer7(int base)
    {
        Stack<Integer> pile = new Stack<>();
        int decimalNumber = sc.nextInt();
        String bases = "0123456789ABCDEF";
        

        while(decimalNumber > 0)
        {
            pile.push(decimalNumber % base);
            decimalNumber /= base;
        }

        while(!pile.isEmpty()){
            System.out.print( bases.charAt(pile.pop()) );
        }

    }
}
