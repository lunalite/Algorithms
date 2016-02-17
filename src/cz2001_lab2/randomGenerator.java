/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz2001_lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;

public class randomGenerator {
    private ArrayList<Integer> rList;
    private ArrayList<Integer> aList;
    private static final int SIZE = 1000000;
    public randomGenerator() {
        this.aList = new ArrayList<Integer>();
        this.rList = new ArrayList<Integer>();

    }
    
    public void generate(int size) {
		int x = 0;
    	for (int i=0;i<SIZE;i++){
			aList.add(i);		//Generates numbers 0 to SIZE (in this case, 999999)
		}
		Collections.shuffle(aList);	//Shuffles numbers
		for (int i=0; i < size; i ++) {
			rList.add(aList.remove(0)); //Retrieves required number of random numbers without repetition
			}
		}
    
    public ArrayList<Integer> getList() {
        return rList;
    }
    public void del() {
        while (!rList.isEmpty()){
            rList.removeAll(rList);
        }
    }
    public void print() {
       for (Object x : rList){
           System.out.print(x + " ");
       }
       System.out.println("");
    }
}
