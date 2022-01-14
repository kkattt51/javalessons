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
//		int in, out;
//		
//		for (out = 1; out < nElems; out++) {
//			long temp = a[out];
//			in = out;
//			while (in > 0 && temp <= a[in - 1]) {
//			    if(temp == a[in - 1]) {
//			    	temp = -1;
//			    }
//			    if (a[in - 1] > temp) {
//			    	a[in] = a[in - 1];
//				    in--;
//			    }
//			    else {
//					break;
//				}
//			    a[in] = temp;
//			}
//		}
//		int in, out;
//		int lastNeg = -1;
//		int dupsCount = 0;
//		for (out = 1; out < nElems; out++) {
//			long temp = a[out];
//			in = out;
//			while (in > 0 && temp <= a[in - 1]) {
//			    if(temp == a[in - 1]) {
//			    	temp = -10;
//			    	lastNeg = in;
//			    	
//			    	dupsCount++;
//			    } 
//			    if (a[in - 1] > temp) {
//			    	a[in] = a[in - 1];
//				    in--;
////			    	a[in - (lastNeg + 1)] = a[in];
////					in--;
//				} else {
//					break;
//				}
//			    
////			    if (a[in - 1] > temp) {
////			    	a[in] = a[in - 1];
////				    in--;   
////			    }
//			    a[in] = temp; 
//			    for (int i = 0; i < nElems; i++) {
//					a[i] = a[lastNeg + 1];
//					
//				}
//			    nElems= nElems - lastNeg;
//			}	
//			//nElems = lastNeg - dupsCount;
//		}
//		int in, out;
//		int nDups = 0;
//	
//		for (out = 1; out < nElems; out++) {
//			long temp = a[out];
//		  	in = out;
//		  	while(in > 0 && a[in - 1] >= temp) {
//		  		if (a[in - 1] == temp) {
//					temp = -2;
//					nDups++;
//				}
//		  		if (a[in - 1] >= temp) {
//		  			a[in] = a[in - 1];
//		  			--in;
//		  		} else {
//					break;
//				}
//		  	}	
//		  	a[in] = temp;
//		}
		int in, out;
		int nDups = 0;
		int j = -1;
		for (out = 1; out < nElems; out++) {
			long temp = a[out];
			in = out;
			if (out != in) {
				nDups++; 
			}
			while (in > 0) {
				if (!(in > 0)) {
					break;
				}
				if (!(a[in - 1] >= temp)) {
					break;
				}
				if (a[in - 1] == temp) {
					temp = -2;
					if (a[in - 1] == - 2) {
						j = in;
						nDups++;
						j++;
					}
				}
				a[in] = a[in - 1];
				--in;	
			}
			//copies++;
			a[in] = temp;
			
		}
		display();
		
		System.out.println("lastNegative: " + j);
		System.out.println("Dups count: " + nDups);
		//int j = -1;
		if (nDups != 0) {
		   for (int i = nDups; i < nElems; i++) {
				a[i - nDups] = a[i];
			}
		}
		nElems -= nDups;
		
		//System.out.println("lastNegative: " + lastNeg);
		//System.out.println("Dups count:" + dupsCount);
		//display();
		
//		System.out.println("Array without dups:");
//		int j = -1;
//    	for (int i = 0; i < nElems; i++) {
//    		if(a[i] == -10) {
//    			j = i;
//        	} else {
//        		a[i - (j + 1)] = a[i];
//        	}
//    	}
//    	nElems = nElems - j - 1;
//    	System.out.println("lastNegative:" + j);
		
		//System.out.println("Dups count:" +);
//		System.out.println("Array without dups:");
//		int key = 0, dups = 0;
//	    for (int i = 0; i < nElems; i++) {
//	        while(key < nElems) {
//	            if(a[key] == -10) {
//	                key++;
//	                dups++;
//	            } else {
//	                a[i++] = a[key];
//	                //i++;
//	                key++; 
//	            }
//	        }
//	    }
//	    nElems = nElems - dups;
//	    System.out.println("lastNegativeKey: " + key);
//		System.out.println("Dups count dups: " + dups);
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

