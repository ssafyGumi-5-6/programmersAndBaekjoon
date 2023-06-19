import java.util.*;

public class Main {
    public static class Node {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        sc.nextLine();

        List<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            sc.nextLine();

            graph.get(from - 1).add(new Node(to - 1, weight));
        }
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++) {
            dist[i] = dijkstra(N, graph, i);
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer = Math.max(dist[i][X - 1] + dist[X - 1][i], answer);
        }

        System.out.println(answer);

        sc.close();
    }

    private static int[] dijkstra(int N, List<ArrayList<Node>> graph, int startIndex) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N];
        dist[startIndex] = 0;

        for(int i = 0; i < N; i++) {
            int nodeWeight = Integer.MAX_VALUE;
            int node = 0;

            for(int j = 0; j < N; j++) {
                if(!visited[j] && (dist[j] < nodeWeight)) {
                    nodeWeight = dist[j];
                    node = j;
                }
            }

            visited[node] = true;
            for(int j = 0; j < graph.get(node).size(); j++) {
                Node adjNode = graph.get(node).get(j);

                dist[adjNode.index] = Math.min(dist[adjNode.index], dist[node] + adjNode.weight);
            }
        }

        return dist;
    }
}
