package 덧칠하기;

class Solution {

    boolean[] paintCheck;

    public int solution(int n, int m, int[] section) {

        // 영역 : n
        // 롤러 길이 : m

        paintCheck = new boolean[n + 2];
        int sectionIdx = 0;


        for(int paintIdx = 0; paintIdx <= n; paintIdx++){
            if(sectionIdx < section.length && section[sectionIdx] == paintIdx){
                paintCheck[paintIdx] = true;
                sectionIdx++;
            }
        }

        int leftAnswer = 0;
        int rightAnswer = 0;
        // 가장 왼쪽에 있는 숫자를 기준으로 반복
        for(int paintIdx = 1; paintIdx <= n; paintIdx++){

            // 페인트 칠 하는 곳일 때 m 길이만큼 색칠한다.
            if(paintCheck[paintIdx]){
                paintIdx += (m-1);
                leftAnswer += 1;
            }
        }

        for(int paintIdx = n; paintIdx >= 1; paintIdx--){
            if(paintCheck[paintIdx]){
                paintIdx -= (m-1);
                rightAnswer += 1;
            }
        }


        // 가장 오른쪽에 있는 숫자를 기준으로 반복

        // System.out.println("leftAnswer: " + leftAnswer);
        // System.out.println("rightAnswer: " + rightAnswer);

        return Math.min(leftAnswer, rightAnswer);
    }
}