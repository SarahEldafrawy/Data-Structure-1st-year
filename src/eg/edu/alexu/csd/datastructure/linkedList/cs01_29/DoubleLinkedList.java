/**
 *
 */
/**
 * @author welcome
 *
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs01_29;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**
 */
public class DoubleLinkedList implements ILinkedList {

	/**
	 */
	class Node {
		/**
		 */
		private Object data;
		/**
		 */
		private Node next;
		/**
		 */
		private Node prev;

		/**
		*/
		public Node() {
			data = null;
			next = null;
			prev = null;
		}
		/**@param p for previous
		 * @param d for data
		 * @param n for next
		*/
		public Node(final Node p, final Object d, final Node n) {
			data = d;
			next = n;
			prev = p;
		}
		/**
		 * @param n for next
		*/
		public void setnext(final Node n) {
			next = n;
		};
		/**
		 * * @param n for next
		*/
		public void setprev(final Node n) {
			prev = n;
		};
		/**
		* @param d for data
		*/
		public void setdata(final Object d) {
			data = d;
		};
		/**
		 * @return next node
		*/
		public Node getnext() {
			return next;
		};
		/**
		 * @return previous node
		*/
		public Node getprev() {
			return prev;
		};
		/**
		 * @return data
		*/
		public Object getdata() {
			return data;
	}
	}
	/**
	 */
	private Node head, tail;
	/**
	 */
	private int size = 0;

	/**
	* Inserts a specified element at the specified position in the list.
	*/
	@Override
	public void add(final int index, final Object element) {
		if (index > size - 1 || index < 0) {
			throw null;
		} else {
			Node prevnode = head;
			Node nodetoadd = new Node(null, element, null);
			if (size == 0) {
				head = nodetoadd;
				size++;
			} else {
				for (int i = 0; i < size; i++) {
					if (i == index - 1) {
						Node temp = prevnode.getnext();
						prevnode.setnext(nodetoadd);
						nodetoadd.setprev(prevnode);
						nodetoadd.setnext(temp);
						size++;
						break;
					}
					prevnode = prevnode.getnext();
				}
			}
			if (nodetoadd.getnext() == null) {
				tail = nodetoadd;
			}
		}
	}
	/** Inserts the specified element at the end of the list. */

	@Override
	public void add(final Object element) {
		Node nodetoadd = new Node(null, element, null);
		Node prevnode = head;
		if (size == 0) {
			head = nodetoadd;
			tail = nodetoadd;
			size++;
		} else {
			prevnode = tail;
			tail = nodetoadd;
			prevnode.setnext(tail);
			tail.setprev(prevnode);
			size++;
		}
	}
/** Returns the element at the specified position in this list. */
	@Override
	public Object get(final int index) {
		if (index >= size || index < 0) {
			throw null;
		} else {
			Node nodeselected;
			if (index < (size / 2)) {
				nodeselected = head;
				for (int i = 0; i < size; i++) {
					if (i == index) {
						break;
					}
					nodeselected = nodeselected.getnext();
				}
			} else {
				nodeselected = tail;
				for (int i = size - 1; i >= (size / 2); i--) {
					if (i == index) {
						break;
					}
					nodeselected = nodeselected.getprev();
				}
			}
			return nodeselected.getdata();
		}
	}
	/**
	* Replaces the element at the specified position in this list with
	* the specified element.
	*/
	@Override
	public void set(final int index, final Object element) {
		if (index >= size || index < 0) {
			throw null;
		} else {
			if (head == null) {
				throw null;
			} else {
				if (index <= (size / 2)) {
					Node nodeselected = head;
					for (int i = 0; i < size; i++) {
						if (i == index) {
						nodeselected.setdata(element);
						break;
						}
					nodeselected = nodeselected.getnext();
					}
				} else {
					Node nodeselected = tail;
					for (int i = size - 1; i > 0; i--) {
						if (i == index) {
						nodeselected.setdata(element);
						break;
						}
					nodeselected = nodeselected.getprev();
					}
				}
			}
		}
	}

/** Removes all of the elements from this list. */

	@Override
	public void clear() {
		Node node = head;
		Node temp;
		while (size != 0) {
			temp = node.getnext();
			node.setnext(null);
			node = temp;
			size--;
		}
		head = null;
	}

/** Returns true if this list contains no elements. */

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
/** Removes the element at the specified position in this list. */

	@Override
	public void remove(final int index) {
		Node prevnode = head;
		if (index >= size || index < 0) {
			throw null;
		} else {
			if (index == 0) {
				Node nextnode = prevnode.getnext();
				prevnode.setnext(null);
				if (nextnode != null) {
					nextnode.setprev(null);
				}
				head = nextnode;
				size--;
			} else if (index == (size - 1)) {
				prevnode = tail.getprev();
				prevnode.setnext(null);
				tail.setprev(null);
				tail = prevnode;
				size--;
			} else {
				for (int i = 0; i < size; i++) {
					if (i == index) {
						Node nodetoremove = prevnode;
						prevnode = prevnode.getprev();
					Node nextnode = nodetoremove.getnext();
						prevnode.setnext(nextnode);
						if (nextnode != null) {
						nextnode.setprev(prevnode);
						}
						nodetoremove.setnext(null);
						nodetoremove.setprev(null);
						size--;
						break;
					}
					prevnode = prevnode.getnext();
				}
			}
		}
	}
	/** Returns the number of elements in this list. */

	@Override
	public int size() {
		return size;
	}
	/**
	* Returns a view of the portion of this list between the specified
	* fromIndex and toIndex, inclusively.
	*/
	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		DoubleLinkedList list = new DoubleLinkedList();
		Node pointNode = head;
		int count = 0;
		int i = 0;
		if (fromIndex < 0 || toIndex > size()) {
			throw null;
		}
		while (count < fromIndex) {
			count++;
			pointNode = pointNode.next;
		}
		while (count <= toIndex) {
			list.add(i, pointNode.getdata());
			count++;
			i++;
			pointNode = pointNode.next;
		}
		return list;
	}
	/**
	* Returns true if this list contains an element with the same value
	* as the specified element.
	*/
	@Override
	public boolean contains(final Object o) {
		Node nodeselected = head;
		for (int i = 0; i < size; i++) {
			if (nodeselected.getdata().equals(o)) {
				return true;
			}
			nodeselected = nodeselected.getnext();
		}
		return false;
	}
}
