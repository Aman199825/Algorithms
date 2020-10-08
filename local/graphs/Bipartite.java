import java.util.*;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        // write your code here
        int n = adj.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        colors[0] = 0;
        while (!q.isEmpty()) {
            Integer temp = q.poll();
            for (int nei : adj[temp]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    colors[nei] = 1 - colors[temp];
                    q.add(nei);
                } else if (colors[nei] == colors[temp]) {
                    return 0;
                }
            }

        }
        return 1;
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
        System.out.println(bipartite(adj));
    }
}
