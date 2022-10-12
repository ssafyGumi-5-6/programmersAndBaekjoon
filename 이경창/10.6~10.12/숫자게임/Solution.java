package 숫자게임;

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = -1;

        Arrays.sort(A);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i< B.length;i++){
            pq.add(B[i]);
        }


        int idx = 0;
        while(pq.size() > 0){
            int curData = pq.poll();

            if(A[idx] < curData){
                idx += 1;
            }
        }

        answer = idx;

        return answer;
    }
}