package cz2001_lab3;

public class quickSort {
    // Declaration of variables
    private static int n;
    private int comparisons;
    
    // Constructor to obtain size n
    public quickSort (int size){
        n = size;
        comparisons = 0;
    }
    
    // Sorting method
    public void sort(int[] ar, int start, int end) {
        int pivot;
        if (start>=end)
            return;
        pivot = partition(ar, start, end);
        sort(ar, start, pivot-1);
        sort(ar, pivot+1, end);
    }
    public int partition(int[] ar, int start, int end) {
        int i, pivot, lastSmall;
        int mid = (start+end)/2;
        swap (ar, start, mid);
        pivot = ar[start];
        lastSmall = start;
        for (i= start+1; i <= end; i ++) {
            comparisons ++;
            if (ar[i] < pivot) {
                swap(ar, i, ++lastSmall);
            }
        }
        swap(ar, start, lastSmall);
        return lastSmall;
    }
    public void swap(int[] ar, int x, int y){
        int temp = ar[x];
        ar[x] = ar[y];
        ar[y] = temp;
    }
    // Print comparisons method
    public void printC() {
        System.out.println(comparisons);
    }
}
