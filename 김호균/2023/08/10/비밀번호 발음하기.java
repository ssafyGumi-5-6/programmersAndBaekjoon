import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);      

        while(true) {
            String password = sc.nextLine();
            if(password.equals("end")) {
                break;
            }

            StringBuilder sb = new StringBuilder();
            sb
                .append("<")
                .append(password)
                .append("> is");

            int vowelsCount = 0;
            int consecutiveConsonants = 0;
            int consecutiveVowels = 0;
            boolean isValid = true;

            for(int i = 0; i < password.length(); ++i) {

                if(isVowels(password.charAt(i))) {
                    ++consecutiveVowels;
                    ++vowelsCount;
                    consecutiveConsonants = 0;
                } else {
                    ++consecutiveConsonants;
                    consecutiveVowels = 0;
                }


                if(consecutiveConsonants == 3 || consecutiveVowels == 3) {
                    isValid = false;
                    break;
                }

                if(password.charAt(i) != 'e' && password.charAt(i) != 'o') {
                    if (i - 1 >= 0 && password.charAt(i) == password.charAt(i - 1)) {
                        isValid = false;
                        break;
                    }
                }

            }

            if(vowelsCount == 0 || !isValid) {
                sb.append(" not");
            }
            sb.append(" acceptable.");
            System.out.println(sb);
        }

        sc.close();
    }

    private static boolean isVowels(char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for(int i = 0; i < vowels.length; ++i) {
            if(c == vowels[i]) {
                return true;
            }
        }
        return false;
    }
}
