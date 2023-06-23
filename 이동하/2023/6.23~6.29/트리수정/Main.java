import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Vertex {
    int to;
    int weight;
    int index;

    Vertex(int to, int weight, int index) {
        this.to = to;
        this.weight = weight;
        this.index = index;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] [] data = new int [N-1][4];
        HashMap<Integer, ArrayList<Vertex>> graph = new HashMap<>();
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (graph.get(a) == null) graph.put(a, new ArrayList<Vertex>());
            if (graph.get(b) == null) graph.put(b, new ArrayList<Vertex>());
            graph.get(a).add(new Vertex(b, c, i));
            graph.get(b).add(new Vertex(a, c, i));
            data[i][0] = a;
            data[i][1] = b;
            data[i][2] = i;
            data[i][3] = c;
        }

        long answer = -1;
        for (int [] d : data) {
            long r1 = ring(d[0], d[2], graph, N);
            long r2 = ring(d[1], d[2], graph, N);
//            System.out.println(r1 + r2 + d[3]);
            answer = Math.max(answer, r1 + r2 + d[3]);
        }
        System.out.println(answer);
    }

    static long [] far_node;
    static void find_far (int start, int stop, HashMap<Integer, ArrayList<Vertex>> graph, long total_weight, boolean [] visit) {
        boolean flag = false;
        for (Vertex v : graph.get(start)) {
            flag = true;
            if (v.index == stop) continue;
            if (visit[v.to] == true) continue;
            visit[v.to] = true;
            find_far(v.to, stop, graph, total_weight + v.weight, visit);
            visit[v.to] = false;
        }
        if (flag) {
            if (far_node[1] < total_weight) {
                far_node[1] = total_weight;
                far_node[0] = start;
            }
        }
    }

    static long ring(int start, int stop, HashMap<Integer, ArrayList<Vertex>> graph, int N) {
        boolean [] visit = new boolean [N];
        visit[start] = true;
        far_node = new long [2];
        far_node[0] = start;
        far_node[1] = -1;
        find_far(start, stop, graph, 0, visit);
        int node = (int)far_node[0];
        far_node[0] = node;
        far_node[1] = -1;
        visit = new boolean [N];
        visit[node] = true;
        find_far(node, stop, graph, 0, visit);
//        System.out.println(Arrays.toString(far_node));
        return far_node[1];
    }
}
