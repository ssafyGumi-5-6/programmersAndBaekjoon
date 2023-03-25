package 롤케이크_자르기;

import java.util.*;


class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        // 0 : 왼쪽으로 개수, 1 : 오른쪽으로 개수
        int[][] arrCnt = new int[topping.length][2];
        Set<Integer> set = new HashSet<>();
        int cnt = 0;

        // 왼쪽으로 시작하여 개수 세기, 0 ~ N - 1
        for(int i = 0; i < topping.length; i++){

            // set에 포함되어 있다면 횟수 증가하고 set에 넣기
            // set에 포함되어 있지 않다면 횟수, set x
            if(!set.contains(topping[i])){
                set.add(topping[i]);
                cnt += 1;
            }

            arrCnt[i][0] = cnt;

        }

        set = new HashSet<>();
        cnt = 0;

        // 오른쪽으로 시작하여 개수 세기, N - 1 ~ 0
        for(int i = topping.length - 1; i >= 0; i--){
            // set에 포함되어 있다면 횟수 증가하고 set에 넣기
            // set에 포함되어 있지 않다면 횟수, set x
            if(!set.contains(topping[i])){
                set.add(topping[i]);
                cnt += 1;
            }
            arrCnt[i][1] = cnt;
        }


        for(int i = 0; i < topping.length - 1; i++){
            // System.out.println("arr : " + arrCnt[i][0] + " " + arrCnt[i][1]);
            if(arrCnt[i][0] == arrCnt[i+1][1]){
                answer += 1;
            }
        }

        return answer;
    }
}
