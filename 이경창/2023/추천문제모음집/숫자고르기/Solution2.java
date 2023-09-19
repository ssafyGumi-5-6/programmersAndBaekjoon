import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2 {
    private static int N;
    private static int[] arr;
    private static Set<Integer> extractData;

    private static void dfs(int curData, int startData, List<Integer> list){
        if(list.contains(curData)){
            if(startData == curData) extractData.addAll(list);
            return;
        }
        else if(list.size() == arr.length){
            return;
        }

        list.add(curData);
        dfs(arr[curData - 1], startData, list);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        extractData = new HashSet<>();

        arr = new int[N];
        for(int tk = 0; tk < N; tk++) {
            arr[tk] = Integer.parseInt(reader.readLine());
        }

        for(int i = 1; i <= N; i++){
            dfs(i, i, new ArrayList<>());
        }

        List<Integer> answer = new ArrayList<>(extractData);
        Collections.sort(answer);

        System.out.println(answer.size());
        for(int num : answer){
            System.out.println(num);
        }

        reader.close();

    }
}
