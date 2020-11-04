import java.util.ArrayList;
import java.util.Scanner;

public class p2564 {
	public static class Info{
		public int d;
		public int p;
		public Info(int d, int p) {
			super();
			this.d = d;
			this.p = p;
		}
	}
	public static int W, H, N, ans;
	public static ArrayList<Info> stores = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		N = sc.nextInt();
		for(int i=0; i <N; i++) {
			stores.add(new Info(sc.nextInt(), sc.nextInt()));
		}
		
		int d = sc.nextInt();
		int pos = sc.nextInt();
		switch(d) {
		case 1:
			break;
			
		case 2:
			pos = W + H + (W - pos);
			break;
			
		case 3:
			pos = 2*W + H + (H - pos);
			break;
			
		case 4:
			pos += W;
			break;
			
		}
		for(int i=0; i<N; i++) {
			int sp = stores.get(i).p;
			switch(stores.get(i).d) {
			case 1:
				break;
				
			case 2:
				sp = W + H + (W - sp);
				break;
				
			case 3:
				sp = 2*W + H + (H - sp);
				break;
				
			case 4:
				sp += W;
				break;
				
			}
			ans += Math.min(Math.abs(sp-pos), Math.abs(Math.abs(sp-pos) - W*2 - H*2));
		}
		
		System.out.println(ans);
	}
	/*
	static int N, M, S, dI, dJ, sum;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		S = sc.nextInt();
		arr = new int[S][2];
		for(int i=0; i<S; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		dI = sc.nextInt();
		dJ = sc.nextInt();
		for(int i=0; i<S; i++) {
				int num = 0;
				//북 남 서 동 1 2 3 4
				switch(dI) {
				case 1:
					if(arr[i][0] == 1) {
						if(arr[i][1] > dJ) {
							num = (arr[i][1]-dJ > dJ+M*2+N+N-arr[i][1] 
									? dJ+M*2+N+N-arr[i][1] 
									: arr[i][1]-dJ );
						}else {
							num = (dJ - arr[i][1] > N-dJ+M*2+N+arr[i][1] 
									? N-dJ+M*2+N+arr[i][1] 
									: dJ - arr[i][1]);
						}
					}else if(arr[i][0] == 2) {
						num = (dJ + M + arr[i][1] > N-dJ + M + N-arr[i][1] 
								? N-dJ + M + N-arr[i][1] 
								: dJ + M + arr[i][1]);
					}else if(arr[i][0] == 3) {
						num = (dJ + arr[i][1] > N-dJ + M + N + M-arr[i][1] 
								? N-dJ + M + N + M-arr[i][1]
								: dJ + arr[i][1]);
					}else {
						num = (N - dJ + arr[i][1] > dJ + M + N + M-arr[i][1] 
								? dJ + M + N + M-arr[i][1] 
								: N - dJ + arr[i][1]);
					}
					break;
					
				case 2:
					if(arr[i][0] == 1) {
						num = (dJ + M + arr[i][1] > N-dJ + M + N-arr[i][1] 
								? N-dJ + M + N-arr[i][1] 
								: dJ + M + arr[i][1]);
					}else if(arr[i][0] == 2) {
						if(arr[i][1] > dJ) {
							num = (arr[i][1]-dJ > dJ+M*2+N+N-arr[i][1] 
									? dJ+M*2+N+N-arr[i][1] 
									: arr[i][1]-dJ);
						}else {
							num = (dJ - arr[i][1] > N-dJ+M*2+N+arr[i][1] 
									? N-dJ+M*2+N+arr[i][1] 
									: dJ - arr[i][1]);
						}
					}else if(arr[i][0] == 3) {
						num = (dJ + M - arr[i][1] > N-dJ + M + N + arr[i][1] 
								? N-dJ + M + N + arr[i][1] 
								: dJ + M - arr[i][1]);
					}else {
						num = (N - dJ + M - arr[i][1] > dJ + M + N + arr[i][1] 
								? dJ + M + N + arr[i][1] 
								: N - dJ + M - arr[i][1]);
					}
					break;
					
				case 3:
					if(arr[i][0] == 1) {
						num = (dJ + arr[i][1] > M-dJ + N + M + N-arr[i][1] 
								? M-dJ + N + M + N-arr[i][1] 
								: dJ + arr[i][1]);
					}else if(arr[i][0] == 2) {
						num = (M-dJ + arr[i][1] > dJ + N + M + N-arr[i][1] 
								? dJ + N + M + N-arr[i][1] 
								: M-dJ + arr[i][1]);
					}else if(arr[i][0] == 3) {
						if(arr[i][1] > dJ) {
							num = (arr[i][1]-dJ > dJ+N*2+M+M-arr[i][1] 
									? dJ+N*2+M+M-arr[i][1] 
									: arr[i][1]-dJ);
						}else {
							num = (dJ-arr[i][1] > M-dJ+N*2+M+arr[i][1] 
									? M-dJ+N*2+M+arr[i][1] 
									: dJ-arr[i][1]);
						}
					}else {
						num = (dJ + N + arr[i][1] > M - dJ + N + M - arr[i][1] 
								? M - dJ + N + M - arr[i][1]
								: dJ + N + arr[i][1]);
					}
					break;
	
				case 4:
					if(arr[i][0] == 1) {
						num = (dJ + N - arr[i][1] > M-dJ + N + M + arr[i][1] 
								? M-dJ + N + M + arr[i][1] 
								: dJ + N - arr[i][1]);
					}else if(arr[i][0] == 2) {
						num = (M-dJ + N - arr[i][1] > dJ + N + M + arr[i][1] 
								?dJ + N + M + arr[i][1] 
								: M-dJ + N - arr[i][1]);
					}else if(arr[i][0] == 3) {
						num = (dJ + N + arr[i][1] > M - dJ + N + M - arr[i][1] 
								? M - dJ + N + M - arr[i][1]
								: dJ + N + arr[i][1]);
					}else {
						if(arr[i][1] > dJ) {
							num = (arr[i][1]-dJ > dJ+N*2+M+M-arr[i][1] 
									? dJ+N*2+M+M-arr[i][1] 
									: arr[i][1]-dJ);
						}else {
							num = (dJ-arr[i][1] > M-dJ+N*2+M+arr[i][1] 
									? M-dJ+N*2+M+arr[i][1] 
									: dJ-arr[i][1]);
						}
						
					}
					break;
				}
				
				sum += num;
		}
		System.out.println(sum);
	}
	
	*/
}
