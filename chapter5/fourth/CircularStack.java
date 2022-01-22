package chapter5.fourth;


class Link {
	public int iData;
	public Link next;
//----------------------------------------------------------------------------------
	public Link(int id) {
		iData = id;
		this.next = null;
	}
//----------------------------------------------------------------------------------
	public void displayLink() {
		System.out.print(iData + " ");
	}
}

class CircularLinklist {
	private Link current;
//----------------------------------------------------------------------------------
	public CircularLinklist() {
		current = null;
	}
//----------------------------------------------------------------------------------
	public boolean isEmpty() {
		return (current == null);
	}
//----------------------------------------------------------------------------------
	public void insert(int data) {
		Link newLink = new Link(data);

		if(current == null) {
			newLink.next = newLink;
			current = newLink;
		} else {
			newLink.next = current.next;
			current.next = newLink;
			current = newLink;
		}
	}
//----------------------------------------------------------------------------------
	public void delete() {
		Link temp = current;

		if (temp.next == current) {
			current = null;
		} else {
			do {
				temp = temp.next;
			} while (temp.next != current);

			temp.next = current.next;
			current = temp;
		}
	}
//----------------------------------------------------------------------------------
	public void display() {
		Link temp = current;

		if (current != null) {
			do {
				temp = temp.next;
				System.out.print(temp.iData +  " ");
			} while(temp != current);
			System.out.println();
		} else {
			System.out.println("List Empty");
		}
	}
}

class LinkStack {
	private CircularLinklist theList;
//----------------------------------------------------------------------------------
	public LinkStack() {
		theList = new CircularLinklist();
	}
//----------------------------------------------------------------------------------
	public boolean isEmpty() {
		return (theList.isEmpty());
	}
//----------------------------------------------------------------------------------
	public void push(int j) {
		theList.insert(j);
	}
//----------------------------------------------------------------------------------
	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			theList.delete();
		}
	}
//----------------------------------------------------------------------------------
	public void displayStack() {
		System.out.print("Stack (top-->bottom): ");
		if (isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			theList.display();
		}
	}
//----------------------------------------------------------------------------------
}

public class CircularStack {

	public static void main(String[] args) {
		LinkStack theStack = new LinkStack();

		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(50);

		theStack.displayStack();

		theStack.pop();
		theStack.push(60);

		theStack.displayStack();
		theStack.pop();
		theStack.pop();
		theStack.pop();
		theStack.pop();
		theStack.pop();
		
		theStack.displayStack();
		theStack.pop();
	}
}
