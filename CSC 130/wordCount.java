/* Akashdeep Vasisht
   Lab 1
This lab allows the user to specify a text file, 
which then opens the file, and then prints two 
column table of all the words in the file togather 
with the number of times that wach word appears.  
*/
import java.util.Scanner;                            //everything that was imported
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class wordCount 
{
   public static void main(String[] args) 
   {
      Scanner scanner = new Scanner(System.in);      // Scanner to scan user input for the path of file
      System.out.println("Enter the path of the file you would like to use: ");
      
      String pathToFile = scanner.nextLine();
      File userInput = new File(pathToFile);                //this will store the variable for where to look for the file
      Scanner scanFile;

      try                                                       // try and catch for errors
      {
         scanFile = new Scanner(userInput);                      // this will try to see if it can find the file
      } 
      catch (FileNotFoundException e) 
      {
         System.out.println("This file was not found.");       //In case the file is not found 
         return;
      }

      Map<String, Integer> recurrence = new HashMap<>();            // creating a hash map

      while (scanFile.hasNextLine())                         // this will scan the lines and split the text so it can store it as a string
      {
         String text = scanFile.nextLine();
         String[] name = text.split(" ");
         
         for (String x : name) 
         {
            String word = x.toLowerCase();                      // brings the word to lower case so all the words can match up without capitalization
            int howManyTimes = recurrence.getOrDefault(word, 0); 
            recurrence.put(word, howManyTimes + 1);                   // ones a recurring word is found it will recorded it and add it to the tally
         }
      }

      Map<String, Integer> sortedrecurrence = new TreeMap<>(recurrence);               //creatign a map    
      System.out.printf("%-15s %s%n", "Word", "How Many Times This Ocurrs");

      for (Map.Entry<String, Integer> entry : sortedrecurrence.entrySet()) 
      {
         System.out.printf("%-15s %d%n", entry.getKey(), entry.getValue());

      }

   }

}