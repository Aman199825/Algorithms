import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        // write your code here
        int n = adj.length;
        boolean[] visited = new boolean[n];
        boolean[] recstack = new boolean[n];
        for (int i = 0; i < n; i++) {

            if (dfs(adj, visited, i, recstack))
                return 1;

        }
        return 0;
    }

    static boolean dfs(ArrayList<Integer>[] adj, boolean[] visited, int src, boolean[] recstack) {

        if (recstack[src])
            return true;
        if (visited[src])
            return false;
        visited[src] = true;
        recstack[src] = true;
        for (int nei : adj[src]) {

            if (dfs(adj, visited, nei, recstack))
                return true;
        }
        // processing complete
        recstack[src] = false;
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
        }
        System.out.println(acyclic(adj));
    }
}
