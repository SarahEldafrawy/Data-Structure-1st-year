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
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		final int sixnum = 6;
		list.add(fnum);
		list.add(snum);
		list.add(tnum);
		list.add(fonum);
		list.add(finum);
		list.add(sixnum);
		for (int i = zeroNum; i < sixnum; i++) {
			final int number = (int) list.get(i);
			Assert.assertEquals(i + fnum, number);
		}
	}

	/**
	 * Insert Node at the middle of List.
	 */
	@Test
	public void insertInMiddle() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		final int sixnum = 6;
		list.add(zeroNum, fnum);
		list.add(fnum, tnum);
		list.add(snum, fonum);
		list.add(tnum, finum);
		list.add(fonum, sixnum);
		list.add(fnum, snum);

		for (int i = zeroNum; i < sixnum; i++) {
			final int number = (int) list.get(i);
			Assert.assertEquals(i + fnum, number);
		}
	}

	/**
	 * Insert a node at the end of the list.
	 */
	@Test
	public void insertAtEnd() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		final int sixnum = 6;
		final int sevnum = 7;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);
		list.add(sixnum);
		list.add(sevnum);

		for (int i = zeroNum; i < sevnum; i++) {
			final int number = (int) list.get(i);
			Assert.assertEquals(i + fnum, number);
		}
	}

	/**
	 * change a value of a node.
	 */
	@Test(expected = Exception.class)
	public void changeNodeValue() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		final int sevnum = 7;
		list.add(zeroNum, fnum);
		list.add(fnum, tnum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, fonum);

		list.set(fnum, snum);
		final int num = (int) list.get(fnum);
		Assert.assertEquals(snum, num);

		list.set(sevnum, finum);
		for (int i = zeroNum; i < finum; i++) {
			final int number = (int) list.get(i);
			Assert.assertEquals(i + fnum, number);
		}
	}

	/**
	 * removing an element and check to see if size decreased.
	 */
	@Test
	public void removeAndCheckSize() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;

		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);
		list.remove(fnum);
		list.remove(tnum);
		final int size = list.size();
		Assert.assertEquals(tnum, size);
	}

	/**
	 * Remove all elements one by one.
	 */
	@Test
	public void removeAllElements() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int sevnum = 7;
		list.add(fnum);
		list.add(snum);
		list.add(tnum);
		list.add(fonum);
		list.add(sevnum);

		list.remove(fonum);
		list.remove(tnum);
		list.remove(snum);
		list.remove(fnum);
		list.remove(zeroNum);
		final int size = list.size();
		Assert.assertEquals(zeroNum, size);
	}

	/**
	 * Remove first Node.
	 */
	@Test
	public void removeFirst() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		list.remove(zeroNum);
		final int size = list.size();
		Assert.assertEquals(fonum, size);

		final int numb = (int) list.get(zeroNum);
		Assert.assertEquals(snum, numb);
	}

	/**
	 * Remove last Node.
	 */
	@Test
	public void removeLast() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		list.remove(fonum);

		Assert.assertEquals(fonum, list.size());
		Assert.assertEquals(fonum, list.get(tnum));
	}

	/**
	 * Remove a non-existing Node.
	 */
	@Test(expected = Exception.class)
	public void removeNENode() { // NE = Non-Existing
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		final int negNum = -1;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		list.remove(negNum);

		Assert.assertEquals(finum, list.size());
	}

	/**
	 * removing a node that is not included in list boundaries.
	 */
	@Test
	public void removeNodeOFB() { // OFB = Out of Boundaries
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		list.remove(fnum);

		Assert.assertEquals(fonum, list.size());
	}

	/**
	 * test contain function.
	 */
	@Test
	public void containFun() { // OFB = Out of Boundaries
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		final int tewNum = 20;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		Assert.assertTrue(list.contains(fnum));
		Assert.assertTrue(!list.contains(tewNum));
	}

	/**
	 * Choosing sublist out of the boundaries of original list.
	 */
	@Test(expected = Exception.class)
	public void getNode() { // OFB = Out of Boundaries
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		final int sevnum = 7;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		Assert.assertEquals(fonum, list.get(tnum));
		Assert.assertNull(list.get(sevnum));
	}

	/**
	 * check that getting an element doesn't remove nodes.
	 */
	@Test
	public void getNodeCheckSize() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		Assert.assertEquals(fonum, list.get(tnum));
		Assert.assertEquals(finum, list.size());
	}

	/**
	 * Clear the elements of the list Assure that the list is Empty.
	 */
	@Test(expected = Exception.class)
	public void clearList() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);
		list.clear();

		Assert.assertEquals(zeroNum, list.size());
		Assert.assertTrue(list.isEmpty());
		Assert.assertNull(list.get(snum));
	}

	/**
	 * Choosing sublist within the list boundaries.
	 */
	@Test
	public void chooseSubList() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		ILinkedList newList = new DoubleLinkedList();
		newList = list.sublist(fnum, tnum);
		for (int i = fnum; i < fonum; i++) {
	Assert.assertEquals(i + fnum, newList.get(i - fnum));
		}

	}

	/**
	 * Choosing sublist equals that of the original list.
	 */
	@Test
	public void subListAsOriginal() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		ILinkedList newList = new DoubleLinkedList();
		newList = list.sublist(zeroNum, fonum);
		for (int i = zeroNum; i < finum; i++) {
			Assert.assertEquals(list.get(i), newList.get(i));
		}

	}

	/**
	 * Choosing sublist out of the boundaries of original list.
	 */
	@Test(expected = Exception.class)
	public void subListOFB() {
		ILinkedList list = new DoubleLinkedList();
		final int zeroNum = 0;
		final int fnum = 1;
		final int snum = 2;
		final int tnum = 3;
		final int fonum = 4;
		final int finum = 5;
		final int negNum = -1;
		list.add(zeroNum, fnum);
		list.add(fnum, snum);
		list.add(snum, tnum);
		list.add(tnum, fonum);
		list.add(fonum, finum);

		ILinkedList newList = new DoubleLinkedList();
		newList = list.sublist(negNum, tnum);
		Assert.assertNull(newList);

	}

}
