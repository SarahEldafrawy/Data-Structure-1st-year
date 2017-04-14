/**
 * 
 */
/**
 * @author welcome
 *
 */
package eg.edu.alexu.csd.datastructure.linkedList;
/**
 *
 * @author welcome
 *
 */
public interface ILinkedList {
/**.
* Inserts a specified @param element at the specified
* @param index in the list.
*/
public void add(int index, Object element);
/** Inserts the specified @param element at the end of the list. */
public void add(Object element);
/** @return the element at the specified
 * @param index in this list.
 */
public Object get(int index);
/**
* Replaces the element at the specified @param index in this list with
* the specified
* @param element for element.
*/
public void set(int index, Object element);
/** Removes all of the elements from this list. */
public void clear();
/** @return true if this list contains no elements. */
public boolean isEmpty();
/** Removes the element at the specified @param index in this list. */
public void remove(int index);
/** @return the number of elements in this list. */
public int size();
/**
* @return a view of the portion of this list between the specified
* @param fromIndex and
* @param toIndex for last index, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @return true if this list contains an element with the same value
* as the specified element
* @param o for element.
*/
public boolean contains(Object o);
}
