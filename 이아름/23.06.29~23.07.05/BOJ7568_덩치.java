package java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ7568_덩치 {

    static int N;
    static ArrayList<Person> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            list.add(new Person(height, weight));
        }

        for (int i = 0; i < N; i++) {
            Person p = list.get(i);
            int k = 0;
            for (int j = 0; j < N; j++) {
                Person t = list.get(j);
                if (p.weight < t.weight && p.height < t.height) {
                    k++;
                }
            }
            sb.append(k + 1).append(" ");
        }

        System.out.println(sb);
    }

    public static class Person {
        int height, weight;

        Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}