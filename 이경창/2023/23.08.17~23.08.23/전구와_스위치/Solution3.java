package 전구와_스위치;

import java.io.*;
import java.util.*;

public class Solution3{

    private static int N;
    private static String beforeStr;
    private static String afterStr;

    private static char swap(char c){
        if(c == '0') return '1';
        else return '0';
    }
    private static int switchSwap(int cnt){
        char[] c = beforeStr.toCharArray();
        char[] c2 = afterStr.toCharArray();
        if(cnt == 1){
            c[0] = swap(c[0]);
            c[1] = swap(c[1]);
        }

        // 마지막 전까지는 다를 경우 i - 1, i , i + 1 교환한다.
        for(int i = 1; i < c.length - 1; i++){
            if(c[i - 1] != c2[i - 1]){
                c[i - 1] = swap(c[i -1]);
                c[i] = swap(c[i]);
                c[i + 1] = swap(c[i + 1]);
                cnt += 1;
            }
        }

        if(c[c.length - 1] != c2[c.length - 1]){
            c[c.length - 1] = swap(c[c.length - 1]);
            c[c.length - 2] = swap(c[c.length - 2]);
            cnt += 1;
        }

        if(new String(c).equals(afterStr)) return cnt;
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        beforeStr = reader.readLine();
        afterStr = reader.readLine();

        // 첫 시작을 바꿨을 때와 바꾸지 않았을 때 두 경우의 수를 돌려본다.
        int answer = switchSwap(0);
        if(answer == -1) answer = switchSwap(1);

        System.out.println(answer);

        reader.close();

    }
}
