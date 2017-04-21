/**
 * 
 */
/**
 * @author welcome
 *
 */
package eg.edu.alexu.csd.datastructure.stack.cs29;

import eg.edu.alexu.csd.datastructure.stack.IStack;
/**
 *
 * @author welcome
 *
 */
public class Stack implements IStack {

	/**
	 */
	class Plate {
		private Plate prev = null;
		private Object data;
	}
	/**
	 */
	private int size = 0;
	/**
	 */
	private Plate top = null;

	/**
	* Inserts a specified element at the specified position in the list.
	* @param index zero-based index
	* @param element object to insert
	*/
	@Override
	public void add(final int index, final Object element) {
		Plate plateToAdd = new Plate();
		if (index >= size) {
			throw null;
		}
		if (top == null || index == (size)) {
			plateToAdd.data = element;
			plateToAdd.prev = top;
			top = plateToAdd;
			size++;
		} else {
			plateToAdd.data = element;
			addBtwStack(index, plateToAdd);
		}
	}
	/**
	* Removes the element at the top of stack and returns that element.
	* @return top of stack element, or through exception if empty
	*/
	@Override
	public Object pop() {
		if (top == null) {
			throw new RuntimeException();
		}
		Object value = top.data;
		Plate temp = top.prev;
		if (top.prev != null) {
			top.prev = null;
		}
		top = temp;
		size--;
		return value;
	}
	/**
	* Get the element at the top of stack without removing it from stack.
	* @return top of stack element, or through exception if empty
	*/
	@Override
	public Object peek() {
		if (top == null) {
			throw new RuntimeException();
		}
		return top.data;
	}
	/**
	* Pushes an item onto the top of this stack.
	* @param element to insert
	*/
	@Override
	public void push(final Object element) {
		Plate plateToAdd = new Plate();
		if (top == null) {
			plateToAdd.data = element;
			top = plateToAdd;
		} else {
			plateToAdd.data = element;
			plateToAdd.prev = top;
			top = plateToAdd;
		}
		size++;
	}
	/**.
	* Tests if this stack is empty
	* @return true if stack empty
	*/
	@Override
	public boolean isEmpty() {
		if (top == null) {
			return true;
		}
		return false;
	}
	/**
	* Returns the number of elements in the stack.
	* @return number of elements in the stack
	*/
	@Override
	public int size() {
		return size;
	}
	public void addBtwStack (int index, Plate plateToAdd) {
		Plate temp3 = new Plate();
		Plate tempTop = top;
		for (int i = size - 1; i != index; i--) {
			tempTop = tempTop.prev;
		}
		temp3 = tempTop.prev;
		plateToAdd.prev = temp3;
		tempTop.prev = plateToAdd;
		size++;
	}
}
