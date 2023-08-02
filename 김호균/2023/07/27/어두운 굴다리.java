import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int M = sc.nextInt();
        sc.nextLine();

        int previousStreetlightPos = sc.nextInt();
        // 굴다리 시작과 가로등, 굴다리 끝 사이 최대 거리 차이
        int maxDiff = previousStreetlightPos;
        
        for(int i = 1; i < M; ++i) {
            int currentStreetlightPos = sc.nextInt();
            
            // 지금 입력한 가로등과 이전에 입력받았던 가로등 사이 거리차이
            int currentDiff = currentStreetlightPos - previousStreetlightPos;
            // 그 거리차이의 반이 필요한 가로등 높이
            currentDiff =  (currentDiff % 2 == 0 ? 0 : 1) + currentDiff / 2;
            maxDiff = Math.max(maxDiff, currentDiff);

            previousStreetlightPos = currentStreetlightPos;
        }
        maxDiff = Math.max(N - previousStreetlightPos, maxDiff);

        System.out.println(maxDiff);

        sc.close();
    }
}
