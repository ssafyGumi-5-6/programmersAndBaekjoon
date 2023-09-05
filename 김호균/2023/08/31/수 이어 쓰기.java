import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int index = 0;
        int N = 0;

        while(index < s.length()) {
            ++N;
            String strN = String.valueOf(N);
            for(int i = 0; i < strN.length(); ++i) {
                if(s.charAt(index) == strN.charAt(i)) {
                    ++index;
                }

                if(index == s.length()) {
                    break;
                }
            }
        }

        System.out.println(N);
        sc.close();
    }
}
