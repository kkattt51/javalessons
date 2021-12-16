package chapter2.sixth;

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
	
	public void noDups() {
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
}

public class HighArrayApp {

	public static void main(String[] args) {
		int maxSize = 100;
		HighArray arr;
		arr = new HighArray(maxSize);
		
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(17);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(17);
		arr.insert(11);
		arr.insert(00);
		arr.insert(17);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();
		arr.noDups();
		
		int searchKey = 35;
		if (arr.find(searchKey)) 
			System.out.println("Found " + searchKey);
		else 
			System.out.println("Cannot find " + searchKey);
		
		arr.delete(00);
		arr.delete(55);
		arr.delete(99);
		
		arr.display();
	}
}
