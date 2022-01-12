package chapter3.sixth;


class ArrayIns {
	private long[] a;
	private int nElems;
	
	public ArrayIns(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for (int j = 0; j < nElems; j++) 
			System.out.print(a[j] + " ");
		System.out.println("");
	}
	
	public void insertionSort() {
		int in, out;
		
		for (out = 1; out < nElems; out++) {
			long temp = a[out];
			in = out;
			while (in > 0 && temp <= a[in - 1]) {
			    if(temp == a[in - 1]) {
			    	temp = -1;
			    }
			    if (a[in - 1] > temp) {
			    	a[in] = a[in - 1];
				    in--;
			    }
			    else {
					break;
				}
			    a[in] = temp;
			}
		}
		display();
		System.out.println("Array without dups:");
		int key = 0, dups = 0;
	    for (int i = 0; i < nElems; i++) {
	        while(key < nElems) {
	            if(a[key] == -1) {
	                key++;
	                dups++;
	            } else {
	                a[i++] = a[key];
	                key++; 
	            }
	        }
	    }
	    nElems = nElems - dups;
	}
	
	public void noDups() {
		System.out.println("Array without duplicates: ");
		int j = 0;
		
	    for (int i = 0; i < nElems - 1; i++) {
	        if (a[i] != a[i + 1]) {
	            a[j] = a[i];
	            j++;
	        }  
	    }
	    a[j++] = a[nElems - 1];
	    
	    for (int i = 0; i < j; i++) {
	        System.out.print(a[i] + " "); 
	    }
	    System.out.println(""); 
	  }
	
	public void median() {
		//insertionSort();
		
		double med;
		
		if (nElems % 2 == 0) {
		    med = ((double)a[nElems / 2] + (double)a[nElems/2 - 1]) / 2;
		    System.out.println("Median = " + med);
		} else {
			med = (double)a[nElems / 2];
			System.out.println("Median = " + med);
		}
		  
	}
}

public class InsertSortApp {

	public static void main(String[] args) {
		int maxSize = 100;
		ArrayIns arr;
		arr = new ArrayIns(maxSize);
		
		
		arr.insert(99);
		arr.insert(77);
		arr.insert(44);
		arr.insert(55);
		arr.insert(17);
		arr.insert(22);
		arr.insert(88);
		arr.insert(17);
		arr.insert(11);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(17);
		arr.insert(33);
		
		arr.display();
		
		System.out.println("Sorted array: ");
		arr.insertionSort();
		
		arr.display();
		
		arr.median();
		
		//arr.noDups();
	}

}

