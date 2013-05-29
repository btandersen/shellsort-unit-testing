/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shellshort;

/**
 *
 * @author Brandon
 */
public class ShellShort
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Simple test case in main...
        int array[] =
        {
            5, 4, 3, 2, 1
        };

        printArray(array);

        ShellSort(array);

        printArray(array);
    }

    /**
     * ShellSort - Implemented using Knuth's linear recurrence relationship of h(s + 1) = 3 * h(s) + 1 where h(1) = 1, s >= 1     * 
     * @param array - this gets sorted in place but is returned as well
     * @return int[] - the sorted array
     */
    public static int[] ShellSort(int[] array)
    {
        // Check to see if the array passed is null, if so, we will do no work and just return null
        if (null != array)
        {
            // temporary int for swapping
            int temp;

            // iterators for the array
            int i = 0;
            int j = 0;

            // the initial gap of h(1) = 1
            int gap = 1;

            // calculate the first gap based on the length of the array to sort
            while (gap <= array.length / 3)
            {
                gap = gap * 3 + 1;
            }

            // sorting
            while (gap > 0)
            {
                // check at the gap
                for (j = gap; j < array.length; ++j)
                {
                    // get the value at the gap
                    temp = array[j];
                    i = j;

                    // do swaps between the value at the gap and those at (i - gap) if not in sorted order
                    while ( ( i > ( gap - 1 ) ) && 
                            (array[i - gap] >= temp) )
                    {
                        array[i] = array[i - gap];
                        i -= gap;
                    }

                    array[i] = temp;
                }

                // calculate the next gap
                gap = (gap - 1) / 3;
            }
        }

        // return the results
        return array;
    }

    /**
     * printArray - just provides a nicely printed output of the array for visual verification
     * @param array 
     */
    public static void printArray(int[] array)
    {
        if (null == array)
        {
            System.out.println("NULL");
        }
        else
        {
            System.out.print("[ ");
            
            for (int i = 0; i < array.length; ++i)
            {
                if (i == array.length - 1)
                {
                    System.out.print(array[i]);
                }
                else
                {
                    System.out.print(array[i] + " | ");
                }
            }
            
            System.out.println(" ]");
        }
    }
}