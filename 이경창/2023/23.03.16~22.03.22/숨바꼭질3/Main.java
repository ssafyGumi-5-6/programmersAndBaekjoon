package 숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


class HideAndSeek{
    int loc;
    int cnt;

    HideAndSeek(int loc, int cnt){
        this.loc = loc;
        this.cnt = cnt;
    }
}

public class Main {
    static int N, K;
    static boolean[] visited;
    static int maxSize = 100000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = maxSize;

        StringBuilder builder = new StringBuilder();

        // N과 K를 입력 받았을 때 모든 경우의 수를 구해서, 그 중에 K가 나오면 min 처리
        String[] inputData = br.readLine().split(" ");

        N = Integer.parseInt(inputData[0]);
        K = Integer.parseInt(inputData[1]);

        Queue<HideAndSeek> queue = new ArrayDeque<>();
        visited = new boolean[maxSize+10];
        queue.add(new HideAndSeek(N, 0));

        while(queue.size() > 0){
            HideAndSeek curHideAndSeek = queue.poll();
            int curLoc = curHideAndSeek.loc;
            int curCnt = curHideAndSeek.cnt;
            visited[curLoc] = true;
//            System.out.println("curLoc : " + curLoc + " curCnt : " + curCnt);
            if(curLoc == K) {
                answer = Math.min(answer, curCnt);
            }

            // (1) 0초 후에 X * 2
            if(curLoc * 2 <= maxSize && !visited[curLoc * 2] ){
                queue.add(new HideAndSeek(curLoc * 2, curCnt));
            }

            // (2) 1초 후에 X-1, X+1]
            if(curLoc - 1 >= 0 && !visited[curLoc - 1]){
                queue.add(new HideAndSeek(curLoc - 1, curCnt + 1));
            }
            if(curLoc + 1 <= maxSize && !visited[curLoc + 1]){
                queue.add(new HideAndSeek(curLoc + 1, curCnt + 1));
            }



        }
        builder.append(answer);
        System.out.println(builder);

    }
}
