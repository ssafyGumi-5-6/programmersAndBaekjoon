package 비밀번호_발음하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static String[] vowel = {"a","e","i","o","u"};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        while(true){
            String s = reader.readLine();
            String printS = "<" + s + ">";
            if(s.equals("end")) break;

            s = s.toLowerCase();

            // (1) a, e, i, o, u : contains
            String firstCase = s.replaceAll("[aeiou]", "");

            // (2) a{3} 제거
            String secondCase = s.replaceAll("[aeiou]{3,}|[^aeiou]{3,}",  "");
//            System.out.println("SecondCase : " + secondCase);
            String thirdCase = s;
            // (3) ee or oo 이외 a{2}는 제거
//            for(int i = 0; i < 26; i++){
//                char c = (char)('a' + i);
//                if(c == 'e' || c == 'o') continue;
//                thirdCase = thirdCase.replaceAll(c +"{2}","");
//            }
            // or
            thirdCase = thirdCase.replaceAll("([^eo])\\1+","");

            if((!firstCase.equals(s)) && secondCase.equals(s) && thirdCase.equals(s)) builder.append(printS).append(" is acceptable.").append("\n");
            else builder.append(printS).append(" is not acceptable.").append("\n");

        }



//        System.out.println(a.replaceAll(String.v/alueOf(s2), ""));
        System.out.println(builder);

        reader.close();
    }
}
