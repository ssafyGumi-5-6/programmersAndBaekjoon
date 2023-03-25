import java.util.*;

class pg43162 {

    static List<Integer>[] list;
    static boolean[] visited;

    static void dfs(int idx) {

        for (int i = 0; i < list[idx].size(); i++) {
            if (!visited[list[idx].get(i)]) {
                visited[list[idx].get(i)] = true;
                dfs(list[idx].get(i));
            }
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] != 0) list[i].add(j);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer += 1;
            }
        }

        return answer;
    }
}
