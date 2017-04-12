/**
 *
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs01_29;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author Personal
 *
 */
public class LinkedListTest {

	/**
	 * Add nodes and check list.
	 */
	@Test
	public void addNodes() {
		ILinkedList list = new DoubleLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		for (int i = 0; i < 6; i++) {
			Assert.assertEquals(i + 1, list.get(i));
		}
	}

	/**
	 * Insert Node at the middle of List.
	 */
	@Test
	public void insertInMiddle() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 3);
		list.add(2, 4);
		list.add(3, 5);
		list.add(4, 6);
		list.add(1, 2);

		for (int i = 0; i < 6; i++) {
			Assert.assertEquals(i + 1, list.get(i));
		}
	}

	/**
	 * Insert a node at the end of the list.
	 */
	@Test
	public void insertAtEnd() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);
		list.add(6);
		list.add(7);

		for (int i = 0; i < 7; i++) {
			Assert.assertEquals(i + 1, list.get(i));
		}
	}

	/**
	 * change a value of a node.
	 */
	@Test
	public void changeNodeValue() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 3);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		list.set(1, 2);
		Assert.assertEquals(2, list.get(1));

		list.set(7, 2);
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals(i + 1, list.get(i));
		}
	}

	/**
	 * removing an element and check to see if size decreased.
	 */
	@Test
	public void removeAndCheckSize() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);
		list.remove(1);
		list.remove(3);

		Assert.assertEquals(3, list.size());
	}

	/**
	 * Remove all elements one by one.
	 */
	@Test
	public void removeAllElements() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		list.remove(4);
		list.remove(3);
		list.remove(2);
		list.remove(1);
		list.remove(0);

		Assert.assertEquals(0, list.size());
	}

	/**
	 * Remove first Node.
	 */
	@Test
	public void removeFirst() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		list.remove(0);

		Assert.assertEquals(4, list.size());
		Assert.assertEquals(2, list.get(0));
	}

	/**
	 * Remove last Node.
	 */
	@Test
	public void removeLast() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		list.remove(4);

		Assert.assertEquals(4, list.size());
		Assert.assertEquals(4, list.get(3));
	}

	/**
	 * Remove a non-existing Node.
	 */
	@Test
	public void removeNENode() { // NE = Non-Existing
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		list.remove(-1);

		Assert.assertEquals(5, list.size());
	}

	/**
	 * removing a node that is not included in list boundaries.
	 */
	@Test
	public void removeNodeOFB() { // OFB = Out of Boundaries
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		list.remove(6);

		Assert.assertEquals(5, list.size());
	}

	/**
	 * test contain function.
	 */
	@Test
	public void containFun() { // OFB = Out of Boundaries
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		Assert.assertTrue(list.contains(5));
		Assert.assertTrue(!list.contains(20));
	}

	/**
	 * Choosing sublist out of the boundaries of original list.
	 */
	@Test
	public void getNode() { // OFB = Out of Boundaries
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		Assert.assertEquals(4, list.get(3));
		Assert.assertNull(list.get(7));
	}

	/**
	 * check that getting an element doesn't remove nodes.
	 */
	@Test
	public void getNodeCheckSize() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		Assert.assertEquals(4, list.get(3));
		Assert.assertEquals(5, list.size());
	}

	/**
	 * Clear the elements of the list Assure that the list is Empty.
	 */
	@Test
	public void clearList() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);
		list.clear();

		Assert.assertEquals(0, list.size());
		Assert.assertTrue(list.isEmpty());
		Assert.assertNull(list.get(2));
	}

	/**
	 * Choosing sublist within the list boundaries.
	 */
	@Test
	public void chooseSubList() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		ILinkedList newList = new DoubleLinkedList();
		newList = list.sublist(1, 3);
		for (int i = 1; i < 4; i++) {
			Assert.assertEquals(i + 1, newList.get(i - 1));
		}

	}

	/**
	 * Choosing sublist equals that of the original list.
	 */
	@Test
	public void subListAsOriginal() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		ILinkedList newList = new DoubleLinkedList();
		newList = list.sublist(0, 4);
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals(list.get(i), newList.get(i));
		}

	}

	/**
	 * Choosing sublist out of the boundaries of original list.
	 */
	@Test
	public void subListOFB() {
		ILinkedList list = new DoubleLinkedList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		list.add(4, 5);

		ILinkedList newList = new DoubleLinkedList();
		newList = list.sublist(-1, 3);
		Assert.assertNull(newList);

	}

}
