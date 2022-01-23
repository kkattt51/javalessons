package chapter5.sixth;

class Link {
	public int iData;
	public Link next;
	public Link previous;
//---------------------------------------------------------------------
	public Link(int d) {
		iData = d;
	}
	public int getiData() {
		return iData;
	}
	public void setiData(int iData) {
		this.iData = iData;
	}
	
	public Link getNext() {
		return next;
	}
	public void setNext(Link next) {
		this.next = next;
	}
	
	public Link getPrevious() {
		return previous;
	}
	public void setPrevious(Link previous) {
		this.previous = previous;
	}
//---------------------------------------------------------------------
	public void displayLink() {
		System.out.print(iData + " ");
	}
//---------------------------------------------------------------------
}
class Row {
	private int col;
	private Link start;

	public Row(int col) {
		this.col = col;

		generateRow();
	}

	private void generateRow() {

		Link newLink = new Link(-1);
		start = newLink;
		Link p = start;
		
		while(col > 1) {
			Link newN = new Link(-1); 
			p.next = newN;
			p = newN;
			col--;
		}
	}

	public Link getStart() {
		return start;
	}
}


class Matrix {
	private int n; //row
	private int m; //col
	private Row[] r;
	private Link start;

	public Matrix(int n, int m) {
		this.n = n;
		this.m = m;
		start = null;
		r = new Row[n];

		check();
		generateMatix();
	}

	private void check() {
		if(n <= 0 || m <= 0) {
			System.out.println("Value of 'n' & 'm' must be greater than 0");
			System.exit(0);
		}
	}

	private void generateMatix() {

		for(int i = 0; i < n; i++) {
			r[i] = new Row(m);
		}

		start = r[0].getStart();

		for(int i = 0; i < n - 1; i++) {
			Link p1 = r[i].getStart();
			Link p2 = r[i + 1].getStart();

			for(int j = 0; j < m; j++) {
				p1.previous = p2;
				p1 = p1.next;
				p2 = p2.next;
			}
		}
	}

	public void insert (int x, int y, int data) {
		Link cell = start;
		int col = y;

		if(x > n || y > m || x <= 0 || y <= 0) {
			System.out.println("(x,y) such that 0 < x < "+ n + " and 0 < y < " + m + ".");
			return;
		}

		for(int row = 1; row < x; row++) {
			cell = cell.previous;
		}

		while(col > 1) {
			cell = cell.next;
			col--;
		}

		cell.iData = data;
	}

	public void display() {
		Link row = start;

		while(row != null) {
			Link cell = row;
			while(cell != null) {
				System.out.print(cell.iData + " ");
				cell = cell.next;
			}
			System.out.println();
			row = row.previous;
		}

		System.out.println();
	}
}

class MatrixApp {
	public static void main(String[] args) {
		Matrix m = new Matrix(7,10);
		m.display(); //Empty 

		//Value filling
		m.insert(1, 1, 11);
		m.insert(1, 2, 12);
		m.insert(1, 3, 13);
		m.insert(1, 4, 14);
		m.insert(1, 5, 15);
		m.insert(1, 6, 16);
		m.insert(1, 7, 17);
		m.insert(1, 8, 18);
		m.insert(1, 9, 19);
		m.insert(1, 10, 20);
		
		m.insert(2, 1, 21);
		m.insert(2, 2, 22);
		m.insert(2, 3, 23);
		m.insert(2, 4, 24);
		m.insert(2, 5, 25);
		m.insert(2, 6, 26);
		m.insert(2, 7, 27);
		m.insert(2, 8, 28);
		m.insert(2, 9, 29);
		m.insert(2, 10, 30);
		
		m.insert(3, 1, 31);
		m.insert(3, 2, 32);
		m.insert(3, 3, 33);
		m.insert(3, 4, 34);
		m.insert(3, 5, 35);
		m.insert(3, 6, 36);
		m.insert(3, 7, 37);
		m.insert(3, 8, 38);
		m.insert(3, 9, 39);
		m.insert(3, 10, 40);
		
		m.insert(4, 1, 41);
		m.insert(4, 2, 42);
		m.insert(4, 3, 43);
		m.insert(4, 4, 44);
		m.insert(4, 5, 45);
		m.insert(4, 6, 46);
		m.insert(4, 7, 47);
		m.insert(4, 8, 48);
		m.insert(4, 9, 49);
		m.insert(4, 10, 50);
		
		m.insert(5, 1, 51);
		m.insert(5, 2, 52);
		m.insert(5, 3, 53);
		m.insert(5, 4, 54);
		m.insert(5, 5, 55);
		m.insert(5, 6, 56);
		m.insert(5, 7, 57);
		m.insert(5, 8, 58);
		m.insert(5, 9, 59);
		m.insert(5, 10, 50);
		
		m.insert(6, 1, 61);
		m.insert(6, 2, 62);
		m.insert(6, 3, 63);
		m.insert(6, 4, 64);
		m.insert(6, 5, 65);
		m.insert(6, 6, 66);
		m.insert(6, 7, 67);
		m.insert(6, 8, 68);
		m.insert(6, 9, 69);
		m.insert(6, 10, 70);
		
		m.insert(7, 1, 71);
		m.insert(7, 2, 72);
		m.insert(7, 3, 73);
		m.insert(7, 4, 74);
		m.insert(7, 5, 75);
		m.insert(7, 6, 76);
		m.insert(7, 7, 77);
		m.insert(7, 8, 78);
		m.insert(7, 9, 79);
		m.insert(7, 10, 80);
		m.display(); //After filling
	}
}