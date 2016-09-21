package Stack;

import LinkedList.LinkedList;

/**
 * Created by shai on 9/20/16.
 */
public class StackA implements Stack {

    private LinkedList l;

    public StackA(int maxSize) {
        this.l = new LinkedList(maxSize);
    }

    @Override
    public boolean push(Object obj) {
        return this.l.addLinkToHead(obj);
    }

    @Override
    public Object pop() {
        return this.l.removeLinkFromHead();
    }

    @Override
    public Object top() {
        return this.l.getHead();
    }

    @Override
    public boolean isEmpty() {
        return this.l.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.l.isFull();
    }

    @Override
    public int size() {
        return this.l.getLength();
    }

    @Override
    public String toString() {
        return "Stack head {" + l + '}';
    }
}
