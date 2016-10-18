/*
 * Created by Alex Steen on 10/18/2016.
 *
 */
package algorithms;


public class Sort<T extends Comparable<? super T>> {
    public Sort() {}




//**********************************************************************//
//*****************************___O(nlogn)___*****************************//
//**********************************************************************//

    /*************
     * MERGE SORT*
     * ***********
     * @param array unsorted array
     * @return  sorted array
     */
    public T[] mergeSort(T[] array) {
        T[] copy = array;
        return mergeSort(array, copy, 0, array.length - 1);
    }

    private T[] mergeSort(T[] a, T[] b, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, b, left, center);
            mergeSort(a, b, center + 1, right);
            a = merge(a, b, left, right, center);
        }
        return a;
    }

    private T[] merge(T[] a, T[] temp, int left, int right, int center) {
        return null;
    }




//**********************************************************************//
//*****************************___O(n^2)___*****************************//
//**********************************************************************//

    /*****************
     * INSERTION SORT*      Complexity:  O(n^2)
     * ***************
     * Running through the array, and each element is essentially pushed backward until it is bigger
     *  than the next number
     * @param array  unsorted array
     * @return sorted array
     */
    public T[] insertionSort(T[] array) {
        for (int i = 1; i < array.length ; ++i) {                   //run through the array
            int j = i;
            while (j > 0 && array[j].compareTo(array[j-1]) < 0) {   //move smaller nums back until bigger than prev num
                T temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
        return array;
    }

    /**************
     * BUBBLE SORT*     Complexity:  O(n^2)
     * ************
     * Using 2 loops, we check each individual element. Essentially, we drag until the
     *  end until the largest element has bubbled to the end (top).
     * @param array unsorted array
     * @return sorted array
     */
    public T[] bubbleSort(T[] array) {
        for (int i = array.length; i >= 0; --i) {           //start with whole array and slowly take off end pieces
            for (int j = 1; j < i; ++j) {                   //iterate through array until end of partition
                if (array[j-1].compareTo(array[j]) > 0) {   //swap if one is bigger
                    T temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /*****************
     * SELECTION SORT*      Complexity: O(n^2)
     * ***************
     * Uses 2 loops, it loops through the array keeping the current index, and finds the smallest element
     *  to swap with the current index's element
     * @param array unsorted array
     * @return  sorted array
     */
    public T[] selectionSort(T[] array) {
        for (int i = 0; i < array.length; i++) {            //running from beg to end, moving forward 1 spot ea time
            int small = i;                                  //min value at the start
            for (int j = i+1; j < array.length; ++j) {       //starting at i+1 and moving forward (after the first spot)
                if (array[small].compareTo(array[j]) > 0) {
                    small = j;                                  //find index of the smallest
                }
            }
            if (small != i) {                               //swap when we find smallest and step forward in array
                T temp = array[i];
                array[i] = array[small];
                array[small] = temp;
            }
        }
        return array;
    }

}
