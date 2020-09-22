import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class p2628 {
	static class Square implements Comparable<Square>{
		public int lx;
		public int ly;
		public int rx;
		public int ry;
		
		public int width;
		public int height;
		
		public Square(int lx, int ly, int rx, int ry) {
			super();
			this.lx = lx;
			this.ly = ly;
			this.rx = rx;
			this.ry = ry;
			width = (rx - lx);
			height = (ry - ly);
		}

		public int compareTo(Square s) {
			return s.height*s.width - width*height;
		}
		
		public int getArea() {
			return width*height;
		}
		
		public boolean isP(int p, int n) {
			if(p == 0) {
				if(n > ly && n < ry) return true;
			}else {
				if(n > lx && n < rx) return true;
			}
			return false;
		}
	}
	static int W, H, n;
	static ArrayList<Square> arr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		n = sc.nextInt();
		arr.add(new Square(0, 0, W, H));
		for(int i=0; i<n; i++) {
			int p = sc.nextInt();
			int num = sc.nextInt();
			int sz = arr.size(), idx = 0;
			for(int j=0; j<sz; j++) {
				Square s = arr.get(idx);
				if(s.isP(p, num)) {
					if(p == 0) {
						arr.add(new Square(s.lx, s.ly, s.rx, num));
						arr.add(new Square(s.lx, num, s.rx, s.ry));
						arr.remove(idx);
						idx--;
					}else {
						arr.add(new Square(s.lx, s.ly, num, s.ry));
						arr.add(new Square(num, s.ly, s.rx, s.ry));
						arr.remove(idx);
						idx--;
					}
				}
				idx++;
			}
		}
		Collections.sort(arr);
		System.out.println(arr.get(0).getArea());
	}

}
