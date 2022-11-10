import java.util.ArrayList;

class Solution {
	ArrayList<Integer> [] graph;
	boolean [] visit;
	int len;
	long answer = 0;
	long [] long_a;
	void dfs(int node) {
		// for (int i : graph[node]) {
        for (int k = 0; k < graph[node].size(); k++) {
            int i = graph[node].get(k);
			if (visit[i] == true) continue;
			visit[i] = true;
			dfs(i);
			answer += (long)Math.abs(long_a[i]);
			long_a[node] += long_a[i];
		}
	}
	public long solution(int[] a, int[][] edges) {
		len = a.length;
		graph = new ArrayList [len];
		long_a = new long[len];
		long chk = 0;
		for (int i = 0; i < len; i++) {
			long_a[i] = a[i];
			graph[i] = new ArrayList<Integer>();
			chk += a[i];
		}
		for (int [] e : edges) {
			graph[e[0]].add(e[1]);
			graph[e[1]].add(e[0]);
		}
		if (chk != 0) return -1;
		visit = new boolean [len];
		visit[0] = true;
		dfs(0);
        return answer;
    }
    public static void main(String[] args) {
    	ArrayList<Integer> aa = new ArrayList<>();
    	for (int i : aa) {
    		System.out.println(i);
    	}
    	new Solution().solution(new int [] {-5,0,2,1,2}, new int [] [] {{0,1},{3,4},{2,3},{0,3}});
    	new Solution().solution(new int [] {0,1,0} , new int [] [] {{0,1},{1,2}});
    }
}
