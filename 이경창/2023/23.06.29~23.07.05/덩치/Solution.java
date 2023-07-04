package 덩치;


import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //전체 사람의 수
        int weight[] = new int[N];  //몸무게
        int height[] = new int[N];  //키
        int rank[] = new int[N];    //등수

        for (int i = 0; i < N; i++) { //입력 받기
            weight[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) { //등수 주인공

            int cnt = 1;
            for (int j = 0; j < N; j++) { //비교군
                if(i == j) continue; //본인과 비교X

                if(weight[i] < weight[j] && height[i] < height[j]) {
                    cnt += 1; //나보다 덩치가 크면 +1
                }
            }
            rank[i] = cnt; //값 저장
            cnt = 1; //다음 사람을 위한 cnt초기화
        }

        for (int i = 0; i < N; i++) {
            System.out.print(rank[i] + " "); //결과출력
        }
    }
}
