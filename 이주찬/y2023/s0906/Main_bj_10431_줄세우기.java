package y2023.s0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * main_bj_10431_줄세우기
 */
public class Main_bj_10431_줄세우기 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());


        for (int t = 1; t <= test_case; t++) {

            st = new StringTokenizer(br.readLine());
            int tNum = Integer.parseInt(st.nextToken());
            MyArr_10431 arr = new MyArr_10431(20);
            for (int i = 0; i < 20; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            sb.append(tNum).append(" ").append(arr.moveCount).append("\n");

        }

        System.out.print(sb.toString());
    }
}

class MyArr_10431 {

    int[] arr;
    int size;
    int moveCount;
    int cap;

    public MyArr_10431(int cap) {
        size = 0;
        arr = new int[cap + 1];
        this.cap = cap;
        moveCount = 0;
    }
    
    public void add(int input) {
        int pointer = -1;
        for (int i = 0; i < cap; i++) {
            if (arr[i] > input) {
                pointer = i;
                break;
            }
        }
        if (pointer != -1) {
            for (int i = size; i > pointer; i--) {
                arr[i] = arr[i - 1];
                moveCount++;
            }
            arr[pointer] = input;
            size++;
        } else {
            arr[size++] = input;
        }
    }

}