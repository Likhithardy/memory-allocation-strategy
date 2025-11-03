
import java.util.*;

class Queue_dsa {

    public static void main(String[] args) {
        Queue<String> q_stack = new LinkedList<String>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many inputs you want");
        int num = input.nextInt();
        for (int i = 1; i < num; i++) {
            System.out.println("Enter [" + i + "] Person Name ");
            String first = input.next();
            q_stack.offer(first);
        }

        System.out.println("Whom you want remove from the queue:(Enter thier name)");
        String remove_name = input.next();
        q_stack.remove(remove_name);
        System.out.println(q_stack);
        System.out.println("Removed Ppl:" + remove_name);

    }
}
