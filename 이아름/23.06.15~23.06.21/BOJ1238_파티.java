import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238_파티 {

    static int N, M, X;
    static ArrayList<Node>[] list;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            Dijkstra(i);
        }

        int[] sum = new int[N + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            sum[i] = dist[X][i] + dist[i][X];
            max = Math.max(sum[i], max);
        }

        System.out.println(max);
    }

    private static void Dijkstra(int x) {

        // X -> 각 노드
        boolean[] visited = new boolean[N + 1];

        dist[x][x] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.w]) continue;
            visited[cur.w] = true;

            for (Node next : list[cur.w]) {
                if (dist[x][next.w] > dist[x][cur.w] + next.cost) {
                    dist[x][next.w] = dist[x][cur.w] + next.cost;

                    pq.offer(new Node(next.w, dist[x][next.w]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int w, cost;

        Node(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}