package algolab4;

//Used to generate edges

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Iterator;

public class randG {
    private List<Integer> edgeList;
    public randG(int vertQty) {
        edgeList = new ArrayList(vertQty);
    }
    public void generate(int edgeQty, int vertQty){
        for (int i = 0; i < edgeQty; i ++){
            int x = (int)(Math.floor(Math.random()*vertQty));
            int y = (int)(Math.floor(Math.random()*vertQty));
            // do-while loop to ensure that there is no self-looping
            while (x == y){
                y = (int)(Math.floor(Math.random()*vertQty));
            }
            edgeList.add(x);
            edgeList.add(y);
        }
    }
    public List getList(){
        return edgeList;
    }
    public void printList(){
        Iterator itr = edgeList.iterator();
        while (itr.hasNext()){
            System.out.print("(" + itr.next() + " " + itr.next() + ") ");
        }
        System.out.println();
    }
}
