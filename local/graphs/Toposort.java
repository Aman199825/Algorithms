import java.util.*;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {

        ArrayList<Integer> order = new ArrayList<Integer>();
        // write your code here
        ArrayList<Integer> res = util(adj);
        return res;
    }

    static ArrayList<Integer> util(ArrayList<Integer>[] adj) {
        int n = adj.length;
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> list = adj[i];
            for (int j : list) {
                inorder[j] += 1;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inorder[i] == 0) {
                q.add(i);
                res.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer temp = q.poll();
            for (int nei : adj[temp]) {
                inorder[nei] -= 1;
                if (inorder[nei] == 0) {
                    res.add(nei);
                    q.add(nei);
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
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}
