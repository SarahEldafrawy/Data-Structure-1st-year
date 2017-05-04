package eg.edu.alexu.csd.datastructure.queue;
/**
 *
 * @author welcome
 *
 */
public interface IQueue {
/**
*Inserts @param item at the queue front.
*/
public void enqueue(Object item);
/**
* @return the object Removed at the queue rear and returns it.
*/
public Object dequeue();
/**
* @return if this queue is empty.
*/
public boolean isEmpty();
/**.
* @return the number of elements in the queue
*/
public int size();

}
