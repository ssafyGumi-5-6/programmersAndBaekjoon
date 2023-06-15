package s230608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_bj_11723_집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        MySet set = new MySet();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = 0;
            if (!cmd.equals("all") && !cmd.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (cmd) {
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    sb.append(set.check(num)).append("\n");
                    break;
                case "toggle":
                    set.toggle(num);
                    break;
                case "all":
                    set.all();
                    break;
                case "empty":
                    set.empty();
                    break;
            }
        }
        System.out.print(sb.toString());
    }
    static class MySet {
        private Set<Integer> set;
    
        public MySet() {
            set = new HashSet<>();
        }
    
        public void add(int value) {
            set.add(value);
        }
    
        public void remove(int value) {
            if (set.contains(value)) {
                set.remove(value);
            }
        }
    
        public int check(int value) {
            if (set.contains(value)) {
                return 1;
            } else
                return 0;
        }
    
        public void toggle(int value) {
            if (set.contains(value)) {
                set.remove(value);
            } else {
                set.add(value);
            }
        }
    
        public void all() {
            for (int i = 1; i <= 20; i++) {
                set.add(i);
            }
        }
    
        public void empty() {
            set.clear();
        }
    }

}