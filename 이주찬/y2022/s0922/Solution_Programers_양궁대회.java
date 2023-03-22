import java.util.Arrays;

public class Solution_Programers_양궁대회 {
    public static void main(String[] args) {

    }
}

class Solution {
    int max;
    int[] res;
    boolean canWin;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        max = 0;
        res = new int[11];
        canWin = false;
        dfs(n, info, 0, 0, 0, new int[11]);
        if (canWin)
            return res;
        else
            return new int[]{ -1 };
    }

    void dfs(int n, int[] info, int goal, int mine, int start, int[] my) {
        if (n == 0 || start == 11) {
            for (int i = start; i < 11; i++) {
                if (info[i] > 0)
                    goal += 10 - i;
            }
            my[10] = n;
            if (mine - goal > max) {
                max = mine - goal;
                canWin = true;
                res = Arrays.copyOf(my, 11);
            } else if (mine - goal == max) {
                for (int i = 10; i >= 0; i--) {
                    if (res[i] < my[i]) {
                        res = Arrays.copyOf(my, 11);
                        break;
                    } else if(res[i] > my[i]){
                        break;
                    }
                }
            }
            return;
        }
        if (info[start] + 1 <= n) {
            my[start] = info[start] + 1;
            dfs(n - (info[start] + 1), info, goal, mine + (10 - start), start + 1, my);
        }
        my[start] = 0;
        int pgoal = goal;
        if(info[start] > 0) pgoal = goal + (10 - start);
        dfs(n, info, pgoal, mine, start + 1, my);
    }
}

class Solution2 {
    int max;
    int[] res;
    boolean canWin;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        max = 0;
        res = new int[11];
        canWin = false;
        dfs(n, info, 0, 0, 0, new int[11]);
        if (canWin)
            return res;
        else
            return new int[]{ -1 };
    }

    void dfs(int n, int[] info, int goal, int mine, int start, int[] my) {
        if (n == 0 || start == 11) {
            // start가 11이면 아래 반복문은 작동 안 함
            for (int i = start; i < 11; i++) {
                if (info[i] > 0)
                    goal += 10 - i;
            }
            my[10] = n; // 남는 화살 넣어주기 n==0이면 0들어감
            if (mine - goal > max) {
                max = mine - goal;
                canWin = true;
                res = Arrays.copyOf(my, 11);
            } else if(mine - goal == max) { // 차이가 같으면 더 낮은 점수를 맞춘 화살이 많은게 인정된다.
                for (int i = 10; i >= 0; i--) {
                    if (res[i] > my[i])
                        break;
                    if(res[i] < my[i]) {
                        res = Arrays.copyOf(my, 11);
                        return;
                    }
                    
                }
            }
            return;
        }

        if (info[start] + 1 <= n) {
            my[start] = info[start] + 1;
            dfs(n - (info[start] + 1), info, goal, mine + (10 - start), start + 1, my);
        }
        my[start] = 0;
        //어피치 화살이 있으면 점수를 누적해준다.
        if(info[start] > 0)  dfs(n, info, goal + (10 - start), mine, start + 1, my);
        else dfs(n, info, goal, mine, start + 1, my);
    }
}