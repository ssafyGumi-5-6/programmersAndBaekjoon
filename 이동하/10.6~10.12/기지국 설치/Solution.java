import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] stations, int w) {
    	int [] [] range = new int [stations.length] [2];
    	range[0][0] = Math.max(stations[0]-w, 1);
    	range[0][1] = Math.min(n, stations[0]+w);
    	int idx = 0;
    	for (int i = 1; i < stations.length; i++) {
    		if (range[idx][1] < stations[i]-w) {
    			range[++idx][0] = stations[i] - w;
    			range[idx][1] = Math.min(n, stations[i] + w);
    		} else {
    			range[idx][1] = Math.min(n, stations[i] + w);
    		}
    	}
    	int r = w*2+1;
    	int answer = ((range[0][0]-1) + (r-1)) / r;
    	for (int i = 1; i <= idx; i++) answer += ((range[i][0]-range[i-1][1]-1) + (r-1)) / r;
    	answer += ((n - range[idx][1]) + (r-1)) / r;
        return answer;
    }
	public static void main(String[] args) {
		new Solution().solution(11, new int [] {4, 11}, 1);
		new Solution().solution(16, new int [] {9}, 2);
	}
}