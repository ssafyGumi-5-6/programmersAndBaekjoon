package 집합;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int bit_set = 0;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num;

            switch (op) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    bit_set |= (1 << (num - 1));
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bit_set = bit_set & ~(1 << (num - 1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((bit_set & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    bit_set ^= (1 << (num - 1));
                    break;
                case "all":
                    bit_set |= (~0);
                    break;
                case "empty":
                    bit_set &= 0;
                    break;
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
