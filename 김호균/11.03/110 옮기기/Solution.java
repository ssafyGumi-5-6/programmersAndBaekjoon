import java.lang.StringBuffer;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i = 0; i  s.length; i++) {
            StringBuffer temp = new StringBuffer();  나올 수 있는 모든 110을 지운 임시 문자열
            int count110 = 0;
            int count = 0;
            
             문자열 처음부터 탐색하며 1의 개수를 센다.
            for(int j = 0; j  s[i].length(); j++) {
                if(s[i].charAt(j) == '1') {
                    count++;  1 카운트
                } else {  0을 만났을 때
                    if(count = 2) { 
                        1 카운트 값이 2개이상이면 110이 된다는 뜻이므로
                        count -= 2;
                        count110++;  110 카운트를 늘려준다.
                    } else {
                         카운트가 1이면 10을 0이면 0을 임시 문자열에 추가한다.
                        if(count == 1) {
                            temp.append(10);
                        } else {
                            temp.append(0);
                        }
                        count = 0;
                    }
                }
                
            }
            
             110을 지웠을 때 1만 남는 경우 처리
            while(count != 0) {
                temp.append(1);
                count--;
            }
            
             뒤에서부터 탐색하여 0이 나오면 0 뒤에 110 개수만큼 붙여준다.
            for(int j = temp.length() - 1; j = 0; j--) {
                if(temp.charAt(j) == '0' && count110  0) {
                    while(count110 != 0) {
                        temp.insert(j+1, 110);
                        count110--;
                    }
                    break;
                }
            }
            
             임시 문자열에 1만 남은 경우 110을 앞에 삽입한다.
            while(count110 != 0) {
                temp.insert(0, 110);
                count110--;
            }
        
             문자열 저장
            answer[i] = temp.toString();
        }
        
        return answer;
    }
}