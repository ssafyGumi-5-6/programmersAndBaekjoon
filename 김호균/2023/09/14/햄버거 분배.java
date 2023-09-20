import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] dinigTable = br.readLine().toCharArray();
        int numberOfPeopleWhoCanEatBurger = 0;
        for(int i = 0; i < N; ++i) {
            if(dinigTable[i] == 'P') {
                boolean canEat = false;
                // 현재 사람 앞에 먹을 수 있는 햄버거가 있는 지 확인
                // 다음 사람이 먹을 수 있는 가능성을 높이기 위해 가장 먼 순서부터 확인한다.
                for(int j = i - K >= 0 ? i - K : 0; j < i; ++j) {
                    if(dinigTable[j] == 'H') {
                        dinigTable[j] = 'X';
                        ++numberOfPeopleWhoCanEatBurger;
                        canEat = true;
                        break;
                    }
                }

                // 앞에서 먹을 수 있는 햄버거를 찾으면 다음 사람으로 진행
                if(canEat) {
                    continue;
                }

                // 못 찾았으면 뒤에서 햄버거 찾기
                // 다음 사람이 먹을 수 있는 가능성을 높이기 위해 가장 가까운 순서부터 확인한다.
                for(int j = i + 1; j < N && j <= i + K; ++j) {
                    if(dinigTable[j] == 'H') {
                        dinigTable[j] = 'X';
                        ++numberOfPeopleWhoCanEatBurger;
                        break;
                    }
                }
            }
        }

        bw.write(String.valueOf(numberOfPeopleWhoCanEatBurger));
        br.close();
        bw.flush();
        bw.close();
    }
}
