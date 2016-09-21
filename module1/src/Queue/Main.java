package Queue;

/**
 * Created by shai on 9/20/16.
 */
public class Main {

    private static boolean push(Queue q, int info) {
        System.out.println("Pushing " + info + ":");
        boolean res = q.push(info);
        System.out.println(q);
        return res;
    }

    private static Object pop(Queue q) {
        System.out.println("Popping first in queue...");
        Object o = q.pop();
        if (o != null) {
            System.out.println(o + " is getting serviced now");
            System.out.println(q);
        } else {
            System.out.println("Queue is empty");
        }
        return o;
    }

    public static void main(String args[]) {

        Queue q = new QueueA(10);
        //Queue q = new QueueB(10);
        int gettingServiced;

        push(q, 1);
        push(q, 2);
        push(q, 3);
        push(q, 4);
        pop(q);
        pop(q);
        pop(q);
        push(q, 98);
        push(q, 99);
        pop(q);
        pop(q);
        pop(q);
        pop(q);
        pop(q);
    }
}
