import java.util.*;

class Node implements Comparable<Node>{
    String name;
    int startTime;
    int plusTime;

    Node(String name, int startTime, int plusTime){
        this.name = name;
        this.startTime = startTime;
        this.plusTime = plusTime;
    }
    Node(String name, int plusTime){
        this.name = name;
        this.plusTime = plusTime;
    }
    Node(){

    }

    @Override
    public int compareTo(Node n){
        // startTime 기준으로 정렬
        return this.startTime - n.startTime;
    }

}


class Solution2 {

    // (1) 2번째 인덱스 n / 60 + n % 60 으로 값을 구한다.
    // - 이름, 시작시간, 도착시간
    // (2) 시작시간 기준 정렬
    // (3) 현재 stack에 들어와 있는 도착시간 보다, 다음 번째 시작시간이 작다면
    // - queue에 현재 시작시간, 도착시간, 인덱스 저장
    // - 현재 stack에 들어와 있는 도착시간 보다, 다음 번째 시작시간이 크다면 (반복문을 돌려서 도착시간이 시작시간보다 작다면 계속 진행)
    public ArrayList<String> solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();

        Node[] node = new Node[plans.length];
        int nodeIdx = 0;
        for(String[] inPlans : plans){
            node[nodeIdx] = new Node();
            node[nodeIdx].name = inPlans[0];
            String[] inS = inPlans[1].split(":");
            int firstData = Integer.parseInt(inS[0]);
            int secondData = Integer.parseInt(inS[1]);

            int curTime = (firstData) * 60 + (secondData % 60);
            node[nodeIdx].startTime = curTime;
            node[nodeIdx++].plusTime = Integer.parseInt(inPlans[2]);
        }

        Arrays.sort(node);


        Stack<Node> stack = new Stack<>();

        for(int i = 0; i < node.length; i++){
            System.out.println("i : "  +i);
            if(i == node.length - 1){
                answer.add(node[i].name);
                break;
            }
            int current = node[i].startTime + node[i].plusTime;
            int next = node[i+1].startTime;
            int differ = next - current;

            if(differ < 0){
                stack.push(new Node(node[i].name, Math.abs(differ)));
            }else {
                answer.add(node[i].name);
                if(differ > 0){
                    while(stack.size() > 0 && differ > 0){
                        if(stack.peek().plusTime <= differ){
                            answer.add(stack.peek().name);
                            differ -= stack.pop().plusTime;
                        }else {
                            Node n = stack.pop();
                            stack.push(new Node(n.name, n.plusTime - differ));
                            break;
                        }
                    }
                }
            }
        }
        while(stack.size() > 0){
            answer.add(stack.pop().name);
        }

        return answer;
    }
}