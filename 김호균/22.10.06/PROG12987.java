import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(B);
        Arrays.sort(A);
        int index = 0;
        for(int i = 0; i < A.length; i++) {
            if(index == B.length) break;
            for(int j = index; j < B.length; j++) {
                if(B[j] > A[i]) {
                    index = j + 1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}