import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int numberOfBuilding = 0;
        int previousHeight = 0;
        Stack<Integer> buildingHeight = new Stack<>();

        for(int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()); // x는 사용하지 않는다.
            int y = Integer.parseInt(st.nextToken());

            // 이전 스카이라인 높이보다 y이 더 크면 stack에 저장한다.
            if(previousHeight < y) {
                buildingHeight.push(y);
            } else if(previousHeight > y) {
                // 이전 스카이라인 높이보다 y가 더 작으면
                // y보다 큰 값을 stack에서 뺀다.  
                while (!buildingHeight.isEmpty() && buildingHeight.peek() > y) {
                    buildingHeight.pop();
                    ++numberOfBuilding;
                }

                // y이 0이 아니고(0은 빌딩이 아님)
                // stack이 비거나 stack의 최상단 값이 y보다 작은 경우
                // y를 stack에 저장한다.
                if(y != 0 && (buildingHeight.isEmpty() || buildingHeight.peek() != y)) {
                    buildingHeight.push(y);
                }
            }

            // 모든 과정을 거치면 y를 이전 스카이라인 높이로 설정한다.
            previousHeight = y;
        }

        // stack에 저장된 값이 있는 경우 stack에서 빼주며, 빌딩 수를 늘려준다.
        /* 예: y가 4, 2, 3 순으로 입력되면 2,3이 stack에 남는다. */
        while(!buildingHeight.isEmpty()) {
            buildingHeight.pop();
            ++numberOfBuilding;
        }

        bw.write(String.valueOf(numberOfBuilding));

        br.close();
        bw.flush();
        bw.close();
    }
}
