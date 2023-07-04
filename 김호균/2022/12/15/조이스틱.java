// https://born2bedeveloper.tistory.com/26
class Solution {
    public int solution(String name) {
        int answer = 0;
        // 시작 지점부터 끝 지점까지 이동할 때 필요한 이동 횟수
        int minMovement = name.length() - 1; 
        
        for(int i = 0; i < name.length(); i++) {
            // 최소한의 상하 움직임
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int aIndex = i + 1;
            // 연속되는 A가 있으면 A가 끝나는 지점 인덱스를 찾는다.
            while(aIndex < name.length() && name.charAt(aIndex) == 'A') {
                aIndex++;
            }
            /* (name.length() - aIndex) 연산을 통해 A가 끝난 지점부터 문자열 끝까지 남은 단어를 구한다.    
            i * 2 연산은 내가 오른 쪽으로 이동해 연속되는 A를 만나고 시작 지점으로 되돌아가기 위해 필요한  이동 횟수다.
            둘을 더하면 연속되는 A가 나올때까지 이동 후 연속되는 A가 끝나는 지점까지 되돌아갈 때 필요한 이동 횟수를 구할 수 있다.*/
            minMovement = Math.min(minMovement, i * 2 + (name.length() - aIndex));
            /* 연속되는 A가 끝나는 지점까지 이동 후 연속되는 A가 시작되는 지점까지 이동할 때 필요한 이동 횟수 
            앞서 구한 이동 횟수와 아래 이동 횟수 중 최솟값을 구하면 된다.*/
            minMovement = Math.min(minMovement, i + (name.length() - aIndex) * 2);
        }
        
        return answer + minMovement;
    }
}
