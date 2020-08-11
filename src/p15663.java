
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class p15663 {
	static int[] arr;
	static int[] ans;
	static boolean[] visit;
	static ArrayList<int[]> arrList;
	static int N, M;
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static class MyComp implements Comparator<int []>{
		public int compare(int[] a, int[] b) {
			for(int i=0; i<a.length; i++) {
				if(a[i] != b[i])
					return a[i] - b[i];
			}
			return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visit = new boolean[N];
		arrList = new ArrayList<>();
		ans = new int[M];
		//for(int i=0; i<M; i++) ans.add(0);
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		perm(0);
		
		
		Collections.sort(arrList, new MyComp());
		
		
		for(int i=0; i<arrList.get(0).length; i++) {
			bf.write(arrList.get(0)[i] + " ");
		}
		bf.write("\n");
		
		
		for(int i=1; i<arrList.size(); i++) {
			boolean chk = true;
			for(int j=0; j<arrList.get(i).length; j++) {
				if(arrList.get(i)[j] != arrList.get(i-1)[j])
				{
					chk = false;
					break;
				}
			}
			
			if(chk)
				continue;
			else {
				for(int j=0; j<arrList.get(i).length; j++) {
					bf.write(arrList.get(i)[j] + " ");
				}
				bf.write("\n");
			}
		}
		bf.flush();
		bf.close();
	}
	
	public static void perm(int cnt) {
		if(cnt == M) {
			int temp[] = Arrays.copyOf(ans, M);
			arrList.add(temp);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[cnt] = arr[i];
				perm(cnt+1);
				visit[i] = false;
			}
		}
	}

}
