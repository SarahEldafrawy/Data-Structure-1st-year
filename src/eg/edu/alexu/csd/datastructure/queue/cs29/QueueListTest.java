package eg.edu.alexu.csd.datastructure.queue.cs29;

import org.junit.Assert;
import org.junit.Test;
/**
 * test for Queue LinkedList based.
 */
public class QueueListTest {

	/**
	 *final constants for magic numbers.
	 */
	private final int q3 = 3, q4 = 4, q5 = 5, q6 = 6, q7 = 7;
	/**
	 *test to check size.
	 */
	@Test
	public void checksize() {
		QueueList list = new QueueList();
		list.enqueue(q5);
		list.enqueue(q7);
		list.dequeue();
		list.enqueue(q3);
		list.enqueue(q6);
		Assert.assertEquals(q3, list.size());
		list.dequeue();
		list.dequeue();
		Assert.assertEquals(1, list.size());
		Assert.assertEquals(q6, list.dequeue());
		Assert.assertEquals(0, list.size());
	};
	/**
	 *test to check different operation on the queue.
	 */
	@Test
	public void addlist() {
		QueueList list = new QueueList();
		list.enqueue(q5);
		list.enqueue(q7);
		list.enqueue(q3);
		list.enqueue(q6);
		Assert.assertEquals(q4, list.size());
		Assert.assertEquals(q5, list.dequeue());
		Assert.assertEquals(q7, list.dequeue());
		Assert.assertEquals(q3, list.dequeue());
		Assert.assertEquals(q6, list.dequeue());
		Assert.assertEquals(0, list.size());
	};
	/**
	 *test to check the list is empty.
	 */
	@Test
	public void checkEmpty() {
		QueueList list = new QueueList();
		list.enqueue(q5);
		list.enqueue(q7);
		list.enqueue(q3);
		list.enqueue(q6);
		list.dequeue();
		list.dequeue();
		list.dequeue();
		list.dequeue();
		Assert.assertEquals(true, list.isEmpty());
	};
	/**
	 *test to check the list isn't empty.
	 */
	@Test
	public void checkNotEmpty() {
		QueueList list = new QueueList();
		list.enqueue(q5);
		list.enqueue(q7);
		list.enqueue(q3);
		list.enqueue(q6);
		list.dequeue();
		list.dequeue();
		list.dequeue();
		Assert.assertNotEquals(true, list.isEmpty());
	};
	/**
	 *test different operation of list.
	 */
	@Test
	public void addRemove() {
		QueueList list = new QueueList();
		list.enqueue(q5);
		list.dequeue();
		list.enqueue(q7);
		list.dequeue();
		list.enqueue(q3);
		list.dequeue();
		list.enqueue(q6);
		list.dequeue();
		Assert.assertEquals(true, list.isEmpty());
	};
}
