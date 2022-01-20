package chapter5.first;

class Link {
	public long iData;
	public Link next;
//---------------------------------------------------------------------
	public Link(long id) {
		iData = id;
	}
//---------------------------------------------------------------------
	public void displayLink() {
		System.out.print(iData + " ");
	}
//---------------------------------------------------------------------
	public long getiData() {
		return iData;
	}
//---------------------------------------------------------------------
	public Link getNext() {
		return next;
	}
//---------------------------------------------------------------------
	public void setiData(long dData) {
		iData = dData;
	}
//---------------------------------------------------------------------
	public void setNext(Link next) {
		this.next = next;
	}
//---------------------------------------------------------------------
}

class SortedList {
	private Link first;
//---------------------------------------------------------------------
	public SortedList() {
		first = null;
	}
//---------------------------------------------------------------------
	public Link getFirst() {
		return first;
	}
//---------------------------------------------------------------------
	public boolean isEmpty() {
		return (first == null);
	}
//---------------------------------------------------------------------
	public void insert(long key) {
		Link newLink = new Link(key);
		Link previous = null;
		Link current = first;
		
		while (current != null && key > current.getiData()) {
			previous = current;
			current = current.getNext();
		}
		if (previous == null) {
			first = newLink;
		} else {
			previous.setNext(newLink);
		}
		newLink.setNext(current);
	}
//---------------------------------------------------------------------
	public Link remove() {
		Link temp = first;
		first = first.getNext();
		return temp;
	}
//---------------------------------------------------------------------
	public void displayList() {
		System.out.print("List (first-->last): ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.getNext();
		}
		System.out.println("");
	}
//---------------------------------------------------------------------
}

class PriorityQ {
    private SortedList theSortedList;
//-------------------------------------------------------------------------------------------------
	public PriorityQ() {
		theSortedList = new SortedList();
	}
//-------------------------------------------------------------------------------------------------	
	
	public void insert(long iData) {
		theSortedList.insert(iData);
	}
//-------------------------------------------------------------------------------------------------
	public long remove() {
		Link temp = theSortedList.remove();
		return temp.iData;
	}
//-------------------------------------------------------------------------------------------------
	public void peekMin() {
		theSortedList.getFirst().displayLink();
	}
//-------------------------------------------------------------------------------------------------
	public boolean isEmpty() {
		return (theSortedList.isEmpty());
	}
//-------------------------------------------------------------------------------------------------	
	public void displayQueue() {
		theSortedList.displayList();
	}
}

public class PriorityQLinkedList {

	public static void main(String[] args) {
		PriorityQ thePQ = new PriorityQ();

		thePQ.insert(10);
		thePQ.insert(5);
		thePQ.insert(7);
		thePQ.insert(27);
		thePQ.insert(25);
		thePQ.insert(35);

		thePQ.displayQueue();

		thePQ.remove();
		thePQ.remove();
		thePQ.displayQueue();
	}

}
