/**
 *
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs01_29;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author Personal
 *
 */
public class SingleLinkedList implements ILinkedList {
	/**
	 * head node that points to list.
	 */
	private Node head = null;
	/**
	 * list size counter.
	 */
	private int length = 0;
	/**
	* @param index where to insert.
	* @param element to insert.
	*/
	@Override
	public void add(final int index, final Object element) {

		if (index > length || index < 0) {
			throw null;
		}

		Node newNode = new Node(element);
		Node pointNode = head;
		length++;
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			for (int i = 0; i < (index - 1); i++) {
				pointNode = pointNode.next;
			}
			newNode.next = pointNode.next;
			pointNode.next = newNode;
		}
	}

	/**
	* @param index where to insert.
	*/
	@Override
	public void remove(final int index) {

		if (index >= length || index < 0) {
			throw null;
		}
		length--;
		Node pointNode = head;
		if (index == 0) {
			head = head.next;
			return;
		}
		for (int i = 0; i < index - 1; i++) {
			pointNode = pointNode.next;
		}
		Node toBeRemoved = pointNode.next;
		pointNode.next = toBeRemoved.next;
		toBeRemoved = null;
	}
	/**
	* @param element to be added.
	*/
	@Override
	public void add(final Object element) {
		Node pointNode = head;
		Node newNode = new Node(element);
		length++;
		if (pointNode == null) {
			head = newNode;
			return;
		}

		while (pointNode.next != null) {
			pointNode = pointNode.next;
		}

		pointNode.next = newNode;
		newNode.next = null;
	}
	/**
	* @param index to get E.
	*/
	@Override
	public Object get(final int index) {
		if (index > (length - 1) || index < 0) {
			throw null;
		}
		Node pointNode = head;
		for (int i = 0; i < index; i++) {
			pointNode = pointNode.next;
		}
		return pointNode.value;
	}
	/**
	* @param index of list.
	* @param element to change.
	*/
	@Override
	public void set(final int index, final Object element) {
		if (index > (length - 1)) {
			throw null;
		}
		Node pointNode = head;
		for (int i = 0; i < index; i++) {
			pointNode = pointNode.next;
		}
		pointNode.value = element;

	}
	/**
	* clear list.
	*/
	@Override
	public void clear() {
		head = null;
		length = 0;
	}
	/**
	* check if empty.
	* @return true if yes or false.
	*/
	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
	/**
	* @return length of list.
	*/
	@Override
	public int size() {
		return length;
	}
	/**
	* @param o element.
	* @return true if found or false else.
	*/
	@Override
	public boolean contains(final Object o) {
		Node pointNode = head;
		boolean found = false;

		while (pointNode != null && !found) {
			if (pointNode.value.equals(o)) {
				found = true;
			}
			pointNode = pointNode.next;
		}
		return found;
	}
	/**
	* formIndex of list.
	* @param toIndex of list.
	* @return sublist of specified size.
	*/
	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		SingleLinkedList list = new SingleLinkedList();
		Node pointNode = head;
		int count = 0;
		int i = 0;
		if (fromIndex < 0 || toIndex > length) {
			throw null;
		}
		while (count < fromIndex) {
			count++;
			pointNode = pointNode.next;
		}
		while (count <= toIndex) {
			list.add(i, pointNode.value);
			count++;
			i++;
			pointNode = pointNode.next;
		}
		return list;
	}
}
