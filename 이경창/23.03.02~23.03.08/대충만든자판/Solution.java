package 대충만든자판;

import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] keymap, String[] targets) {
        ArrayList<Integer> answer = new ArrayList<>();

        int maxData = 110;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c = 'A' ; c <= 'Z' + 1; c++){
            map.put(c, maxData);
        }

        for(String inKeymap : keymap){
            for(int i = 0; i < inKeymap.length(); i++){
                int cnt = map.get(inKeymap.charAt(i));

                if(cnt > i + 1){
                    map.put(inKeymap.charAt(i), i + 1);
                }
            }
        }

        for(String target : targets){
            boolean check = true;
            int curData = 0;
            for(int i = 0; i < target.length(); i++){
                int curIdx = map.get(target.charAt(i));
                if(curIdx == maxData){
                    check = false;
                    break;
                }else{
                    curData += curIdx;
                }
            }

            if(check == true){
                answer.add(curData);
            }else{
                answer.add(-1);
            }
        }

        return answer;
    }
}