/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz2001_lab2;

import java.util.*;

public class hashClosed extends hashFunction{
    private LinkedList<Integer>[] cSortList; 
    private int Comparisons;
    public hashClosed() {
        cSortList = new LinkedList[tableSize];
        }
    public void hashInsert(int key){
        int code = hash(key);
        if (cSortList[code] == null) {
            cSortList[code] = new LinkedList();
            }
        cSortList[code].addLast(key);
        }
    public void hashInsertList(ArrayList<Integer> list){
        int i = 0;
        while (i < list.size()) {
            hashInsert(list.get(i));
            i++;
        }
    }
    public int search(int key) {
        int code = hash(key);
        int i = 0;
        int size;
        Comparisons = 0;
        if (cSortList[code] == null) {
            Comparisons ++;
            return -1;
        }
        else 
            size = cSortList[code].size();
        while (i < size) {
            Comparisons ++;
            if (cSortList[code].get(i) == key)
                return code;
            else
                i++;
        }
        return -1;
    }
    public void print() {
        for (int i = 0; i < tableSize; i ++) {
            if (cSortList[i] != null)
                System.out.println(i + " = " + cSortList[i]);
        }
    }
    public int getComparisons() {
        return Comparisons;
    }
}
