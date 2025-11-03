
class Node {

    int data;
    Node next;

    Node(int newData) {
        data = newData;
        next = null;
    }
}

public class LinkedList_exp {

    public static int countNodes(Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println("Count of nodes is " + countNodes(head));
    }
}
