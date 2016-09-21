package Queue;

/**
 * Created by shai on 9/20/16.
 */
public class QueueB implements Queue {

    private static final int INVALID = -1;

    private final int maxSize;
    private Object arr[];
    private int first;
    private int nextEmpty;

    public QueueB(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new Object[maxSize];
        this.first = INVALID;
        this.nextEmpty = 0;
    }

    private int next(int current) {
        return current < (this.maxSize - 1) ? (current + 1) : 0;
    }

    @Override
    public boolean push(Object obj) {
        if (isFull()) {
            // means queue is full
            return false;
        } else {
            if (isEmpty()) {
                this.first = this.nextEmpty;
            }
            this.arr[this.nextEmpty] = obj;
            this.nextEmpty = next(this.nextEmpty);
            return true;
        }
    }

    private Object getFirst() {
        if (isEmpty()) {
            return null;
        }
        return this.arr[this.first];
    }

    @Override
    public Object pop() {
        Object obj = getFirst();
        if (obj != null) {
            this.first = next(this.first);
            if (this.first == this.nextEmpty) {
                // means that this is the last element in the queue
                this.first = INVALID;
            }
        }
        return obj;
    }

    @Override
    public Object top() {
        return getFirst();
    }

    @Override
    public boolean isEmpty() {
        return this.first == INVALID;
    }

    @Override
    public boolean isFull() {
        return this.nextEmpty == this.first;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        if (isFull()) return this.maxSize;
        return (this.first < this.nextEmpty) ? this.nextEmpty - this.first : this.maxSize - (this.first - this.nextEmpty);
    }

    @Override
    public String toString() {
        String ans = "Queue start --> ";
        if (!isEmpty()) {
            int i = this.first;
            int elemCount = 0;
            while (elemCount < size()) {
                ans += arr[i].toString() + ", ";
                i = next(i);
                elemCount++;
            }
        }
        if (!isEmpty()) {
            ans = ans.substring(0, ans.length() - 2);
        }
        ans += " (size " + size() + ")";
        return ans;
    }

}
