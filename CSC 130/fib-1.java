/* Akashdeep Vasisht
   Lab 1
   The program below uses the Fibonacci Seq, The Fibonacci function below is recursive and calculates
   elasped time for six terms following the term inputted by the user.
*/
import java.util.Scanner;

public class fib                                           // Akashdeep Vasisht CSC 130 Lab 1
{
   public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");    // User Input, imported and used scanner
        int x = scan.nextInt();
                                                           // All Variables, used long to store higher values
        long startingTime;                                 // Will store the starting time for each term as it goes through for loop
        long endTime;                                      // Will store the end time for each term as it goes through for loop   
        long calcTime;                                     // After End and Starting time are subtracted/divided this will hold sum
        long output;                                       // Holds the output from the fibSeq Method

        for (int i = x; i < x + 6; i++)                    // For loop, will run up to six terms and use the calculations within
        {
            startingTime = System.currentTimeMillis();     // Used currentTimeMills() to calc and divided by 1ooo to get seconds             
            output = fibSeq(i);
            endTime = System.currentTimeMillis();
            calcTime = (endTime-startingTime)/1000;        //Gets the starting time and subtracts from stop time
            System.out.println("The Fibonacci term at position " + i + " is " + output + " Computed in " + calcTime + " seconds.");
        }
    }

   
   public static long fibSeq(int x)                        // Takes input by user and stores it as Int, 
   {
        if (x<=1) 
        {
            return x;                                      // For input of 1 or less by user
        } 
        else 
        {
            return fibSeq(x-1)+fibSeq(x-2);                 // Recursion, fibSeq(int x) function is used inside fibSeq(int x)
        }                                                   // Gets the Fibonaccu Seq at given integer
    }

}
