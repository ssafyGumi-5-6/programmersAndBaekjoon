package 야근지수;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int in_n : works){
            pq.add(in_n * -1);
        }

        long answer = 0;

        while(n-- > 0){
            int in_n = pq.poll();

            if(in_n == 0) break;

            pq.offer(in_n + 1);
        }

        while(pq.size() > 0){
            int in_r = pq.poll() * -1;
            // System.out.print(in_r + " ");
            answer += Math.pow(in_r, 2);
        }

        return answer;
    }
}