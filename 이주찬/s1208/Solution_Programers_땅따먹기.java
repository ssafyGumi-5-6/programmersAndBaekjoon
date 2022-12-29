import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_Programers_땅따먹기 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input = {
                { 1, 2, 3, 5 },
                { 5, 6, 6, 8 },
                { 3, 4, 7, 9 },
                { 4, 2, 2, 1 }
        };

        int answer = sol.solution(input);
        System.out.println(answer);
    }

    static class Solution {
        int solution(int[][] land) {
            int answer = 0;
            int N = land.length;
            Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0]) {
                        return o2[0] - o1[0];
                    } else {
                        return o2[1] - o1[1];
                    }
                }

            });
            for (int i = 0; i < N; i++) {
                int[] diff = new int[6]; // 0: 최대 차, 1: 최댓값, 2: 최댓값 열 번호, 3: 차댓값, 4: 차댓값 열번호, 5: 행번호
                int max = 0;
                int amax = 0;
                int col = 0;
                int acol = 0;
                for (int j = 0; j < 4; j++) {
                    if (land[i][j] > max) {
                        amax = max;
                        acol = col;
                        max = land[i][j];
                        col = j;
                    } else if (land[i][j] > amax) {
                        amax = land[i][j];
                        acol = j;
                    }
                }
                diff[0] = max - amax;
                diff[1] = max;
                diff[2] = col;
                diff[3] = amax;
                diff[4] = acol;
                diff[5] = i;
                pq.add(diff);
            }
            int[] visited = new int[N];
            Arrays.fill(visited, -1);
            // 0: 최대 차, 1: 최댓값, 2: 최댓값 열 번호, 3: 차댓값, 4: 차댓값 열번호
            while (!pq.isEmpty()) {
                int[] curRow = pq.poll();
                int rowNum = curRow[5];
                if((rowNum > 0 && visited[rowNum - 1] != curRow[2]) && rowNum <)
            }
            return answer;
        }
    }
}
