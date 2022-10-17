import java.util.Set;
import java.util.HashSet;

class Solution {
    int answer;
    int userSize;
    int bannedSize;
    Set<Integer> set;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        userSize = user_id.length;
        bannedSize = banned_id.length;
        set = new HashSet<>();
        comb(user_id, banned_id, 0, 0);
        return answer;
    }
    
    private void comb(String[] user_id, String[] banned_id, int cnt, int bit) {
        if(cnt == bannedSize) {
            if(!set.contains(bit)) {
                set.add(bit);
                answer++;
            }
            return;
        }
        
        for(int i = 0; i < userSize; i++) {
            if((bit & (1 << i)) == (1 << i)) {
                continue;
            }
            String user = user_id[i];
            String banned = banned_id[cnt];
            if(user.length() != banned.length()) continue;
            
            boolean isBanned = true;
            for(int j = 0; j < user.length(); j++) {
                if(user.charAt(j) != banned.charAt(j) && banned.charAt(j) != '*') {
                    isBanned = false;
                    break;
                }
            }
            if(isBanned) {
                comb(user_id, banned_id, cnt + 1, bit | (1 << i));
            }
        }
    }
}