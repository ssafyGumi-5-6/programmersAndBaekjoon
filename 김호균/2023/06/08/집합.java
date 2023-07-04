import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfOrder = sc.nextInt();
        sc.nextLine();
        
        StringBuilder sb = new StringBuilder();

        boolean[] isNumberExist = new boolean[21]; // 집합에 숫자가 존재하는지 확인하는 배열

        for(int i = 0; i < numberOfOrder; i++) {
            // 명령어와 숫자를 입력받는다.
            String[] commandAndNumber = sc.nextLine().split(" ");

            // 명령어 종류 별로 작업을 수행한다.
            switch (commandAndNumber[0]) {
                case "add":
                    isNumberExist[Integer.parseInt(commandAndNumber[1])] = true;
                    break;
                case "remove":
                    isNumberExist[Integer.parseInt(commandAndNumber[1])] = false;
                    break;
                case "check":
                    sb
                        .append(isNumberExist[Integer.parseInt(commandAndNumber[1])] ? 1: 0)
                        .append("\n");
                    break;
                case "toggle":
                    int number = Integer.parseInt(commandAndNumber[1]);
                    isNumberExist[number] = !isNumberExist[number];
                    break;
                case "all":
                    Arrays.fill(isNumberExist, true);
                    break;
                case "empty":
                    Arrays.fill(isNumberExist, false);
                    break;
            }
        }
        
        // 출력을 한 번만 진행해 오버헤드 시간을 줄이는 것이 중요하다.
        System.out.println(sb.toString());
        sc.close();
    }
}
