package 요격시스템;

import java.util.*;

public class Solution {
    public int solution(int[][] targets) {
        int answer = 0;


        // 오름 차순 정렬
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]){
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });

        int beforeArriveData = -1;
        for(int[] inTarget : targets){
            // 만약 현재 시작지점이 도착지점 보다 크다면 update
            if(inTarget[0] >= beforeArriveData){
                answer += 1;
                beforeArriveData = inTarget[1];
            }
        }
        
        return answer;
    }
}