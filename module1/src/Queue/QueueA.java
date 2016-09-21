package Queue;

import LinkedList.LinkedList;

/**
 * Created by shai on 9/20/16.
 */
public class QueueA implements Queue{

    /**
     * This queue implementation uses a linked-list.
     * Elements are inserted (enqueued) to the list tail and
     * removed (de-queued) from the list head.
     */
    private LinkedList l;

    public QueueA(int maxSize) {
        this.l = new LinkedList(maxSize);
    }

    public boolean push(Object info) {
        return l.addLinkToTail(info);
    }

    public Object pop() {
        return l.removeLinkFromHead();
    }

    public Object top() {
        return l.getHead();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return l.getLength();
    }

    @Override
    public String toString() {
        return "Queue start --> " + l + " (size " + size() + ")";
    }
}
