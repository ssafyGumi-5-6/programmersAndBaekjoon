import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] graph = new int[N];

        // 그래프 입력
        for(int i = 0; i < N; ++i) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[N];
        List<Integer> answer = new ArrayList<>();
        // 그래프 탐색
        for(int i = 0; i < N; ++i) {
            if(visited[i]) {
                continue;
            }

            // i로 시작해 i로 끝나는지 확인하는 dfs 메서드
            List<Integer> result = dfs(i, i, visited, graph);
            // 결과로 나온 List를 정답List와 합친다.
            if(result != null) {
                answer.addAll(result);
            }
        }

        sb.append(answer.size()).append("\n");

        answer.sort((i1, i2) -> i1 - i2);
        for(Integer i : answer) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private static List<Integer> dfs(int start, int cur, boolean[] visited, int[] graph) {
        // 방문한 노드라면
        if(visited[cur]) {
            // 노드가 시작지점과 같으면 List 반환
            if(cur == start) {
                List<Integer> list = new ArrayList<>();
                return list;
            }

            // 아니면 null 반환
            return null;
        }

        // 방문하지 않은 노드면 체크 후 dfs 반복
        visited[cur] = true;
        List<Integer> list = dfs(start, graph[cur] - 1, visited, graph);
        if(list == null) {
            // dfs결과가 null 이면 탐색의 시작 노드와 끝 노드가 다르다는 것을 의미하므로
            // 방문 체크 해제 후 null 반환
            visited[cur] = false;
            return null;
        } else {
            // null이 아니면 현재 노드 값을 list에 넣어준다.
            list.add(cur + 1);
            return list;
        }
    }

}
