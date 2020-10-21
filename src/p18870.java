import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p18870 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashSet<Integer> hs = new HashSet<>();
		int arr[] = new int[N];
		ArrayList<Integer> arrList = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			if(hs.add(temp)) {
				arrList.add(temp);
			}
		}
		
		Collections.sort(arrList);
		for(int i=0; i<N; i++) {
			bw.write(Collections.binarySearch(arrList, arr[i]) + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}

}