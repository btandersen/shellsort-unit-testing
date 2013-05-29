/*
 * To change this template, choose Tools , Templates
 * and open the template in the editor.
 */
package shellshort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brandon
 */
public class ShellShortTest
{
    // test cases and expected results for easy iteration
    int[][] testCases;
    int[][] expResults;

    /**
     * Default constructor to initialize the test cases and expected results
     */
    public ShellShortTest()
    {
        // generate some random arrays

        // an array of size 1024 with elements ranging from 0 to 100
        List<Integer> test = generateRandomArray(1024, 100);
        int[] rand = toIntArray(test);
        Collections.sort(test); // we will assume the developers that implemented the Collections class did their unit testing and that their sort works
        int[] randSorted = toIntArray(test);

        // an array of size 100 with elements ranging from 0 to Integer.MAX_VALUE
        test = generateRandomArray(100, Integer.MAX_VALUE);
        int[] randMax = toIntArray(test);
        Collections.sort(test); // we will assume the developers that implemented the Collections class did their unit testing and that their sort works
        int[] randSortedMax = toIntArray(test);
        
        // an array of size 100 with elements ranging from +/-Integer.MAX_VALUE
        test = generateRandomArrayWithNegatives(100);
        int[] randNeg = toIntArray(test);
        Collections.sort(test); // we will assume the developers that implemented the Collections class did their unit testing and that their sort works
        int[] randSortedNeg = toIntArray(test);
        
        // our test cases
        testCases = new int[][] {
            null,                               // NULL array
            { },                                // empty array
            { 23 },                             // array of size one
            { 1, 2, 3, 4, 5 },                  // sorted array
            { 5, 4, 3, 2, 1 },                  // reverse-sorted array
            { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 },   // partially sorted, with duplicates
            { 2, 2, 4, 5, 1, 3, 5 },            // more duplicates
            rand,                               // large array with #'s from 0 to 100
            randMax,                            // array with large integers
            randNeg                             // array with + and - numbers
        };
        
        // our expected results
        expResults = new int[][] {
            null,
            { },
            { 23 },
            { 1, 2, 3, 4, 5 },
            { 1, 2, 3, 4, 5 },
            { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 },
            { 1, 2, 2, 3, 4, 5, 5 },
            randSorted,
            randSortedMax,
            randSortedNeg
        };
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        // nothing to do here
    }

    @AfterClass
    public static void tearDownClass()
    {
        // nothing to do here
    }

    @Before
    public void setUp()
    {
        // nothing to do here
    }

    @After
    public void tearDown()
    {
        // nothing to do here
    }

    /**
     * Test of ShellSort method, of class ShellShort.
     */
    @Test
    public void testShellSort()
    {
        System.out.println("ShellSort");

        // iterate through the test cases...
        for (int i = 0; i < testCases.length; ++i)
        {
            System.out.println("\nTest Case " + i);

            System.out.print("Original  array:\t");
            ShellShort.printArray(testCases[i]);

            System.out.print("Expected  array:\t");
            ShellShort.printArray(expResults[i]);

            // sort the test case and get the returned result
            int[] result = ShellShort.ShellSort(testCases[i]);

            System.out.print("Resulting array:\t");
            ShellShort.printArray(result);

            // assert that the expected result matches the returned result
            assertArrayEquals(expResults[i], result);
        }
    }

    /**
     * generateRandomArray - generates a random ArrayList of Integers
     * @param size - the size of the ArrayList to generate
     * @param maxInt - the maximum range
     * @return - the resulting ArrayList of Integers
     */
    public static ArrayList<Integer> generateRandomArray(int size, int maxInt)
    {
        ArrayList<Integer> result = null;

        if (0 == size)
        {
            result = new ArrayList<>();
        }
        else if (size > 0)
        {
            result = new ArrayList<>();
            for (int i = 0; i < size; ++i)
            {
                Random rand = new Random();
                result.add(rand.nextInt(maxInt));
            }
        }

        return result;
    }
    
        /**
     * generateRandomArrayWithNegatives - generates a random ArrayList of Integers, both + and -
     * @param size - the size of the ArrayList to generate
     * @return - the resulting ArrayList of Integers
     */
    public static ArrayList<Integer> generateRandomArrayWithNegatives(int size)
    {
        ArrayList<Integer> result = null;

        if (0 == size)
        {
            result = new ArrayList<>();
        }
        else if (size > 0)
        {
            result = new ArrayList<>();
            for (int i = 0; i < size; ++i)
            {
                Random rand = new Random();
                result.add(rand.nextInt());
            }
        }

        return result;
    }

    public static int[] toIntArray(List<Integer> list)
    {
        int[] result = null;

        if (null != list)
        {
            result = new int[list.size()];

            for (int i = 0; i < list.size(); ++i)
            {
                result[i] = list.get(i);
            }
        }

        return result;
    }
}
