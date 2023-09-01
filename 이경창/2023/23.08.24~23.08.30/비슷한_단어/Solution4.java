package 비슷한_단어;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution4 {

    private static int N;
    private static String[] str;

    // 이 문제는 접두사 즉, 첫 부분부터 찾는거라 LCS, LIS를 사용할 필요가 없음
    private static int checkFunction(String builder1, String builder2){
        int count = 0;
        for(int i = 0; i < Math.min(builder1.length(), builder2.length()); i++){
            if(builder1.charAt(i) != builder2.charAt(i)) break;
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
//        str = new String[N];
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        String left = "";
        String right = "";

        for(int i = 0; i < N; i++){
            String s = reader.readLine();
            if(!list.contains(s))
                list.add(s);
        }


        // Stream<Set<String>
//        Map<Integer, String> map = IntStream.range(0, list.size()).boxed().collect(Collectors.toMap(
//                index -> index,
//                index -> list.get(index)
//        ));

//        for(Map.Entry<Integer, String> mes : map.entrySet()){
//            System.out.println(mes.getKey() + " " + mes.getValue());
//        }

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                int result = checkFunction(list.get(i), list.get(j));
                if(result > answer){
                    answer = result;
                    left = list.get(i);
                    right = list.get(j);
                }
            }
        }

        System.out.println(left);
        System.out.println(right);


        reader.close();
    }
}
