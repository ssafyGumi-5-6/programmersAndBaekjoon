package pk2차원_동전_뒤집기;

class Solution {

    int[][] beginning, target;
    int m, n; // 행, 열
    int answer;

    void turnCoinRow(int row){
        // 현재 동전 행을 뒤집는다.
        for(int i =0; i < n ; i++){
            beginning[row][i] = (beginning[row][i] + 1) % 2;
        }
    }

    int possibleCheck(int col){
        int cnt = 0;

        // col 열 위치를 기준으로 행을 체크한다.
        // m번 바뀔 시, 이 자리는 뒤집는 자리
        // 0번 바뀔 시, 이 자리는 유지되는 자리
        // 아닐 시, 동전을 뒤집어도 목표가 될 수 없는 상황
        for(int i =0; i< m; i++){
            if(beginning[i][col] !=  target[i][col]) cnt += 1;
        }

        if(cnt == 0) return 0;
        else if(cnt == m) return 1;
        else return -1;
    }

    // dfs는 행을 기준으로 확인한다.
    void dfs(int row, int cnt){
        // 만약 현재 행이 m위치에 도착했을 때
        if(row == m){
            // - 변경 가능한지 boolean doitChangeRC = true
            boolean doitChangeRC = true;

            for(int i = 0; i < n; i++){
                // - 열을 확인한다.
                int isItPossibleCheck = possibleCheck(i);
                //  - 열을 확인하면서 현재 열을 비교해서 전부 다르거나 or 전부 같다면 : cnt + 결과(결과 : 전부 같으면 0, 다르면 1);
                //  - 만약 현재 m개가 같거나 다르지 않다면 doitChangeRC를 = false로 (현재 이구간은 변경해도 target으로 만들 수 없다.)
                if(isItPossibleCheck == -1){
                    doitChangeRC = false;
                    break;
                }
                cnt += isItPossibleCheck;
            }


            if(doitChangeRC == true) answer = Math.min(answer, cnt);
            // System.out.println("doitChangeRC, cnt : " + doitChangeRC + " " + cnt + " answer : " + answer);
            return;
        }



        // 만약 현재 행이 m위치에 도착하지 않았을 때
        if(row != m){
            dfs(row + 1, cnt); // 다음 행으로 이동
            turnCoinRow(row); // 현재 행 구간을 변경한다. 0 <-> 1
            dfs(row + 1, cnt + 1); // 다음 행으로 이동하면서 현재 행을 변경했기 때문에 횟수 증가
            turnCoinRow(row); // 다시 되돌린다.
        }


    }

    public int solution(int[][] _beginning, int[][] _target) {
        beginning = _beginning; // 시작
        target = _target; // 도착
        m = beginning.length; // 행
        n = beginning[0].length; // 열
        answer = 21; // 10 x 10 행 열 전체 바꿀 때 10 + 10 + 1

        // 시작 위치 : 행, 현재 변경된 횟수
        dfs(0, 0);

        if(answer == 21) answer = -1;

        return answer;
    }
}
