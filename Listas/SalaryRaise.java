package EstruturaDados.Listas;

import java.util.ArrayList;
import java.util.Scanner;

public class SalaryRaise 
{
    static ArrayList<Employees> employeesList = new ArrayList<>();
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Employees employee1 = new Employees("333", "Maria Brown", 4000);
        Employees employee2 = new Employees("536", "Alex Grey", 3000);
        Employees employee3 = new Employees("772", "Bob Green", 5000);

        employeesList.add(employee1);
        employeesList.add(employee2);
        employeesList.add(employee3);
        
        showEmployees();

        String chosenID = askID(sc);

        Employees searched_Employee = employeesList.stream().filter( x -> x.getId().equals(chosenID) ).findFirst().orElse(null);

        if(searched_Employee != null)
        {
            double percentage = askPercentage(sc);
            searched_Employee.raiseSalary(percentage);
        }

        else{
            System.out.println("This ID does not exist");
        }

        printList();

        sc.close();
    }

    static void showEmployees()
    {
        for (int i = 0; i < employeesList.size(); i++) 
        {
            System.out.println("Employee #" + (i+1)+":");
            System.out.println( "ID: " + (employeesList.get(i)).getId() );
            System.out.println( "Name: " + (employeesList.get(i)).getName() );
            System.out.println( "Salary: " + (employeesList.get(i)).getSalary() );
            
            System.out.println();
        }
    }

    static String askID(Scanner sc)
    {
        System.out.print("Enter the employee ID that will have a salary increase: ");
        String chosenID = sc.nextLine();
        return chosenID;
    }

    static double askPercentage(Scanner sc)
    {
        System.out.print("Enter the percentage: ");

        double percentage = sc.nextDouble();
        System.out.println();
        return percentage;
    }

    static void printList()
    {
        System.out.println("List of Employees:");

        for (Employees emp : employeesList) {
            System.out.println(emp);
        }
    }
}