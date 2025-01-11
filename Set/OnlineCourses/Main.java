package EstruturaDados.Set.OnlineCourses;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Set<Integer> studentsSet = new HashSet<>();

        addStudents("A", sc, studentsSet);
        addStudents("B", sc, studentsSet);
        addStudents("C", sc, studentsSet);

        System.out.println("Total students: " + studentsSet.size());

        sc.close();
    }

    private static void addStudents(String course, Scanner sc, Set<Integer> studentsSet)
    {
        System.out.print("How many studens for course " + course + "? ");
        int students = sc.nextInt();

        for (int i = 1; i <= students; i++) 
        {
            System.out.print(i + " - student's code: ");
            studentsSet.add(sc.nextInt());
        }
    }
}