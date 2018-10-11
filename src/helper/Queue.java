package helper;

public class Queue<G> {
	Node tail = null;
	Node head = null;
	int count;

	public void enqueue(G data) {
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

	public G dequeue() {
		Node temp = head;
		Node data = head;
		if (count == 1) {
			temp.next = null;
			head = null;
			tail = null;
			count--;
			return (G) data.data;
		}

		temp = temp.next;
		head = temp;
		count--;
		return (G) data.data;
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

	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return count;
	}
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
	}
}
