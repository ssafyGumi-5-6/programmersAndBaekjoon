import java.util.Arrays;
class Solution {
    public int solution(int[] a) {
        // 왼쪽 오른쪽 모두 나보다 작은 수가 없으면 남기는게 불가능하다.
        // 양 끝은 어떤 수든 무조건 마지막까지 남길 수 있다.
        int answer = 2;
        int length = a.length;
        // 길이가 1이나 2인 경우 처리
        if(length == 1 || length == 2) return length;
        length--;
        
        // 처음부터 탐색한다.
        int leftMin = a[0];
        for(int i = 1; i < length; i++) {
            // 탐색하며 지금 최솟값보다 작으면 a[i]기준 왼쪽에
            // a[i]보다 작은 수가 있다는 뜻이므로 답을 늘리고
            // 최솟값을 a[i]로 한다.
            if(a[i] < leftMin) {
                answer++;
                leftMin = a[i];
            }
        }
        
        // 마지막부터 탐색한다.
        int rightMin = a[length];
        for(int i = length; i >= 1; i--) {
            // 지금 탐색하는 수가 처음부터 탐색했을 때 구한 최솟값이면
            // 더 탐색해도 더 작은 수를 찾을 수 없으므로 탐색을 종료한다.
            if(leftMin == a[i]) break;
            
            // 탐색하며 지금 최솟값보다 작으면 a[i]기준 오른쪽에
            // a[i]보다 작은 수가 있다는 뜻이므로 답을 늘리고
            // 최솟값을 a[i]로 한다.
            if(a[i] < rightMin) {
                answer++;
                rightMin = a[i];
            }
        }
        
        return answer;
    }
}