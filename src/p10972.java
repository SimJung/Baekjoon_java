import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p10972 {
	static boolean visit[];
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<Integer> curPerm = new ArrayList<>();
	static ArrayList<Integer> ansPerm = new ArrayList<>();
	static boolean chk = false;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr.add(num);
			curPerm.add(num);
		}
		Collections.sort(arr);
		
		getAns(0);
	}
	
	public static void getAns(int cnt, int idx) {
		if(cnt == N) {
			if(!chk) {
				for(int i=0; i<N; i++) {
					
				}
			}else {
				
			}
			
		}
	}

}
