import java.util.Iterator;
import java.util.ListIterator;
//import javafx.scene.Node;

public class LinkedList<E> implements SimpleList<E>{
	Node startNode;
	int size;
	
	public LinkedList () {
		size = 0;
		startNode = null;
	}
	
	private class Node {
		Node next;
		E value;
		
		public Node(E element) {
			this.value  = element ;
			next = null;
		}

	}
	
	

	@Override
	public boolean add(E element) {
		add(size, element);
		return true;
		
	}

	@Override
	public void add(int index, E element) {
		Node newNode = new Node(element);
		Node tempNode = startNode;
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		if (isEmpty()) {
			startNode = newNode;
		}
		else {
			for (int i = 1; i < index; i++) {
				tempNode = tempNode.next;
			}
			newNode.next = tempNode.next;
			tempNode.next = newNode;
			}
			size++;
		}
		

	@Override
	public boolean addAll(SimpleList<? extends E> c) {
		return addAll(size, c);
	}

	@Override
	public boolean addAll(int index, SimpleList<? extends E> c) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		if (c == null) {
			throw new NullPointerException("Index is null");
		}
		return false;
	}

	@Override
	public void clear() {
		size = 0;
		startNode = null;	
	}

	@Override
	public boolean contains(Object object) {
		/*
		Node n = startNode;
		
		while (n != null && !n.value.equals(object)) {
			n = n.next;
		}
		
		if (n != null) {
			return true;
		}
		
		else {
			return false;
		}*/
		return indexOf(object) != -1;
	}
	
	@Override
	public boolean containsAll(SimpleList<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		Node n = startNode;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		return n.value;
	}

	@Override
	public int indexOf(Object object) {
		Node n = startNode;
		int index = 0;
		while(n != null) {
			if (n.value.equals(object)) {
				return index;
			}
			index++;
			n = n.next;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
			
	}

	@Override
	public Iterator<E> iterator() {
		return  (Iterator<E>) new LinkedList();
	}

	@Override
	public int lastIndexOf(Object object) {
		int index = size - 1;
		Node n = startNode;
		while (n != null) {
			if (n.value.equals(object)) {
				return index;
			}
			index--;
			n = n.next;
		}

		return  -1;
	}

	@Override
	public boolean remove(Object object) {
		if (startNode == null) {
			return false;
		}
		
		if (startNode.value.equals(object)) {
			startNode = startNode.next;
			return true;
		}
		else {
			Node tempNode =startNode;
			while (tempNode.next != null) {
				if (tempNode.next.value.equals(object)) {
					tempNode.next = tempNode.next.next;
					return true;
				}
				tempNode = tempNode.next;
			}
			return false;
		}
		
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		if (index == 0) {
			E element = startNode.value;
			startNode = startNode.next;
			return element;
		}
		else {
			Node tempNode = startNode;
			for (int i = 0; i < index - 1; i++) {
				tempNode = tempNode.next;
			}
			E element = tempNode.next.value;
			tempNode.next = tempNode.next.next;
			return element;
		}
		
	}

	@Override
	public boolean removeAll(SimpleList<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(SimpleList<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		Node n = startNode;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		return n.value = element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public SimpleList<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		Node n = startNode;
		for (int i = 0; i < size; i++) {
			array[i] = n.value;
			n = n.next;
		}
		return array;
	}
	
	@Override
	public String toString(){
		Node n = startNode;
		String s = "[";
		while(n != null)
		{
			s += n.value + ", ";
			n = n.next;
		}
		s = s.substring(0, s.length() - 2) + "]";
		return s;
	}

	public Node locate(int index) {
		Node n = startNode;
		int i = 0;
		while(n != null && i != index) {
			i++;
			n = n.next;
		}
		return n;
	}


}
