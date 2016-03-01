package cz2001_lab3;

import java.io.*;
import java.util.Scanner;

public class mainApp {
    // Selections of n, random methods, sorting methods
    private final static int n = 10;    
    // (1) random Generator
    // (2) Increasing order
    // (3) Decreasing order
    // (4) Use data from file
    private final static int r = 4;
    // (1) mergeSort
    // (2) quickSort
    private final static int s = 1;     
    private static File file = new File("dataset.txt");
    
    public static void main(String[] args) throws IOException {
        // Declaration of variables
        long startTime;
        long endTime;
        int[] bArr = new int[n];
        
        // Instantiation of objects
        numGen gen = new numGen(n);
        mergeSort mSort = new mergeSort(n);
        quickSort qSort = new quickSort(n);
        
        if (r <= 3 && r >= 1) {
            if (r == 1) {
            gen.randG1();   
            bArr = gen.getArr();
            }
        else if (r == 2) {
            gen.randG2();
            bArr = gen.getArr();
            }
        else if (r == 3) {
            gen.randG3();
            bArr = gen.getArr();
            }
            PrintWriter pwStream = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        for (int i = 0; i < n; i ++){
            pwStream.print(bArr[i] + " ");
            }
        pwStream.close();
        }
        
        else if (r == 4) {
            try {
                int j =0;
                Scanner scStream = new Scanner(file);
                while (scStream.hasNextInt()) {
                    bArr[j] = scStream.nextInt();
                    j++;
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Error opening the input file!" + e.getMessage());
                System.exit(0);
            }
            catch (IOException e) {
                System.out.println("IO Error!" + e.getMessage());
                System.exit(0);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Check numbers within dataset and variable n. Mismatch!");
                System.exit(0);
            }
        }
        
        // Print out array
        print(bArr);
        
        // mergeSort selection
        if (s == 1) {
            System.out.println("\n**** Start mergeSort ****");
            // Start timing of method
            startTime = System.nanoTime();
            mSort.sort(bArr, 0, n-1);
            endTime = System.nanoTime();
            // End timing of method
        }
        
        // quickSort selection
        else if (s == 2) {   
            System.out.println("\n**** Start quickSort ****");
            // Start timing of method
            startTime = System.nanoTime();
            qSort.sort(bArr, 0, n-1);
            endTime = System.nanoTime();
            // End timing of method
        }

        print(bArr);      //Print sorted array
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        
        //Results
        System.out.println("\n=========Results=========");
        
        System.out.print("Number of comparisons: ");
        if (s==1)
            mSort.printC();
        else if (s==2)
            qSort.printC();
        System.out.println(duration + " ns");
    }    
    
    public static void print(int[] arr){
        for (int i = 0; i < n; i ++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}
