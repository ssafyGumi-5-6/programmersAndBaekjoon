package pk혼자_놀기의_달인;

class Solution {

    int[] cards;

    // 방문한지 check하기 위해 사용한 visited
    boolean[] visited;

    // dfs
    // 결과를 ansPerm에 저장한다.
    int ansPerm;

    int dfs(int nextIdx, int cnt, int start) {
        // 만약 nextIdx가 start라면 종료
        if (nextIdx == start) {
            ansPerm = cnt;
            return ansPerm;
        }

        // dfs로 다음 번째 위치를 찾는다.
        // visited true를 주었는데,
        // 이와 같은 경우 현재 해당 구간 카드 영역을 싹다 체크해버려서
        // 해당 구간 중복체크하는게 없어진다.
        // ex) 1 4 7 8을 확인할 때
        // 1 -> 4 -> 7 -> 8 한 번 확인했으므로
        // 4 -> 7 -> 8 -> 1 로 확인할 필요가 없음
        visited[nextIdx] = true;
        dfs(cards[nextIdx] - 1, cnt + 1, start);
        return ansPerm;
    }

    public int solution(int[] _cards) {
        int answer = 0;
        cards = _cards;

        // 카드 개수만큼 반복문을 돌린다.
        for (int i = 0; i < cards.length; i++) {
            // 현재 카드를 방문한지 체크하기 위해 사용한 visited
            visited = new boolean[cards.length];
            visited[i] = true;

            // 첫 번째 구간을 체크한다.
            int box1 = dfs(cards[i] - 1, 1, i);


            // 두 번째 구간을 하나씩 체크한다. (첫 번째 구간과 중간중간 체크되는 구간 제외 : visited)
            for (int j = 0; j < cards.length; j++) {
                if (visited[j]) continue;
                int box2 = dfs(cards[j] - 1, 1, j);

                // System.out.println("i, j : " + i + " " + j + " " + "box1, box2 : " + box1 + " " + box2);
                answer = Math.max(answer, box1 * box2);
            }
        }

        return answer;
    }
}