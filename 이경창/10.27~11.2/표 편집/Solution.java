import java.util.*;

class pg81303 {

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
        int totalSize = n;
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
                k -= cnt;
            }else if(checkUDCZ(s.charAt(0)) == 2){
                String[] res = s.split(" ");
                int cnt = Integer.parseInt(res[1]);
                k += cnt;
            }else if(checkUDCZ(s.charAt(0)) == 3){
                // System.out.println("stack 에 삽입 : " + k );
                stack.push(k);
                totalSize -= 1;
                if(k == totalSize) k -= 1;
            }else if(checkUDCZ(s.charAt(0)) == 4){
                int res = stack.pop();
                // System.out.println("stack 에서 삭제 : " +  res);
                if(res <= k){
                    k += 1;
                }
                totalSize += 1;
            }


            // System.out.println(" i : " + i + " k : " + k);
        }

        StringBuilder sb = new StringBuilder();

        // 첫 번째 반복문에서 모두 O로 만든 후,

        for(int i =0; i< totalSize; i++) sb.append('O');

        // 두 번째 반복문에서 해당 인덱스 X로 만든다.
        // System.out.println("결과 : ");
        while(stack.size() > 0){
            int res = stack.pop().intValue();
            // System.out.println(res);
            sb.insert(res, 'X');
        }

        return sb.toString();
    }
}