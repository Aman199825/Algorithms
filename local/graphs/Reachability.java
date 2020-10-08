import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        // write your code here
        int v = adj.length;
        boolean[] visited = new boolean[v];
        if (bfs(adj, visited, x, y))
            return 1;
        return 0;
    }

    static boolean bfs(ArrayList<Integer>[] adj, boolean[] visited, int x, int y) {
        visited[x] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int nei : adj[temp]) {
                if (nei == y)
                    return true;
                if (!visited[nei]) {
                    q.add(nei);
                    visited[nei] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}
