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
    
    public ShellShortTest() {
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
        
        System.out.println("Test Case 1: Null array");
        int[] array1 =      null;
        int[] expResult1 =  null;
        System.out.print("Tested array:\t");
        ShellShort.printArray(array1);
        System.out.print("Expected array:\t");
        ShellShort.printArray(expResult1);
        int[] result = ShellShort.ShellSort(array1);
        System.out.print("Result array:\t");
        ShellShort.printArray(result);
        assertArrayEquals(expResult1, result);
        
        System.out.println("\nTest Case 2: Empty array");
        int[] array2 =      {};
        int[] expResult2 =  {};
        System.out.print("Tested array:\t");
        ShellShort.printArray(array2);
        System.out.print("Expected array:\t");
        ShellShort.printArray(expResult2);
        result = ShellShort.ShellSort(array2);
        System.out.print("Result array:\t");
        ShellShort.printArray(result);
        assertArrayEquals(expResult2, result);
        
        System.out.println("\nTest Case 3: Single element array");
        int[] array3 =      {23};
        int[] expResult3 =  {23};
        System.out.print("Tested array:\t");
        ShellShort.printArray(array3);
        System.out.print("Expected array:\t");
        ShellShort.printArray(expResult3);
        result = ShellShort.ShellSort(array3);
        System.out.print("Result array:\t");
        ShellShort.printArray(result);
        assertArrayEquals(expResult3, result);
        
        System.out.println("\nTest Case 4: Sorted array");
        int[] array4 =      {1,2,3,4,5};
        int[] expResult4 =  {1,2,3,4,5};
        System.out.print("Tested array:\t");
        ShellShort.printArray(array4);
        System.out.print("Expected array:\t");
        ShellShort.printArray(expResult4);
        result = ShellShort.ShellSort(array4);
        System.out.print("Result array:\t");
        ShellShort.printArray(result);
        assertArrayEquals(expResult4, result);
        
        System.out.println("\nTest Case 5: Reverse-sorted array");
        int[] array5 =      {5,4,3,2,1};
        int[] expResult5 =  {1,2,3,4,5};
        System.out.print("Tested array:\t");
        ShellShort.printArray(array5);
        System.out.print("Expected array:\t");
        ShellShort.printArray(expResult5);
        result = ShellShort.ShellSort(array5);
        System.out.print("Result array:\t");
        ShellShort.printArray(result);
        assertArrayEquals(expResult5, result);
        
        System.out.println("\nTest Case 6: Array with duplicate elements");
        int[] array6 =      {2,2,4,5,1,3,5};
        int[] expResult6 =  {1,2,2,3,4,5,5};
        System.out.print("Tested array:\t");
        ShellShort.printArray(array6);
        System.out.print("Expected array:\t");
        ShellShort.printArray(expResult6);
        result = ShellShort.ShellSort(array6);
        System.out.print("Result array:\t");
        ShellShort.printArray(result);
        assertArrayEquals(expResult6, result);
        
        System.out.println("\nTest Case 7: Random array");
        List<Integer> test = generateRandomArray(100, 4096);
        int[] array7 =      toIntArray(test);
        Collections.sort(test);
        int[] expResult7 =  toIntArray(test);
        System.out.print("Tested array:\t");
        ShellShort.printArray(array7);
        System.out.print("Expected array:\t");
        ShellShort.printArray(expResult7);
        result = ShellShort.ShellSort(array7);
        System.out.print("Result array:\t");
        ShellShort.printArray(result);
        assertArrayEquals(expResult7, result);
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
