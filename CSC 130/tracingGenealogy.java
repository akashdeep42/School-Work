// Akashdeep Vasisht
// Lab 3 Part 2
// This code reads a file of genealogy infroamtion and then allows
// the user to enter pairs of names "x" and "y". Then it determines
// weather Y is a descendant of X.

import java.util.*;                    // all lib that were imported
import java.io.File;
import java.io.FileNotFoundException;

public class tracingGenealogy 
{
    private static Map<String, List<String>> tracingGenealogy = new HashMap<>(); // creating a hashmap
    public static void main(String[] args) 
    {
        try 
        {
            Scanner sc = new Scanner(new File("names.txt"));      // Scanner to scan given file for parents and children
            int x = sc.nextInt();                                     // holds scan num
            sc.nextLine();
            for(int i=0; i<x; i++)                                    // For loop to get all the parents and children
            {
                String[] first = sc.nextLine().split(" ");
                String orgin = first[0];
                int amt = Integer.parseInt(first[1]);                 // Creating to fit new child
                List<String> child = new ArrayList<>();
                for (int z=2; z<first.length; z++)                    // For loop to go through all the children
                {
                    child.add(first[z]);
                }
                tracingGenealogy.put(orgin, child);
            }
            sc.close();
        }
        catch (FileNotFoundException e)                              // In case file not found, will throw out an error            
        {
            System.out.println("Unable to find this file. Recheck file name.");
            return;
        }
        
        Scanner scan = new Scanner(System.in);                       // Scanner to get user input for the x and y names
        while (true)                                                 // While loop to enter in names from user and compare and output
        {
            System.out.print("Enter name to check relation: ");
            String input = scan.nextLine();
            String[] names = input.split(" ");                       // Takes both names and splits them up so we can compare
            String pre = names[0];
            String post = names[1];                                  // Stores the values of the names
            List<String> dirc = getPath(pre, post);
            if (dirc == null)                                        // If names don't match    
            {
                System.out.println(pre + " is not a descendant of " + post);
            } 
            else                                                     // If the names match
            {
                System.out.println(String.join(pre + " is a descendant of " + post, dirc));
            }
        }
    }
    
    private static List<String> getPath(String pre, String post) // This will check for ancestor and descendents
    {
        if (!tracingGenealogy.containsKey(post))          // Compares the name with the key which is the names in file
        {
            return null;
        }
        if (pre.equals(pre))                              // For the ancestors
        {
            return Collections.singletonList(pre);
        }
        for (String children : tracingGenealogy.get(post))     // For the descendents
        {
            List<String> dirc = getPath(pre, children);
            if (dirc != null) 
            {
                dirc.add(0, post);
                return dirc;
            }
        }
        return null;
    }
}