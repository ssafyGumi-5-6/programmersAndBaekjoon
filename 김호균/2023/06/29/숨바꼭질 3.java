import java.util.*;

public class Main {

    static class Data {
        int pos;
        int time;

        public Data(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(findShortestTime(N, K));

        sc.close();
    }

    private static int findShortestTime(int N, int K) {
        // 시간 기준 오름차순 정렬을 위한 최소힙
        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(d -> d.time));
        pq.add(new Data(N, 0));

        // 방문 시간을 확인하기 위한 배열
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[N] = 0;

        while(!pq.isEmpty()) {
            Data cur = pq.poll();

            // 현재 위치가 동생위치(K)면 현재 시간 반환
            if(cur.pos == K) {
                return cur.time;
            }

            int pos = cur.pos;

            /* 이동할 위치가 유효범위 안이고 이동 시간이 이전 방문 시간보다 작아야 이동할 수 있다 */
            if(pos + 1 <= 100000 && visited[pos + 1] > cur.time + 1) {
                pq.add(new Data(pos + 1, cur.time + 1));
                visited[pos + 1] = cur.time + 1;
            }

            if(pos - 1 >= 0 && visited[pos - 1] > cur.time + 1) {
                pq.add(new Data(pos - 1, cur.time + 1));
                visited[pos - 1] = cur.time + 1;
            }

            if(pos * 2 <= 100000 && visited[pos * 2] > cur.time) {
                pq.add(new Data(pos * 2, cur.time));
                visited[pos * 2] = cur.time;
            }

        }

        // 동생위치에 도달할 수 없다는 얘기
        // 이 문제에서는 나올 수 없는 수치다.
        return 0;
    }

}
