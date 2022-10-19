import java.util.Arrays;

class Solution {
    public int solution(int sticker[]) {
    	int sticker_len = sticker.length;
    	if (sticker_len == 1) return sticker[0];
    	int [] answer1 = new int [sticker_len-1];
    	answer1[0] = sticker[0];
    	answer1[1] = Math.max(sticker[0], sticker[1]);
    	for (int i = 2; i < sticker_len-1; i++) answer1[i] = Math.max(answer1[i-1], answer1[i-2] + sticker[i]);
    	int [] answer2 = new int [sticker_len];
    	answer2[1] = sticker[1];
    	answer2[2] = Math.max(sticker[1], sticker[2]);
    	for (int i = 3; i < sticker_len; i++) answer2[i] = Math.max(answer2[i-1], answer2[i-2] + sticker[i]);
    	System.out.println(Math.max(answer1[sticker_len-2], answer2[sticker_len-1]));
    	return Math.max(answer1[sticker_len-2], answer2[sticker_len-1]);
    }
    
    public static void main(String[] args) {
		new Solution().solution(new int [] {14, 6, 5, 11, 3, 9, 2, 10});
		new Solution().solution(new int [] {1, 3, 2, 5, 4});
	}
}