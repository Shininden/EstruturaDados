package EstruturaDados.Map.VoteCounting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> candidatesList = new LinkedHashMap<>();

        System.out.print("Enter file path: ");
        String readPath = sc.nextLine();
        
        try ( BufferedReader br = new BufferedReader( new FileReader(readPath) ) )
        {
            String currLine = br.readLine();
            
            while (currLine != null) 
            {
                String[] infos = currLine.split(",");
                String currCandidate = infos[0];
                int count = Integer.parseInt(infos[1]);

                if (!candidatesList.containsKey(currCandidate)) {
					candidatesList.put(currCandidate, count);
				}
				else 
                {
                    int votesSoFar = candidatesList.get(currCandidate);
					candidatesList.put(currCandidate, votesSoFar + count);
				}
                
                currLine = br.readLine();
            }

            for (String candidate : candidatesList.keySet()) {
                System.out.println(candidate + ": " + candidatesList.get(candidate));
            }
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}