/**
 * 
 */
/**
 * @author welcome
 *
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs1_29;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DoubleLinkedList implements ILinkedList {

	class Node {
		private Object data;
		private Node next;
		private Node prev;
		
		public Node() {
			data = null;
			next = null;
			prev = null;
		}
		public Node(Node p, Object d, Node n) {
			data = d;
			next = n;
			prev = p;
		}
		public void setnext(Node n) {
			next = n;
		};
		public void setprev(Node n) {
			prev = n;
		};
		public void setdata(Object d) {
			data = d;
		};
		public Node getnext() {
			return next;
		};
		public Node getprev() {
			return prev;
		};
		public Object getdata() {
			return data;
	}
	}
	private Node head = null;
	private int size = 0;

	/**
	* Inserts a specified element at the specified position in the list.
	*/  //done
	@Override
	public void add(int index, Object element) {
		index--;
		Node prevnode = head;
		Node nodetoadd = new Node(null, element, null);
		for (int i = 0; i < size; i++) {
			if (i == index) {
				Node temp = prevnode.getnext();
				temp.setprev(nodetoadd);
				prevnode.setnext(nodetoadd);
				nodetoadd.setprev(prevnode);
				nodetoadd.setnext(temp);
				size++;
				break;
			}
			prevnode = prevnode.getnext();
		}
	}
	/** Inserts the specified element at the end of the list. */ //done

	@Override
	public void add(Object element) {
		Node nodetoadd = new Node(null, element, null);
		Node prevnode = head;
		int i = 0;
		while (i < size) {
			prevnode = prevnode.getnext();
		}
		prevnode.setnext(nodetoadd);
		nodetoadd.setprev(prevnode);
		size++;
	}
	/** Returns the element at the specified position in this list. */ //done
	@Override
	public Object get(int index) {
		if (index >= size) {
			return null;
		}
		Node nodeselected = head;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				break; // check the loop
			}
			nodeselected = nodeselected.getnext();
		}
		return nodeselected.getdata();
	}
	/**
	* Replaces the element at the specified position in this list with
	* the specified element.
	*/  //done
	@Override
	public void set(int index, Object element) {
		if (index <= size) {
			Node nodeselected = head;
			for (int i = 0; i < size; i++) {
				if (i == index) {
					nodeselected.setdata(element);
					break;
				}
				nodeselected = nodeselected.getnext();
			}
			}
		}

		/** Removes all of the elements from this list. */ //done

	@Override
	public void clear() {
		head = null;
	}

/** Returns true if this list contains no elements. */ //done

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
/** Removes the element at the specified position in this list. */ //done

	@Override
	public void remove(int index) {
		index--;
		Node prevnode = head;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				Node nodetoremove = prevnode.getnext();
				Node nextnode = nodetoremove.getnext();
				prevnode.setnext(nextnode);
				nextnode.setprev(prevnode);
				nodetoremove.setnext(null);
				nodetoremove.setprev(null);
				size--;
				break;
			}
			prevnode = prevnode.getnext();
		}
	}
	/** Returns the number of elements in this list. */ //done

	@Override
	public int size() {
		return size;
	}
	/**
	* Returns a view of the portion of this list between the specified
	* fromIndex and toIndex, inclusively.
	*/
	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	* Returns true if this list contains an element with the same value
	* as the specified element.
	*/ //done
	@Override
	public boolean contains(Object o) {
		Node nodeselected = head;
		for (int i = 0; i < size; i++) {
			if (nodeselected.getdata() == o) {
				return true;
			}
			nodeselected = nodeselected.getnext();
		}
		return false;
	}
}
