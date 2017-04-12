/**
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs01_29;

/**
 * @author welcome
 */
public class Main {

	public static void main(final String[] args) {

		DoubleLinkedList list = new DoubleLinkedList();
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
		System.out.println(list.size());
		System.out.println(list.get(0));
	}
}
