import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws IOException {
        // BufferedReader와 BufferedWriter 사용이 필수이다. 안 그러면 시간초과 발생
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String initStr = br.readLine();
        Deque<Character> cursorLeft = new ArrayDeque<>();
        Deque<Character> cursorRight = new ArrayDeque<>();
        int commandCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < initStr.length(); ++i) {
            cursorLeft.add(initStr.charAt(i));
        }

        for (int i = 0; i < commandCount; ++i) {
            String command = br.readLine();

            switch(command.charAt(0)) {
                case 'L':
                    if(cursorLeft.isEmpty()) {
                        break;
                    }
                    cursorRight.addFirst(cursorLeft.removeLast());
                    break;
                case 'D':
                    if(cursorRight.isEmpty()) {
                        break;
                    }
                    cursorLeft.addLast(cursorRight.removeFirst());
                    break;
                case 'B':
                    if(cursorLeft.isEmpty()) {
                        break;
                    }
                    cursorLeft.removeLast();
                    break;
                case 'P':
                    cursorLeft.addLast(command.charAt(2));
                    break;
                default:
                    break;
            }
        }

        while(!cursorLeft.isEmpty()) {
            bw.write(cursorLeft.pollFirst());
        }
        while(!cursorRight.isEmpty()) {
            bw.write(cursorRight.pollFirst());
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
