package helper;

public class OrderedLinkedList<G> implements Comparable<G> {
	Node head = null;
	int count = 0;
	Node tempMain = null;

	@Override
	public int compareTo(G o) {
		return ((Comparable<G>) tempMain.data).compareTo(o);
	}

	public void add(G data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			count++;
			return;
		}
		tempMain = head;
		System.out.println(compareTo(data));
		/*if (count == 1) {
			if (compareTo(data) == (-1) || compareTo(data) == (0)) {
				tempMain.next = n;
			} else if (compareTo(data) == 1) {
				n.next = tempMain;
				head = n;
			}
			count++;
			return;
		}*/

	}

	public int indexOf(G data) {
		Node temp = head;
		for (int i = 0; i < count; i++) {
			if (temp.data == data) {
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}

	public void show() {
		Node temp = head;
		for (int i = 0; i < count; i++) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		OrderedLinkedList<String> ol = new OrderedLinkedList<String>();
		ol.add("bb");
		ol.add("dd");
		ol.show();
	}
}
