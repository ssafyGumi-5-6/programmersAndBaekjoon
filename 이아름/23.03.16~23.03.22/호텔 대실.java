import java.util.Arrays;

public class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Time[] times = new Time[book_time.length];
        boolean[] check = new boolean[book_time.length];
        int index = 0;
        for (String[] s : book_time) {
            String[] ss = s[0].split(":");
            String[] se = s[1].split(":");
            int start = Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
            int end = Integer.parseInt(se[0]) * 60 + Integer.parseInt(se[1]);
            times[index++] = new Time(start, end);
        }

        Arrays.sort(times);

        for (int i = 0; i < times.length; i++) {
            if (check[i]) continue;
            check[i] = true;
            int next = times[i].next();
            for (int j = i + 1; j < times.length; j++) {
                if (next < times[j].start) {
                    check[j] = true;
                    next = times[j].next();
                }
            }
            answer++;
        }

        return answer;
    }

    public static class Time implements Comparable<Time> {
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "start: " + start + " end: " + end;
        }

        @Override
        public int compareTo(Time o) {
            int res = Integer.compare(start, o.start);
            if (res == 0) {
                return Integer.compare(end, o.end);
            } else {
                return res;
            }
        }

        public int next() {
            return this.end + 9;
        }
    }
}