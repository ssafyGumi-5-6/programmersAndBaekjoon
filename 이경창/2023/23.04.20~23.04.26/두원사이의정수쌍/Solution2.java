package 두원사이의정수쌍;

class Solution {

    long r1, r2;

    int getY(long radius, long maxRadius) {
        double curY = Math.sqrt(maxRadius * maxRadius - radius * radius);

        if (maxRadius == r1 && curY % 1 == 0) {
            return (int) curY - 1;
        } else {
            return (int) curY;
        }
    }

    public long solution(long _r1, long _r2) {
        long answer = 0;
        r1 = _r1;
        r2 = _r2;

        /*

        y^2 = z^2 - x^2

        (1) 0 ~ r1 구간
        - 현재 위치에서 r1 구간까지 구한다.
        - 현재 위치에서 r2 구간까지 구한다.
        - 두 개의 차를 구한다.
        (2) r1 ~ r2 구간
        - 현재 위치에서 r2 구간까지 구한다.
        */

        for (int i = 1; i < r2; i++) {
            if (i < r1) {
                answer += (getY(i, r2) - getY(i, r1));
            } else {
                answer += getY(i, r2);
            }
        }

        answer *= 4;
        answer += (r2 - r1 + 1) * 4;

        return answer;
    }
}