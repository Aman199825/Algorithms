

import java.util.*;

class Edge {
    int vertex;
    int wt;

    Edge(int vertex, int wt) {
        this.vertex = vertex;
        this.wt = wt;
    }
}

public class Dijkstra {
  
    static PriorityQueue<Edge> pq = null;
    static Integer[] dist = null;

    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int n = adj.length;
        pq = new PriorityQueue<Edge>((e1, e2) -> e1.wt - e2.wt);
       
        dist = new Integer[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        pq.add(new Edge(s, 0));
        while (!pq.isEmpty()) {
            Edge temp = pq.poll();
            int v = temp.vertex;
            for(int nei:adj[v])
            {
            	int ind=adj[v].indexOf(nei);
            	if(dist[nei]>dist[v]+cost[v].get(ind))
            	{
            		dist[nei]=dist[v]+cost[v].get(ind);
            		pq.add(new Edge(nei,dist[nei]));
            	}
            	
            }
        }
        // settled.add(s);
        return dist[t] == Integer.MAX_VALUE ? -1 : dist[t];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

