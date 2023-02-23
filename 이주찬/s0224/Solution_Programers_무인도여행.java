import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다.
지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며,
격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다.
지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다.
이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다.
지도의 각 칸에 적힌 숫자는 식량을 나타내는데,
상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서
최대 며칠동안 머물 수 있는지를 나타냅니다. 어떤 섬으로 놀러 갈지
못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지
알아본 후 놀러갈 섬을 결정하려 합니다.

지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때,
각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요.
만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
 */
public class Solution_Programers_무인도여행 {
    public static void main(String[] args) {
        String[][] input = {
            {"X591X","X1X5X","X231X", "1XXX1"},
                { "XXX", "XXX", "XXX" },
            {"111", "XXX", "XXX"}
        };

        Solution solution = new Solution();
        for (int i = 0; i < input.length; i++) {
            int[] res = solution.solution(input[i]);
            System.out.println(Arrays.toString(res));
        }
    }

    static class Solution {
        static int[] ga = { 0, 1, 0, -1 };
        static int[] se = { -1, 0, 1, 0 };
        public int[] solution(String[] maps) {

            // 문자열 배열을 Integer 2차원 배열로 변환
            int w = maps[0].length();
            int h = maps.length;
            int[][] intMap = new int[h][w];
            for (int i = 0; i < h; i++) {
                String row = maps[i];
                for (int j = 0; j < w; j++) {
                    char c = row.charAt(j);
                    if (c == 'X') {
                        intMap[i][j] = 0;
                    } else {
                        intMap[i][j] = c - '0';
                    }
                }
            }
            // 각 무인도의 크기를 담을 pq
            Queue<Integer> pq = new PriorityQueue<Integer>();

            // 맵 전체를 순회
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    int[] zero = {0};
                    int res = dfs(intMap, visited, i, j, zero);
                    if (res != 0) {
                        pq.offer(res);
                    }
                }
            }
            int resLen = pq.size();
            if (resLen == 0) {
                return new int[] { -1 };
            }

            int[] answer = new int[resLen];
            int idx = 0;
            while (!pq.isEmpty()) {
                answer[idx++] = pq.poll();
            }
            return answer;
        }
        
        static int dfs(int[][] map, boolean[][] visited, int y, int x, int[] sum) {
            if (y < 0 || y >= map.length || x < 0 || x >= map[0].length)
                return 0;
            if (visited[y][x]) {
                return 0;
            }
            visited[y][x] = true;
            if (map[y][x] == 0) {
                return 0;
            }
            sum[0] += map[y][x];
            for (int i = 0; i < 4; i++) {
                int dy = y + se[i];
                int dx = x + ga[i];
                dfs(map, visited, dy, dx, sum);
            }
            return sum[0];
        }
        
    }
}

