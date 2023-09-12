import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        
        long[] budget = new long[N];
        long totalBudgetRequired = 0L;
        
        for(int i = 0; i < N; ++i) {
            budget[i] = sc.nextLong();
            totalBudgetRequired += budget[i];
        }
        sc.nextLine();
        // 입력 받은 예산을 크기순으로 정렬한다.
        Arrays.sort(budget);
        
        long M = sc.nextLong();
           
        // 필요한 예산 총합이 보유한 예산보다 작거나 같으면 가장 큰 예산을 출력한다.
        if(M >= totalBudgetRequired) {
            System.out.println(budget[N - 1]);
        } else {
            for(int i = 0; i < N; ++i) {
                // 보유 예산으로 상한액 계산
                long upperLimit = M / (N - i);
                
                // 상한액보다 예산이 크다는 뜻은 상한액으로 지불해야한다는 말
                // i 뒤에 나올 예산은 다 i보다 크므로 해당 상한액이 답이 된다.
                if(upperLimit <= budget[i]) {
                    System.out.println(upperLimit);
                    break;
                }
                
                // 상한액이 예산보다 크면 상한액으로 지불할 필요가 없으므로 예산을 지불한다.
                M -= budget[i];
            }
        }
        
        sc.close();
    }
}
