import java.util.*;

public class Main {
    public static void main (String[] args) {
        StringBuilder answer = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int testCase = 0; testCase < T; ++testCase) {
            sc.nextLine();
            int N = sc.nextInt();
            sc.nextLine();
            
            long[] array = new long[N];
            
            for(int i = 0; i < N; ++i) {
                array[i] = sc.nextLong();
            }
            
            long max = array[N - 1];
            long benefit = 0L;
            for(int i = N - 2; i >= 0; --i) {
                if(array[i] > max) {
                    max = array[i];
                } else {
                    benefit += max - array[i];
                }
            }
            
            answer
                .append(benefit)
                .append("\n");
        }
        
        System.out.print(answer);
        
        sc.close();
    }
}
