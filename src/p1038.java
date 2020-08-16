import java.util.Scanner;
public class p1038 {
	static int[][] dp = new int[10][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp[0][0] = 1;
		for(int i=0; i<10; i++) {
			if(i == 0) {
				for(int j=1; j<10; j++) {
					dp[i][j] = dp[i][j-1]+1;	
				}	
			}else {
				dp[i][0] = dp[i-1][10-i]+1;
				for(int j=1; j<10-i; j++) {
					dp[i][j] = dp[i][j-1]+dp[i-1][j];
				}
			}
		}
		
		long start=0;
		int startIdx;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10-i; j++) {
				if(dp[i][j]-1 >= n) {
					startIdx = dp[i][j]-1;
					start += j;
					int idx = j+1;
					for(int k=0; k<i; k++) {
						start += (long)Math.pow(10, k+1)*idx++;
					}
					
					while(startIdx != n) {
						start--;
						if(!isDVal(start)) start= makeDVal(start);
						startIdx--;
					}
					
					System.out.println(start);
					return ;
				}
			}
		}
		
		System.out.println("-1");
	}
	
	static boolean isDVal(long n) {
		String n_str = String.valueOf(n);
		for(int i=1; i<n_str.length(); i++) {
			if(n_str.charAt(i-1) <= n_str.charAt(i)) return false;
		}
		return true;
	}
	
	static long makeDVal(long n) {
		StringBuilder n_str = new StringBuilder(String.valueOf(n));
		
		for(int i=1; i<n_str.length(); i++) {
			if(i>=2 && i != n_str.length()-1 && n_str.charAt(i) == '0') {
				n_str.replace(i-1, i, String.valueOf((n_str.charAt(i-2)-'0')-1));
			}
			if(n_str.charAt(i-1) <= n_str.charAt(i)) n_str.replace(i, i+1, String.valueOf((n_str.charAt(i-1)-'0')-1));
		}
		return Long.parseLong(n_str.toString());
	}
}
