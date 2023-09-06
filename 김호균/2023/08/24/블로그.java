import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        sc.nextLine();

        // N일 동안 일일 방문자 수
        int[] dailyVisitors = new int[N];

        // 첫쨋날을 기준으로 X일 방문자 수
        dailyVisitors[0] = sc.nextInt();
        long maxNumberOfVisitor = dailyVisitors[0];
        for(int i = 1; i < X; ++i) {
            dailyVisitors[i] = sc.nextInt();
            maxNumberOfVisitor += dailyVisitors[i];
        }

        // 그다음 날을 기준으로 X일 동안 방문자 수
        // 첫날을 빼고 X + 1일 방문자 수를 더하는 과정을 반복하여 구한다.
        long numberOfVisitor = maxNumberOfVisitor - dailyVisitors[0];
        long periodCount = 1L;
        for(int i = X; i < N; ++i) {
            dailyVisitors[i] = sc.nextInt();
            numberOfVisitor += dailyVisitors[i];
            if(numberOfVisitor > maxNumberOfVisitor) {
                maxNumberOfVisitor = numberOfVisitor;
                periodCount = 1;
            } else if (numberOfVisitor == maxNumberOfVisitor) {
                ++periodCount;
            }
            numberOfVisitor -= dailyVisitors[i - X + 1];
        }

        if(maxNumberOfVisitor == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxNumberOfVisitor);
            System.out.println(periodCount);
        }

        sc.close();
    }
}
