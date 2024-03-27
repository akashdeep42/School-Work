/* Akashdeep Vasisht LAB 2 
   This program has a total of three functions,
   Linear Search
   Binary Search
   Selection Sort
   Which run through an array of 20 integers.
   And outputs the answer found with the amount 
   of comparisons it took to get to that answer.
*/

import java.util.Arrays;

public class sortingAlgo 
{
   //Main Funcation
   public static void main(String[] args) 
   {
        int[] array = {4, 23, 26, 2, 12, 21, 13, 42, 28, 53, 15, 3, 6, 43, 63, 29, 57, 10, 31, 38};       // Array of 20 integers

        int linearSearch = linearSearchAlgo(array, 10);                                                   // Calls and searches 10 using linear search

        int binarySearch = binarySearchAlgo(array, 12);                                                   // Calls and searchs 12 usin binary search                                                   

        selectionSortAlgo(array);                                                                         // Calls the sorting algo to sort the array of 20 integers
    }
    //Linear Search
    public static int linearSearchAlgo(int[] array, int answer) 
    {
        int numOfComparisons = 0;                                          // How many times it compared to the answer
        
        for (int i=0; i<array.length; i++) 
        {
            numOfComparisons++;
            if (array[i] == answer) 
            {
                System.out.println("Linear Search Alogritm Located: " + answer);                  // Prints answer found, number of comparisons and time complexity
                System.out.println("Number Of Comparisons: " + numOfComparisons);
                System.out.println("Time Complexity: O(n), since it contains a for loop, and the number of elements in array will decide how long it takes.");
                return i;
            }
        }
        System.out.println("Not in Array");                     // For testing function in case not in array
        return -1;
    }

    //Binary Search
    public static int binarySearchAlgo(int[] array, int answer) 
    {
        int numOfComparisons = 0;                                                // How many times it compared to the answer
        int higher = array.length - 1;                                           // stores the value of nums 
        int lower = 0;
        
        while (lower<=higher)                                                    // while loop to determine higher and lower parts                                      
        {
            numOfComparisons++;
            int middlePoint = (lower+higher)/2;
            
            if (array[middlePoint]==answer)                                      // sets the middle point to cut by half
            {
                System.out.println("Binary Search Alogritm Located: " + answer);                  // Prints answer found, number of comparisons and time complexity
                System.out.println("Number Of Comparisons: " + numOfComparisons);
                System.out.println("Time Complexity: O(log n), since it cuts it in half using a while loop, num of steps = k, n ~ 2**k, so k ~ log2(n).");
                return middlePoint;
            } 
            else if (array[middlePoint]<answer) 
            {
                lower = middlePoint+1;                                           // keeps cutting until found 
            } 
            else 
            {
                higher = middlePoint-1;
            }
        }
        
        System.out.println("Not in Array");                // For testing function in case not in array
        return -1;
    }

    //Selection Sort
    public static void selectionSortAlgo(int[] array) 
    {
        for (int i=0; i<array.length-1; i++) 
        {
            int lowestIndex = i;                                         // the value holds the lowest number and then the next and so on until sorted
            
            for (int j=i+1; j<array.length; j++)                          // nested for loop to go through each integer
            {
                if (array[j] < array[lowestIndex]) 
                {
                    lowestIndex=j;
                }
            }
            
            int temp = array[i];                         // holds temporary value 
            array[i] = array[lowestIndex];
            array[lowestIndex] = temp;
        }
        
        System.out.println("Sorted Array in ascending order: " + Arrays.toString(array));         // Prints sorted array in ascending order and time complexity
        System.out.println("Time Complexity: O(n^2), since descending to ascending, nested for loop.");
    }

    
}