package chapter3.third;

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
			while (in > 0 && a[in - 1] >= temp) {
				a[in] = a[in - 1];
				--in;
			}
			a[in] = temp;
		}
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
	
	public void noDups() {
		System.out.println("Array without dups: ");
		for (int i = 0; i < nElems; i++) {
			for (int j = i + 1; j < nElems; j++) {
                if(a[i] == a[j]){
                    a[j] = 111;
                    delete(a[j]);
                }
            }
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	public void median() {
		insertionSort();
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
		
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(17);
		arr.insert(22);
		arr.insert(88);
		arr.insert(17);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(17);
		arr.insert(33);
		
		arr.display();
		
		arr.noDups();
		
		System.out.println("Sorted array: ");
		arr.insertionSort();
		arr.display();
		
		arr.median();
		
	}

}
