
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class p18111 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n, m, b, minVal=1000, maxVal=-1, time=2000000001, height=0;
		
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
			int tempB = b, tempTime=0;
			boolean enoughBlock = true;
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(i > arr[j][k]) {
						if(i - arr[j][k] <= tempB) {
							tempB -= (i-arr[j][k]);
							tempTime += (i-arr[j][k]);
						}else {
							enoughBlock = false;
							break;
						}
					}else if(i < arr[j][k]) {
						tempTime += (arr[j][k]-i)*2;
					}
				}
				if(!enoughBlock) break;
			}
			if(enoughBlock && time > tempTime) {
				time = tempTime;
				height = i;
			}
		}
		System.out.println(time+" "+height);
		
	}

}
