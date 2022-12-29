package Solution;


import java.util.*;
class Solution {

    // 방문처리
    boolean[] visited;
    // 입력값 저장 배열
    int[][] dungeons;
    // 정답, 횟수
    int answer = 0;

    void backtracking(int cnt, int k){
        // System.out.println("cnt : " + cnt + " k : " + k);
        // 만약 k < 0이라면 answer을 체크한다.(Max(answer, cnt))
        answer = Math.max(answer, cnt);

        for(int i = 0; i < dungeons.length; i++){
            // 최소 필요 피로도가 k보다 작거나 같다면 탐색한다.
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                backtracking(cnt + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }

    }

    public int solution(int k, int[][] _dungeons) {

        visited = new boolean[_dungeons.length];
        dungeons = _dungeons;
        Arrays.sort(dungeons, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2 ){
                return o2[0] - o1[0];
            }
        });
        // System.out.println("Arrays : " + Arrays.deepToString(dungeons));
        backtracking(0, k);

        //System.out.println();


        return answer;
    }
}