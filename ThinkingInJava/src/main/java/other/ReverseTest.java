package main.java.other;

/**
 * @author toutou
 * @date by 2020/05
 */
public class ReverseTest {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node tmp = null;
        Node cur = null;
        for (int i = 1; i < 10; i++) {
            tmp = new Node(i);
            if (1 == i) {
                head.next = tmp;
            } else {
                cur.next = tmp;
            }
            cur = tmp;
        }



        //Node sds = null;
        Node h = reverseWhile(head);
        System.out.println("OK");
        //while (null != h) {
        //    System.out.print(h.() + " ");
        //    h = h.getNextNode();
        //}
    }

    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static Node reverseWhile(Node node){
        Node pre = null;
        Node next = null;
        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }
    }
}
