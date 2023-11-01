package 가르침;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        int answer = N;
        Map<Character, Integer> map = new HashMap<>();
        List<String> inputList = new ArrayList<>();


        for(int i = 0; i < N; i++){
            String input = reader.readLine();
            inputList.add(input);

            // a, n, t, i, c
            Set<Character> set = input.chars().distinct()
                    .filter(c -> c != 'a' && c != 'n' && c != 't' && c != 'i' && c != 'c')
                    .mapToObj(c -> (char)c)
                    .collect(Collectors.toSet());

            // 여기서 백트래킹이 필요함이네

//            System.out.println(set.size() + " " + set.toString());

            // 남은 갯수가 K - 5보다 작다면
            if(set.size() <= K - 5){
                for(char inSet : set){
                    map.putIfAbsent(inSet, 0);
                    map.put(inSet, map.get(inSet) + 1);
                }
            }
        }

        if(K < 5){
            // K가 5보다 작다면 돌릴 필요가 없음
            System.out.println(0);
            System.exit(0);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        // 내림차순 정렬
        Collections.sort(list, (c1, c2) -> (map.get(c2) - map.get(c1)));

        // a, n, t, i, c
        boolean[] visited = new boolean[27];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for(int i = 0; i < list.size() && i < K - 5; i++){
            visited[list.get(i) - 'a'] = true;
//            System.out.println(list.get(i) + " " + map.get(list.get(i)));
        }


        for(int i = 0; i < N; i++){
            String s = inputList.get(i);
            for(char inS : s.toCharArray()){
                if(!visited[inS - 'a']){
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);


        reader.close();
    }
}
