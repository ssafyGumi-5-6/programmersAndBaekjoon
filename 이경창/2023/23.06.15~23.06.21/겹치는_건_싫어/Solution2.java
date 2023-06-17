package 겹치는_건_싫어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution2 {

    // Map으로 들어온 갯수 처리하기
    // 들어온 후 최댓값과 비교하여 업데이트
    static int N, K;
    static int maxData;
    static int start, end;
    static int[] arr;
    static int[] insideTheArray = new int[100010];
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];

        int answer = 0;
        for(int i  = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 반복문을 통해 확인한다.
        // 투 포인터를 통해 start, end 로 구분한다.
        while(end < arr.length){

            // 범위 이내라면
            while(end < arr.length && insideTheArray[arr[end]] < K){
                insideTheArray[arr[end]] += 1;
                end += 1;
            }

            // K보다 많은 갯수를 가진 경우, 범위 변경
            // - 시작 부분부터 하나씩 없애면서 확인한다.
            // - 마지막 구간이 포함될 경우, 범위에 벗어났기에 -1을 해준다.
            answer = Integer.max(answer, end - start);

            insideTheArray[arr[start]] -= 1;
            start += 1;
        }

        System.out.println(answer);
        br.close();
    }
}