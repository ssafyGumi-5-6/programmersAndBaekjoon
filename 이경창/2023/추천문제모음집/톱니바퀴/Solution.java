package 톱니바퀴;

import java.io.*;
import java.util.*;

public class Solution {

    private static int[][] aCogwheel;
    private static int[] isItRotation;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        aCogwheel = new int[4][8];
        isItRotation = new int[4];

        for(int i = 0; i < 4; i++){
            String s = reader.readLine();
            char[] c = s.toCharArray();
            for(int j = 0; j < c.length; j++){
                aCogwheel[i][j] = c[j] - '0';
            }
        }

        K = Integer.parseInt(reader.readLine());

        for(int i = 0; i < K; i++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int index = Integer.parseInt(tokenizer.nextToken()) - 1;
            int direction = Integer.parseInt(tokenizer.nextToken());
            int leftDirection = direction * -1;
            int rightDirection = direction * -1;
            Arrays.fill(isItRotation, 0);
            isItRotation[index] = direction;

//            System.out.println((i + 1) + " 번째");
            // 왼쪽 탐색
            for(int leftIdx = index - 1; leftIdx >= 0; leftIdx--){
                if(aCogwheel[leftIdx][2] == aCogwheel[leftIdx + 1][6]) break;
                isItRotation[leftIdx] = leftDirection;
                leftDirection *= -1;
            }

            // 오른쪽 탐색
            for(int rightIdx = index + 1; rightIdx < 4; rightIdx++){
                if(aCogwheel[rightIdx - 1][2] == aCogwheel[rightIdx][6]) break;
                isItRotation[rightIdx] = rightDirection;
                rightDirection *= -1;
            }

            // 회전
            for(int j = 0; j < 4; j++){
                // 1인 경우 시계방향, -1인 경우 반시계방향
                if(isItRotation[j] == -1){
                    int[] testCase = aCogwheel[j].clone();
                    for(int curIdx = 0; curIdx < 8; curIdx++){
                        aCogwheel[j][curIdx] = testCase[(curIdx + 1) % 8];
                    }
                }else if(isItRotation[j] == 1){
                    int[] testCase = aCogwheel[j].clone();
                    for(int curIdx = 0; curIdx < 8; curIdx++){
                        aCogwheel[j][(curIdx + 1) % 8] = testCase[curIdx];
                    }
                }
            }

//            System.out.println(Arrays.toString(isItRotation));
//            for(int j = 0; j < 4; j++){
//                System.out.println(Arrays.toString(aCogwheel[j]));
//            }
//
//            System.out.println();
        }

        int answer = 0;
        int multiple = 1;
        for(int i = 0; i < 4; i++){
            if(aCogwheel[i][0] == 1) answer += multiple;
            multiple *= 2;
        }

        System.out.println(answer);

        reader.close();
    }
}
