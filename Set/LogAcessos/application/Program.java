package EstruturaDados.Set.LogAcessos.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import EstruturaDados.Set.LogAcessos.entities.LogEntry;

public class Program 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter file path: ");
        String readPath = sc.nextLine();


        try ( BufferedReader br = new BufferedReader( new FileReader(readPath) ) )
        {
            Set<LogEntry> set = new HashSet<>();

            String currLine = br.readLine();
            
            while (currLine != null) 
            {
                String[] infos = currLine.split(" ");
                String userName = infos[0];
                Date entryMoment = Date.from(Instant.parse(infos[1]));

                set.add(new LogEntry(userName, entryMoment));//set only allows fresh elements to be added

                currLine = br.readLine();
            }
            System.out.println("Total users: " + set.size());
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }


        sc.close();
    }
}