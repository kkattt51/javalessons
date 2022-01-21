package chapter5.third;

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
	public void find(int data) {
		boolean found = false;

		Link temp = current;

		do {
			temp = temp.next;
			if (data == temp.iData) {
				found = true;
				break;
			}
		} while (temp != current);

		if (found) {
			System.out.println(data + "--> Found");
		} else {
			System.out.println(data + "--> Not found");
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

public class CircularLinkListApp {

	public static void main(String[] args) {
		CircularLinklist theCircularLinklist = new CircularLinklist();

		theCircularLinklist.insert(10);
		theCircularLinklist.insert(20);
		theCircularLinklist.insert(30);
		theCircularLinklist.insert(50);
		
		theCircularLinklist.display();
		
		theCircularLinklist.insert(40);

		theCircularLinklist.display();
		
		theCircularLinklist.find(20);
		theCircularLinklist.find(55);

		theCircularLinklist.delete();
		theCircularLinklist.delete();
		theCircularLinklist.delete();
		
		if (!theCircularLinklist.isEmpty()) {
			theCircularLinklist.display();
		} else {
			System.out.println("List is Empty");
		}
		theCircularLinklist.delete();
		theCircularLinklist.delete();
	
		theCircularLinklist.display();
	}
}
