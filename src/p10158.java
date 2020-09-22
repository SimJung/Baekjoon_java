import java.util.Scanner;

public class p10158 {
	static int W, H, p, q, t, moveI = 1, moveJ = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		p = sc.nextInt();
		q = sc.nextInt();
		t = sc.nextInt();
		
		int ni = q;
		int nj = p;
		int tempT = t % 2*H;
		while(t-- > 0) {
			ni += moveI;
			nj += moveJ;
			if(ni < 0 || ni > H) {
				ni -= moveI;
				moveI *= -1;
				ni += moveI;
			}
			
			if(nj < 0 || nj > W) {
				nj -= moveJ;
				moveJ *= -1;
				nj += moveJ;
			}
		}
		
		System.out.println(nj + " " + ni);
	}

}
