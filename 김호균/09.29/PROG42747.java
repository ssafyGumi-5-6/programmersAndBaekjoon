import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int h = Integer.MAX_VALUE;
        int count = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] < h) {
                h = citations[i];
            }
            
            if(h <= answer) break;
            answer++;
        }
        
        return answer;
    }
}