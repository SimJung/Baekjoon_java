
import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;
public class p1920 {
	
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		StringTokenizer st;
		N = Integer.parseInt(sc.nextLine());
		st = new StringTokenizer(sc.nextLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(sc.nextLine());
		st = new StringTokenizer(sc.nextLine());
		for(int i=0; i<M; i++) {
			if(binarySearch(Integer.parseInt(st.nextToken()))) System.out.println("1");
			else System.out.println("0");
		}
	}
	
	public static boolean binarySearch(int n) {
		int left = 0, right = arr.length;
		int mid  = (left+right) / 2;;
		if(n < arr[left] || n > arr[right-1]) return false;
		while(left < right) {
			mid = (left+right) / 2;
			//System.out.println("MID : " + mid + "\nArr[mid] : " + arr[mid]);
			
			if(arr[mid] > n) right = mid - 1;
			else if(arr[mid] < n) left = mid + 1;
			else break;
		}
		if(arr[left] == n || arr[mid] == n) return true;
		return false;
	}
}
