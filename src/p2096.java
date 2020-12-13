import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2096 {
	public static int N, arr[][], maxDp[][], minDp[][], delta[] = {-1, 0, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		maxDp = new int[N][3];
		minDp = new int[N][3];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<3; i++) {
			maxDp[0][i] = arr[0][i];
			minDp[0][i] = arr[0][i];
		}
		 
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				maxDp[i][j] = maxDp[i-1][j] + arr[i][j];
				minDp[i][j] = minDp[i-1][j] + arr[i][j];
				for(int d=0; d<3; d++) {
					int nj = j + delta[d];
					
					if(nj < 0 || nj >= 3) continue;
					
					maxDp[i][j] = (maxDp[i-1][nj] + arr[i][j] > maxDp[i][j] ? maxDp[i-1][nj] + arr[i][j] : maxDp[i][j]);
					minDp[i][j] = (minDp[i-1][nj] + arr[i][j] < minDp[i][j] ? minDp[i-1][nj] + arr[i][j] : minDp[i][j]);
					
				}
			}
			
		}
		
		int maxVal = maxDp[N-1][0];
		int minVal = minDp[N-1][0];
		for(int i=0; i<3; i++) {
			if(maxVal < maxDp[N-1][i]) maxVal = maxDp[N-1][i];
			if(minVal > minDp[N-1][i]) minVal = minDp[N-1][i];
		}
		
		System.out.println(maxVal + " " + minVal);
	}

}
