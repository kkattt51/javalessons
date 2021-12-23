package chapter3.fifth;

import javax.print.attribute.standard.Copies;

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
		
		int copies = 0;
		int comparisons = 0;
		
		for (out = 1; out < nElems; out++) {
			long temp = a[out];
			copies++;
			in = out;
		
//			if (out != in) {
//				comparisons++; 
//			}
			while (true) {
				if (!(in > 0)) {
					break;
				}
				if (!(a[in - 1] >= temp)) {
					break;
				}
				comparisons++;
				a[in] = a[in - 1];
				copies++;
				--in;	
			}
			comparisons++;
			a[in] = temp;
			copies++;
		}
		System.out.println("copies " + copies);
		System.out.println("comparisons " + comparisons);
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
		
//		arr.insert(00);
//		arr.insert(11);
//		arr.insert(22);
//		arr.insert(33);
//		arr.insert(44);
//		arr.insert(55);
//		arr.insert(66);
//		arr.insert(77);
//		arr.insert(88);
//		arr.insert(99);
		
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
		//arr.median();
		
		arr.insertionSort();
		arr.display();
	}

}
