package chapter4.fifth;

import java.util.logging.Level;
import java.util.logging.Logger;

class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
//-------------------------------------------------------------------------------------------------
	public Queue(int s) {
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

class SuperMarket extends Thread {

    private final int Ncashiers = 3;
    private final int custPerLine = 6;
    private final int hrs = 15 * 1000 * 60 * 60;
    private long secs;
    private final Queue[] lines;
    private final Thread[] checkers;
    private boolean closing;
    private final long NewCustTime = 1000 * 5;
    private final long groceryPass = 2;
    private final long otherTransac = 1000 * 60 * 2;
    
    public SuperMarket(String string) {
        super(string);
        secs = 0;
        this.lines = new Queue[Ncashiers];
        closing = false;
        this.checkers = new Thread[Ncashiers];
    }

    @Override
    public void run() {
       
        for (int i = 0; i < Ncashiers; i++) {
            final int index;
            
            index = i;
            lines[i] = new Queue(this.custPerLine);
            checkers[i] = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        if( !lines[index].isEmpty() ) {
                            try {
                                Thread.sleep(lines[index].peekFront() * groceryPass + otherTransac );
                                System.out.println("From checker " + index + " Removing: " + lines[index].remove());
                             
                            } catch (InterruptedException ex) {
                                Logger.getLogger(SuperMarket.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            try 
                            {
                                Thread.sleep(NewCustTime);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(SuperMarket.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }   
            };
            checkers[i].start();
        }
        
        int best; 
        long groseries;
            
        while(!closing) {
            best = this.pickTheBest();
            if( !this.lines[best].isFull() ) {
                try {
                    Thread.sleep(this.NewCustTime);
                    secs+=5;
                    groseries = (long)(Math.random()*custPerLine) * 2;
                    this.lines[best].insert( groseries );
                    System.out.println("Checker " + best + ": " + groseries);
                        
                    for (int i = 0; i < this.Ncashiers; i++) {
                        if(!lines[i].isEmpty()) {
                            this.lines[i].displayQueue();
                        }
                    }
                    closing = secs>hrs;

                } catch (InterruptedException ex) {
                    Logger.getLogger(SuperMarket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private int pickTheBest() {
        int temp = this.lines[0].size(), pos = 0;
        
        for (int i = 0; i < this.lines.length; i++) {
            if(this.lines[i].size() < temp) {
                temp = this.lines[i].size();
                pos = i; 
            }
        }
        return pos;
    }   
}

public class QueueApp {

	public static void main(String[] args) {
		System.out.println("");
	    System.out.println("SUPER MARKET SIMULATOR:");
	    SuperMarket supermarket = new SuperMarket("SuperMarket");
	    supermarket.start();
	}	
}

