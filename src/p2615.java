import java.util.Scanner;
public class p2615 {
	static int delta[][] = {
			{0, 1},	//오른쪽	
			{1, 1},	//오른쪽 아래 대각선	
			{1, 0},	//아래쪽	
			{-1, 1}	//오른쪽 위 대각선	
	};
	
	static final int sz = 19;
	static int arr[][] = new int[sz][sz];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<sz; i++) {
			for(int j=0; j<sz; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<sz; i++) {
			for(int j=0; j<sz; j++) {
				if(arr[i][j] != 0) {
					if(canWin(i, j)) {
						System.out.println(arr[i][j]);
						System.out.println((i+1) + " " + (j+1));
						return ;
					}
				}
			}
		}
		
		System.out.println("0");
	}
	
	public static boolean canWin(int startI, int startJ) {
		int stone = arr[startI][startJ];
		for(int i=0; i<4; i++) {
			int ni = startI;
			int nj = startJ;
			boolean tempAns = true;
			
			for(int j=0; j<4; j++) {
				ni += delta[i][0];
				nj += delta[i][1];
				
				if(ni < 0 || ni >= sz || nj < 0 || nj >= sz || arr[ni][nj] != stone)
				{
					tempAns = false;
					break;
				}
				
				if(j == 3) {
					ni += delta[i][0];
					nj += delta[i][1];
					if(ni < 0 || ni >= sz || nj < 0 || nj >= sz)
						break;
					
					if(arr[ni][nj] == stone) {
						tempAns = false;
						break;
					}
				}
			}
			
			if(tempAns) {
				ni = startI - delta[i][0];
				nj = startJ - delta[i][1];
				if(ni < 0 || ni >= sz || nj < 0 || nj >= sz)
					return true;
				
				else if(arr[ni][nj] != stone) {
					return true;
				}
			}
		}
		
		return false;
	}

}
