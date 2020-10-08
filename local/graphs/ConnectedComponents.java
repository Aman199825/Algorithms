import java.util.ArrayList;
import java.util.*;

public class ConnectedComponents {

    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;

        // write your code here
        int n = adj.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result += 1;
                dfs(adj, visited, i);
            }
        }
        // result = count;
        return result;
    }

    static void dfs(ArrayList<Integer>[] adj, boolean[] visited, int x) {
        visited[x] = true;

        for (int nei : adj[x]) {
            if (!visited[nei]) {
                dfs(adj, visited, nei);
            }
        }
    }

    static int bfs(ArrayList<Integer>[] adj, boolean[] visited, int x) {
        visited[x] = true;
        int res = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int nei : adj[temp]) {

                if (!visited[nei]) {
                    res += 1;
                    q.add(nei);
                    visited[nei] = true;
                }
            }
        }
        return res;
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
        System.out.println(numberOfComponents(adj));
    }
}
