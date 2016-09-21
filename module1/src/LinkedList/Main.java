package LinkedList;

/**
 * Created by shai on 9/18/16.
 */
public class Main {

    private static boolean addToHead(LinkedList l, Object o) {
        boolean res = l.addLinkToHead(o);
        System.out.println("Adding to head: " + o);
        System.out.println(l);
        return res;
    }

    private static boolean addToTail(LinkedList l, Object o) {
        boolean res = l.addLinkToTail(o);
        System.out.println("Adding to tail: " + o);
        System.out.println(l);
        return res;
    }

    private static boolean addTo(LinkedList l, Object o, int pos) {
        boolean res = l.addLink(o, pos);
        System.out.println("Adding to position " + pos + ": " + o);
        System.out.println(l);
        return res;
    }

    private static Object removeFromHead(LinkedList l) {
        Object o = l.removeLinkFromHead();
        System.out.println(l + "  (Removed from head: " + o + ")");
        return o;
    }

    private static Object removeFromTail(LinkedList l) {
        Object o = l.removeLinkFromTail();
        System.out.println(l + "  (Removed from tail: " + o + ")");
        return o;
    }

    private static Object removeFrom(LinkedList l, int pos) {
        Object o = l.removeLink(pos);
        System.out.println(l + "  (Removed from position " + pos + ": " + o + ")");
        return o;
    }

    public static void main(String args[]) {

        LinkedList l = new LinkedList(10);
        Link link = null;

        addToTail(l, 1);
        addToTail(l, 2);
        addToTail(l, 3);
        addToHead(l, 0);
        addToTail(l, 4);
        addToTail(l, 5);
        removeFromHead(l);
        removeFromTail(l);
        removeFromTail(l);
        addTo(l, -10, 3);
        removeFrom(l, 0);
    }
}
