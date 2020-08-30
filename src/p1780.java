import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1780 {
	static int arr[][];
	static int paper[] = new int[3];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		getPaper(0, 0, n);
		
		for(int i=0; i<3; i++)
			System.out.println(paper[i]);
	}
	
	static void getPaper(int startI, int startJ, int sz) {
		boolean isOk = true;
		int val = arr[startI][startJ];
		for(int i=startI; i<startI+sz; i++) {
			for(int j=startJ; j<startJ+sz; j++) {
				if(arr[i][j] != val) {
					isOk = false;
					break;
				}
			}
			if(!isOk) break;
		}
		
		if(sz==1 || isOk) paper[val+1]++;
		else {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					getPaper(startI + i*sz/3, startJ + j*sz/3, sz/3);
				}
			}
		}
	}

}
