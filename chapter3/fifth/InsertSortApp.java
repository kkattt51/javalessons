package chapter3.fifth;

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
			//copies++;
			in = out;
		
			if (out != in) {
				copies++;
				//comparisons++; 
			}
			while (in > 0) {
				if (!(in > 0)) {
					break;
				}
				if (!(a[in - 1] >= temp)) {
					break;
				}
				//comparisons++;
				copies++;
				a[in] = a[in - 1];
				//copies++;
				comparisons++;
				--in;	
			}
			////comparisons++;
			copies++;
			a[in] = temp;
			copies++;
			comparisons++;
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
		
		arr.insert(0);
		arr.insert(1);
		arr.insert(2);
		arr.insert(3);
		
		arr.insert(4);
		arr.insert(5);
		arr.insert(6);
		
		arr.insert(7);
		arr.insert(8);
		arr.insert(9);
		arr.insert(7);
		
		arr.insert(11);
		arr.insert(12);
		
		arr.insert(13);
		arr.insert(14);
		arr.insert(15);
		arr.insert(16);
		arr.insert(17);
		arr.insert(18);
		arr.insert(19);
		arr.insert(13);
		arr.insert(21);
		arr.insert(22);
		arr.insert(23);
		arr.insert(24);
		//0 1 2 3 4 5 6 7 8 9 7 11 12 13 14 15 16 17 18 19 13 21 22 23 24
		
//		arr.insert(11);
//		arr.insert(00);
//		arr.insert(22);
//		arr.insert(33);
//		arr.insert(44);
//		arr.insert(55);
//		arr.insert(66);
//		arr.insert(77);
//		arr.insert(88);
//		arr.insert(99);
		
		
//		arr.insert(77);
//		arr.insert(99);
//		arr.insert(44);
//		arr.insert(55);
//		arr.insert(22);
//		arr.insert(88);
//		arr.insert(11);
//		arr.insert(00);
//		arr.insert(66);
//		arr.insert(33);
	
		
		arr.display();
		//arr.median();
		
		arr.insertionSort();
		arr.display();
	}

}
