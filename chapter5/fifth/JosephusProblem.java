package chapter5.fifth;

class Link {
	public int iData;
	public Link next;
//----------------------------------------------------------------------------------
	public Link(int id) {
		iData = id;
		next = null;
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
	public void move() {
		if (!isEmpty()) {
			current = current.next;
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

class JosephusProblem {
	public static void main(String[] args) {
		final int PEOPLE = 7;
    	final int COUNT = 4;
    	final int FIRST = 1;

    	CircularLinklist theCircularLinklist = new CircularLinklist();

    	// Insert People to CircularLinklist
    	for (int i = 1; i <= PEOPLE ; i++) {
      		theCircularLinklist.insert(i);
    	}

    	// Suicide Sequence
    	while (!theCircularLinklist.isEmpty()) {
      		theCircularLinklist.display();
      		for (int i = FIRST; i <= COUNT; i++) {
        		theCircularLinklist.move();
      		}
      		theCircularLinklist.delete();
    	}
	}
}
