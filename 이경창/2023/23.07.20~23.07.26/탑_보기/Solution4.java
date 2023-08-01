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
            if(buildingHeight[index] > buildingHeight[buildingNumber]){
                // stack이 비었거나, 현재 층이 이전 stack에 있는 값보다 클 경우 바로 삽입
                if(stack.isEmpty() || buildingHeight[stack.peek()] < buildingHeight[index]) stack.push(index);
            }
        }
        System.out.println("stack : " + stack.size());
    }

    private static void rightRange(int buildingNumber, Stack<Integer> stack){
        for(int index = buildingNumber + 1; index <= buildingRightMaxHeight[buildingNumber]; index++){
            if(buildingHeight[index] > buildingHeight[buildingNumber]){
                // stack이 빈 경우, 현재 층이 이전 stack에 있는 값보다 클 경우 바로 삽입
                if(stack.isEmpty() || buildingHeight[stack.peek()] < buildingHeight[index]) stack.push(index);
            }
        }
        System.out.println("stack : " + stack.size());

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        N = Integer.parseInt(reader.readLine());
        buildingHeight = new int[N];
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
                rightRange(buildingNumber, stack);
                if(stack.isEmpty()) builder.append(0).append("\n");
                else builder.append(stack.size()).append(" ").append(stack.firstElement() + 1);
//                for(int index = buildingNumber + 1; index <= buildingRightMaxHeight[buildingNumber]; index++){
//                    if(buildingHeight[index] > buildingHeight[buildingNumber]){
//                        // stack이 빈 경우, 현재 층이 이전 stack에 있는 값보다 클 경우 바로 삽입
//                        if(stack.isEmpty() || buildingHeight[stack.peek()] < buildingHeight[index]) stack.push(index);
//                    }
//                }
            }else if(buildingNumber == N - 1){
                leftRange(buildingNumber, stack);
                if(stack.isEmpty()) builder.append(0).append("\n");
                else builder.append(stack.size()).append(" ").append(stack.firstElement() + 1);
//                for(int index = buildingNumber - 1; index >= buildingLeftMaxHeight[buildingNumber]; index--){
//                    if(buildingHeight[index] > buildingHeight[buildingNumber]){
//                        // stack이 비었거나, 현재 층이 이전 stack에 있는 값보다 클 경우 바로 삽입
//                        if(stack.isEmpty() || buildingHeight[stack.peek()] < buildingHeight[index]) stack.push(index);
//                    }
//                }
            }else {

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
                    count += stack.size();
                }

                if(count == 0) builder.append(0).append("\n");
                else builder.append(count).append(" ").append(resultIndex).append("\n");

//                for(int index = buildingNumber + 1; index <= buildingRightMaxHeight[buildingNumber]; index++){
//                    if(buildingHeight[index] > buildingHeight[buildingNumber]){
//                        // stack이 빈 경우, 현재 층이 이전 stack에 있는 값보다 클 경우 바로 삽입
//                        if(stack.isEmpty() || buildingHeight[stack.peek()] < buildingHeight[index]) stack.push(index);
//                    }
//                }

//                for(int index = buildingNumber - 1; index >= buildingLeftMaxHeight[buildingNumber]; index--){
//                    if(buildingHeight[index] > buildingHeight[buildingNumber]){
//                        // stack이 비었거나, 현재 층이 이전 stack에 있는 값보다 클 경우 바로 삽입
//                        if(stack.isEmpty() || buildingHeight[stack.peek()] < buildingHeight[index]) stack.push(index);
//                    }
//                }
            }


        }
        System.out.println(builder);
        reader.close();
    }
}
