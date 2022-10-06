import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
    	int answer = 0;
    	int len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        int check_idx = 0;
        while (check_idx < len) {
        	while (check_idx < len && A[idx] >= B[check_idx]) check_idx++;
        	if (check_idx < len) answer++;
        	idx++;
        	check_idx++;
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
    	new Solution().solution(new int [] {1}, new int [] {2});
		
		new Solution().solution(new int [] {1,3,5,7}, new int [] {0,2,4,6});
		new Solution().solution(new int [] {5,1,3,7}, new int [] {2,2,6,8});
		new Solution().solution(new int [] {2,2,2,2}, new int [] {1,1,1,1});
	}
}

/*
1 3 5 7
2 2 6 8
*/