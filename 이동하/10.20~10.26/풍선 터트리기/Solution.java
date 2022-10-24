import java.util.Arrays;

class Solution {
    public int solution(int[] a) {
    	int a_len = a.length;
    	boolean [] ans = new boolean [a_len];
    	int answer = 0;
    	int k = Integer.MAX_VALUE;
    	for (int i = 0; i < a_len; i++) {
    		if (k > a[i]) {
    			k = a[i];
    			ans[i] = true;
    			answer++;
    		}
    	}
    	k = Integer.MAX_VALUE;
    	for (int i = a_len-1; i >= 0; i--) {
    		if (k > a[i]) {
    			k = a[i];
    			if (ans[i] == false) answer++;
    		}
    	}
    	System.out.println(answer);
    	return 0;
    }
    public static void main(String[] args) {
		new Solution().solution(new int [] {9,-1,-5});
		new Solution().solution(new int [] {-16,27,65,-2,58,-92,-71,-68,-61,-33});
	}
}