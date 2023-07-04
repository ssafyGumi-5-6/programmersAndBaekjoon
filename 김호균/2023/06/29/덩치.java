import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int[] rankings = new int[N];
        int[][] peopleData = new int[N][2];

        for(int i = 0; i < N; i++) {
            peopleData[i][0] = sc.nextInt();
            peopleData[i][1] = sc.nextInt();
            sc.nextLine();

            rankings[i] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(peopleData[i][0] < peopleData[j][0] && peopleData[i][1] < peopleData[j][1]) {
                    rankings[i]++;
                }
            }
        }

        for(int i : rankings) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}