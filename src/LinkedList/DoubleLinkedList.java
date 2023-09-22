package LinkedList;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

	private static class DoubleLinkedListIterator<T> implements Iterator<T> {

		private Node<T> runner;

		public DoubleLinkedListIterator(DoubleLinkedList<T> list) {
			runner = list.head.getNext();
		}

		@Override
		public boolean hasNext() {
			return runner != null;
		}

		@Override
		public T next() {
			T data = runner.getData();
			runner = runner.getNext();
			return data;
		}

	}

	private static class Node<T> {
		private T data;
		private Node<T> next, prev;

		public Node() {
			data = null;
			next = null;
			prev = null;
		}

		public Node(T data) {
			this.data = data;
			next = null;
			prev = null;
		}

		/*
		 * public Node(T data, Node<T> next, Node<T> prev) {
		 * this.data=data;
		 * this.next=next;
		 * this.prev=prev;
		 * }
		 */

		public boolean equals(Node<T> p) {
			return super.equals(p);
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}
	}

	private Node<T> head, tail;

	public DoubleLinkedList() {
		head = tail = new Node<>();
	}

	public Node<T> begin() {
		return head;
	}

	public Node<T> end() {
		return tail;
	}

	public Node<T> next(Node<T> p) throws DoubleLinkedListBOLException {
		if (p.equals(tail) || p.getNext() == null)
			throw new DoubleLinkedListBOLException(
					"301 - Tentativa de acesso a posi��o posterior ao �ltimo elemento da lista!!");
		return p.getNext();
	}

	public Node<T> prev(Node<T> p) throws DoubleLinkedListBOLException {
		if (p.equals(head) || p.getPrev() == null)
			throw new DoubleLinkedListBOLException(
					"302 - Tentativa de acesso a posi��o anterior ao primeiro elemento da lista!!");
		return p.getPrev();
	}

	public T get(Node<T> p) throws DoubleLinkedListBOLException {
		if (p.equals(tail) || p.getNext() == null)
			throw new DoubleLinkedListBOLException(
					"303 - Tentativa de acesso ao dado da posi��o posterior ao �ltimo elemento da lista!!");
		return (T) p.getNext().getData();
	}

	public void set(Node<T> p, T data) throws DoubleLinkedListEOLException {
		if (p.equals(tail) || p.getNext() == null)
			throw new DoubleLinkedListEOLException(
					"304 - Tentativa de actualiza��o do dado da posi��o posterior ao �ltimo elemento da lista!!");
		p.getNext().setData(data);
	}

	public void insert(Node<T> p, T x) {
		if (tail.equals(head))
			tail = new Node<>();

		if (p.equals(tail))
			p = p.getPrev();

		Node<T> newNode = new Node<>(x);
		newNode.setNext(p.getNext());

		if (!p.equals(head))
			newNode.setPrev(p);
		p.setNext(newNode);

		if (newNode.getNext() != null)
			newNode.getNext().setPrev(newNode);
		else
			tail.setPrev(newNode);
	}

	public void remove(Node<T> p) throws DoubleLinkedListEOLException {
		if (p.equals(tail) || p.getNext() == null)
			throw new DoubleLinkedListEOLException("305");
		Node<T> deletedNode = p.getNext();
		p.setNext(deletedNode.getNext());
		if (deletedNode.getNext() != null)
			deletedNode.getNext().setPrev(p);
		else
			tail.setPrev(p);
		if (tail.getPrev().equals(head))
			tail = head;
	}

	public Node<T> find(T data) {
		Node<T> runner = head.getNext();

		while (runner != null && runner.getData() != data)
			runner = runner.getNext();

		return runner;
	}

	public int findAndCountSteps(T data) {
		Node<T> runner = head.getNext();
		int steps = 0;

		while (runner != null) {
			steps++;
			if (runner.getData().equals(data)) {
				return steps;
			}
			runner = runner.getNext();
		}

		return -1;
	}

	public Node<T> nth(int k) {
		Node<T> runner = head;
		int cont = -1;
		while (runner != null && cont++ < k)
			runner = runner.getNext();

		return runner;
	}

	public int lenght() {
		Node<T> runner = head;
		int cont = -1;

		while (runner != null) {
			cont++;
			runner = runner.getNext();
		}
		return cont;
	}

	@Override
	public String toString() {
		Node<T> runner = head;
		String str = "[ ";
		while (runner != null) {
			try {
				str += get(runner) + " ";
			} catch (DoubleLinkedListBOLException e) {
			}
			runner = runner.getNext();
		}
		str += "]";
		return str;
	}

	@Override
	public Iterator<T> iterator() {
		return new DoubleLinkedListIterator<T>(this);
	}
}
