import java.util.Arrays;

import sun.jvm.hotspot.utilities.IntegerEnum;

public class Solution {
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        dijsktra(graph, 0);

        // System.out.println(graph.length + " " + graph[0].length);

    }

    static int findMinium(int[] distance, boolean[] finalized, int length) {

        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < length; i++) {
            /// i am an idiot bitch
            if (!finalized[i] && distance[i] <= min) {
                answer = i;
                min = distance[i];
            }
        }
        return answer;

    }

    static void dijsktra(int[][] graph, int src) {

        // we could use a better data structure for this

        int[] distance = new int[graph.length];// instead we can use a hashmap for the following distance //set can also
                                               // be used 
        boolean[] finalized = new boolean[graph.length];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(finalized, false);

        distance[src] = 0;

        int u = findMinium(distance, finalized, graph.length);

        // this will undergo every adacent vertex of the u vertex
        for (int i = 0; i < graph.length; i++) {

            // Explaination to the if condition
            // the distance of the source to the vertex should be less than the value which
            // is stored in distance array
            // distance of the source should be not be infinity
            // and the destination vertex should not be finalized
            // there should be some connection to the vertex from the source

            if (graph[u][v] < distance[v] && distance[u] != Integer.MAX_VALUE && !finalized[v] && graph[u][v] != 0) {
                distance[v] = graph[u][v];
            }
        }

    }

}