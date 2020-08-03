package boj_java;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
public class p10816 {
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n, m, idx = 0;
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		arr = new int[n][2];
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			int bsIdx = bs(temp);
			if(bsIdx == -1) {
				arr[idx][0] = temp;
				arr[idx++][1]++;
			}else {
				arr[bsIdx][1]++;
			}
			
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0]) return 1;
				else if(o1[0] < o2[0]) return -1;
				return 0;
			}
		});
		m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<m; i++) {
			int bsIdx = bs(Integer.parseInt(st.nextToken()));
			System.out.print((bsIdx == -1 ? 0 : arr[bsIdx][1]) + " ");
		}
		System.out.println();
	}
	
	public static int bs(int val) {
		int left = 0, right = arr.length;
		int mid = 0;
		if(arr[left][0] > val || arr[right-1][0] < val)
			return -1;
		while(left < right) {
			mid = (left + right)/2;
			if(arr[mid][0] > val) right = mid-1;
			else if(arr[mid][0] < val) left = mid+1;
			else return mid;
		}
		if(arr[left][0] == val)
			return left;
		if(arr[mid][0] == val)
			return mid;
		
		return -1;
	}
}
