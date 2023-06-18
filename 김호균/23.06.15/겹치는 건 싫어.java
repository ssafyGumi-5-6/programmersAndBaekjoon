import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        int[] count = new int[100001]; // 몇 개가 중복됐는지 확인하는 배열
        List<Integer> list = new ArrayList<>(); // 입력받은 수열을 저장하는 리스트
        int answer = 0;
        int lastIndex = 0;
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int currentValue = ++count[a]; // 입력받은 숫자의 중복 카운트를 늘려준다.
            list.add(a);

            /* 중복 횟수가 K 번을 넘기면 
             * 중복 횟수 넘기기 전(list.size() - 1)과 지금의 정답과 비교해 큰 값을 정답으로 정한다.
             * 리스트 앞에서부터 중복 횟수 제한을 넘긴 숫자가 처음 등장하는 시점까지 지운다.
             * 리스트에서 지워지는 숫자들의 중복 횟수도 줄여준다.
             */
            if(currentValue > K) {
                answer = Math.max(answer, list.size() - 1);
                int removedValue = 0;
                do {
                    removedValue = list.remove(0);
                    --count[removedValue];
                } while (removedValue != a);
            }

        }

        // 마지막으로 한 번 더 지금 리스트의 길이와 정답을 비교해 답을 다시 구한다.
        answer = Math.max(answer, list.size());
        System.out.print(answer);
        sc.close();
    }
}
