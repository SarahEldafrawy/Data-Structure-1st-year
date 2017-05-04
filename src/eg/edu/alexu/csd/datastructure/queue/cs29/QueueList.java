/**
 *
 */
/**
 * @author welcome
 *
 */
package eg.edu.alexu.csd.datastructure.queue.cs29;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.linkedList.cs01_29.DoubleLinkedList;;

/**
 *
 * @author welcome
 *
 */
public class QueueList implements ILinkedBased, IQueue {
	/**
	 */
	private DoubleLinkedList list;
	/**
	 *constructor for queue.
	 */
	public QueueList() {
		this.list = new DoubleLinkedList();
	}
	/**
	*Inserts @param item at the queue front.
	*/
	@Override
	public void enqueue(final Object item) {
		this.list.add(item);
	}
	/**
	* @return the object Removed at the queue rear and returns it.
	*/
	@Override
	public Object dequeue() {
		Object item = this.list.get(0);
		this.list.remove(0);
		return item;
	}
	/**
	* @return if this queue is empty.
	*/
	@Override
	public boolean isEmpty() {
		if (this.list.isEmpty()) {
			return true;
		}
		return false;
	}
	/**.
	* @return the number of elements in the queue
	*/
	@Override
	public int size() {
		return this.list.size();
	}

}
