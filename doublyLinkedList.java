package doublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class doublyLinkedList<E extends Comparable<? super E>> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	public doublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	private static class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;

		public Node(E data, Node<E> next, Node<E> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		public E getElement() {
			return data;
		}

		void setNext(Node<E> next) {
			this.next = next;
		}

		void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		Node<E> getNext() {
			return next;
		}

		Node<E> getPrev() {
			return prev;
		}
	}

	public int size() {
		return this.size;
	}

	public void addFirst(E data) {
		Node<E> temp = new Node(data, head, null);
		if (head == null) {
			head.prev = temp;
		}
		head = temp;
		if (tail == null) {
			tail = temp;
		}
		size++;
	}

	public void addLast(E data) {
		Node<E> temp = new Node(data, null, tail);
		if (tail != null) {
			tail.next = temp;
		}
		tail = temp;
		if (head == null) {
			head = temp;
		}
		size++;
	}

	private class ListIterator<E> implements Iterator<E> {
		Node curr;

		public ListIterator() {
			curr =  head;
		}

		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public E next() {
			E res = (E) curr.getElement();
			curr = curr.getNext();
			return res;
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void removeFirst() {
		if (this.size == 0) {
			System.out.println("The list is empty");
		}
		if (this.size == 1) {
			tail = null;
			head = null;
			this.size=0;
		} else {
			head = head.next;
			this.size--;
		}
	}

	public void removeLast() {
		if (this.size == 0) {
			System.out.println("List is empty");
		}
		if (this.size == 1) {
			this.tail = null;
			this.head = null;
			this.size=0;
		} else {
			tail = tail.prev;
			this.size--;
		}
	}

	public void remove(E element) {
		boolean found = false;
		if (this.size == 0) {
			System.out.println("List is empty");
		}
		Node<E> temp = head;
		while (!found) {
			if ((temp.data).compareTo(element) == 0) {
				if (temp == tail) {
				removeLast();
				found=true;
				}
				else if (temp == head) {
				removeFirst();
				found=true;
				} 
				else {
					temp.prev.next = temp.next;
					found = true;
					this.size--;
				}

			} else {
				temp = temp.next;
			}
		}
	}

	public E getKthNode(int index) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Invalid Index");
		}
		Node<E> temp = head;
		int counter = 0;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}
		return temp.data;
	}

	public boolean isPalindrome() throws Exception {
		int counter = 0;
		boolean isPalindrome = true;
		while (isPalindrome && counter < this.size / 2) {
			if (this.getKthNode(counter) == this.getKthNode(this.size - counter - 1)) {
				counter++;
			} else {
				isPalindrome = false;
			}
		}

		return isPalindrome;
	}

	public void display() throws Exception {
		int i;
		Node<E> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " => ");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public void reverse() {
		Node<E> prev = null;
		Node<E> curr = this.head;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		this.head = prev;
	}

	public E findMinimum() {
		E min;
		int i;
		Node<E> temp = head;
		Node<E> minNode = head;
		min = (E) temp.data;
		for (i = 0; i < size - 1; i++) {
			if ((temp.next.data).compareTo(min) < 0) {
				min = (E) temp.next.data;
				minNode = temp.next;
				temp = temp.next;
			} else {
				temp = temp.next;
			}
		}
		return minNode.data;
	}

	public E popMin() {
		E min = this.findMinimum();
		remove(min);
		return min;
		
	}

}
