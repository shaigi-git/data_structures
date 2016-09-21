package Queue;

/**
 * Created by shai on 9/20/16.
 */
public interface Queue {

    boolean push(Object obj);
    Object pop();
    Object top();
    boolean isEmpty();
    boolean isFull();
    int size();
}
