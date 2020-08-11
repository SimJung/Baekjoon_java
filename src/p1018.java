
import java.util.Scanner;
public class p1018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		n = sc.nextInt();
		m = sc.nextInt();
		
		char[][] arr = new char[n][];
		for(int i =0; i<n; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		char now = arr[0][0];
		int ans = 81, temp = 0;
		
		for(int k=0; k<n-7; k++) {
			for(int l = 0; l<m-7; l++) {
				temp = 0;
				for(int i=k; i<k+8; i++) {
					for(int j=l; j<l+8; j++) {
						if(arr[i][j] != now)temp++;
						now = (now == 'W' ? 'B' : 'W');
					}
					now = (now == 'W' ? 'B' : 'W');
				}
				if(ans > temp) ans = temp;
			}
		}
		
		
		
		
		now = (arr[0][0] == 'W' ? 'B' : 'W');
		for(int k=0; k<n-7; k++) {
			for(int l = 0; l<m-7; l++) {
				temp = 0;
				for(int i=k; i<k+8; i++) {
					for(int j=l; j<l+8; j++) {
						if(arr[i][j] != now)temp++;
						now = (now == 'W' ? 'B' : 'W');
					}
					now = (now == 'W' ? 'B' : 'W');
				}
				if(ans > temp) ans = temp;
			}
		}
		
		if(ans > temp) ans = temp;
		System.out.println(ans);
	}

}
