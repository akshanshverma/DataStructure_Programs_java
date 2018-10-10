package helper;

public class OrderedLinkedList<G> {
	Node head = null;
	int count = 0;

	public void add(G data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			count++;
			return;
		}
		Node temp = head;
		
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
		ol.add("akku");
		ol.show();
	}
}
