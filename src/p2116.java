import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2116 {
	static int N, sum, prevNum, result, flag;
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][6];
		
		for(int t=0; t<N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				arr[t][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int t = 1; t <= 6; t++) {
			prevNum = t;
			sum = 0;
			for (int i = 0; i < N; i++) {
				flag = 0;
				for (int j = 0; j < 6; j++) {
					if (arr[i][j] == prevNum) {
						switch (j) {
						case 0:
							flag |= 1<<0;
							flag |= 1<<5;
							prevNum = arr[i][5];
							break;

						case 1:
							flag |= 1<<1;
							flag |= 1<<3;
							prevNum = arr[i][3];
							break;

						case 2:
							flag |= 1<<2;
							flag |= 1<<4;
							prevNum = arr[i][4];
							break;

						case 3:
							flag |= 1<<3;
							flag |= 1<<1;
							prevNum = arr[i][1];
							break;

						case 4:
							flag |= 1<<4;
							flag |= 1<<2;
							prevNum = arr[i][2];
							break;

						case 5:
							flag |= 1<<0;
							flag |= 1<<5;
							prevNum = arr[i][0];
							break;
						}
						if(flag != 0) break;
					}
				}
				int maxVal = 0;
				for(int j=0; j<6; j++) {
					if((flag & (1<<j)) == 0) {
						if(maxVal < arr[i][j]) maxVal = arr[i][j];
					}
				}
				sum += maxVal;
			}
			if(result < sum) result = sum;
		}
		System.out.println(result);
	}

}
