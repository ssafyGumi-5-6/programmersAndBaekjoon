import java.util.Arrays;

class Solution {
    public int solution(int[][] board, int[][] skill) {
    	int [] d = new int [3];
    	d[1] = -1;
    	d[2] = 1;
    	int r = board.length;
    	int c = board[0].length;
    	int [] [] sum = new int [r+1] [c+1];
    	for (int [] s : skill) {
//    		System.out.println(Arrays.toString(s));
    		sum[s[1]][s[2]]+=s[5] * d[s[0]];
    		sum[s[1]][s[4]+1]+=s[5] * -d[s[0]];
    		sum[s[3]+1][s[2]]+=s[5] * -d[s[0]];
    		sum[s[3]+1][s[4]+1]+=s[5] * d[s[0]];
    	}
//    	for (int [] k : sum) {
//    		System.out.println(Arrays.toString(k));
//    	}
//    	System.out.println();
    	for (int i = 0; i < r; i++) {
    		int temp = 0;
    		for (int j = 0; j < c; j++) {
    			sum[i][j] += temp;
    			temp = sum[i][j];
    		}
    	}
//    	for (int [] k : sum) {
//    		System.out.println(Arrays.toString(k));
//    	}
//    	System.out.println();
    	for (int i = 0; i < c; i++) {
    		int temp = 0;
    		for (int j = 0; j < r; j++) {
    			sum[j][i] += temp;
    			temp = sum[j][i];
    		}
    	}
//    	for (int [] k : sum) {
//    		System.out.println(Arrays.toString(k));
//    	}
    	int answer = 0;
    	for (int i = 0; i < r; i++) {
    		for (int j = 0; j < c; j++) {
    			if (board[i][j] + sum[i][j] > 0) answer++;
    			board[i][j] += sum[i][j];
    		}
    	}
//    	System.out.println();
//    	for (int [] i : board) {
//    		System.out.println(Arrays.toString(i));
//       	}
    	System.out.println(answer);
        return 0;
    }
    public static void main(String[] args) {
		new Solution().solution(new int [] [] {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int [] [] {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}});
		new Solution().solution(new int [] [] {{1,2,3},{4,5,6},{7,8,9}}, new int [] [] {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}});
	}
}