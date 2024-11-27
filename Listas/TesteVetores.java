package EstruturaDados.Listas;
import EstruturaDados.Pilhas.Contato;

import java.util.Scanner;
import java.util.ArrayList;

public class TesteVetores 
{
	static Contato contato = null;
    public static void main(String[] args)
    {
		Scanner sc = new Scanner(System.in);
		ArrayList<Contato> lista = new ArrayList<Contato>(20);
		
		createContacts(5, lista);
		int option = 1;

		while (option != 0) 
		{
			option = optionMenu(sc);

			switch (option) 
			{
				case 0:
					break;

				case 1:
					addContact(sc, lista);
					break;
				
				case 2:
					addContactAtPos(sc, lista);
				break;

				case 3:
					searchContactAtPos(sc, lista);
					break;

				case 4:
					deleteContactAtPos(sc, lista);
					break;

				case 5:
					System.out.println("The size of the vector is: " + lista.size());
					break;
					
				case 6:
					lista.clear();
					break;

				case 7:
					System.out.println(lista);
					break;
			}
		}

		sc.close();
	}    

	private static void createContacts(int amount, ArrayList<Contato> lista)
	{
		Contato contato;

		for (int i = 0; i < amount; i++) 
		{
			contato = new Contato("Contato " + i, "111"+i, i+"@email.com");
			lista.add(contato);
		}
	}
	
	private static int optionMenu(Scanner sc)
	{
		boolean validEntry = false;
		int option = 0;
		//String input;

		while (!validEntry) 
		{
			System.out.println("Type the desired option: ");
			System.out.println("0: Exit");
			System.out.println("1: Add contact");
			System.out.println("2: Add contat at a specific position");
			System.out.println("3: Search for contact in a specific position");
			System.out.println("4: Delete contact at a specific position");
			System.out.println("5: See vector's size");
			System.out.println("6: Clear vector");
			System.out.println("7: Print vector");

			try 
			{
				option = sc.nextInt();
				if(option >= 0 && option <= 11){
					validEntry = true;
				}
				else{
					throw new Exception();
				}
			} 
			catch (Exception e) {
				System.out.println("Invalid input, type again\n\n");
			}
		}

		return option;
	}

	private static void addContact(Scanner sc, ArrayList<Contato> lista)
	{
		System.out.println("To add a contact, inform the following: Name, phone, email");
		String name = sc.nextLine();
		String phone = sc.nextLine();
		String email = sc.nextLine();

		contato = new Contato(name, phone, email);
		lista.add(contato);
	}

	private static void addContactAtPos(Scanner sc, ArrayList<Contato> lista)
	{
		addContact(sc, lista);

		System.out.print("Type the desired position ");
		int pos = sc.nextInt();

		try 
		{
			lista.add(pos, contato);
			System.out.println("Contact added successfully");
			System.out.println(contato);
		} 
		catch (Exception e) {
			System.out.println("Invalid Position, contact not added");
		}
	}

	private static void searchContactAtPos(Scanner sc, ArrayList<Contato> lista)
	{
		System.out.println("Type the desired position");
		int pos = sc.nextInt();

		try 
		{
			Contato contato = lista.get(pos);
			System.out.println("Contact exists, here's the data: ");
			System.out.println(contato);
		} 
		catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}

	private static void deleteContactAtPos(Scanner sc, ArrayList<Contato> lista)
	{
		System.out.println("Type the desired position");
		int pos = sc.nextInt();

		try 
		{
			lista.remove(pos);
			System.out.println("Contact deleted");
		} 
		catch (Exception e) {
			System.out.println("Invalid Position");
		}
	}
}