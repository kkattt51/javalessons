package chapter4.fourth;

class PriorityQ {
	private int maxSize;
	private long[] queArray;
	private int nItems;
//-------------------------------------------------------------------------------------------------
	public PriorityQ(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}
//-------------------------------------------------------------------------------------------------	
//	public void insert(long item) {
//		int j;
//		
//		if (nItems == 0) {
//			queArray[nItems++] = item;
//		} else {
//			for (j = nItems - 1; j >= 0; j--) {
//				if (item > queArray[j]) {
//					queArray[j + 1] = queArray[j];
//				} else {
//					break;
//				}
//			}
//			queArray[j + 1] = item;
//			nItems++;
//		}
//	}
	
	public void insert(long item) {
		queArray[nItems++] = item;
	}
//-------------------------------------------------------------------------------------------------
	private void insertionSort() {
        int in, out;
        for ( out = 1; out < nItems; out++ ) {
            long temp = queArray[out];
            in = out;
            while(in > 0 && queArray[in - 1] <= temp) {
                queArray[in] = queArray[in - 1];
                --in;
            }
            queArray[in] = temp;
        }
    }
//-------------------------------------------------------------------------------------------------
	public long remove() {
		insertionSort();
		return queArray[--nItems];
	}
//-------------------------------------------------------------------------------------------------
	public long peekMin() {
		return queArray[nItems - 1];
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
	public void display() {
		
		for(int i = 0; i < maxSize; i++) {
			long temp = remove();
			System.out.print(temp + " ");	
		}
	}
}

public class PriorityQApp {

	public static void main(String[] args) {
		PriorityQ thePQ = new PriorityQ(5);
		
		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);
		
		thePQ.display();
		
//		while (!thePQ.isEmpty()) {
//			long item = thePQ.remove();
//			System.out.print(item + " ");
//		}
//		System.out.println("");
	}
}
