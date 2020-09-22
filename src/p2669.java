import java.util.Scanner;

public class p2669 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mini=1000, minj=1000, maxi=0, maxj=0;
		boolean arr[][] = new boolean[105][105];
		for(int i=0; i<4; i++) {
			int li, lj, ri, rj;
			lj = sc.nextInt();
			li = sc.nextInt();
			rj = sc.nextInt();
			ri = sc.nextInt();
			
			if(mini > li) mini = li;
			if(minj > lj) minj = lj;
			if(maxi < ri) maxi = ri;
			if(maxj < rj) maxj = rj;
			
			for(int j=li; j<ri; j++) {
				for(int k=lj; k<rj; k++) {
					arr[j][k] = true;
				}
			}
		}
		
		int sum = 0;
		for(int i=mini; i<maxi; i++) {
			for(int j=minj; j<maxj; j++) {
				if(arr[i][j]) sum++;
				//System.out.print(arr[i][j] ? 1 : 0);
			}
			//System.out.println();
		}
		
		System.out.println(sum);
	}

}
