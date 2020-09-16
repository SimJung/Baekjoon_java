import java.util.ArrayList;
import java.util.Scanner;

public class p2239 {
	static int[][] arr = new int[9][9];
	static boolean isEnd = false;
	static ArrayList<int[]> zeroList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<9; i++) {
            String str = sc.next();
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
				if(arr[i][j] == 0) zeroList.add(new int[] {i, j});
			}
		}
		
		sudoku(0);
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void sudoku(int cnt) {
		if(cnt == zeroList.size()) {
			isEnd = true;
			return;
		}
		int i = zeroList.get(cnt)[0];
		int j = zeroList.get(cnt)[1];
		for(int k=1; k<=9; k++) {
			if(isOk(i, j, k)) {
				arr[i][j] = k;
				sudoku(cnt+1);
				if(isEnd) return;
				arr[i][j] = 0;
			}
		}
		
	}
	
	public static boolean isOk(int i, int j, int k) {
		for(int l = 0; l<9; l++) {
			if(arr[i][l] == k || arr[l][j] == k) return false;
		}
		
		int startI = 0;
		int startJ = 0;
		switch(i) {
		case 0:
		case 1:
		case 2:
			startI = 0;
			break;
		case 3:
		case 4:
		case 5:
			startI = 3;
			break;
		case 6:
		case 7:
		case 8:
			startI = 6;
			break;		
		}
		
		switch(j) {
		case 0:
		case 1:
		case 2:
			startJ = 0;
			break;
		case 3:
		case 4:
		case 5:
			startJ = 3;
			break;
		case 6:
		case 7:
		case 8:
			startJ = 6;
			break;		
		}
		
		for(int l = startI; l<startI+3; l++) {
			for(int m = startJ; m<startJ+3; m++) {
				if(arr[l][m] == k) return false;
			}
		}
		
		return true;
	}
}
