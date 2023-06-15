import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    // 벨트의 칸 별 상태를 나타내는 클래스
    static class Slot {
        int endurance;
        boolean isRobotExist;
        
        Slot (int endurance) {
            this.endurance = endurance;
            this.isRobotExist = false;
        }
        
        Slot (int endurance, boolean isRobotExist) {
            this.endurance = endurance;
            this.isRobotExist = isRobotExist;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfConveyorBeltSlots = sc.nextInt();
        int enduranceZeroConveyorBeltThreshold = sc.nextInt();
        sc.nextLine();
        
        LinkedList<Slot> slots = new LinkedList<>();
        for(int i = 0; i < numberOfConveyorBeltSlots * 2; i++) {
           slots.add(new Slot(sc.nextInt()));
        }
        
        int step = 0; // 단계
        while( enduranceZeroConveyorBeltThreshold > 0) {
            ++step;
            
            slots.addFirst(slots.pollLast()); // 벨트를 한칸 돌린다.
            
            // 내리는 칸에 로봇이 있으면 제거한다.
            slots.get(numberOfConveyorBeltSlots - 1).isRobotExist = false;
            
            // 로봇 이동
            for(int i = numberOfConveyorBeltSlots - 2; i >= 0; i--) {
                if(slots.get(i).isRobotExist) {
                    if (!slots.get(i + 1).isRobotExist && slots.get(i + 1).endurance > 0) {
                        slots.get(i).isRobotExist = false;
                        slots.get(i + 1).isRobotExist = true;
                        slots.get(i + 1).endurance -= 1;
                        
                        if(slots.get(i + 1).endurance == 0) {
                            --enduranceZeroConveyorBeltThreshold;
                        }
                    }
                }
            }
            
            // 내리는 칸에 로봇이 있으면 제거한다.
            slots.get(numberOfConveyorBeltSlots - 1).isRobotExist = false;
            
            // 올리는 칸에 로봇을 올린다.
            if(slots.getFirst().endurance > 0) {
                slots.getFirst().endurance -= 1;
                slots.getFirst().isRobotExist = true;
                
                if(slots.getFirst().endurance == 0) {
                    --enduranceZeroConveyorBeltThreshold;
                }
            }
        }
        
        System.out.println(step);
    }
}
