package helper;

public class UnOrderedList<G> {
	Node head = null;
	Node tail = null;
	int count = 0;

	public void add(G data) {
		Node n = new Node(data);

		if (head == null) {
			head = n;
			tail = head;
			count++;
			return;
		}
		n.next = head;
		head = n;
		count++;
		return;
	}

	public void append(G data) {
		Node n = new Node(data);

		if (head == null) {
			head = n;
			tail = head;
			count++;
			return;
		}
		tail.next = n;
		tail = tail.next;
		count++;
		return;
	}

	public void remove(G data) {
		if (head == null) {
			System.out.println("no data");
			return;
		}
		if (head.data.equals(data)) {
			head = head.next;
			count--;
			return;
		}
		Node temp = head;
		int i;

		for (i = 1; i <= count; i++) {
			if (temp.data.equals(data)) {
				if (i == count) {
					break;
				}
				temp = temp.next;
				break;
			}
			temp = temp.next;
		}

		Node temp2 = head;
		for (int j = 1; j < i - 1; j++) {
			temp2 = temp2.next;
		}

		if (i == count) {
			temp2.next = null;
			tail = temp2;
			count--;
			return;
		}

		temp2.next = temp;
		count--;
		return;
	}

	public boolean search(G data) {
		Node temp = head;
		for (int i = 0; i < count; i++) {
			if (temp.data.equals((Object) data)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
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

	public void list() {
		if (head != null ) {
			Node temp = head;
			for (int i = 0; i < count; i++) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}else {
			System.out.println("no data");
		}
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

	public void insert(int p, G data) {
		if (p >= 0 && p < count) {
			Node n = new Node(data);
			if (p == 0) {
				n.next = head;
				head = n;
				count++;
				return;
			} else if (p == count) {
				n.next = null;
				tail.next = n;
				tail = n;
				count++;
				return;
			}
			Node temp = head;
			Node temp2 = head.next;

			for (int i = 1; i < p; i++) {
				temp = temp.next;
				temp2 = temp2.next;
			}

			temp.next = n;
			n.next = temp2;
			count++;
			return;
		} else {
			System.out.println("index not found");
		}
	}

	public G pop() {

		Node temp = head;
		Node data = tail;
		if (count == 1) {
			temp.next = null;
			head = null;
			tail = null;
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

	public G pop(int n) {
		G data;
		if (n == 0) {
			data = (G) head.data;
			head = head.next;
			count--;
			return data;
		}
		Node temp = head;
		if (n == count - 1) {
			data = (G) tail.data;
			for (int i = 1; i < count - 1; i++) {
				temp = temp.next;
			}
			temp.next = null;
			tail = temp;
			count--;
			return data;
		}
		Node temp2 = head.next;
		Node temp3 = head.next.next;

		for (int i = 1; i < n; i++) {
			temp = temp.next;
			temp2 = temp2.next;
			temp3 = temp3.next;

		}
		data = (G) temp2.data;
		temp.next = temp3;
		count--;
		return data;
	}

	public G getData() {
		String st = "";
		Node temp = head;
		for (int i = 0; i < count; i++) {
			st = st + temp.data + " ";
			temp = temp.next;
		}
		return (G) st;
	}

	public static void main(String[] args) {
		UnOrderedList<String> un = new UnOrderedList<String>();
		un.add("akku");
		System.out.println(un.pop());
		un.list();
	}
}
