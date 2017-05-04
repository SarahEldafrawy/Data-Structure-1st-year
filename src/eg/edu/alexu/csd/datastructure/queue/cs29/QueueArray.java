/**
 *
 */
/**
 * @author welcome
 *
 */
package eg.edu.alexu.csd.datastructure.queue.cs29;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 *
 * @author welcome
 *
 */
public class QueueArray implements IArrayBased, IQueue {
	/**
	 */
	private Object[] list;
	/**
	 */
	private int count, r, f, arrSize;

	/**
	 *@param n constructor for queue.
	 */
	public QueueArray(final int n) {
		this.list = new Object[n];
		this.arrSize = n;
		this.count = 0;
		this.r = 0;
		this.f = r + 1;
	}
	/**
	*Inserts @param item at the queue front.
	*/
	@Override
	public void enqueue(final Object item) {
		if (count == (arrSize - 1)) {
			throw new RuntimeException();
		}
		list[r] = item;
		r = (r + 1) % arrSize;
		count++;
	}
	/**
	* @return the object Removed at the queue rear and returns it.
	*/
	@Override
	public Object dequeue() {
		if (count == 0) {
			throw new RuntimeException();
		}
		Object item = list[f];
		list[f] = null;
		count--;
		f = (f + 1) % arrSize;
		return item;
	}
	/**
	* @return if this queue is empty.
	*/
	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}
	/**.
	* @return the number of elements in the queue
	*/
	@Override
	public int size() {
		return this.count;
	}

}
