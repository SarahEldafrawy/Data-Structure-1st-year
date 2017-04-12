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

	private Node head = null;

	/**
	* @param index where to insert.
	* @param element to insert.
	*/
	@Override
	public void add(int index, Object element) {
		int length = size();
		if (index > length) {
			return;
		}

		Node newNode = new Node(element);
		Node pointNode = head;

		if (index == 0) {
			newNode.next = head;
			head = newNode;
		}
		else {
			for (int i = 0; i < index - 1; i++) {
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
	public void remove(int index) {

		int length = size();

		if (index >= length || index < 0) {
			return;
		}

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
	public void add(Object element) {
		Node pointNode = head;
		Node newNode = new Node(element);

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
	public Object get(int index) {
		int length = size();
		if (index > (length - 1)) {
			return null;
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
	public void set(int index, Object element) {
		int length = size();
		if (index > (length - 1)) {
			return;
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
	* @return counter of size.
	*/
	@Override
	public int size() {
		Node pointNode = head;
		int counter = 0;
		while (pointNode != null) {
			counter++;
			pointNode = pointNode.next;
		}
		return counter;
	}
	/**
	* @param o element.
	* @return true if found or false else.
	*/
	@Override
	public boolean contains(Object o) {
		Node pointNode = head;
		boolean found = false;

		while (pointNode != null && !found) {
			if (pointNode.value == o) {
				found = true;
			}
			pointNode = pointNode.next;
		}
		return found;
	}
	/**
	* @param formIndex of list.
	* @param toIndex of list.
	* @return sublist of specified size.
	*/
	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		SingleLinkedList list = new SingleLinkedList();
		Node pointNode = head;
		int count = 0;
		int i = 0;
		if (fromIndex < 0 || toIndex > size()) {
			return null;
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
