package LinkedList;

/**
 * Created by shai on 9/18/16.
 */
public class LinkedList {

    private int maxSize;
    private Link head;
    private int length;

    public int getLength() {
        return length;
    }

    private enum LOCATION {
        HEAD,
        MIDDLE,
        TAIL
    }

    public LinkedList(int maxSize) {
        this.maxSize = maxSize;
        this.head = null;
        this.length = 0;
    }

    public LinkedList(Object obj, int maxSize) {
        this.maxSize = maxSize;
        this.head = new Link(obj);
        this.length = 1;
    }

    private boolean addLink(Link link, LOCATION loc, int pos) {

        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            this.head = link;
        } else {

            Link l = null;
            switch (loc) {
                case HEAD:
                    link.setNext(this.head);
                    this.head = link;
                    break;

                case MIDDLE:

                    l = getLink(pos - 1);
                    // now l points to the last element on the list
                    link.setNext(l.getNext());
                    l.setNext(link);
                    break;

                case TAIL:
                    l = getTail();
                    // now l points to the last element on the list
                    l.setNext(link);
                    break;
            }
        }
        this.length++;
        return true;
    }

    /**
     * Gets the link in this position
     * @param pos position of link in the list (first link is 0)
     * @return a link, or null
     */
    public Link getLink(int pos) {

        if (pos > this.length - 1 || pos < 0) return null;

        Link l = this.head;
        int posCurr = getHeadPosition();

        while (l != null && posCurr < pos) {
            l = l.getNext();
            posCurr++;
        }

        // now l points to the last element on the list
        return l;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean isFull() {
        return this.length == this.maxSize;
    }

    public boolean addLinkToHead(Object obj) {
        Link link = new Link(obj);
        return addLink(link, LOCATION.HEAD, -1);
    }

    public boolean addLink(Object obj, int position) {
        Link link = new Link(obj);
        if (position == getHeadPosition()) {
            return addLinkToHead(link);
        } else if (position == getTailPosition() + 1) {
            return addLinkToTail(link);
        }
        return addLink(link, LOCATION.MIDDLE, position);
    }

    public boolean addLinkToTail(Object obj) {
        Link link = new Link(obj);
        return addLink(link, LOCATION.TAIL, -1);
    }

    public Object removeLinkFromHead() {
        Link link = removeLink(LOCATION.HEAD, -1);
        return link != null ? link.getInfo() : null;
    }

    private Link removeLink(LOCATION loc, int pos) {

        Link l = null;

        if (isEmpty()) {
            return null;
        } else if (this.length == 1) {
            l = this.head;
            this.head = null;
        } else {

            switch (loc) {
                case HEAD:
                    l = this.head;
                    this.head = this.head.getNext();
                    break;

                case MIDDLE:
                    l = getLink(pos - 1);
                    if (l.getNext() != null) {
                        l.setNext(l.getNext().getNext());
                    } else {
                        // link doesn't exist
                        return null;
                    }
                    break;

                case TAIL:
                    l = this.head;
                    while (l.getNext().getNext() != null) {
                        l = l.getNext();
                    }
                    Link tmp = l;
                    l = l.getNext();
                    tmp.setNext(null);
                    break;
            }
        }
        this.length--;
        return l;
    }

    public Object removeLink(int pos) {
        if (pos == getHeadPosition()) {
            return removeLinkFromHead();
        } else if (pos == getTailPosition() + 1) {
            return removeLinkFromTail();
        }
        return removeLink(LOCATION.MIDDLE, pos).getInfo();
    }

    public Object removeLinkFromTail() {
        return removeLink(LOCATION.TAIL, -1).getInfo();
    }

    public Link getHead() {
        return getLink(getHeadPosition());
    }

    public Link getTail() {
        return getLink(getTailPosition());
    }

    private int getHeadPosition() {
        if (isEmpty()) {
            return -1;
        } else {
            return 0;
        }
    }

    private int getTailPosition() {
        if (isEmpty()) {
            return -1;
        } else {
            return this.length - 1;
        }
    }

    @Override
    public String toString() {
        String res = "";
        Link l = this.head;
        while (l != null) {
            res += l.getInfo();
            l = l.getNext();
            res += l != null ? ", " : "";
        }
        return res;
    }
}
