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

        List<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            sc.nextLine();
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            graph.get(from - 1).add(new Node(to - 1, weight));
            graph.get(to - 1).add(new Node(from - 1, weight));
        }
        int[] dist = new int[N];
        dist = dijkstra(N, graph, 0);

        System.out.println(dist[N - 1]);

        sc.close();
    }

    private static int[] dijkstra(int N, List<ArrayList<Node>> graph, int startIndex) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startIndex] = 0;
        // 힙을 사용해 실행시간을 N*N에서 N*logN으로 줄여야 해결할 수 있다.
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				
				return o1.weight - o2.weight;
			}
		});
        pq.add(new Node(startIndex, 0));
        boolean visited[] = new boolean[N];
        
        
        while(!pq.isEmpty()) {
            int nodeWeight = pq.peek().weight;
            int node = pq.poll().index;
            
            if(visited[node] && dist[node] < nodeWeight) {
                continue;
            }
            
            visited[node] = true;
            
            for(int j = 0; j < graph.get(node).size(); j++) {
                Node adjNode = graph.get(node).get(j);

                int nextWeight = dist[node] + adjNode.weight;
                if(nextWeight < dist[adjNode.index]) {
                    dist[adjNode.index] = dist[node] + adjNode.weight;
                    pq.add(new Node(adjNode.index, nextWeight));
                }
            }
        }

        return dist;
    }
}
