import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/* 
 [본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.]

당신은 행렬에 적용할 수 있는 두 가지 연산을 만들었습니다.

ShiftRow
모든 행이 아래쪽으로 한 칸씩 밀려납니다. 즉, 모든 행에 대해서 i번째 행은 i+1번째 행이 됩니다. (마지막 행은 1번째 행이 됩니다.)
ShiftRow의 예 Untitled Diagram.drawio (52).png
왼쪽 행렬이 초기 상태이고 오른쪽 행렬이 ShiftRow를 한 번 시행한 뒤의 행렬입니다.
1번째 행에 있던 [1,2,3]이 2번째 행으로, 2번째 행에 있던 [4,5,6]이 3번째 행으로, 3번째 행에 있던 [7,8,9]가 1번째 행이 된 것을 확인할 수 있습니다.
Rotate
행렬의 바깥쪽에 있는 원소들을 시계 방향으로 한 칸 회전시킵니다.
행렬의 바깥쪽에 있는 원소들은 첫 행, 첫 열, 끝 행, 끝 열에 포함되는 원소들입니다.
한 칸 회전시킨다는 것은 이 원소들이 시계 방향으로 한 칸씩 밀려난다는 것을 의미합니다. 즉, 다음 4개의 연산이 동시에 시행됩니다.
첫 행에서 끝 열에 있는 원소를 제외한 첫 행의 모든 원소는 오른쪽으로 한 칸 이동합니다.
끝 열에서 끝 행에 있는 원소를 제외한 끝 열의 모든 원소는 아래쪽으로 한 칸 이동합니다.
끝 행에서 첫 열에 있는 원소를 제외한 끝 행의 모든 원소는 왼쪽으로 한 칸 이동합니다.
첫 열에서 첫 행에 있는 원소를 제외한 첫 열의 모든 원소는 위쪽으로 한 칸 이동합니다.
Rotate의 예 Untitled Diagram.drawio (51).png
왼쪽 행렬이 초기 상태이고 오른쪽 행렬이 Rotate를 한 번 시행한 뒤의 행렬입니다.
바깥쪽에 있는 값들이 시계 방향으로 한 칸씩 이동한 것을 확인할 수 있습니다.
당신은 행렬에 연산을 여러 번 시행하려고 합니다.
행렬의 초기 상태를 담고 있는 2차원 정수 배열 rc, 시행할 연산을 순서대로 담고 있는 문자열 배열 operations가 매개변수로 주어졌을 때, 연산을 차례대로 시행한 후의 행렬 상태를 return 하도록 solution 함수를 완성해주세요.

제한사항
2 ≤ rc의 행 길이(=행렬의 가로 길이) ≤ 50,000
rc의 모든 행의 길이는 동일합니다.
2 ≤ rc의 열 길이(=행렬의 세로 길이) ≤ 50,000
rc의 모든 열의 길이는 동일합니다.
4 ≤ rc의 행 길이 x rc의 열 길이 ≤ 100,000
rc[i][j] 는 i+1번째 행 j+1번째 열에 있는 원소를 나타냅니다.
1 ≤ rc[i][j] ≤ 1,000,000
1 ≤ operations의 길이 ≤ 100,000
operations의 원소는 "ShiftRow" 혹은 "Rotate"입니다.
정확성 테스트 케이스 제한 사항

2 ≤ rc의 행 길이(=행렬의 가로 길이) ≤ 1,000
rc의 모든 행의 길이는 동일합니다.
2 ≤ rc의 열 길이(=행렬의 세로 길이) ≤ 1,000
rc의 모든 열의 길이는 동일합니다.
4 ≤ rc의 행 길이 x rc의 열 길이 ≤ 10,000
1 ≤ operations의 길이 ≤ 100
효율성 테스트 케이스 제한 사항

주어진 조건 외 추가 제한사항 없습니다.
입출력 예
rc	operations	result
[[1, 2, 3], [4, 5, 6], [7, 8, 9]]	["Rotate", "ShiftRow"]	[[8, 9, 6], [4, 1, 2], [7, 5, 3]]
[[8, 6, 3], [3, 3, 7], [8, 4, 9]]	["Rotate", "ShiftRow", "ShiftRow"]	[[8, 3, 3], [4, 9, 7], [3, 8, 6]]
[[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]	["ShiftRow", "Rotate", "ShiftRow", "Rotate"]	[[1, 6, 7 ,8], [5, 9, 10, 4], [2, 3, 12, 11]]
 */
public class Solution_Programers_행렬과연산 {
    public static void main(String[] args) {
        Solution_행렬과연산 sol = new Solution_행렬과연산();
        
        int[][][] input = {
                {
                        { 1, 2 },
                        { 3, 1000000 }
                },
                {
                        { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 }
                },
                {
                        { 1, 2 },
                        { 3, 4 },
                        { 5, 6 },
                        { 1, 2 },
                        { 3, 4 },
                        { 5, 6 },
                        { 1, 2 },
                        { 3, 4 },
                        { 5, 6 }
                },
                {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                },
                {
                        { 8, 6, 3 },
                        { 3, 3, 7 },
                        { 8, 4, 9 },
                },
                {
                        { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 }
                },
                {
                        { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 }
                }
        };
        String[][] inputStr = {
            {"ShiftRow", "ShiftRow", "ShiftRow", "ShiftRow"},
            {"ShiftRow", "ShiftRow", "ShiftRow", "ShiftRow"},
            {"ShiftRow", "ShiftRow", "ShiftRow", "ShiftRow"},
            {"ShiftRow"},
            {"Rotate", "ShiftRow", "ShiftRow"},
            {"ShiftRow", "Rotate", "ShiftRow", "Rotate"},
            {"ShiftRow", "ShiftRow", "ShiftRow", "ShiftRow", "Rotate", "Rotate", "Rotate", "Rotate"}
        };
        for (int i = 0; i < input.length; i++) {
            int[][] output = sol.solution(input[i], inputStr[i]);
            for (int j = 0; j < output.length; j++) {
                System.out.println(Arrays.toString(output[j]));
            }
            System.out.println();
        }
    }
}

class Solution_행렬과연산 {
    public int[][] solution(int[][] rc, String[] operations) {
        int n = operations.length;
        int r = rc.length;
        int c = rc[0].length;
        List<Deque<Integer>> edge = new ArrayList<>();
        Deque<Deque<Integer>> inner = new ArrayDeque<>();
        if (r > 2 && c > 2) {
            for (int i = 1; i < r - 1; i++) {
                inner.add(new ArrayDeque<Integer>());
                for (int j = 1; j < c - 1; j++) {
                    inner.peekLast().add(rc[i][j]);
                }
            }
        }
        edge.add(new ArrayDeque<Integer>());
        for (int i = 0; i < c; i++) {
            edge.get(0).add(rc[0][i]);
        }
        edge.add(new ArrayDeque<Integer>());
        for (int i = 1; i < r - 1; i++) {
            edge.get(1).add(rc[i][c - 1]);
        }
        edge.add(new ArrayDeque<Integer>());
        for (int i = 0; i < c; i++) {
            edge.get(2).add(rc[r - 1][i]);
        }
        edge.add(new ArrayDeque<Integer>());
        for (int i = 1; i < r - 1; i++) {
            edge.get(3).add(rc[i][0]);
        }

        for (int i = 0; i < n; i++) {
            switch (operations[i]) {
                case "Rotate":
                    rotate(edge, r);
                    break;
                case "ShiftRow":
                    shiftRow(edge, inner, r, c);
                    break;
            }
        }
        for (int i = 0; i < c; i++) {
            rc[0][i] = edge.get(0).poll();
            rc[r - 1][i] = edge.get(2).poll();
        }
        for (int i = 1; i < r - 1; i++) {
            rc[i][c - 1] = edge.get(1).poll();
            rc[i][0] = edge.get(3).poll();
        }
        if (r > 2 && c > 2) {
            for (int i = 1; i < r - 1; i++) {
                Deque<Integer> temp = inner.poll();
                for (int j = 1; j < c - 1; j++) {
                    rc[i][j] = temp.poll();
                }
            }
        }

        return rc;
    }

    static void rotate(List<Deque<Integer>> edge, int r) {
        if (r > 2) {
            edge.get(0).offerFirst(edge.get(3).pollFirst());
            edge.get(1).offerFirst(edge.get(0).pollLast());
            edge.get(2).offerLast(edge.get(1).pollLast());
            edge.get(3).offerLast(edge.get(2).pollFirst());
        } else {
            edge.get(0).offerFirst(edge.get(2).pollFirst());
            edge.get(2).offerLast(edge.get(0).pollLast());
        }
    }

    static void shiftRow(List<Deque<Integer>> edge, Deque<Deque<Integer>> inner, int r, int c) {
        if (r > 2 && c > 2) {
            edge.get(3).offerFirst(edge.get(0).pollFirst());
            edge.get(1).offerFirst(edge.get(0).pollLast());
            inner.offerFirst(edge.remove(0));
            edge.add(0, edge.remove(1));
            edge.add(2, inner.pollLast());
            edge.get(2).offerFirst(edge.get(3).pollLast());
            edge.get(2).offerLast(edge.get(1).pollLast());
        } else if (r == 2) {
            edge.add(0, edge.remove(2));
            edge.add(2, edge.remove(1));
        } else if (c == 2) {
            edge.get(3).offerFirst(edge.get(0).pollFirst());
            edge.get(1).offerFirst(edge.get(0).pollLast());
            edge.get(0).offerFirst(edge.get(2).pollFirst());
            edge.get(0).offerLast(edge.get(2).pollLast());
            edge.get(2).offerFirst(edge.get(3).pollLast());
            edge.get(2).offerLast(edge.get(1).pollLast());
        }
    }
}