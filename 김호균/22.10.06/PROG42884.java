import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int cameraPos = routes[0][1];
        answer = 1;
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] <= cameraPos && routes[i][1] >= cameraPos) continue;
            cameraPos = routes[i][1];
            answer++;
        }
        return answer;
    }
}