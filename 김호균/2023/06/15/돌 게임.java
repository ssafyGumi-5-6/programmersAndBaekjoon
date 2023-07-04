import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStone = sc.nextInt();
        
        System.out.println(numberOfStone % 2 == 0 ? "CY" : "SK");
        
        sc.close();
    }
}
