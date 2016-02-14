/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz2001_lab2;

import java.util.*;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        boolean End = false;
        int key2BSearch;
        int index;
        //initialising list randG with 10 numbers
        randomGenerator randG = new randomGenerator(); 
        hashOpen hO = new hashOpen();
        hashClosed HC = new hashClosed();
        randG.generate(10);
        System.out.println("==============");
        System.out.println("1. Print current list");
        System.out.println("2. Re-/Generate number list");
        System.out.println("3. Open address hashing scheme");
        System.out.println("4. Closed address hashing scheme");
        System.out.println("5. Terminate");
        System.out.println("==============");
        do{
            int Choice = sc.nextInt();
            switch (Choice) {
                case 1:
                    randG.print();
                    break;
                case 2:
                    System.out.print("Please insert the amount of numbers to be generated: ");
                    int N = sc.nextInt();
                    randG.del();
                    randG.generate(N);
                    break;
                case 3:
                    // Open address hashing scheme
                    hO.hashInsertList(randG.getList());
                    System.out.println("==============");
                    System.out.println("hash = key");
                    hO.print();
                    System.out.println("==============");
                    do {
                    System.out.print("Insert number to be searched: ");
                    key2BSearch = sc.nextInt();
                    if (key2BSearch == -1)
                        break;
                    index = hO.search(key2BSearch);
                    if (index == -1)
                        System.out.println("Not found.");
                    else
                        System.out.println("Key " + key2BSearch + " with code " + hO.hash(key2BSearch) +" found at index " + index + " % " + hO.tableSize);
                    System.out.println("Total number of comparisons excluding those in main: " + hO.getComparisons());
                    } while (key2BSearch != -1);
                    break;
                case 4:
                    // Closed address hashing scheme
                    HC.hashInsertList(randG.getList());
                    System.out.println("==============");
                    System.out.println("hash = key");
                    HC.print();
                    System.out.println("==============");
                    do {
                    System.out.print("Insert number to be searched: ");
                    key2BSearch = sc.nextInt();
                    if (key2BSearch == -1)
                        break;
                    index = HC.search(key2BSearch);
                    if (index == 0 || index == -1)
                        System.out.println("Not found.");
                    else
                        System.out.println("Key " + key2BSearch + " found at index " + index );
                    System.out.println("Total number of comparisons excluding those in main: " + HC.getComparisons());
                    } while (key2BSearch != -1);
                    break;
                case 5:
                    End = true;
                    System.out.println("System terminating...");
                    break;
                default: 
                    break;
            }
        } while (End == false);            
    }   
}
