package cz2001_lab3;

public class mergeSort {
    private static int n;
    private int[] auxArr;
    private int comparisons;
    
    // Constructor to obtain size n
    public mergeSort (int size){
        n = size;
        auxArr = new int[n];
        comparisons = 0;
    }
    
    // Sorting method
    public void sort(int[] ar, int start, int end) {
        if (start == end)           // return if there is only 1 variable.
            return;
        else if (end - start > 1){  // if there are 2 or more variables, divide and conquer
            int mid = (start + end) / 2;
            sort(ar, start, mid);
            sort (ar, mid+1, end);
        }                              
        merge(ar, start, end);      // Start merging after dividing        
    }
    public void merge(int[] ar, int start, int end){
        int mid = (start+end)/2;
        int i = start;
        int j = mid + 1;
        int index = 0;
        
        if (end - start <= 0)       // if start == end, return
            return;
        
        while (i<=mid && j <= end) {        // main merging element - while counter i,j hasn't reach mid,end, compare and sort through auxArr
            if (ar[i] > ar[j]){
                auxArr[index] = ar[j];
                j++;
                comparisons++;
            }
            else if (ar[i] < ar[j]) {
                auxArr[index] = ar[i];
                i++;
                comparisons++;
            }
            else {
                auxArr[index] = ar[i];
                i++;
                index++;
                auxArr[index] = ar[j];
                j++;
                comparisons++;
            }
            index++;        // Increase count of index for auxArr to store into empty slot
        }        
        if (i <= mid) {         // For the case where i reaches mid, copy rest of variables into auxArr
            for (int z = i; z <= mid; z ++) {
                auxArr[index] = ar[z];
                index++;
            }
        }
        if (j <= end) {         // For the case where j reaches end, copy rest of variables into auxArr
            for (int z = j; z <= end; z ++) {
                auxArr[index] = ar[z];
                index++;
            }
        }
        System.arraycopy(auxArr, 0, ar, start, index);  // Copy array back from auxArr to original array
    }
    // Print comparisons method
    public void printC() {
        System.out.println(comparisons);
    }
}
