/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz2001_lab2;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class randomGenerator {
    private ArrayList<Integer> rList;
    private static final int SIZE = 8999;
    public randomGenerator() {
        this.rList = new ArrayList<Integer>();
    }
    
    public void generate(int size) {
        for (int i = 0; i < size; i ++) {
            rList.add((int)(Math.random()*SIZE+1000));
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
