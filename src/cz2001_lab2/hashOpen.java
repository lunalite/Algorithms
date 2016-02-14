/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz2001_lab2;

import java.util.*;

public class hashOpen extends hashFunction {
    private int Comparisons;
    private int[] oSortList = new int[tableSize];
    public void hashInsert(int key){
        int code = hash(key);
        int i = code;
        boolean inserted = false;
        while (inserted == false) {
            if (oSortList[i%tableSize] == 0) {
                oSortList[i%tableSize] = key;
                return;
            }
            else 
                i++;
        }
    }
    public void hashInsertList(ArrayList<Integer> list){
        int i = 0;
        while (i < list.size()) {
            hashInsert(list.get(i));
            i++;
            }
        }
    public void print() {
        for (int i = 0 ; i < tableSize; i ++) {
            if (oSortList[i] != 0)
                System.out.println(i + " = " + oSortList[i]);
        }
    }
    public int search(int key) {
        int code = hash(key);
        int i = code;
        Comparisons = 0;
        if (oSortList[i] == 0) {
            Comparisons ++;
            return -1;
        }
        while (oSortList[i%tableSize] != 0) { //linear probing
            Comparisons ++;
            if (oSortList[i%tableSize] == key)
                return i;
            else if (i == code*2)
                break;
            else
                i++;
        }
        return -1;
    }
    public int getComparisons() {
        return Comparisons;
    } 
}
