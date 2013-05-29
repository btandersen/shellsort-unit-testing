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
public class ShellShortTest {
    
    int[][] testCases;
    int[][] expResults;
    
    public ShellShortTest() {
        List<Integer> test = generateRandomArray(1024, 100);
        int[] rand = toIntArray(test);     
        Collections.sort(test);
        int[] randSorted = toIntArray(test);
        
        test = generateRandomArray(100, Integer.MAX_VALUE);
        int[] randMax = toIntArray(test);     
        Collections.sort(test);
        int[] randSortedMax = toIntArray(test);
        
        testCases = new int[][] {
            null,
            { },
            {23},
            {1,2,3,4,5},
            {5,4,3,2,1},
            {2,2,4,5,1,3,5},
            rand,
            randMax
        };
        
        expResults = new int[][] {
            null,
            { },
            {23},
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,2,3,4,5,5},
            randSorted,
            randSortedMax
        };
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ShellSort method, of class ShellShort.
     */
    @Test
    public void testShellSort() {
        System.out.println("ShellSort");
        
        for (int i = 0; i < testCases.length; ++i) {
            System.out.println("\nTest Case " + i);
            
            System.out.print("Tested array:\t");
            ShellShort.printArray(testCases[i]);
            
            System.out.print("Expected array:\t");
            ShellShort.printArray(expResults[i]);
            
            int[] result = ShellShort.ShellSort(testCases[i]);
            
            System.out.print("Result array:\t");
            ShellShort.printArray(result);
            
            assertArrayEquals(expResults[i], result);
        }
    }
    
    public static ArrayList<Integer> generateRandomArray(int size, int maxInt) {
        ArrayList<Integer> result = null;

        if (0 == size) {
            result = new ArrayList<>();
        } else if (size > 0) {
            result = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                Random rand = new Random();
                result.add(rand.nextInt(maxInt));
            }
        }

        return result;
    }
    
    public static int[] toIntArray(List<Integer> list) {
        int[] result = null;
        
        if (null != list) {
            result = new int[list.size()];
            
            for (int i = 0; i < list.size(); ++i) {
                result[i] = list.get(i);
            }
        }
        
        return result;
    }
}
