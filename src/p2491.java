import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2491 {
	static int upArr[], downArr[], arr[], N, result = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		upArr = new int[N];
		downArr = new int[N];
		
		arr[0] = Integer.parseInt(st.nextToken());
		upArr[0] = 1;
		downArr[0] = 1;
		for(int i=1; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > arr[i-1]) {
				upArr[i] = upArr[i-1]+1;
				downArr[i] = 1;
			}else if(arr[i] < arr[i-1]) {
				downArr[i] = downArr[i-1]+1;
				upArr[i] = 1;	
			}else {
				upArr[i] = upArr[i-1]+1;
				downArr[i] = downArr[i-1]+1;
			}
			if(result < upArr[i]) result = upArr[i];
			if(result < downArr[i]) result = downArr[i];
		}
		
		System.out.println(result);
	}

}
