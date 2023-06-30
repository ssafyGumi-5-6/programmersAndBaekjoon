import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

       Set<String> keywords = new HashSet<>();

        for (int i = 0; i < N; i++) {
            keywords.add(sc.nextLine());
        }

        // 출력시간 최적화를 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] words = sc.nextLine().split(",");
            // 작성한 글의 단어가 keywords Set에 있으면 지운다.
            for(String s : words) {
                keywords.remove(s);
            }
            
            // 남은 keywords 수를 StringBuilder에 저장
            sb.append(keywords.size()).append("\n");
        }

        System.out.print(sb);

        sc.close();
    }
}
