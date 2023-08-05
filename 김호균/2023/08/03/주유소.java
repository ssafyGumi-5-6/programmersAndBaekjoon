import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer = 0L;

        int N = sc.nextInt();
        sc.nextLine();

        long[] km = new long[N - 1];
        for(int i = 0; i < N - 1; ++i) {
            km[i] = sc.nextLong();
        }
        sc.nextLine();

        long previousPrice = sc.nextLong();
        answer += km[0] * previousPrice;
        for(int i = 1; i < N - 1; ++i) {
            long currentPrice = sc.nextLong();
            if(currentPrice < previousPrice) {
                previousPrice = currentPrice;
            } 

            answer += km[i] * previousPrice;
        }

        System.out.println(answer);


        sc.close();
    }
}
