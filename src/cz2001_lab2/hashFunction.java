/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz2001_lab2;

import java.util.*;
import java.lang.Math;

//Could try and implement a table size that changes accordingly to the number of keys that are going to be inserted.

public class hashFunction {
    protected static int tableSize = 997;
    
    public int hash(int key) { 
        // hashFunction with key mod prime number, 997 to allow for a bigger table size
        return key % tableSize;
    }
    
    public static int getTableSize(){
        return tableSize;
    }
}
