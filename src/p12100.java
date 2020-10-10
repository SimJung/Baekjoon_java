import java.util.Arrays;
import java.util.Scanner;

public class p12100 {
	public static int N;
	public static int ans;
	public static int delta[][] = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int arr[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		move(arr, 0);
		System.out.println(ans);
	}
	
	public static void move(int[][] arr, int cnt) {
		if(cnt == 5) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] > ans) {
						ans = arr[i][j];
					}
				}
			}
			
		}else {
			for(int d=0; d<4; d++) {
				int newArr[][] = new int[N][];
				for(int i=0; i<N; i++) {
					newArr[i] = Arrays.copyOf(arr[i], N);
				}
				
				switch(d) {
				//위
				case 0:
					for(int j=0; j<N; j++) {
						for(int i=1; i<N; i++) {
							if(newArr[i][j] != 0) {
								for(int k=0; k<i; k++) {
									if(newArr[k][j] == 0) {
										newArr[k][j] = newArr[i][j];
										newArr[i][j] = 0;
										break;
									}
								}
							}
						}
					}
					
					for(int j=0; j<N; j++) {
						int nowVal = newArr[0][j];
						for(int i=1; i<N; i++) {
							if(nowVal != 0 && newArr[i][j] == nowVal) {
								newArr[i-1][j] *= 2;
								for(int k=i; k<N-1; k++) {
									newArr[k][j] = newArr[k+1][j];
								}
								newArr[N-1][j] = 0;
								nowVal = 0;
								i--;
							}else {
								nowVal = newArr[i][j];
							}
						}
					}
					break;
				
				//아래
				case 1:
					for(int j=0; j<N; j++) {
						for(int i=N-2; i>=0; i--) {
							if(newArr[i][j] != 0) {
								for(int k=N-1; k>i; k--) {
									if(newArr[k][j] == 0) {
										newArr[k][j] = newArr[i][j];
										newArr[i][j] = 0;
										break;
									}
								}
							}
						}
					}
					
					for(int j=0; j<N; j++) {
						int nowVal = newArr[N-1][j];
						for(int i=N-2; i>=0; i--) {
							if(nowVal != 0 && newArr[i][j] == nowVal) {
								newArr[i+1][j] *= 2;
								for(int k=i; k>0; k--) {
									newArr[k][j] = newArr[k-1][j];
								}
								newArr[0][j] = 0;
								nowVal = 0;
								i++;
							}else {
								nowVal = newArr[i][j];
							}
						}
					}
					
					
					
					break;
					
				//좌
				case 2:
					for(int i=0; i<N; i++) {
						for(int j=1; j<N; j++) {
							if(newArr[i][j] != 0) {
								for(int k=0; k<j; k++) {
									if(newArr[i][k] == 0) {
										newArr[i][k] = newArr[i][j];
										newArr[i][j] = 0;
										break;
									}
								}
							}
						}
					}
					
					for(int i=0; i<N; i++) {
						int nowVal = newArr[i][0];
						for(int j=1; j<N; j++) {
							if(nowVal != 0 && newArr[i][j] == nowVal) {
								newArr[i][j-1] *= 2;
								for(int k=j; k<N-1; k++) {
									newArr[i][k] = newArr[i][k+1];
								}
								newArr[i][N-1] = 0;
								nowVal = 0;
								j--;
							}else {
								nowVal = newArr[i][j];
							}
						}
					}
					
					
					break;
					
				//우
				case 3:
					for(int i=0; i<N; i++) {
						for(int j=N-2; j>=0; j--) {
							if(newArr[i][j] != 0) {
								for(int k=N-1; k>j; k--) {
									if(newArr[i][k] == 0) {
										newArr[i][k] = newArr[i][j];
										newArr[i][j] = 0;
										break;
									}
								}
							}
						}
					}
					
					for(int i=0; i<N; i++) {
						int nowVal = newArr[i][N-1];
						for(int j=N-2; j>=0; j--) {
							if(nowVal != 0 && newArr[i][j] == nowVal) {
								newArr[i][j+1] *= 2;
								for(int k=j; k>0; k--) {
									newArr[i][k] = newArr[i][k-1];
								}
								newArr[i][0] = 0;
								nowVal = 0;
								j++;
							}else {
								nowVal = newArr[i][j];
							}
						}
					}
					break;
				}
				
				move(newArr, cnt+1);
			}
		}
	}
}