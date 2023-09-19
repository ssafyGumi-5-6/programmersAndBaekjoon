import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution3 {

    private static int N;
    private static int[] arr;

    private static void ASCII(int curData, int inputData, StringBuilder combine, StringBuilder builder){
        if(curData > inputData){
            if(calculate(combine)) builder.append(combine).append("\n");
            return;
        }
        ASCII(curData + 1, inputData, new StringBuilder(combine+ " " + curData), builder);
        ASCII(curData + 1, inputData, new StringBuilder(combine+ "+" + curData), builder);
        ASCII(curData + 1, inputData, new StringBuilder(combine+ "-" + curData), builder);
    }

    private static int operator(int num1, int num2, char c){
        switch(c){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
        }
        return -1;
    }
    private static boolean calculate(StringBuilder combine){
//        System.out.println(combine.toString());
        combine = new StringBuilder(combine.toString().replaceAll(" ", ""));
        StringTokenizer tokenizer = new StringTokenizer(combine.toString(), "+-", true);
        int sum = 0;
        while(tokenizer.hasMoreTokens()){
            String str = tokenizer.nextToken();
//            System.out.println("s : " + str.toString());
            if(str.equals("+") || str.equals("-")){
                String nextStr = tokenizer.nextToken();
//                System.out.println(str.toString());
                sum = operator(sum, Integer.parseInt(nextStr), str.charAt(0));
            }else{
                sum += Integer.parseInt(str);
            }
        }
//        System.out.println("sum : " + sum);
        return sum == 0 ? true : false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        N = Integer.parseInt(reader.readLine());

        arr = new int[10];

        for(int i = 0; i < 10; i++) arr[i] = i;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(reader.readLine());
            StringBuilder inputBuilder = new StringBuilder();
            ASCII(2, num, new StringBuilder().append(1), inputBuilder);
            if(!inputBuilder.toString().isEmpty()){

                builder.append(inputBuilder);
                if(i < N - 1) builder.append("\n");
            }
        }

        System.out.print(builder);

        reader.close();
    }
}
