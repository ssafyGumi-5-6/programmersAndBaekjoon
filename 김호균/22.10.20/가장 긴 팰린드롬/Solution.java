class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        // 전체 길이 줄이며 비교
        for(int length = s.length(); length > 1; length--) {
            // 시작점을 0번 인덱스부터 하나씩 증가하며 탐색
            for(int i = 0; i + length <= s.length(); i++) {
                int start = i, end = i + length - 1;
                boolean flag = true;
                
                // 시작점과 끝점이 같거나 작아지면 회문
                while(start <= end) {
                    // 탐색 중에 다른 부분이 나오면 회문이 아니다.
                    if(s.charAt(start) != s.charAt(end)) {
                        flag = false;
                        break;
                    }
                    start++;
                    end--;
                }
                
                // flag가 true면 회문이므로 길이를 리턴
                if(flag) return length;
            }
        } 

        return answer;
    }
}
