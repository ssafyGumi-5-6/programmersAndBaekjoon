package 리모컨;

import java.io.*;
import java.util.*;

public class Solution4 {


    private static int N, M;
    private static boolean[] breakDown;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        breakDown = new boolean[10];

        if(M > 0){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for(int i = 0; i < M; i++){
                int num = Integer.parseInt(tokenizer.nextToken());
                breakDown[num] = true;
            }
        }


        int minPress = Math.abs(N - 100);

        for(int channel = 1000000; channel >= 0; channel--){
            char[] c = Integer.toString(channel).toCharArray();
            for(int i = 0; i < c.length; i++){
                if(breakDown[Character.getNumericValue(c[i])]) break;
                else if(i == c.length - 1) {
                    minPress = Math.min(minPress, Math.abs(N - channel) + c.length);
                }
            }
        }

        System.out.println(minPress);

        reader.close();
    }
}
