import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NegativeCycle {

    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        // write your code here
        int n1 = adj.length;
        long[] dist = new long[n1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                for (int nei : adj[j]) {
                    int ind = adj[j].indexOf(nei);
                    int currwt = cost[j].get(ind);
                    if (dist[nei] > dist[j] + currwt) {
                        if (i == n1 - 1)
                            return 1;
                        dist[nei] = dist[j] + currwt;
                    }
                }
            }
        }

        return 0;
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
        System.out.println(negativeCycle(adj, cost));
    }
}
