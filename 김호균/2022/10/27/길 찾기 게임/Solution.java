import java.util.Arrays;

// 이진 트리 노드
class Node {
    int data;  // 노드 데이터 값
    Node left; // 왼쪽 자식
    Node right; // 오른 쪽 자식
    // 좌표 값 저장
    int x; 
    int y;
    
    public Node(int data, int x, int y) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    Node head;
    int[][] answer;
    int index = 0;
    public int[][] solution(int[][] nodeinfo) {
        
        int[][] array = new int[nodeinfo.length][3];
        // 정렬 전 노드 데이터(들어오는 순서)를 좌표와 같이 저장해준다.
        for(int i = 0; i < nodeinfo.length; i++) {
            array[i][0] = nodeinfo[i][0];
            array[i][1] = nodeinfo[i][1];
            array[i][2] = i + 1;
        }
        
        // Y좌표를 내림차순으로 정렬한다. 
        // Y좌표가 같으면 X좌표를 오름차순으로 정렬해준다.
        Arrays.sort(array, (o1, o2) -> {
            if(o1[1] - o2[1] == 0) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        // 정렬된 배열의 첫 번째 값이 Y좌표가 가장 크므로 루트가 된다.
        head = new Node(array[0][2], array[0][0], array[0][1]);
        for(int i = 1; i < array.length; i++) { // 하나하나 넣는다.
            insert(array[i]);
        }
        answer = new int[2][nodeinfo.length]; 
        preorder(head);
        index=0;
        postorder(head);
        return answer;
    }
    
    // 전위 탐색
    // 부모 -> 왼쪽 자식 -> 오른쪽 자식 순서로 탐색한다.
    void preorder(Node node) {
        answer[0][index] = node.data; // 부모 탐색
        index++;
        if(node.left != null) preorder(node.left); // 왼쪽 자식이 있으면 탐색
        if(node.right != null) preorder(node.right); // 오른쪽 자식이 있으면 탐색
    }
    
    // 후위 탐색
    // 왼쪽 자식 -> 오른쪽 자식 -> 부모 순서로 탐색한다.
    void postorder(Node node) {
        if(node.left != null) postorder(node.left);  // 왼 쪽에 자식이 없어질 때까지 이동
        if(node.right != null) postorder(node.right); // 오른 쪽에 자식이 없어질 때까지 이동
        answer[1][index] = node.data; // 양쪽다 자식이 없으면 탐색
        index++;
    }
    
    // insert 함수
    void insert(int[] array) {
        int x = array[0];
        int y = array[1];
        int data = array[2]; 
        
        // 루트 부터 좌우 좌표 비교
        Node cursor = head;
        while(true) {
            // Y좌표는 순서대로 들어오기 때문에 X좌표만 비교하면 된다.
            // X좌표가 크면 나(cursor)보다 항상 오른쪽 노드이기 때문에 오른쪽 자식과 비교를 한다.
            if(cursor.x < x) {
                if(cursor.right == null){ // 오른쪽 자식이 없으면 지금 들어온 노드가 오른쪽 자식이 된다.
                    cursor.right = new Node(data, x, y);
                    break;
                } else
                    cursor = cursor.right;
            } else {
            // X좌표가 작으면 왼 쪽 노드이기 때문에 오른 쪽 비교를 한다.
                if(cursor.left == null) { // 오른쪽과 마찬가지
                    cursor.left = new Node(data, x, y);
                    break;
                } else
                    cursor = cursor.left;
            }
        }
    }
}