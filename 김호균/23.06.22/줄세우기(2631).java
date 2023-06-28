import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        
        int[] studentNumber = new int[N];
        int[] dp = new int[N];
        int max = 0;
        /* 최장증가수열을 찾고 해당 수열을 제외한 나머지 수들을 순서에 맞게 변경하면
         * 정답을 찾을 수 있다. */ 
        for(int i = 0; i < N; i++) {
            studentNumber[i] = sc.nextInt();
            sc.nextLine();
            
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(studentNumber[j] < studentNumber[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            // 최장증가수열의 최댓값을 저장
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        
        System.out.println(N - max);
        
        sc.close();
    }
}
