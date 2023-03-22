import java.util.Arrays;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Arrays.sort(section);
        int paintedSection = 0;
        for(int i = 0; i < section.length; i++) {
            if(paintedSection <= section[i]) {
                answer++;
                paintedSection = section[i] + m; 
            }
        }
        return answer;
    }
}
