package cz2001_lab3;

public class mainApp {
    // Selections of n, random methods, sorting methods
    private final static int n = 10;    
    // (1) random Generator
    // (2) Increasing order
    // (3) Decreasing order
    private final static int r = 1;
    // (1) mergeSort
    // (2) quickSort
    private final static int s = 1;     
    
    public static void main(String[] args) {
        // Declaration of variables
        long startTime;
        long endTime;
        
        // Instantiation of objects
        numGen gen = new numGen(n);
        mergeSort mSort = new mergeSort(n);
        quickSort qSort = new quickSort(n);

        if (r == 1)
            gen.randG1();   
        else if (r==2)
            gen.randG2();
        else if (r==3)
            gen.randG3();
        
        // Print out array
        gen.print();    
        
        // mergeSort selection
        if (s == 1) {
            System.out.println("\n**** Start mergeSort ****");
            // Start timing of method
            startTime = System.nanoTime();
            mSort.sort(gen.getArr(), 0, n-1);
            endTime = System.nanoTime();
            // End timing of method
        }
        
        // quickSort selection
        else if (s == 2) {   
            System.out.println("\n**** Start quickSort ****");
            // Start timing of method
            startTime = System.nanoTime();
            qSort.sort(gen.getArr(), 0, n-1);
            endTime = System.nanoTime();
            // End timing of method
        }

        print(gen.getArr());      //Print sorted array
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
