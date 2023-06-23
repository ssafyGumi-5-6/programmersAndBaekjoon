import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        
        for(int t = 0; t < testCase; t++) {
            int testCaseNum = sc.nextInt();
            
            List<Integer> students = new ArrayList<>();
            int backMovingCount = 0;
            
            /* 앞에서부터 정렬하기 때문에 이제 줄을 서야하는 학생(i 번째 학생)보다
             * 앞에 선 키가 작은 사람은 이미 본인보다 큰 사람 앞으로 이동을 마친 상태이므로
             * i 번째 학생보다 키가 큰사람만 뒤로 움직이게 된다.
             * 결국 i 번째 학생보다 앞에 있으며 키가 큰 사람의 수만 카운트하면 된다. */
            for(int i = 0; i < 20; i++) {
                students.add(sc.nextInt());
                for(int j = 0; j < i; j++) {
                    if(students.get(i) < students.get(j)) {
                        backMovingCount++;
                    }
                }
            }
            
            System.out.println(testCaseNum + " " + backMovingCount);
        }
        
        sc.close();
    }
}
