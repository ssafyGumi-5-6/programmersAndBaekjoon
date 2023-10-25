package 스카이라인_쉬운거;

import java.io.*;
import java.util.*;

public class Solution {

    public static class Point{
        public final int x;
        public final int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        Point[] points = new Point[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            points[i] = new Point(x, y);

        }

        int answer = 0;

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && points[stack.peek()].y > points[i].y){
                int beforeIndex = stack.pop();

                if(!stack.isEmpty() && points[stack.peek()].y == points[beforeIndex].y) continue;

                // 0인 경우 out 한 구간 종료
                if(points[beforeIndex].y == 0) break;
                answer += 1;
            }
            stack.push(i);
//            System.out.println(i + " " +  " x, y : " + points[i] .x + " " + points[i].y + " answer : " + answer+ " size : " + stack.size() + " " + points[stack.peek()].y);
        }

        while(!stack.isEmpty()){
            int beforeIndex = stack.pop();

            if(!stack.isEmpty() && points[stack.peek()].y == points[beforeIndex].y) continue;
            if(points[beforeIndex].y == 0) break;
            answer += 1;
        }

        System.out.println(answer);

        reader.close();
    }
}
