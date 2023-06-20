import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ20922_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] count = new int[100_001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int length = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(arr[i]);
            count[arr[i]]++;

            if (length < list.size() && K >= count[arr[i]]) {
                length = list.size();
            } else {
                length = 0;
                int index = list.indexOf(arr[i]);


                for (int j = index; j >= 0; j--) {
                    count[list.get(j)]--;
                    list.remove(j);
                }
            }
            max = Math.max(max, length);
        }

        System.out.println(max);
    }
}