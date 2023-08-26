package 문자열_교환;

import java.io.*;
import java.util.*;

public class Solution2 {

    private static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        str = reader.readLine();

        char[] c = str.toCharArray();
        int aCount = 0;
        int result = Integer.MAX_VALUE;

        for(int i = 0 ; i < c.length; i++){
            if(c[i] == 'a') aCount += 1;
        }

        for(int i = 0; i < c.length; i++){
            int bCnt = 0;
            for(int j = i; j < aCount + i; j++){
                int nextIndex = j % c.length;
                if(c[nextIndex] == 'b') bCnt += 1;
            }
            result = Math.min(result, bCnt);
        }

        System.out.println(result);
        reader.close();
    }
}
