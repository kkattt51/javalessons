package chapter2.third;

class HighArray {
	private long[] a;
	private int nElems;
	
	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < nElems; j++) 
			if (a[j] == searchKey) 
				break;
		if (j == nElems)
			return false;
		else 
			return true;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++) 
			if (a[j] == value) 
				break;
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
	
	public long getMax(long max) {
		max = 0;
		for (int j = 0; j < nElems; j++) {
		     if (a[j] > max) {
		      max = a[j];
		     }
		}
		if (nElems > 0) {
			System.out.println("The highest maximum for the array is: " + max);
			return max;
		}
		else 
			return -1;
	}
	
	public long removeMax(long max){
		max = 0;
		
		int j;
		for (j = 0; j < nElems - 1; j++) {
			int min = j;
            for (int i = j + 1; i < nElems; i++)
                if (a[i] < a[min])
                    min = i;
		    if (a[j] > max) {
		    	max = a[j];
		    }
		    long temp = a[min];
	        a[min] = a[j];
	        a[j] = temp;
		}
		
		if (nElems > 0) {
			System.out.println("The highest maximum for the array is: " + max);
			//int j;
			for (j = 0; j < nElems; j++) 
				if (a[j] == max) 
					break;
			if (j == nElems)
				return max;
			else {
				for (int k = j; k < nElems; k++) 
					a[k] = a[k + 1];
				nElems--;
				return max;
			}
		}
		else 
			return -1;
	}
	public void selectionSort() {

	    for (int step = 0; step < nElems - 1; step++) {
	      int min_idx = step;

	      for (int i = step + 1; i < nElems; i++) {

	        // To sort in descending order, change > to < in this line.
	        // Select the minimum element in each loop.
	        if (a[i] < a[min_idx]) {
	          min_idx = i;
	        }
	      }

	      // put min at the correct position
	      long temp = a[step];
	      a[step] = a[min_idx];
	      a[min_idx] = temp;
	    }
	}

}	

public class HighArrayApp {

	private static HighArray array;

	public static void main(String[] args) {
		int maxSize = 100;
		HighArray arr;
		arr = new HighArray(maxSize);
		
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();
		
		int searchKey = 35;
		if (arr.find(searchKey)) 
			System.out.println("Found " + searchKey);
		else 
			System.out.println("Cannot find " + searchKey);
		
		
		
		arr.delete(00);
		arr.delete(55);
		arr.delete(99);
		
		arr.display();

		arr.getMax(maxSize);
		
		arr.display();
		arr.selectionSort();
		arr.display();
		
		array = arr;
		array.insert(59);
		array.display();
		
		array.removeMax(maxSize);
		array.display();
		
	}
}

