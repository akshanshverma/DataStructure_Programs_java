package helper;

public class UnOrderedList {
	Node head = null;
	Node tail = null;
	int count = 0;

	public void add(Object data) {
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

	public void append(Object data) {
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

	public void remove(Object data) {
		if (head == null) {
			System.out.println("no data");
			return;
		}
		if (head.data == data) {
			head = head.next;
			count--;
			return;
		}
		Node temp = head;
		int i;

		for (i = 1; i <= count; i++) {
			if (temp.data == data) {
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

	public boolean search(Object data) {
		Node temp = head;
		for (int i = 0; i < count; i++) {
			if (temp.data == data) {
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
		Node temp = head;
		for (int i = 0; i < count; i++) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public int indexOf(Object data) {
		Node temp = head;
		for (int i = 0; i < count; i++) {
			if (temp.data == data) {
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}

	public void insert(int p, Object data) {
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

	public Object pop() {
		Node temp = head;
		Node data = tail;
		for (int i = 1; i < count - 1; i++) {
			temp = temp.next;
		}
		temp.next = null;
		tail = temp;
		count--;
		return data.data;
	}

	public Object pop(int n) {
		Object data;
		if (n == 0) {
			data = head.data;
			head = head.next;
			count--;
			return data;
		}
		Node temp = head;
		if (n == count - 1) {
			data = tail.data;
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
		data = temp2.data;
		temp.next = temp3;
		count--;
		return data;
	}
}
