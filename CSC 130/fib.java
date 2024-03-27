import java.util.Scanner;

public class fib                                           // Akashdeep Vasisht CSC 130 Lab 1
{
   public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");    // User Input
        int x = scan.nextInt();
        
        long startingTime;
        long endTime;
        long calcTime;                                     // All Variables 
        long output;

        for (int i = x; i < x + 6; i++) 
        {
            startingTime = System.currentTimeMillis();     // Gets the starting time and subtracts from stop time
            output = fibSeq(i);
            endTime = System.currentTimeMillis();
            calcTime = (endTime-startingTime)/1000;
            System.out.println("The Fibonacci term at position " + i + " is " + output + " Computed in " + calcTime + " seconds.");
        }
    }

   
   public static long fibSeq(int x) 
   {
        if (x<=1) 
        {
            return x;
        } 
        else 
        {
            return fibSeq(x-1)+fibSeq(x-2);                 // Recursion
        }
    }

}
