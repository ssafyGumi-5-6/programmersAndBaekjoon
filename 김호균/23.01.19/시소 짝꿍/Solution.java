import java.util.Map;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> weightsMap = new HashMap<>();
        /*
         * 현재 값에서 아래 값을 곱한 값이 앞서 나온 적 있다면 그 경우 만큼 정답에 더해주면 된다.
         * 1/2, 2/3, 3/4, 1, 4/3, 3/2, 2
         */
        for(int i = 0; i < weights.length; i++) {
            
            if(weightsMap.get(weights[i]) == null) {
                weightsMap.put(weights[i], 1);
            } else {
                answer += weightsMap.get(weights[i]);
                weightsMap.put(weights[i], weightsMap.get(weights[i]) + 1);
            }
             
            if(weights[i] % 2 == 0) {
                if(weightsMap.get(weights[i] / 2) != null)
                    answer += weightsMap.get(weights[i] / 2); 
                
                if(weightsMap.get((weights[i] / 2) * 3) != null)
                    answer += weightsMap.get((weights[i] / 2) * 3);
            }
            
            if(weights[i] % 3 == 0) {
                if(weightsMap.get((weights[i] / 3) * 2) != null)
                    answer += weightsMap.get((weights[i] / 3) * 2);
                
                if(weightsMap.get((weights[i] / 3) * 4) != null)
                    answer += weightsMap.get((weights[i] / 3) * 4);
            }

            if(weightsMap.get(weights[i] * 2) != null)
                 answer += weightsMap.get(weights[i] * 2);

                
            if(weights[i] % 4 == 0 && weightsMap.get((weights[i] / 4) * 3) != null)
                answer += weightsMap.get((weights[i] / 4) * 3);
            
        }
        return answer;
    }
}
