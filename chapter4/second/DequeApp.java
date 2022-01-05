package chapter4.second;

class Deque {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
//-------------------------------------------------------------------------------------------------
	public Deque(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
//-------------------------------------------------------------------------------------------------
	public void insert(long j) {
		if (rear == maxSize - 1) {
			rear = -1;
		}		
		queArray[++rear] = j;
		nItems++;
	}
//-------------------------------------------------------------------------------------------------
	public long remove() {
		long temp = queArray[front++];
		if (front == maxSize) {
			front = 0;
		}
		nItems--;
		return temp;
	}
//-------------------------------------------------------------------------------------------------
	public long peekFront() {
		return queArray[front];
	}
//-------------------------------------------------------------------------------------------------
	public boolean isEmpty() {
		return (nItems == 0);
	}
//-------------------------------------------------------------------------------------------------
	public boolean isFull() {
		return (nItems == maxSize);
	}
//-------------------------------------------------------------------------------------------------
	public int size() {
		return nItems;
	}
//-------------------------------------------------------------------------------------------------
	public void displayDeque() {
        if (!this.isEmpty()) {
            int disp = front;
            if(front > rear) {
                while (disp < maxSize) {
                    System.out.print("[" + this.queArray[disp++] + "]");
                }
                disp = 0;
                while (disp <= rear) {
                    System.out.print("[" + this.queArray[disp++] + "]");
                }
            } else {
                while (disp <= rear) {
                    System.out.print("[" + this.queArray[disp++] + "]");
                }
            }
        }
        else {
            System.out.println("Empty queue");
        }
        System.out.println("");
    }
//-------------------------------------------------------------------------------------------------
    public void insertRight(long j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }
//-------------------------------------------------------------------------------------------------
    public void insertLeft(long x) {
        
        if (front == 0 && rear < maxSize - 1) {         
           front = maxSize - 1;
           rear = maxSize - 1;
        } else if (front > 0) {
            front--;
        }
        queArray[front] = x;
        nItems++;
    }
//-------------------------------------------------------------------------------------------------
    public long removeLeft() {
        long temp = queArray[front++]; 
        if (front > maxSize - 1) {     
            front = 0;
        }
        nItems--;          
        return temp;
    }
//-------------------------------------------------------------------------------------------------  
    public long removeRight() {
        rear--;  
        if (rear <= -1) {  
            rear = maxSize - 1;
        }
        long temp = queArray[rear];
        nItems--;
        return temp;
    }
}

public class DequeApp {

	public static void main(String[] args) {
		int maxSize = 20;
		int rem = 5;
		
		Deque theDeque = new Deque(maxSize);
		
        System.out.println("DEQUEUE..........................................");
        System.out.println("Filling from the left side (oposite direction than a normal Queue)");
        
        for (int i = 0; i < maxSize; i++) {
            if(!theDeque.isFull()) {
                theDeque.insertLeft((long)(Math.random() * maxSize));
            }
        }
        theDeque.displayDeque();
        
        System.out.println("Full Queue");
        System.out.println("Removing items from the left...");
        for (int i = 0; i < rem; i++) {
            theDeque.removeLeft();
        }
        theDeque.displayDeque();
        
        System.out.println("");
        System.out.println("Inserting items from the left...");
        for (int i = 0; i < rem / 2; i++) {
            theDeque.insertLeft((long)(Math.random() * maxSize));
        }
        theDeque.displayDeque();
        
        System.out.println("Leaving only three items, from the right (opposite than normal)...");
        for (int i = 0; i < rem * 3 - 1 ; i++) {
            theDeque.removeRight();
        }
        theDeque.displayDeque();
        
        System.out.println("Inserting items one left and one right...");
        theDeque.insertLeft((long)(Math.random() * maxSize));
        theDeque.insertRight((long)(Math.random() * maxSize));
        theDeque.displayDeque();
        
        System.out.println("Leaving only one item... ");
        theDeque.removeRight();
        theDeque.removeLeft();
        theDeque.displayDeque();
        System.out.println("............");
        theDeque.removeRight();
        theDeque.removeLeft();
        theDeque.displayDeque();
        System.out.println("Zero items...");
        theDeque.removeRight();
        theDeque.displayDeque();
	}
}
