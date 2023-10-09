package y2023.s0615;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_Bj_9655_돌게임 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }

}
