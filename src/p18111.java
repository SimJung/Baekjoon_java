
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class p18111 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n, m, b, minVal=Integer.MAX_VALUE, maxVal=-1, height=0;
		long time=Integer.MAX_VALUE;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(minVal > arr[i][j]) minVal = arr[i][j];
				if(maxVal < arr[i][j]) maxVal = arr[i][j];
			}
		}
		
		for(int i=maxVal; i>=minVal; i--) {
			long tempB = b, tempTime=0;
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(i > arr[j][k]) {
						tempB -= Math.abs(i-arr[j][k]);
						tempTime += Math.abs(i-arr[j][k]);
					}else if(i < arr[j][k]) {
						tempTime += Math.abs(arr[j][k]-i)*2;
					}else {
						continue;
					}
				}
			}
			if(tempB < 0) break;
			if(time > tempTime) {
				time = tempTime;
				height = i;
			}
		}
		System.out.println(time+" "+height);
		
	}

}
