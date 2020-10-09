import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3042 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int arr[][] = new int[26][2];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				if(s.charAt(j) != '.') {
					arr[cnt][0] = i;
					arr[cnt][1] = j;
					cnt++;
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<cnt-2; i++) {
			for(int j=i+1; j<cnt-1; j++) {
				for(int k=j+1; k<cnt; k++) {
					int jy = arr[j][1] - arr[i][1];
					int jx = arr[j][0] - arr[i][0];
					int ky = arr[k][1] - arr[i][1];
					int kx = arr[k][0] - arr[i][0];
					
					if(jy * kx == jx * ky) {
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);
	}

}
