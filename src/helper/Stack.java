/****************************************************
 * 
 * 
 * @ver
 ****************************************************/
package helper;


public class Stack<G> {

	Node tail = null;
	Node head = null;
	int count;

	public void push(G data) {
		Node n = new Node(data);

		if (tail == null) {
			tail = n;
			head = tail;
			count++;
			return;
		}
		tail.next = n;
		tail = tail.next;
		count++;
		return;
	}

	public G pop() {

		Node temp = head;
		Node data = tail;
		if (count == 1) {
			temp.next = null;
			head = null;
			tail = null;
			count--;
			return (G) data.data;
		}
		for (int i = 1; i < count - 1; i++) {
			temp = temp.next;
		}
		temp.next = null;
		tail = temp;
		count--;
		return (G) data.data;
	}

	public G peek() {
		return (G) tail.data;
	}

	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return count;
	}

	public void show() {
		if (tail != null) {
			Node temp = head;
			for (int i = 0; i < count; i++) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		} else {
			System.out.println("no data");
		}
	}
}
