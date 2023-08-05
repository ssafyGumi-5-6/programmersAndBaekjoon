import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    Node next;
    Node pre;
    char key;

    Node (Node pre, Node next, char key) {
        this.next = next;
        this.pre = pre;
        this.key = key;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Node HEAD = new Node(null, null, '*');
        Node pointer = HEAD;

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            Node temp = new Node(null, null, str.charAt(i));
            pointer.next = temp;
            temp.pre = pointer;
            pointer = temp;
        }


        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char command = st.nextToken().charAt(0);
            if (command == 'L') {
                if (pointer.pre == null) continue;
                pointer = pointer.pre;
            } else if (command == 'D') {
                if (pointer.next == null) continue;
                pointer = pointer.next;
            } else if (command == 'B') {
                if (pointer == HEAD) continue;
                if (pointer.next == null) {
                    pointer.pre.next = null;
                    pointer = pointer.pre;
                }
                else {
                    pointer.pre.next = pointer.next;
                    pointer.next.pre = pointer.pre;
                    pointer = pointer.pre;
                }
            } else if (command == 'P') {
                char $ = st.nextToken().charAt(0);
                Node temp = new Node(null, null, $);
                temp.pre = pointer;
                if (pointer.next != null) {
                    pointer.next.pre = temp;
                    temp.next = pointer.next;
                }
                pointer.next = temp;
                pointer = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        Node answer = HEAD.next;
        while (answer != null) {
            sb.append(answer.key);
            answer = answer.next;
        }
        System.out.println(sb);
    }
}
