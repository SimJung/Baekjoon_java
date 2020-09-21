import java.util.Scanner;

public class p2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] lbx, lby, ltx, lty, rbx, rby, rtx, rty;
		lbx = new int[2];
		lby = new int[2];
		ltx = new int[2];
		lty = new int[2];
		rbx = new int[2];
		rby = new int[2];
		rtx = new int[2];
		rty = new int[2];
		
		for(int tc=0; tc<4; tc++) {
			for(int i=0; i<2; i++) {
				lbx[i] = sc.nextInt();
				lby[i] = sc.nextInt();
				rtx[i] = sc.nextInt();
				rty[i] = sc.nextInt();
				
				ltx[i] = lbx[i];
				lty[i] = rty[i];
				rbx[i] = rtx[i];
				rby[i] = lby[i];
			}
			
			if()
			
		}
	}
}
