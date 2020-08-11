
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class p15655 {
	static int arr[];
	static int n, m;
	static int ans[];
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[m];
		
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		comb(0, 0);
		bf.flush();
		bf.close();
	}
	
	public static void comb(int cnt, int idx) throws IOException{
		if(cnt == m)
		{
			for(int i=0; i<cnt; i++)
				bf.write(ans[i] + " ");
				bf.write("\n");
			return ;
		}
		
		for(int i=idx; i<n-m+cnt+1; i++) {
			ans[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
}
