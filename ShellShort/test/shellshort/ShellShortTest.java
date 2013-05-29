/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shellshort;

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
        int[] array = null;
        int[] expResult = null;
        int[] result = ShellShort.ShellSort(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
