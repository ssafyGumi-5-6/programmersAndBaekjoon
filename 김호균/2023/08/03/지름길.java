import java.util.*;

public class Main {
    public static class ShortCut {
        int start;
        int end;
        int distance;

        public ShortCut (int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static class Node {
    	int index;
    	int weight;

    	public Node (int index, int weight) {
    		this.index = index;
    		this.weight = weight;
    	}

    	@Override
		public boolean equals(Object n) {
    		Node node = (Node) n;
    		return node.index == this.index && node.weight == this.weight;
    	}

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        sc.nextLine();
        Map<Integer, Integer> nodeInfo = new HashMap<>();
        Map<Integer, Integer> nodeKey = new HashMap<>();

        List<ShortCut> shortcutList = new ArrayList<>();
        List<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0; i < N; ++i) {

            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();
            sc.nextLine();
            if(end <= D && end - start > distance) {
                shortcutList.add(new ShortCut(start, end, distance));        
            }
        }

        shortcutList.sort(
            (o1, o2) -> o1.start == o2. start ? o1.end - o2.end : o1.start - o2.start
        );

        if(shortcutList.isEmpty()) {
        	System.out.println(D);
        } else {

            for(int i = 0; i < 2; ++i) {
                graph.add(new ArrayList<>());
            }

        	int index = 0;
        	nodeInfo.put(index, 0);
        	nodeKey.put(0, index);
        	nodeInfo.put(++index, D);
        	nodeKey.put(D, index);

        	for(int i = 0; i < shortcutList.size(); ++i) {
        		int from = 0;
        		int to = 0;

        		if(nodeKey.get(shortcutList.get(i).start) == null) {
        			nodeInfo.put(++index, shortcutList.get(i).start);
        			nodeKey.put(shortcutList.get(i).start, index);
        			graph.add(new ArrayList<>());
        			from = index;
        		} else {
        			from = nodeKey.get(shortcutList.get(i).start);
        		}

        		if(nodeKey.get(shortcutList.get(i).end) == null) {
        			nodeInfo.put(++index, shortcutList.get(i).end);
        			nodeKey.put(shortcutList.get(i).end, index);
        			graph.add(new ArrayList<>());
        			to = index;
        		} else {
        			to = nodeKey.get(shortcutList.get(i).end);
        		}

        		graph.get(from).add(new Node(to, shortcutList.get(i).distance));

        		for(int j = 0; j < index; ++j) {
        			int jWeight = nodeInfo.get(j);
        			int fromWeight = nodeInfo.get(from);
        			int toWeight = nodeInfo.get(to);

        			if(jWeight > fromWeight) {
        				Node fromNode = new Node(j, jWeight - fromWeight);
        				if(!graph.get(from).contains(fromNode)) {
        					graph.get(from).add(fromNode);
        				}
        			} else if(jWeight < fromWeight) {
        				Node fromNode = new Node(from, fromWeight -jWeight);
        				if(!graph.get(j).contains(fromNode)) {
        					graph.get(j).add(fromNode);
        				}
        			}

        			if(jWeight > toWeight) {
        				Node toNode = new Node(j, jWeight - toWeight);
        				if(!graph.get(to).contains(toNode)) {
        					graph.get(to).add(toNode);
        				}
        			} else if(jWeight < toWeight) {
        				Node toNode = new Node(to, toWeight - jWeight);
        				if(!graph.get(j).contains(toNode)) {
        					graph.get(j).add(toNode);
        				}
        			}
        		}
        	}

        	int[] dist = dijkstra(nodeKey.size(), graph, 0);
        	System.out.println(dist[1]);
        }

        sc.close();
    }

    private static int[] dijkstra(int size, List<ArrayList<Node>> graph, int startIndex) {
        int[] dist = new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[size];
        dist[startIndex] = 0;

        for(int i = 0; i < size; i++) {
            int nodeWeight = Integer.MAX_VALUE;
            int node = 0;

            for(int j = 0; j < size; j++) {
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
