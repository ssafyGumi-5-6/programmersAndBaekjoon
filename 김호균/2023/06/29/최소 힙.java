import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            
            if(x == 0) {
                sb
                    .append(pq.peek() == null ? 0 : pq.poll())
                    .append("\n");
            } else {
                pq.add(x);
            }
        }
        
        System.out.println(sb);

        sc.close();
    }
}
