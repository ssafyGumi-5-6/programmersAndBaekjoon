package 에디터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2 {
//    private static int index;
    private static int M;

//    private static boolean withRange(int idx){
//        return 0 <= idx && idx <= builder.length();
//    }

    private static void LDBP(char c, StringTokenizer tokenizer, Stack<Character> leftStack, Stack<Character> rightStack) throws IOException{
        // StringBuilder로 풀려고 했지만 StringBuilder도 O(T x N)이다.
        // 제한시간이 0.3 초이므로 500,000 데이터 1억 / 3 초과 터짐
        switch(c){
            case 'P':
                char inputC = tokenizer.nextToken().charAt(0);
//                System.out.println("C : " + inputC + " index : " + index);
                leftStack.push(inputC);
//                if(!leftStack.isEmpty()) rightStack.push(leftStack.peek());
//                if(index == builder.length()) builder = new StringBuilder(builder.substring(0, index) + inputC);
//                else if(index == 0) builder = new StringBuilder(inputC + builder.toString());
//                else builder = new StringBuilder(builder.substring(0, index) + inputC + builder.substring(index, builder.length()));
//                index += 1;
                break;
            case 'L':
//                System.out.println("before index : " + index);
                if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
//                if(withRange(index - 1)) index -= 1;
//                System.out.println("after index : " + index);
                break;
            case 'D':
                if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
//                if(withRange(index + 1)) index += 1;
                break;
            case 'B':
                if(!leftStack.isEmpty()) leftStack.pop();
//                if(index <= 0) break;
////                System.out.println("index : " + index + " builder.length : " + builder.length());
//                if(index == builder.length()){
//                    builder = new StringBuilder(builder.substring(0, index - 1));
////                    System.out.println("index == builder.length()" + index);
//                }
//                else{
////                    System.out.println("실행 : " + builder.substring(0, index) + " " + builder.substring(index, builder.length()));
//                    builder = new StringBuilder(builder.substring(0, index - 1) + builder.substring(index, builder.length()));
//                }
//                index -= 1;
//                System.out.println("builder : " + builder + " index : " + index);
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        char[] cArray = reader.readLine().toCharArray();

        for(int cIndex = 0; cIndex < cArray.length; cIndex++) leftStack.push(cArray[cIndex]);
        M = Integer.parseInt(reader.readLine());

        for(int tk = 0; tk < M; tk++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            char c = tokenizer.nextToken().charAt(0);
//            System.out.println("tk : " + tk + " index : " + index + " 입력된 값 : " + c + " 변경 전 : " + builder);
            LDBP(c, tokenizer, leftStack, rightStack);
//            System.out.println("변경 후 : " + builder);
        }

        while(!leftStack.isEmpty()) rightStack.push(leftStack.pop());

        StringBuilder builder = new StringBuilder();
        while(!rightStack.isEmpty()) builder.append(rightStack.pop());
        System.out.println(builder);
        reader.close();
    }
}
