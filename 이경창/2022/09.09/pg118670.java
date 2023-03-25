
import java.util.ArrayDeque;
import java.util.Deque;

// 행렬과 연산
class pg118670 {

    // 중앙 지역
    static Deque<Deque<Integer>> mid;

    // 사이드 왼쪽
    static Deque<Integer> side1;

    // 사이드 오른쪽
    static Deque<Integer> side2;

    static int r, c;

    static void shiftRowFun() {
        // 마지막 행을 첫 번째 행 위치로 옮긴다.
        side1.addFirst(side1.removeLast());
        mid.addFirst(mid.pollLast());
        side2.addFirst(side2.removeLast());
    }

    static void rotateFun() {
        if(c == 2){
            // 열이 2개일 때
            side2.addFirst(side1.pollFirst());
            side1.addLast(side2.pollLast());
        }else{
            // 열이 2개 초과일 때
            // mid의 첫번째 행의 마지막 인덱스 값을 side2의 첫번째 위치로 옮긴다.
            side2.addFirst(mid.peekFirst().removeLast());

            // side2의 마지막 인덱스 값을 mid의 마지막 행의 마지막 인덱스 위치로 옮긴다.
            mid.peekLast().addLast(side2.removeLast());

            // mid의 마지막 행의 첫 번째 인덱스 값을 side1의 마지막 인덱스로 옮긴다.
            side1.addLast(mid.peekLast().removeFirst());

            // side1의 첫 번째 인덱스를 mid의 첫번째 행의 첫 번째 인덱스 값으로 옮긴다.
            mid.peekFirst().addFirst(side1.removeFirst());
        }
    }

    public static int[][] solution(int[][] rc, String[] operations) {
        mid = new ArrayDeque<>();
        side1 = new ArrayDeque<>();
        side2 = new ArrayDeque<>();

        r = rc.length;
        c = rc[0].length;


        for (int i = 0; i < rc.length; i++) {
            mid.addLast(new ArrayDeque<>());
            for (int j = 0; j < rc[0].length; j++) {
                if (j == 0) {
                    side1.add(rc[i][j]);
                } else if (j == rc[0].length - 1) {
                    side2.add(rc[i][j]);
                } else {
                    mid.peekLast().addLast(rc[i][j]);
                }
            }
        }


        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("ShiftRow")) {
                shiftRowFun();
            } else if (operations[i].equals("Rotate")) {
                rotateFun();
            }
        }

        int[][] answer = new int[rc.length][rc[0].length];

        for (int i = 0; i < rc.length; i++) {
            Deque<Integer> temp = mid.pollFirst();
            for (int j = 0; j < rc[0].length; j++) {
                if (j == 0) {
                    answer[i][j] = side1.pollFirst();
                } else if (j == rc[0].length - 1) {
                    answer[i][j] = side2.pollFirst();
                } else {
                    answer[i][j] = temp.pollFirst();
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] rc = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        String[] oper = {"ShiftRow", "Rotate", "ShiftRow", "Rotate"};
        System.out.println(solution(rc, oper));
    }
}
