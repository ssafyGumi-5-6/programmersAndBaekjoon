import java.util.Set;
import java.util.HashSet;

class Solution {
    
    Set<Integer> set; // 비트 마스킹 중복 검사를 위해 필요하다.
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        set = new HashSet<>();
        comb(user_id, banned_id, 0, 0);
        answer = set.size();
        return answer;
    }
    
    private void comb(String[] user_id, String[] banned_id, int cnt, int bit) {
        if(cnt == banned_id.length) {
            if(!set.contains(bit)) { // 결과로 나온 조합을 이미 만든 적있으면 거른다.
                set.add(bit);
            }
            return;
        }
        
        for(int i = 0, userSize = user_id.length; i < userSize; i++) {
            if((1 & (bit >> i)) == 1) { // 이미 선택한 적 있으면 거른다.
                continue;
            }

            // 36 ~ 50 번 줄은 정규 식을 이용하면 더 깔끔하게 만들 수 있다.
            // \w가 하나의 알파벳이나 숫자 언더바를 뜻한다고 한다.
            /*
             * String regex = banned_id[cnt].replace("*", "[\\w]");
             * if(!user_id[i].matches(regex)) continue;
             * comb(user_id, banned_id, cnt + 1, bit | (1 << i));
            */
            String user = user_id[i];
            String banned = banned_id[cnt];
            if(user.length() != banned.length()) continue; // 문자열 길이가 달라도 거른다.
            
            boolean isBanned = true;
            for(int j = 0, userLength = user.length(); j < userLength; j++) {
                if(user.charAt(j) != banned.charAt(j) && banned.charAt(j) != '*') {
                    isBanned = false;
                    break;
                }
            }
            
            if(isBanned) { // *을 제외한 패턴이 일치하면 재귀를 돈다.
                comb(user_id, banned_id, cnt + 1, bit | (1 << i));
            }
        }
    }
}