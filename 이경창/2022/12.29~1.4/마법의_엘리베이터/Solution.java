package 마법의_엘리베이터;

// 참고 : https://leejams.github.io/%EB%A7%88%EB%B2%95%EC%9D%98-%EC%97%98%EB%A0%88%EB%B2%A0%EC%9D%B4%ED%84%B0/

class Solution {
    public int solution(int storey) {
        int answer = 0;

        // storey를 문자열로 바꿔서, 10^0 의 자리부터 확인한다.
        String strStorey = Integer.toString(storey);

        int nextPlus = 0;

        for(int i = strStorey.length() - 1; i >= 0; i--){
            // 현재 위치 값을 구한다.
            int curLocData = (strStorey.charAt(i) - '0') + nextPlus;


            // 현재 위치 값이 넘어 올 수도 있기 때문에, 초기화 한다.
            nextPlus = 0;


            // 만약 현재 위치 값 > 5라면
            // - 10 - curLocData을 answer에 더해준다. (왜냐하면 curLocData 만큼 횟수를 더하는 것 보다, *10한 값에서 빼주는게 더 작은 값을 얻을 수 있다.)
            if(curLocData > 5){
                answer += 10 - curLocData;
                nextPlus += 1;
            }else if(curLocData == 5 && i > 0){
                // 만약 현재 위치 값이 == 5라면
                // - 다음 위치 값이 5보다 크거나 같다면, * 10한 값에 5를 빼준다.
                // - 그 다음 값이 5보다 큰 값이라면 어차피 answer += 10 - curLocData를 실행할 것이기에
                // - curLocData += 1 한 값을 해줘야 더 작은 값을 구할 수 있다.
                if(strStorey.charAt(i - 1) - '0' >= 5){
                    answer += 10 - curLocData;
                    nextPlus += 1;
                }else{
                    answer += curLocData;
                }
            }else{
                // 5보다 작은 값이라면 그냥 answer에 그 숫자만큼 더해준다.
                answer += curLocData;
            }
        }

        if(nextPlus > 0) answer += nextPlus;

        return answer;
    }
}

