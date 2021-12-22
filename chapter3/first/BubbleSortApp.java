package chapter3.first;

/*
 * В программе bubbleSort.java(листинг 3.1) и в приложении BubbleSort Workshop индекс in всегда перемещается слева направо, находит наибольший элемент
 * и перемещает его к позиции out справа. Измените метод bubbleSort() так, чтобы в нём выполнялись двусторонние перемещения, иначе говоря, индекс in сначала, 
 * как и прежде, переносит наибольший элемент слева направо, но затем он меняет направление и переносит наименьший элемент справа налево. Вам понадобятся
 * два внешних индекса: справа(старый индекс out) и слева.
 */

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
	public void bubbleSort() {
		int right = nElems - 1;
		int left = 0;
		
		do {
			for (int in = left; in < right; in++) {	
				if (a[in] > a[in + 1]) {
					swap(in, in + 1);
				}
			}
			right--;
			for (int in = right; in > left; in--) {
				if (a[in] < a[in - 1]) {
					swap(in, in - 1);
				}
			}
			left++;
		} while (right > left);
	}
	
	/*
	 * public void bubbleSort() { int out, in, left;
	 * 
	 * for (out = nElems - 1; out > 1; out--) for (in = 0; in < out; in++) if (a[in]
	 * > a[in + 1]) swap(in, in + 1);
	 * 
	 * for (left = 0; left < nElems - 1; left++) //for (in = 0; in < nElems - left -
	 * 1; in++) for(in = nElems - 1; in > left - 1; in--) if (a[in] < a[in + 1])
	 * swap(in + 1, in); }
	 */
	
	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
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
		
		arr.bubbleSort();
		arr.display();
	}
}
