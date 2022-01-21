package chapter5.second;

class Link {
	public long dData;
	public Link next;
	public Link previous;
//---------------------------------------------------------------------
	public Link(long d) {
		dData = d;
	}
//---------------------------------------------------------------------
	public void displayLink() {
		System.out.print(dData + " ");
	}
//---------------------------------------------------------------------
}

class DoublyLinkedList {
	private Link first;
	private Link last;
//---------------------------------------------------------------------
	public DoublyLinkedList() { 
		first = null;
		last = null;
	}
//----------------------------------------------------------------------------------
	public Link getFirst() {
		return first;
	}
//----------------------------------------------------------------------------------
	public Link getLast() {
		return last;
	}
//---------------------------------------------------------------------
	public boolean isEmpty() {
		return (first == null);
	}
//----------------------------------------------------------------------------------
	public void insertFirst(long d) {
		Link newLink = new Link(d);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
//---------------------------------------------------------------------
	public void insertLast(long d) {
		Link newLink = new Link(d);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}
//---------------------------------------------------------------------
	public boolean insertAfter(long key, long d) {
		Link current = first;
		while (current.dData != key) {
			current = current.next;
			if (current == null) {
				return false;
			}
		}
		Link newLink = new Link(d);
		
		if (current == last) {
			newLink.next = null;
			last = newLink;
		} else {
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next = newLink;
		return true;
	}
//---------------------------------------------------------------------
	public Link deleteFirst() {
		Link temp = first;
		if (first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}
//---------------------------------------------------------------------
	public Link deleteLast() {
		Link temp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}		
//---------------------------------------------------------------------
	public Link deleteKey(long key) {
		Link current = first;
		while (current.dData != key) {
			current = current.next;
			if (current == null) {
				return null;
			}
		}
		if (current == first) {
			first = current.next;
		} else {
			current.previous.next = current.next;
		}
		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		return current;
	}	
//---------------------------------------------------------------------
	public void displayForward() {
		System.out.print("List (first-->last): ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
//---------------------------------------------------------------------
	public void displayBackward() {
		System.out.print("List (last-->first): ");
		Link current = last;
		while (current != null) {
			current.displayLink();
			current = current.previous;
		}
		System.out.println("");
	}
//---------------------------------------------------------------------
}

class Deque {
	DoublyLinkedList theList;
//-------------------------------------------------------------------------------------------------
	public Deque() {
		theList = new DoublyLinkedList();
	}
//-------------------------------------------------------------------------------------------------
	public boolean isEmpty() {
		return (theList.isEmpty());
	}
//-------------------------------------------------------------------------------------------------
	public void insertRight(long j) {
        theList.insertLast(j);
    }
//-------------------------------------------------------------------------------------------------
	public void insertLeft(long x) {
		theList.insertFirst(x);
	}
//-------------------------------------------------------------------------------------------------
	public void insert(long k, long d) {
		theList.insertAfter(k, d);
	}
//-------------------------------------------------------------------------------------------------
	public void removeRight() {
       theList.deleteLast();
    }
//-------------------------------------------------------------------------------------------------
	public void removeLeft() {         
       theList.deleteFirst();
    }
//-------------------------------------------------------------------------------------------------
	public void remove(long key) {
		theList.deleteKey(key);
	}
//-------------------------------------------------------------------------------------------------
    public void displayDequeForward() {
        theList.displayForward();
    }
//-------------------------------------------------------------------------------------------------
    public void displayDequeBackward() {
        theList.displayBackward();
    }
//-------------------------------------------------------------------------------------------------
    public void peekFront() {
		theList.getFirst().displayLink();
	}
//-------------------------------------------------------------------------------------------------
    public void peekRear() {
		theList.getLast().displayLink();
	}
//-------------------------------------------------------------------------------------------------  
}


public class DoublyLinkedDeque {

	public static void main(String[] args) {
		Deque theDeque = new Deque();
		
		theDeque.insertLeft(22);
		theDeque.insertLeft(44);
		theDeque.insertLeft(66);
		
		theDeque.insertRight(11);
		theDeque.insertRight(33);
		theDeque.insertRight(55);
		
		theDeque.displayDequeForward();
		theDeque.displayDequeBackward();
		
		theDeque.removeLeft();
		theDeque.displayDequeForward();
		theDeque.removeRight();
		theDeque.displayDequeForward();
		theDeque.remove(11);
		
		theDeque.displayDequeForward();
		
		theDeque.insert(22, 77);
		theDeque.insert(33, 88);
		
		
		theDeque.displayDequeForward();
		System.out.print("Front: ");
		theDeque.peekFront();
		System.out.println("");
		System.out.print("Rear: ");
		theDeque.peekRear();
		System.out.println("");
		theDeque.displayDequeForward();
		
	}
}
