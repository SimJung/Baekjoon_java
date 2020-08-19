import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class p14500 {
	
	static int[][][] tetromino = {
			{	
				{0, 0},
				{0, 1},
				{0, 2},
				{0, 3}
			},
			
			{	
				{0, 0},
				{1, 0},
				{2, 0},
				{3, 0}
			},
			
			{	
				{0, 0},
				{0, 1},
				{1, 0},
				{1, 1}
			},
			
			{	
				{0, 0},
				{0, 1},
				{0, 2},
				{-1, 2}
			},
			
			{	
				{0, 0},
				{0, 1},
				{0, 2},
				{1, 2}
			},
			
			{	
				{0, 0},
				{1, 0},
				{2, 0},
				{2, 1}
			},
			
			{	
				{0, 0},
				{1, 0},
				{2, 0},
				{2, -1}
			},
			
			{	
				{0, 0},
				{1, 0},
				{0, 1},
				{0, 2}
			},
			
			{	
				{0, 0},
				{1, 0},
				{1, 1},
				{1, 2}
			},
			
			{	
				{0, 0},
				{0, 1},
				{1, 0},
				{2, 0}
			},
			
			{	
				{0, 0},
				{0, 1},
				{1, 1},
				{2, 1}
			},
			
			{	
				{0, 0},
				{1, 0},
				{1, 1},
				{2, 1}
			},
			
			{	
				{0, 0},
				{0, 1},
				{1, 0},
				{1, -1}
			},
			
			{	
				{0, 0},
				{1, 0},
				{1, -1},
				{2, -1}
			},
			
			{	
				{0, 0},
				{0, 1},
				{1, 1},
				{1, 2}
			},
			
			{	
				{0, 0},
				{0, 1},
				{0, 2},
				{1, 1}
			},
			
			{	
				{0, 0},
				{0, 1},
				{0, 2},
				{-1, 1}
			},
			
			{	
				{0, 0},
				{1, 0},
				{2, 0},
				{1, 1}
			},
			
			{	
				{0, 0},
				{1, 0},
				{2, 0},
				{1, -1}
			}
	};
	static int N, M;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<tetromino.length; k++) {
					int temp = 0;
					for(int l=0; l<4; l++) {
						int ni = i + tetromino[k][l][0];
						int nj = j + tetromino[k][l][1];
						
						if(ni<0 || ni >= N || nj<0 || nj >= M) break;
						
						temp += arr[ni][nj];
					}
					
					if(ans < temp) ans = temp;
				}
			}
		}
		
		System.out.println(ans);
	}

}
