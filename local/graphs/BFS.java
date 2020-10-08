import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int vertex;
    int dist;

    Node(int vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }
}

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        // write your code here
        int n = adj.length;
        boolean[] visited = new boolean[n];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, 0));
        visited[s] = true;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            int currdist = temp.dist;
            for (int nei : adj[temp.vertex]) {
                if (!visited[nei]) {
                    if (nei == t) {
                        return currdist + 1;
                    }
                    q.add(new Node(nei, currdist + 1));
                    visited[nei] = true;
                }
            }
        }
        return -1;
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
        System.out.println(distance(adj, x, y));
    }
}
