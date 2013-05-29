/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shellshort;

import java.util.Random;

/**
 *
 * @author Brandon
 */
public class ShellShort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // int array[] = {5,4,3,2,1};
        int array[] = generateRandomArray(1);

        printArray(array);

        ShellSort(array);

        printArray(array);
    }

    public static int[] ShellSort(int[] array) {

        if (null != array) {
            int temp;

            int i = 0;
            int k = 0;

            int sequence = 1;

            while (sequence <= array.length / 3) {
                sequence = sequence * 3 + 1;
            }

            while (sequence > 0) {
                for (k = sequence; k < array.length; ++k) {
                    temp = array[k];
                    i = k;

                    while (i > sequence - 1 && array[i - sequence] >= temp) {
                        array[i] = array[i - sequence];
                        i -= sequence;
                    }

                    array[i] = temp;
                }

                sequence = (sequence - 1) / 3;
            }
        }

        return array;
    }

    public static void printArray(int[] array) {
        if (null == array) {
            System.out.println("NULL");
        } else {
            System.out.print("[ ");
            for (int i = 0; i < array.length; ++i) {
                if (i == array.length - 1) {
                    System.out.print(array[i]);
                } else {
                    System.out.print(array[i] + " | ");
                }
            }
            System.out.println(" ]");
        }
    }

    public static int[] generateRandomArray(int size) {
        int result[] = null;

        if (0 == size) {
            result = new int[]{};
        } else if (size > 0) {
            result = new int[size];
            for (int i = 0; i < result.length; ++i) {
                Random rand = new Random();
                result[i] = rand.nextInt();
            }
        }

        return result;
    }
}