package 단속카메라;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static int solution(int[][] routes) {
        // 단속 카메라
        // - routes에는 차량의 이동 경로가 포함되어 있다.
        // - routes[i][0], routes[i][1]에는 i번째 차량이 진입 나간 지점이 적혀있다.
        // 📢 어떻게 풀었는가?
        // - 나간지점을 기준으로 정렬을 한다.
        // - 다음번 구간이 현재 구간에 해당되지 않는다면 새로 시작한다.

        // ex)
        // - [[-20, 15], [-14,-5], [-18,-13], [-5,-3]]
        // - [-18, -13], [-14, -5], [-5, -3], [-20, 15]
        // - [-18, -13], [-14, -5] : 1
        // - [-5, -3], [-20, 15] : 1
        // => 답 : 2

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 0번 저장 도착지점 시작
        int start = routes[0][1];
        int answer = 1;
        for(int i =1; i< routes.length; i++){
            if(start < routes[i][0]){
                answer +=1 ;
                start = routes[i][1];
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[][] arr = {{-20, 15}, {-14,-5}, {-18,-13}, {-5,-3}};

        System.out.println(solution(arr));



    }
}
