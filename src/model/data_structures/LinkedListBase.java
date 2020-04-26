package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListBase<Item> implements Iterable<Item> {

	private Node<Item> first;
	private int n;

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	/**
	 * Initializes an empty bag.
	 */
	public LinkedListBase() {
		first = null;
		n = 0;
	}

	/**
	 * Returns true if this bag is empty.
	 *
	 * @return {@code true} if this bag is empty;
	 *         {@code false} otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in this bag.
	 *
	 * @return the number of items in this bag
	 */
	public int size() {
		return n;
	}

	/**
	 * Adds the item to this bag.
	 *
	 * @param  item the item to add to this bag
	 */
	public void add(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		n++;
	}


	public Iterator<Item> iterator()  {
		return new LinkedIterator(first);  
	}


	private class LinkedIterator implements Iterator<Item> {
		private Node<Item> current;

		public LinkedIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext()  { return current != null;                     }
		public void remove()      { throw new UnsupportedOperationException();  }

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next; 
			return item;
		}
	}

}
