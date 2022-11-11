import java.util.ArrayList;

class Solution {
    ArrayList<Integer> [] graph;
    int answer;
    
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        // 트리 제작
        graph = new ArrayList [n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] i : wires) {
            int p = i[0];
            int c = i[1];
            graph[p].add(c);
            graph[c].add(p);
        }
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        // 1 번부터 자식 노드 탐색 시작
        int count = dfs(1, visited, n);
        return answer;
    }

    int dfs(int value, boolean[] visited, int n){
        int cnt = 1;
        // 자식이 없으면 반복문을 돌지 않으므로 1을 반환
        for(int i : graph[value]) {
            if(visited[i]) continue;
            visited[i] = true;
            // 자식 노드가 있으면 자식 노드의 자손 노드 합을 더해준다.
            cnt+= dfs(i, visited, n);
        }
        // 자손 노드 수를 구하면 해당 노드를 잘랐을 때 발생하는 차이를 비교하고
        // 작은 수를 답으로 넣어준다.
        answer = Math.min(answer, (Math.abs(cnt - (n - cnt))));
        return cnt;
    }
}