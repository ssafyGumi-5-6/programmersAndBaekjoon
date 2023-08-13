package 영단어_암기는_괴로워;

import java.io.*;
import java.util.*;

public class Solution2 {

    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder builder = new StringBuilder();

        Map<String ,Integer> map = new HashMap<>();

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        for(int i = 0; i < N; i++){
            String s = reader.readLine();
            if(s.length() < M) continue;
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a1, a2) -> {
            if(map.get(a1) > map.get(a2)) return -1;
            else if(map.get(a1) < map.get(a2)) return 1;
            else{
                if(a1.length() > a2.length()) return -1;
                else if(a1.length() < a2.length()) return 1;
                else {
                    return a1.compareTo(a2);
                }
            }
        });

        for(int i = 0; i< list.size(); i++){
            builder.append(list.get(i)).append("\n");
        }

        System.out.print(builder);

        reader.close();
    }
}
