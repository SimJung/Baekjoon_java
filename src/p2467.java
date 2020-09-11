import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2467 {
	static int N, front, end, ansF, ansE, ans;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		front = 0;
		end = N-1;
		ansF = front;
		ansE = end;
		ans = Math.abs(arr[front]+arr[end]);
		
		while(true) {
			if(front+1 == end) break;
			//System.out.println(front+" "+end);
			int diffTempF = Math.abs(arr[front+1]+arr[end]);
			int diffTempE = Math.abs(arr[front]+arr[end-1]);
			if(diffTempF < diffTempE) {
				if(ans > diffTempF) {
					ans = diffTempF;
					ansF = front+1;
					ansE = end;
				}
				front++;
			}else {
				if(ans > diffTempE) {
					ans = diffTempE;
					ansF = front;
					ansE = end-1;
				}
				end--;
			}
		}
		
		System.out.println(arr[ansF]+" "+arr[ansE]);
	}
}
