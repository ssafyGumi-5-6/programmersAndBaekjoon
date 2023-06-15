package s1229;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        int len = enemy.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            pq.offer(enemy[i]);
            sum += enemy[i];
            if (sum > n) {
                if (k > 0) {
                    sum -= pq.poll();
                    k--;
                } else {
                    break;
                }
            }
            answer = i;
        }
        answer++;
        return answer;
    }
}
