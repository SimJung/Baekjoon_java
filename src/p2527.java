import java.util.Scanner;

public class p2527 {
	static int[] lbx, lby, ltx, lty, rbx, rby, rtx, rty;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
			
			System.out.println(ret());
			
		}
	}
	
	public static char ret() {
		if(lby[0] > lty[1] || lbx[0] > rbx[1] || lby[1] > lty[0] || lbx[1] > rbx[0]) return 'd';
		else if(chk(ltx, lty, rbx, rby) || chk(lbx, lby, rtx, rty)) return 'c';
		else if(ltx[0] == rbx[1] || lty[0] == rby[1] || lby[0] == rty[1] || rbx[0] == lbx[1]) return 'b';
		else return 'a';
	}
	
	public static boolean chk(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
		if(arr1[0] == arr3[1] && arr2[0] == arr4[1])
			return true;
		if(arr1[1] == arr3[0] && arr2[1] == arr4[0])
			return true;
		return false;
	}
}
