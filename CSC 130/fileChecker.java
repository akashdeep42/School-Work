// Akashdeep Vasisht 
// Lab 3 Part 1
// This code takes in a file in the command line and checks for properly nested delimiters.
// Output tells you if properly nested, if not output shows at what line.

import java.util.Stack;
import java.io.BufferedReader;               //everything that was imported
import java.io.IOException;
import java.io.FileReader;

public class fileChecker
{
   public static void main(String[] args) 
   {
      if (args.length != 1)                  // For testing purposes
      {
            System.out.println("Testing");
            System.exit(1);
      }
      
      String file = args[0];
      try 
      {                                      // Try and Catch
         check(file);                        // In case there is any error reading the file
      } 
      catch (IOException e) 
      {
         System.out.println("Cannot read file, check file name and retry.");
         e.printStackTrace();
      }
    }

    private static void check(String file) throws IOException 
    {
        boolean error = false;                          // Set to false, will go true in case of error
        Stack<Character> stack = new Stack<>();         // Implmentation of a stack
        //try and catch
        try (BufferedReader scan = new BufferedReader(new FileReader(file))) 
        {
            int rowNum = 0;                              // Zero to start from the first line
            String row;

            while ((row=scan.readLine())!=null)          // While loops goes as long as there are lines to read
            {
                rowNum++; //increment for while loop
                for (int i=0; i<row.length(); i++)       // For loop goes through the entire code line by line
                {
                    char x = row.charAt(i);

                    if (x=='{'||x=='('||x=='[')           // Push and Pop sequences 
                    {                                     // Which goes through all
                        stack.push(x);                    // delimiters, that are 
                    }                                     // pushed into the stack
                    else if (x=='}'||x==')'||x==']')      // and then popped when
                    {                                     // a match is found.
                        if (stack.isEmpty()) 
                        {
                            error = true;
                        } 
                        else 
                        {
                            char lastDelimiter = stack.pop();   // pops the last delimiter
                            
                            if ((x=='}'&& lastDelimiter !='{')||(x==')'&& lastDelimiter !='(')||(x ==']'&& lastDelimiter !='[')) 
                            {
                                error = true;                       // will turn the boolean to true
                            }
                        }
                    }

                    if (error) 
                    {
                        break;
                    }
                }

                System.out.println(row);

                if (error)    // If there is an error this will show at what line
                {
                    System.out.println("Delimiter error found on line number " + rowNum + ".");
                    break;
                }
            }
        }

        if (!error && !stack.isEmpty())             // Checks if stack is empty with no error
        {
            System.out.println("Missing delimiter.");        // In case of missing delimiters
        }
        else if (!error)                           // Checks for no errors
        {
            System.out.println("All delimiters in this file are nested."); // If the file is properly nested
        }
    }
}