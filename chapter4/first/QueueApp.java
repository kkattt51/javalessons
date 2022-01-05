package chapter4.first;

class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
//-------------------------------------------------------------------------------------------------
	public Queue(int s) {
		maxSize = s;
		queArray =new long[maxSize];
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
	public void displayQueue() {
        if(!this.isEmpty()) {
            int disp = front;
            if(front > rear) {
                while(disp < maxSize) {
                    System.out.print("[" + this.queArray[disp++] + "]");
                }
                disp = 0;
                while(disp <= rear) {
                    System.out.print("[" + this.queArray[disp++] + "]");
                }
            } else {
                while(disp <= rear) {
                    System.out.print("[" + this.queArray[disp++] + "]");
                }
            }
        }
        else {
            System.out.println("Empty queue");
        }
        System.out.println("");
    }
}

public class QueueApp {

	public static void main(String[] args) {
		int maxSize = 20;
        int rem = 5;
		System.out.println("Filling completely the Queue");
		
        Queue theQueue = new Queue(maxSize);
        
        for (int i = 0; i < maxSize; i++) {
        	theQueue.insert((long)(Math.random() * maxSize));
        }
        theQueue.displayQueue();
        
        System.out.println("Full Queue");
        System.out.println("Removing items...");
        for (int i = 0; i < rem; i++) {
        	theQueue.remove();
        }
        theQueue.displayQueue();
        
        System.out.println("");
        System.out.println("Inserting items (breaking the sequence)...");
        for (int i = 0; i < rem / 2; i++) {
        	theQueue.insert((long)(Math.random() * maxSize));
        }
        theQueue.displayQueue();
        
        System.out.println("Leaving only three items...");
        for (int i = 0; i < rem * 3 - 1 ; i++) {
        	theQueue.remove();
        }
        theQueue.displayQueue();
        
        System.out.println("Inserting items (On new rear position)...");
        theQueue.insert((long)(Math.random() * maxSize));
        theQueue.insert((long)(Math.random() * maxSize));
        theQueue.displayQueue();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

