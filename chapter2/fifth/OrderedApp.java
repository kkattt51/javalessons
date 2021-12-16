package chapter2.fifth;

class OrdArray {
	private long[] a;
	private int nElems;
	
	public OrdArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	public int size() {
		return nElems;
	}
	
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;
		
		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey) 
				return curIn;
			else if (lowerBound > upperBound) 
				return nElems;
			else {
				if (a[curIn] < searchKey) 
					lowerBound = curIn + 1;
				else 
					upperBound = curIn - 1;
			}
		}
	}
	
	public void insert(long value) {
		int lowerBound = 0;
	    int upperBound = nElems;
	    int curIn;
	    while(lowerBound < upperBound) {
	        curIn = (lowerBound + upperBound) / 2;
	        if(a[curIn] > value) {
	            upperBound = curIn;
	        } else {
	            lowerBound = curIn + 1;
	        }
	    }
	    for(int k = nElems; k > lowerBound; k--) {
	        a[k] = a[k - 1];
	    }
	    a[lowerBound] = value;
	    nElems++;
	}
	
	public boolean delete(long value) {
		int j = find(value);
		if (j == nElems)
			return false;
		else {
			for (int k = j; k < nElems; k++) 
				a[k] = a[k + 1];
			nElems--;
			return true;
		}
	}
	
	public void display() {
		for (int j = 0; j < nElems; j++) 
			System.out.print(a[j] + " ");
		System.out.println("");
	}
	
	public void merge(OrdArray a1, OrdArray a2) {
	
		long[] a3 = new long[a1.nElems + a2.nElems];
		int count = 0;
		int i = 0;
		int j = 0;
	    for(i = 0; i < a1.nElems; i++) {
	    	a3[i] = a1.a[i];
	        count++;
	    }
	    for(j = 0; j < a2.nElems; j++) {
	    	a3[count++] = a2.a[j];
	    } 
	    
	    System.out.println(a3.length);
	    
	    for (int out = 0; out < a3.length; out++) {
	    	for (int in = 1; in < (a3.length - out); in++) {
	    		if (a3[in - 1] > a3[in]) {
	    			long temp = a3[in - 1];
	    			a3[in - 1] = a3[in];
	    			a3[in] = temp;
	    		}
	        }
	    }
	    for(int k = 0; k < a3.length; k++) {
	    	System.out.print(a3[k] + " ");
	    }
	}
}

public class OrderedApp {

	public static void main(String[] args) {
		int maxSize = 100;
		OrdArray arr1;
		arr1 = new OrdArray(maxSize);
		
		arr1.insert(77);
		arr1.insert(99);
		arr1.insert(44);
		arr1.insert(55);
		arr1.insert(22);
		arr1.insert(88);
		arr1.insert(11);
		arr1.insert(00);
		arr1.insert(66);
		arr1.insert(33);
		
		OrdArray arr2;
		arr2 = new OrdArray(maxSize);
		
		arr2.insert(10);
		arr2.insert(12);
		arr2.insert(36);
		arr2.insert(75);
		arr2.insert(54);
		arr2.insert(28);
		arr2.insert(91);
		arr2.insert(69);
		
		
		
		int searchKey = 55;
		if (arr1.find(searchKey) != arr1.size()) 
			System.out.println("Found " + searchKey);
		else 
			System.out.println("Cannot find " + searchKey);
		
		arr1.display();
		arr2.display();
		
		OrdArray arr3 = new OrdArray(maxSize);
		arr3.merge(arr1, arr2);
		arr3.display();
		
		
		arr1.delete(00);
		arr1.delete(55);
		arr1.delete(99);
		
		arr1.display();
		
		arr1.insert(69);
		arr1.display();
	}
}
