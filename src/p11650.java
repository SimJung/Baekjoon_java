
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;
public class p11650 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if(a[0] > b[0]) return 1;
				else if(a[0] < b[0]) return -1;
				else {
					if(a[1] > b[1]) return 1;
					else if(a[1] < b[1]) return -1;
				}
				return 0;
			}
		});
		
		for(int i=0; i<N; i++)
			System.out.println(arr[i][0] + " " + arr[i][1]);
	}

}
