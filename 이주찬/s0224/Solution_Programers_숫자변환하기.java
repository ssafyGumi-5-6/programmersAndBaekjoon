import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_Programers_숫자변환하기 {
    public static void main(String[] args) {
        /* 
        10	40	5
        10	40	30
        2	5	4 
        */
        Solution sol = new Solution();
        int[] xInput = { 10, 10, 2, 1 };
        int[] yInput = { 40, 40, 5, 475134 };
        int[] nInput = { 5, 30, 4, 1 };
        for (int i = 0; i < xInput.length; i++) {
            System.out.println(sol.solution(xInput[i], yInput[i], nInput[i]));
        }
    }

    static class Solution {

        public int solution(int x, int y, int n) {
            Queue<Integer> q = new ArrayDeque<Integer>();
            q.offer(x);
            int count = -1;
            int res = -1;
            boolean[] visited = new boolean[y + 1];
            Loop1: while (!q.isEmpty()) {
                int width = q.size();
                count++;
                for (int i = 0; i < width; i++) {
                    int cur = q.poll();
                    // System.out.println(y + " " + cur + " : " + Arrays.toString(q.toArray()));
                    if (visited[cur])
                        continue;
                    visited[cur] = true;
                    if (cur == y) {
                        res = count;
                        break Loop1;
                    }
                    if(y >= cur * 3)
                        q.offer(cur * 3);
                    if (y >= cur * 2)
                        q.offer(cur * 2);
                    if(y >= cur + n)
                        q.offer(cur + n);
                }
            }
            return res;
        }

        
    }
}
