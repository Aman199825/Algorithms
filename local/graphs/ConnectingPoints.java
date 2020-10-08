
import java.text.DecimalFormat;
import java.util.*;

class Node {
    int x;
    int y;
    int parent;
    int rank;

    Node() {

    }

    Node(int x, int y, int parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        rank = 0;
    }
}

class Edge {
    int u;
    int v;
    double weight;

    Edge(int u, int v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class ConnectingPoints {
    static double weight(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    static int find(Node[] nodes, int i) {
        if (nodes[i].parent == i)
            return nodes[i].parent;
        nodes[i].parent = find(nodes, nodes[i].parent);
        return nodes[i].parent;
    }

    static void union(Node[] nodes, int i, int j) {
        int r1 = find(nodes, i);
        int r2 = find(nodes, j);
        if (r1 != r2) {
            if (nodes[r1].rank > nodes[r2].rank) {
                nodes[r2].parent = r1;
            } else if (r2 > r1) {
                nodes[r1].parent = r2;
            } else {
                nodes[r1].parent = r2;
                nodes[r2].rank += 1;
            }
        }
    }

    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        // write your code here
        int n = x.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(x[i], y[i], i);
        }
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, weight(x[i], y[i], x[j], y[j])));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {

            @Override
            public int compare(Edge e1, Edge e2) {
                // TODO Auto-generated method stub
                return e1.weight < e2.weight ? -1 : 1;
            }

        });
        int n2 = edges.size();
        for (int i = 0; i < n2; i++) {
            Edge temp = edges.get(i);
            int src = temp.u;
            int dest = temp.v;
            if (find(nodes, src) != find(nodes, dest)) {
                result += temp.weight;
                union(nodes, src, dest);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        double res = minimumDistance(x, y);
        // System.out.format(arg0, arg1)
        DecimalFormat numberFormat = new DecimalFormat("#.000000");
        System.out.println(numberFormat.format(res));
    }
}
