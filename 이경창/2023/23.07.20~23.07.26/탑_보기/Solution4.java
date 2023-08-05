package 탑_보기;

import java.util.*;
import java.io.*;

public class Solution4 {

    private static int N;
    private static int[] buildingHeight;
    private static int[] buildingLeftMaxHeight;
    private static int[] buildingRightMaxHeight;

    private static void leftRange(int buildingNumber, Stack<Integer> stack){
        for(int index = buildingNumber - 1; index >= buildingLeftMaxHeight[buildingNumber]; index--){
//            System.out.println("buildingHeight : " + buildingHeight[index] + " " + buildingHeight[buildingNumber]);
            if(buildingHeight[index] > buildingHeight[buildingNumber]){
                // stack이 비었거나, 현재 층이 이전 stack에 있는 값보다 클 경우 바로 삽입
                if(stack.isEmpty() || buildingHeight[stack.peek()] < buildingHeight[index]) stack.push(index);
            }
        }
    }

    private static void rightRange(int buildingNumber, Stack<Integer> stack){
        for(int index = buildingNumber + 1; index <= buildingRightMaxHeight[buildingNumber]; index++){
            if(buildingHeight[index] > buildingHeight[buildingNumber]){
                // stack이 빈 경우, 현재 층이 이전 stack에 있는 값보다 클 경우 바로 삽입
                if(stack.isEmpty() || buildingHeight[stack.peek()] < buildingHeight[index]) stack.push(index);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while(tokenizer.hasMoreTokens()) list.add(Integer.parseInt(tokenizer.nextToken()));
        buildingHeight = list.stream().mapToInt(Integer::intValue).toArray();
        buildingLeftMaxHeight = new int[N];
        buildingRightMaxHeight = new int[N];

        /*
            (1)
            left
            right
        */
        for(int buildingNumber = N - 1; buildingNumber >= 0; buildingNumber--){
            int maxIndex = buildingNumber;
            for(int nextBuildingNumber = buildingNumber - 1; nextBuildingNumber >= 0; nextBuildingNumber--){
                maxIndex = (buildingHeight[maxIndex] > buildingHeight[nextBuildingNumber] ? maxIndex : nextBuildingNumber);
            }
            buildingLeftMaxHeight[buildingNumber] = maxIndex;
        }

        for(int buildingNumber = 0; buildingNumber <= N - 1; buildingNumber++){
            int maxIndex = buildingNumber;
            for(int nextBuildingNumber = buildingNumber + 1; nextBuildingNumber <= N - 1; nextBuildingNumber++){
                maxIndex = (buildingHeight[maxIndex] > buildingHeight[nextBuildingNumber] ? maxIndex : nextBuildingNumber);
            }
            buildingRightMaxHeight[buildingNumber] = maxIndex;
        }

        /*
        (2) 큰 값들을 Stack에 삽입하며 체크한다.
        */
        for(int buildingNumber = 0; buildingNumber <= N - 1; buildingNumber++){
            Stack<Integer> stack = new Stack<>();
            if(buildingNumber == 0){
//                System.out.println("첫 번째 시작");
                rightRange(buildingNumber, stack);
//                System.out.println("size : " + stack.size() + " " + (stack.firstElement() + 1));
                if(stack.isEmpty()) builder.append(0).append("\n");
                else builder.append(stack.size()).append(" ").append((stack.firstElement() + 1)).append("\n");
            }else if(buildingNumber == N - 1){
//                System.out.println("마지막 시작");
                leftRange(buildingNumber, stack);
                if(stack.isEmpty()) builder.append(0).append("\n");
                else builder.append(stack.size()).append(" ").append((stack.firstElement() + 1)).append("\n");
            }else {
//                System.out.println("중간 시작 : " +  buildingNumber + " [] : " + buildingHeight[buildingNumber]);
                int count = 0;
                int resultIndex = 0;
                rightRange(buildingNumber, stack);
                if(!stack.isEmpty()){
                    resultIndex = stack.firstElement();
                    count += stack.size();
                }

                stack = new Stack<>();
                leftRange(buildingNumber, stack);
                if(!stack.isEmpty()){
                    int leftFirstIndex = stack.firstElement();
                    if(Math.abs(buildingNumber - resultIndex) > Math.abs(buildingNumber - leftFirstIndex)) resultIndex = leftFirstIndex;
                    else if(Math.abs(buildingNumber - resultIndex) == Math.abs(buildingNumber - leftFirstIndex)) resultIndex = Math.min(resultIndex, leftFirstIndex);
                    count += stack.size();
                }

//                System.out.println("number" + buildingNumber + " count : " + count);
                if(count == 0) builder.append(0).append("\n");
                else builder.append(count).append(" ").append((resultIndex + 1)).append("\n");
            }
        }
        System.out.print(builder);
        reader.close();
    }
}
