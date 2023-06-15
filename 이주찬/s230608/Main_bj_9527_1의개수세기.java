package s230608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_bj_9527_1의개수세기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken()) - 1;
        long b = Long.parseLong(st.nextToken());

        // 2^54 = 1.8e + 16 > 1e + 16
        // 2^53 = 9e + 15

        boolean[] aBin = new boolean[54];
        boolean[] bBin = new boolean[54];

        int idx = 0;
        while (!(a == 0)) {
            if (a % 2 == 1) {
                aBin[idx] = true;
            }
            a = a / 2;
            idx++;
        }
        int aBinMax = idx;
        idx = 0;
        while (!(b == 0)) {
            if (b % 2 == 1) {
                bBin[idx] = true;
            }
            b = b / 2;
            idx++;
        }
        int bBinMax = idx;


        long[] hap = new long[bBinMax];
        hap[0] = 1;
        long[] hapSum = new long[bBinMax];
        hapSum[0] = 1;
        for (int i = 1; i < bBinMax; i++) {
            long tmp = (long) Math.pow(2, i - 1);
            hap[i] = hap[i - 1] * 2 + tmp;
            hapSum[i] = hapSum[i - 1] + hap[i];
        }
        long answer = hapSum[bBinMax - 1];
        int numOfOne = 0;
        for (int i = bBinMax - 1; i >= 0; i--) {
            if (!bBin[i]) {
                answer -= hap[i] + (long) Math.pow(2, i) * numOfOne;
            } else {
                numOfOne++;
            }
        }
        if (aBinMax != 0) {
            long aSum = hapSum[aBinMax - 1];
            numOfOne = 0;
            for (int i = aBinMax - 1; i >= 0; i--) {
                if (!aBin[i]) {
                    aSum -= hap[i] + (long) Math.pow(2, i) * numOfOne;
                } else {
                    numOfOne++;
                }
            }
            answer -= aSum;
        }

        System.out.println(answer);

    }
}
