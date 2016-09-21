package LinkedList;

/**
 * Created by shai on 9/18/16.
 */
public class Link {

    private Object info;
    private Link next;

    public Link(Object info) {
        this.info = info;
    }

    public Link(Object info, Link nextLink) {
        this.info = info;
        this.next = nextLink;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public String toString() {
        return info.toString();
    }
}
