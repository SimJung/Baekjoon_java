import java.util.Scanner;

public class p2477 {
	static int N, maxH, maxV;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[6];
		for(int i=0; i<6; i++) {
			int d = sc.nextInt();
			arr[i] = sc.nextInt();
			
			if(d == 1 || d == 2) {
				if(arr[i] >= maxH) maxH = arr[i];
			}else {
				if(arr[i] >= maxV) maxV = arr[i];
			}
		}
		
		int area = 1;
		
		if(arr[5]+arr[1] == maxH || arr[1]+arr[5] == maxV) {
			area *=arr[0];
		}
		for(int i=1; i<5; i++) {
			if(arr[i-1]+arr[i+1] == maxH || arr[i-1]+arr[i+1] == maxV) {
				area *=arr[i];
			}
		}
		if(arr[4]+arr[0] == maxH || arr[4]+arr[0] == maxV) {
			area *=arr[5];
		}
		System.out.println((maxV*maxH - area)*N);
	}

}
