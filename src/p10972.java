import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p10972 {
	static int arr[];
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(np()) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}else {
			System.out.println("-1");
		}
	}
	
	public static boolean np() {
		int i = arr.length-1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		
		if(i == 0) return false;
		
		int j = arr.length-1;
		while(arr[i-1] >= arr[j]) j--;
		
		swap(i-1, j);
		
		int k = arr.length-1;
		while(i < k) swap(i++, k--);
		
		return true;
		
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
