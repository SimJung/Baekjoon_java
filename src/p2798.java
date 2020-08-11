
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;
public class p2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(sc.nextLine());
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int ans = 0;
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int k = j+1; k<n; k++) {
					int sum = arr[i]+arr[j]+arr[k];
					if(sum <= m && m-ans > m-sum) {
						ans = sum;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
