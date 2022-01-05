package chapter4.third;

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

class DequeStack {
    Deque theDeque;
    
    public DequeStack(int s) {    
        theDeque = new Deque(s);   
    }
    
    public void push(long x) {
        this.theDeque.insertLeft(x);
    }
    
    public long pop() {
        return this.theDeque.removeLeft();
    }
    
    public long peek() {
        return this.theDeque.peekFront();
    }
}

public class DequeApp {
	public static void main(String[] args) {
		int maxSize = 20;
		
		DequeStack stackX = new DequeStack(maxSize);
        System.out.println("Pushing into the implemented Stack...");
        for (int i = 0; i < maxSize; i++) {
            long item = (long)(Math.random() * maxSize);
            stackX.push(item);
            System.out.println("Pushed: " + item);
        }
        System.out.println("Poping from the implemented Stack...");
        for (int i = 0; i < maxSize; i++) {
            System.out.println("Poped: " + stackX.pop());
        }
	}
}










