/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algolab4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlgoLab4 {
    private static final int vert = 10;    // Number of vertices
    private static final int edges = 10;   // Number of edges
    private static List<Integer>[] graph = new LinkedList[vert];
    private static int[] visited = new int[vert];       // If visited[x] = 1, means vertex x has been visited.
    private static int[][] lengthV = new int[vert][vert]; //length array of [initial][final]
    private static int[][] parent = new int[vert][vert];  //parent of the shortest path for [starting node][current node]
    
    public static void main(String[] args) {
        randG rG = new randG(edges*2);
        rG.generate(edges, vert);     
        createGraph(rG.getList());
        Queue L = new LinkedList<Integer>();
        long totalTime = 0;
        for (int z = 0; z < vert; z ++) {
            Arrays.fill(parent[z],-1);  // Initialise the parent array, such that the starting value is -1
                                        // i.e. if parent[x][y] = -1, then current node y has no parents for starting 
                                        // node x.
                                        
            Arrays.fill(visited, 0);    // Initialise the visited array
            if (graph[z] != null){
                long start_time = System.nanoTime();
                bFS(z, L);
                long end_time = System.nanoTime();
                totalTime += end_time - start_time;
            }
        }
        System.out.println("Time elapsed: " + totalTime);
        
        //To print out the arrays for parent and length array
        //print2DArray(lengthV);
        //print2DArray(parent);
    }   
    public static void createGraph(List<Integer> list) {
        int i = 0;
        while (i < edges*2){
            // instantiate the graph list
            if (graph[list.get(i)] == null){
                graph[list.get(i)] = new LinkedList<Integer>();
            }
            if (graph[list.get(i+1)] == null){
                graph[list.get(i+1)] = new LinkedList<Integer>();
            }
            //This ensures that there is no repetition in the edges formed but total number of edges will decrease
            if (!graph[list.get(i)].contains(list.get(i+1)))
                graph[list.get(i)].add(list.get(i+1));
            if (!graph[list.get(i+1)].contains(list.get(i)))
                graph[list.get(i+1)].add(list.get(i));
            i += 2;
        }
    }
    public static void printGraph(){
        for (int i = 0; i < vert ; i ++){
            if (graph[i] != null){
                System.out.print("Connector for " + i + ": ");
                Iterator<Integer> itr = graph[i].iterator();
                while (itr.hasNext()){
                    System.out.print(itr.next() + " ");
                }
                System.out.println("");
            }
            
        }
    }
    public static void bFS(int start, Queue L){
        visited[start] = 1;
        L.add(start);    //put s into the empty queue L;
        while (!L.isEmpty()) {
            int justVisited = (int)L.remove(); //remove a vertex v from front of queue L;
            for (int vert : graph[justVisited]){
		    if (visited[vert] == 0) {
                        visited[vert] = 1;
                        L.add(vert); //add w to end of queue L;
                        parent[start][vert] = justVisited;  //Add just visited node to current node as parent
                        // Add length of children by 1 greater than parent length to starting node
                        lengthV[start][vert] = lengthV[start][justVisited] + 1; 
                    }	
            }
	}
    }
    public static void print2DArray(int[][] arr) {
        for (int i=0;i<vert;i++){
            for (int j=0;j<vert;j++)
                System.out.printf("%5d", arr[i][j]);
            System.out.println("");
        }
        System.out.println(" ");
    }
}
