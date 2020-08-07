package boj_java;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class p15664 {
	static int N, M;
	static int arr[];
	static int ans[];
	static ArrayList<int[]> arrList = new ArrayList<>();
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static class MyComp implements Comparator<int[]>{
		public int compare(int[] a1, int [] a2) {
			for(int i=0; i<a1.length; i++) {
				if(a1[i] != a2[i]) return a1[i] - a2[i];
				
			}
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		ans = new int[M];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		comb(0, 0);
		
		Collections.sort(arrList, new MyComp());
		for(int i=0; i<arrList.get(0).length; i++) {
			bf.write(arrList.get(0)[i]+" ");
		}
		bf.write("\n");
		
		for(int i=1; i<arrList.size(); i++) {
			boolean chk = true;
			for(int j=0; j<arrList.get(i).length; j++) {
				if(arrList.get(i)[j] != arrList.get(i-1)[j]) {
					chk = false;
					break;
				}
			}
			
			if(chk) continue;
			for(int j=0; j<arrList.get(i).length; j++) {
				bf.write(arrList.get(i)[j]+" ");
			}
			bf.write("\n");
		}
		
		bf.flush();
		bf.close();
	}
	
	public static void comb(int cnt, int idx) {
		if(cnt == M) {
			int temp[] = Arrays.copyOf(ans, M);
			arrList.add(temp);
			return;
		}
		
		for(int i=idx; i<N; i++) {
			ans[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}

}
