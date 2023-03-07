package 성적평가;

import java.util.*;
import java.io.*;


class TotalRank implements Comparable<TotalRank>{
    int userIdx;
    int totalScore;

    @Override
    public int compareTo(TotalRank t1){
        if(this.totalScore > t1.totalScore){
            return -1;
        }else if(this.totalScore == t1.totalScore){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public String toString(){
        return "userIdx : " + userIdx + " totalScore : " + totalScore;
    }

}

public class Solution {

    static int N;
    static TotalRank[] totalRank;
    static TotalRank[] inCurRank;
    static int[] curRank;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        totalRank = new TotalRank[N];
        inCurRank = new TotalRank[N];
        curRank = new int[N];

        int rank, before;

        for(int i =0 ; i< N; i++){
            totalRank[i] = new TotalRank();
            inCurRank[i] = new TotalRank();
        }


        for(int i = 0; i < 3; i++){
            String[] s = br.readLine().split(" ");
            int[] curScoreList = new int[N];

            for(int idx = 0; idx < N; idx++){
                curScoreList[idx] = Integer.parseInt(s[idx]);

                // 총점을 준다.
                totalRank[idx].userIdx = idx;
                totalRank[idx].totalScore += curScoreList[idx];

                inCurRank[idx].userIdx = idx;
                inCurRank[idx].totalScore = curScoreList[idx];

//                System.out.println("cur : " + curScoreList[idx]);
            }


            // 현재 순위를 주기 위해 정렬
            Arrays.sort(inCurRank);

            rank = 1;
            before = -1;
            int sameCnt = 0;
            for(TotalRank inRank : inCurRank){
                if(before != -1 && before > inRank.totalScore){
                    rank += (1 + sameCnt);
                    sameCnt = 0;
                }else if(before != -1 && before == inRank.totalScore){
                    sameCnt += 1;
                }
                curRank[inRank.userIdx] = rank;
                before = inRank.totalScore;
            }

            for (int inCurRank : curRank) {
                sb.append(inCurRank).append(" ");
            }
            sb.append("\n");
        }

        Arrays.sort(totalRank);

        curRank = new int[N];
        int rank2 = 1;
        int before2 = -1;
        int sameCnt = 0;
        for(TotalRank inTotalRank : totalRank){
            if(before2 != -1 && before2 > inTotalRank.totalScore){
                rank2 += (1 + sameCnt);
                sameCnt = 0;
            }else if(before2 != -1 && before2 == inTotalRank.totalScore){
                sameCnt += 1;
            }
            curRank[inTotalRank.userIdx] = rank2;
            before2 = inTotalRank.totalScore;
        }


        for (int inCurRank : curRank) {
            sb.append(inCurRank).append(" ");
        }

//        sb.append(Arrays.toString(curRank));
        System.out.println(sb);
    }
}