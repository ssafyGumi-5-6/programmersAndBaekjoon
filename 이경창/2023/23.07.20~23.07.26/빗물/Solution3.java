package 빗물;

import java.util.*;
import java.io.*;

public class Solution3 {
    private static int H, W;
    private static int[] blockHeight;
    private static int[] leftLongHeight;
    private static int[] rightLongHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        H = Integer.parseInt(tokenizer.nextToken());
        W = Integer.parseInt(tokenizer.nextToken());

        blockHeight = new int[W];
        leftLongHeight = new int[W];
        rightLongHeight = new int[W];

        tokenizer = new StringTokenizer(reader.readLine());

        int answer = 0;
        List<Integer> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) list.add(Integer.parseInt(tokenizer.nextToken()));
        blockHeight = list.stream().mapToInt(Integer::intValue).toArray();

        for (int i = W - 1; i >= 0; i--) {
            int maxData = blockHeight[i];
            for (int j = i - 1; j >= 0; j--) maxData = Math.max(maxData, blockHeight[j]);
            leftLongHeight[i] = maxData;
        }

        for (int i = 0; i < W; i++) {
            int maxData = blockHeight[i];
            for (int j = i + 1; j < W; j++) maxData = Math.max(maxData, blockHeight[j]);
            rightLongHeight[i] = maxData;
        }

//        for(int i = 0; i < W; i++){
//            System.out.println("left : " + leftLongHeight[i] + " right : " + rightLongHeight[i]);
//        }

        for (int i = 0; i < W; i++) {
//            if(i == 0 && blockHeight[i] < rightLongHeight[i]) answer += (rightLongHeight[i] - blockHeight[i]);
//            else if(i == W - 1 && blockHeight[i] < leftLongHeight[i]) answer += (leftLongHeight[i] - blockHeight[i]);

            if (blockHeight[i] < leftLongHeight[i] && blockHeight[i] < rightLongHeight[i])
                answer += (Math.min(leftLongHeight[i], rightLongHeight[i]) - blockHeight[i]);

        }

        System.out.println(answer);

        reader.close();
    }
}
