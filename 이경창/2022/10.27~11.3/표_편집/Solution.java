package 표_편집;


import java.util.*;

class Solution {

    int checkUDCZ(char c){
        if(c == 'U'){
            // U인 경우 위로 n만큼
            return 1;
        }else if(c == 'D'){
            return 2;
        }else if(c == 'C'){
            return 3;
        }else{
            return 4;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // U X : X칸 위에 있는 행을 선택
        // D X : X칸 아래에 있는 행을 선택
        // C : 현재 선택된 행 삭제 후, 바로 아래 행을 선택 (가장 마지막 행인 경우 바로 윗행을 선택)
        // Z : 가장 최근에 삭제된 행을 원래대로 복구, 현재 선택된 행은 바뀌지 않음

        for(int i = 0; i< cmd.length; i++){
            String s = cmd[i];

            if(checkUDCZ(s.charAt(0)) == 1){
                String[] res = s.split(" ");
                int cnt = Integer.parseInt(res[1]);
                while(cnt > 0){
                    cnt -= 1;
                    if(visited[k]){
                        cnt += 1;
                    }
                    k -= 1;
                    if(k == -1) k = n-1;
                }
            }else if(checkUDCZ(s.charAt(0)) == 2){
                String[] res = s.split(" ");
                int cnt = Integer.parseInt(res[1]);
                while(cnt > 0){
                    cnt -= 1;
                    if(visited[k]){
                        cnt += 1;
                    }
                    k += 1;

                    if(k == n) k = 0;
                }
            }else if(checkUDCZ(s.charAt(0)) == 3){
                visited[k] = true;
                stack.push(k);
                k += 1;
                if(k == n) k = 0;
            }else if(checkUDCZ(s.charAt(0)) == 4){
                if(stack.size() > 0){
                    visited[stack.pop()] = true;
                }
            }

            while(visited[k]){
                k += 1;
                if(k == n) k = 0;
            }
        }

        return answer;
    }
}

