import java.util.Scanner;

public class p1244 {
	static int N, arr[], num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		num = sc.nextInt();
		for(int i=0; i<num; i++) {
			int chk = sc.nextInt();
			int sn = sc.nextInt();
			
			if(chk == 1) {
				for(int j=sn; j<=N; j+=sn) {
					arr[j] = (arr[j] == 1 ? 0 : 1);
				}
			}else {
				arr[sn] = (arr[sn] == 1 ? 0 : 1);
				for(int j=1; j<=N; j++) {
					if(sn-j <= 0 || sn+j > N || arr[sn-j] != arr[sn+j]) break;
					arr[sn+j] = (arr[sn+j] == 1 ? 0 : 1);
					arr[sn-j] = (arr[sn-j] == 1 ? 0 : 1);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i]+" ");
			if(i % 20 == 0) System.out.println();
		}
	}

}
