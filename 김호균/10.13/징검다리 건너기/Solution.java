import java.util.Arrays;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        // k 개씩 비교 제일 큰 수가 전체에서 제일 작은 수면 그게 정답
        // 제일 큰 수 다음 인덱스로 넘긴다. 
        // 효율성 13 시간 초과 최대 N^2의 시간 복잡도를 가진다.
//         int min = Integer.MAX_VALUE;
//         for(int i = 0, stonesSize = stones.length; i + k <= stonesSize; i++) {
//             int index = 0;
//             int max = 0;
//             for(int j = i; j < i + k; j++) {
//                 if(stones[j] > max) {
//                     index = j;
//                     max = stones[j];
//                 }
//             }
//             i = index;
            
//             if(max < min) {
//                 min = max;
//             }
//         }
//         answer = min;
        // 이진 탐색으로 풀이...
        // https://velog.io/@hyunjkluz/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4640464-%EC%A7%95%EA%B2%80%EB%8B%A4%EB%A6%AC-%EA%B1%B4%EB%84%88%EA%B8%B0-Java
        int min = 1, max = 200000000;
        while(min <= max) {
            int mid = (min + max) / 2;
            int cross = 0;
            for(int i : stones) {
                if(i - mid < 0) {
                    cross++;
                } else {
                    cross = 0;
                }
                
                if(cross == k) break;
            }
            
            if(cross == k) {
                max = --mid;
            } else {
                min = mid + 1;
                answer = Math.max(answer, mid);
            }
            
        }
        return answer;
    }
}