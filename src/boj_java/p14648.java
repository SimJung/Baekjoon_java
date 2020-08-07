package boj_java;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class p14648 {
	static long arr[];
	static int N, q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		st = new StringTokenizer(bf.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<q; i++) {
			int qu, a, b, c, d;
			st = new StringTokenizer(bf.readLine());
			qu = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			switch(qu){
			case 1:
				System.out.println(sum(a, b, true));
				break;
			case 2:
				c = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				
				System.out.println(sum(a,b,false) - sum(c,d,false));
				
				break;
			}
		}
	}
	
	public static long sum(int a, int b, boolean isSwap) {
		long temp, ret;
		if(a == b) {
			if(a == 1) {
				ret = arr[a-1];
			}else {
				ret = arr[a-1] - arr[a-2];
			}
			
		}else {
			if(a == 1) {
				ret = arr[b-1];
				temp = arr[a-1];
				
			}else {
				ret = arr[b-1] - arr[a-2];
				temp = arr[a-1] - arr[a-2];
			}
			
			if(isSwap) {
				temp = arr[b-1] - arr[b-2] - temp;
				for(int j = a-1; j<b-1; j++) {
					arr[j] += temp;
				}
			}
		}
		
		return ret;
	}

}
