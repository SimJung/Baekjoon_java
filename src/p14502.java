import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
public class p14502 {

	static int delta[][] = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
	};
	
	static int N, M;
	static int lab[][];
	
	static int[] combinationTemp = new int[3];
	static Queue<int[][]> wallQueue = new LinkedList<>();
	static Queue<int[]> virusQ = new LinkedList<>();
	static int safe, answer;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 2) virusQ.offer(new int[] {i, j});
				else if(lab[i][j] == 0) safe++;
			}
		}
		safe -= 3;
		make_wallQueue(0, 0);
		
		while(!wallQueue.isEmpty()) {
			int tempSafe = safe;
			int tempLab[][] = new int[N][M];
			for(int i=0; i<N; i++) tempLab[i] = Arrays.copyOf(lab[i], M);
			
			for(int i=0; i<3; i++) {
				tempLab[wallQueue.peek()[i][0]][wallQueue.peek()[i][1]] = 1;
			}
			wallQueue.poll();
			
			
			Queue<int[]> tempVirusQ = new LinkedList(virusQ);
			while(!tempVirusQ.isEmpty()) {
				int[] virusPos = tempVirusQ.poll();
				for(int i=0; i<4; i++) {
					int ni = virusPos[0] + delta[i][0];
					int nj = virusPos[1] + delta[i][1];
					
					if(ni >= N || ni < 0 || nj >= M || nj < 0 || tempLab[ni][nj] != 0)
						continue;
					
					tempLab[ni][nj] = 2;
					tempSafe--;
					tempVirusQ.offer(new int[] {ni, nj});
				}
			}
			
			if(answer < tempSafe) answer = tempSafe;
		}
		System.out.println(answer);
	}
	
	public static void make_wallQueue(int cnt, int idx) {
		if(cnt == 3) {
			for(int i=0; i<3; i++) {
				if(lab[combinationTemp[i]/M][combinationTemp[i]%M] != 0)
					return ;
			}
			wallQueue.offer(new int[][] {{combinationTemp[0]/M, combinationTemp[0]%M}, {combinationTemp[1]/M, combinationTemp[1]%M}, {combinationTemp[2]/M, combinationTemp[2]%M}});
		}else {
			for(int i=idx; i<N*M; i++) {
				combinationTemp[cnt] = i;
				make_wallQueue(cnt+1, i+1);
			}
		}
	}

}
