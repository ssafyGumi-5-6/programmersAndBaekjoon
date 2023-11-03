package 가르침;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    private static int N, K;
    private static boolean[] visited; // 26 알파벳
    private static int answer;
    private static List<String> list = new ArrayList<>();
    private static void backtracking(int idx, int cnt){
        if(cnt == K - 5){
            int count = N;
            for(int i = 0; i < N; i++){
                char[] c = list.get(i).toCharArray();

                for(int cIdx = 0; cIdx < c.length; cIdx++){
                    if(!visited[c[cIdx] - 'a']){
                        count--;
                        break;
                    }
                }
            }
            answer = Math.max(answer, count);
            return;
        }else{
            for(int i = idx; i < 26; i++){
                if(!visited[i]){
                    visited[i] = true;
                    backtracking(i, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());


        Map<Character, Integer> map = new HashMap<>();


        for(int i = 0; i < N; i++){
            String input = reader.readLine();
            // anta, tica => out
            input = input.replace("anta", "");
            input = input.replace("tica", "");

            list.add(input);
        }

        if(K < 5){
            // K가 5보다 작다면 돌릴 필요가 없음
            System.out.println(0);
            System.exit(0);
        }else if(K == 26){

            // K가 26개면 모든 알파벳을 읽을 수 있다.
            System.out.println(N);
            System.exit(0);
        }

        visited = new boolean[26];
        // anta, tica => out
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        // 이외인 경우 backtracking();
        backtracking(0, 0);

        System.out.println(answer);


        reader.close();
    }
}
