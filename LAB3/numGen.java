package cz2001_lab3;
import java.lang.Math;

public class numGen {
    // Declaration of variables
    private int[] Arr;
    private int n;
    
    // Constructor to obtain size n
    public numGen (int size) {
        n = size;
        Arr = new int[n];
    }
    
    // Method (1) - randomly generated datasets of integers in the range [1, ... n]
    public void randG1() {
        for (int i = 0; i < n; i ++){
            Arr[i] = (int)(Math.random() * n +1);
        }
    }
    
    // Method (2) - Integers 1, 2, ..., n sorted in ascending order
    public void randG2() {
        for (int i = 0; i < n; i ++) {
            Arr[i] = i+1;
        }
    }
    
    // Method (3) - Integers n, n−1, ...,1 sorted in descending order
    public void randG3() {
        int j = n;
        for (int i = 0; i < n; i ++) {
            Arr[i] = j;
            j--;
        }
    }
    
    //Get methods
    public int[] getArr() {
        return Arr;
    }    
    
    // Print method
    public void print() {
        for (int i = 0; i < n; i ++){
            System.out.print(Arr[i]+" ");
        }
        System.out.println("");
    }
}
