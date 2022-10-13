package w1012;

public class Solution_Programers_12979_기지국설치 {

	public static void main(String[] args) {
		int[] N = {11, 16, 10};
		int[][] stations = {
				{4, 11},
				{9},
				{4, 10}
		};
		int[] W = {1, 2, 1};
		
		Solution sol = new Solution();
		
		for(int i = 0; i < N.length; i++) {
			System.out.println(sol.solution(N[i], stations[i], W[i]));
		}
	}
	
	static class Solution {
	    public int solution(int n, int[] stations, int w) {
	        int answer = 0;
	        
	        int cover = 2 * w + 1;
	        int last = 0;
	        for(int i = 0; i < stations.length; i++) {
	        	int st = stations[i];
	        	int curFront = st - w - 1;
	        	int curLast = st + w;
	        	int space = curFront - last;
	        	if(space > 0) answer += Math.ceil((double)space / (double)cover);
	        	last = curLast;
	        }
	        int space = n - last;
	        if(space > 0) answer += Math.ceil((double)space / (double)cover);

	        return answer;
	    }
	}
}
