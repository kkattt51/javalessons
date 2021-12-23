package chapter3.fourth;

class ArrayBub {
	private long[] a;
	private int nElems;
	
	public ArrayBub(int max) {
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
	
	public void oddEvenSort() {
	    for (int i = 0; i < nElems; i++) {
	        if (i % 2 == 0) {
	        // нечетная итерация
	            for (int j = 0; j <= nElems - 2; j = j + 2) { 
	                // условие j <= nElems - 2 нужно чтобы a[j+1] не выходило за 
	                // пределы массива (не больше nElems-1)
	                // j = j + 2 для перехода к следующей паре для сравнения
	                swap(j, j + 1);
	                // если левый элемент больше, меняем местами
	            }
	        }
	        else 
	        // четная итерация
	        {       
	            for (int j = 1; j <= nElems - 2; j = j + 2) {
	                swap(j, j + 1);
	            }
	        }
	    }
	}
	
//	public void bubbleSort() {
//		int right = nElems - 1;
//		int left = 0;
//		
//		do {
//			for (int in = left; in < right; in++) {	
//				if (a[in] > a[in + 1]) {
//					swap(in, in + 1);
//				}
//			}
//			right--;
//			for (int in = right; in > left; in--) {
//				if (a[in] < a[in - 1]) {
//					swap(in, in - 1);
//				}
//			}
//			left++;
//		} while (right > left);
//	}
	
//	public void bubbleSort() {
//		int out, in, left;
//		
//		for (out = nElems - 1; out > 1; out--) 
//			for (in = 0; in < out; in++) 
//				if (a[in] > a[in + 1]) 
//					swap(in, in + 1);	
//				
//		for (left = 0; left < nElems - 1; left++) 
//			//for (in = 0; in < nElems - left - 1; in++)
//			for(in = nElems - 1; in > left - 1; in--)
//				if (a[in] < a[in + 1]) 
//					swap(in + 1, in);
//	}
	
	private void swap(int one, int two) {
		if(a[one] > a[two])
	    {
	        long temp = a[one];
	        a[one] = a[two];
	        a[two] = temp;
	    }
	}
}

public class BubbleSortApp {

	public static void main(String[] args) {
		int maxSize = 100;
		ArrayBub arr;
		arr = new ArrayBub(maxSize);
		
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
		arr.oddEvenSort();
		//arr.bubbleSort();
		arr.display();
	}
}

