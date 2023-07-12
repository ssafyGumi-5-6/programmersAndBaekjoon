import java.util.*;

public class Main {

    static class Star {

        int x;
        int y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int K = sc.nextInt();

        Star[] starPos = new Star[K];
        for (int i = 0; i < K; i++) {
            sc.nextLine();
            int x = sc.nextInt();
            int y = sc.nextInt();

            starPos[i] = new Star(x, y);
        }

        int maxBouncedStar = 0;
        for (int i = 0; i < K; i++) {

            for (int j = 0; j < K; j++) {
                int bouncedStar = 0;
                int xBoundary = starPos[i].x + L;
                int yBoundary = starPos[j].y + L;
                for(int p = 0; p < K; p++) {
                    if (starPos[i].x <= starPos[p].x && starPos[p].x <= xBoundary
                        && starPos[j].y <= starPos[p].y && starPos[p].y <= yBoundary) {
                        bouncedStar++;
                    }
                }

                maxBouncedStar = Math.max(maxBouncedStar, bouncedStar);
            }

        }

        System.out.println(K - maxBouncedStar);
        sc.close();
    }

}
