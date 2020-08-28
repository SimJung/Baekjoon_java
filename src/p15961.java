import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15961 {
	public static int N, d, k, c, maxK, ans;
	public static ArrayList<Integer> sushi = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int eat[] = new int[d+1];
		int tempAns = 0;
		for(int i=0; i<N; i++) {
			int temp =Integer.parseInt(bf.readLine()); 
			sushi.add(temp);
			
			if(i < k) {
				if(eat[temp] == 0)
					tempAns++;
				eat[temp]++;
			}else {
				if(eat[c] == 0) tempAns++;
				if(ans < tempAns) ans = tempAns;
				if(eat[c] == 0) tempAns--;
				eat[sushi.get(i-k)]--;
				if(eat[sushi.get(i-k)] == 0)
					tempAns--;
				if(eat[temp] == 0)
					tempAns++;
				eat[temp]++;
			}
				
		}
		
		for(int i=0; i<k; i++) {
			int temp = (sushi.get(i-k+N));
			if(eat[c] == 0) tempAns++;
			if(ans < tempAns) ans = tempAns;
			if(eat[c] == 0) tempAns--;
			eat[temp]--;
			if(eat[temp] == 0)
				tempAns--;
			if(eat[sushi.get(i)] == 0)
				tempAns++;
			eat[sushi.get(i)]++;
		}
		
		System.out.println(ans);
		
		
	}

}
