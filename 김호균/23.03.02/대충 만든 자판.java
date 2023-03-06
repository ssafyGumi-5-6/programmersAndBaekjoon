import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        // 각 문자가 만들어질 수 있는 최소 횟수
        Map<Character, Integer> min = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                /* 처음 등장한 문자거나 현재 최소 횟수보다
                   더 적은 횟수로 해당 문자를 입력할 수 있으면 값을 변경해준다. */
                if(min.get(keymap[i].charAt(j)) == null || min.get(keymap[i].charAt(j)) > j + 1) {
                    min.put(keymap[i].charAt(j), j + 1);
                }
            }
        }
        
        // 최소 횟수를 저장한 Map을 이용해 답을 구한다.   
        for(int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                if(min.get(targets[i].charAt(j)) == null) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += min.get(targets[i].charAt(j));
            }
        }
        
        return answer;
    }
}
