package 숫자_재배치;

import java.util.*;
import java.io.*;

public class Solution2 {

    private static String A;
    private static int B;
    private static char[] aArr;
    private static boolean[] visited;
    private static List<Integer> result;

    private static void comb(int cnt, StringBuilder builder){
        if(cnt == A.length()){
            result.add(Integer.parseInt(builder.toString()));
            return;
        }else{
            for(int i = 0; i < A.length(); i++){
                if(cnt == 0 && aArr[i] == '0') continue;
                if(!visited[i]){
                    visited[i] = true;
                    builder.append(aArr[i]);
                    comb(cnt + 1, builder);
                    visited[i] = false;
                    builder.deleteCharAt(cnt);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        A = tokenizer.nextToken();
        B = Integer.parseInt(tokenizer.nextToken());

        aArr = A.toCharArray();
        visited = new boolean[A.length()];
        result = new ArrayList<>();

        comb(0, new StringBuilder());

        int answer = -1;

        for(int num : result){
            if(num < B && num > answer) answer = num;
        }

        System.out.println(answer);

        reader.close();
    }
}
