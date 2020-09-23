import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class p2304 {
	static int N, maxH, nowF, nowB;
	static boolean area[][];
	static ArrayList<int[]> arr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(maxH < y) maxH = y;
			arr.add(new int[] {x, y});
		}
		
		Collections.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		
		nowF = 0;
		nowB = N-1;
		
		area = new boolean[(arr.get(N-1)[0])+1][maxH];
		
		while(arr.get(nowF)[1] != maxH) {
			for(int i=nowF; i<N; i++) {
				if(arr.get(i)[1] == maxH || arr.get(nowF)[1] < arr.get(i)[1] || i== N-1) {
					for(int j=arr.get(nowF)[0]; j<arr.get(i)[0]; j++) {
						for(int k=0; k<arr.get(nowF)[1]; k++) {
							area[j][k] = true;
						}
					}
						
					nowF = i;
					break;
				}
			}
		}
		
		while(arr.get(nowB)[1] != maxH) {
			for(int i=nowB; i>=0; i--) {
				if(arr.get(i)[1] == maxH || arr.get(nowB)[1] < arr.get(i)[1] || i== 0) {
					for(int j=arr.get(nowB)[0]; j>=arr.get(i)[0]; j--) {
						for(int k=0; k<arr.get(nowB)[1]; k++) {
							area[j][k] = true;
						}
					}
						
					nowB = i;
					break;
				}
			}
		}
		
		if(nowB == nowF) {
			for(int i=0; i<maxH; i++) {
				area[arr.get(nowF)[0]][i] = true;
			}
		}else {
			for(int i=arr.get(nowF)[0]; i<=arr.get(nowB)[0]; i++) {
				for(int j=0; j<maxH; j++) {
					area[i][j] = true;
				}
			}
		}
		
		int sum = 0;
		for(int i=arr.get(0)[0]; i<=arr.get(N-1)[0]; i++) {
			for(int j=maxH-1; j>=0; j--) {
				if(area[i][j]) sum++;
				//System.out.print(area[i][j]?1:0);
			}
			//System.out.println();
		}
		System.out.println(sum);
	}

}
