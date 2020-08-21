import java.util.Scanner;
public class p1027 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), ans = 0;
		long arr[] = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextLong();
		}
		
		for(int i=0; i<N; i++) {
			int temp = 0;
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				long higher, lower, highIdx, lowIdx;
				if(arr[i] > arr[j]) {
					higher = arr[i];
					highIdx = i;
					lower = arr[j];
					lowIdx = j;
				}else {
					higher = arr[j];
					highIdx = j;
					lower = arr[i];
					lowIdx = i;
				}
				boolean isOk = true;
				for(int k=(i>j ? j : i)+1; k<(i > j ? i : j); k++) {
					double h = ((higher - lower)*(k - lowIdx)) / (double)(highIdx - lowIdx);
					if(arr[k] >= lower + h) {
						isOk = false;
						break;
					}
				}
				if(isOk) temp++;
			}
			if(temp > ans) ans = temp;
		}
		System.out.println(ans);
	}

}
