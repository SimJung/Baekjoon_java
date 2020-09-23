import java.util.Scanner;

public class p2999 {
	public static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R=1, C=1;
		StringBuilder sb = new StringBuilder(sc.next());
		for(int i = (int)Math.sqrt(sb.length()); i>0; i--) {
			if(sb.length()%i == 0) {
				R = i;
				C = sb.length()/R;
				break;
			}
		}
		
		arr = new char[R][C];
		int idx = 0;
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				arr[j][i] = sb.charAt(idx++);
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(arr[i][j]);
			}
		}
		System.out.println();
	}

}
